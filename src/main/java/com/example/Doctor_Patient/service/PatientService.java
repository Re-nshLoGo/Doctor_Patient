package com.example.Doctor_Patient.service;


import com.example.Doctor_Patient.dao.DocRepository;
import com.example.Doctor_Patient.dao.PatientRepo;
import com.example.Doctor_Patient.dto.PatientDto;
import com.example.Doctor_Patient.exception.RecordNotFound;
import com.example.Doctor_Patient.model.Doctor;
import com.example.Doctor_Patient.model.Patient;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PatientService {
    @Autowired
    PatientRepo patientRepo;
    @Autowired
    ModelMapper modelMapper;
    @Autowired
    DocRepository docRepository;
    public List<Patient> getAll() {
        return patientRepo.findAll();
    }

    public void save(PatientDto reqpatient) {
        Patient patient = modelMapper.map(reqpatient, Patient.class);
        patientRepo.save(patient);
    }


    public List<Doctor> getDoc(int patientId) {
        Patient patient = patientRepo.findById(patientId).orElseThrow(() -> new RecordNotFound("Patient not found with Id: "+patientId));
        List<Doctor> list = new ArrayList<>();
        String symptom = patient.getSymptom();
        String location = patient.getCity();
        list = docRepository.findByCity(location);
        if(list.isEmpty()){
            throw new RecordNotFound("We are still waiting to expand to your location");
        }
        String spec = "";
        if(symptom.equals("Arthritis")||symptom.equals("Back Pain")||symptom.equals("Tissue injuries")){
            spec = "Orthopedic";
        }else if(symptom.equals("Dysmenorrhea")){
            spec = "Gynecology";
        }else if(symptom.equals("Skin infection")||symptom.equals("skin burn")){
            spec = "Orthopedic";
        }else if(symptom.equals("Ear pain")){
            spec = "ENT";
        }
        List<Doctor> ans = new ArrayList<>();
        for (Doctor doctor: list) {
            if((doctor.getSpecializedIn()).equals(spec)){
                ans.add(doctor);
            }
        }
        if(ans.isEmpty()){
            throw new RecordNotFound("There isn’t any doctor present at your location for your symptom");
        }
        return ans;
    }

    public void Delete(int patientId) {
        Patient patient = patientRepo.findById(patientId).orElseThrow(()->new RecordNotFound("Patient not found with id: "+patientId));
        patientRepo.delete(patient);
    }
}

