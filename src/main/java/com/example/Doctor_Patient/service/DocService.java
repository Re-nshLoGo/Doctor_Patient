package com.example.Doctor_Patient.service;


import com.example.Doctor_Patient.dao.DocRepository;
import com.example.Doctor_Patient.dto.DocDto;
import com.example.Doctor_Patient.exception.RecordNotFound;
import com.example.Doctor_Patient.model.Doctor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class DocService {

    @Autowired
    private DocRepository docRepository;
    @Autowired
    private ModelMapper modelMapper;
    public Doctor savedoc(DocDto doctor) {
        Doctor map = modelMapper.map(doctor, Doctor.class);

        return  docRepository.save(map);
    }

    public List<Doctor> fetchAll(String id) {
        List<Doctor> doctorList;
        if(null != id){
            doctorList = new ArrayList<>();
            doctorList.add(docRepository.findById(Integer.valueOf(id)).orElseThrow(()-> new RecordNotFound("Doctor not found with id: "+id)));
        }else {
            doctorList = (List<Doctor>) docRepository.findAll();
        }
        return doctorList;
    }

}
