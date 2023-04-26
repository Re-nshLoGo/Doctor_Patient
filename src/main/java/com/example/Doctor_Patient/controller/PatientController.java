package com.example.Doctor_Patient.controller;


import com.example.Doctor_Patient.dto.PatientDto;
import com.example.Doctor_Patient.model.Doctor;
import com.example.Doctor_Patient.model.Patient;
import com.example.Doctor_Patient.service.PatientService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PatientController {
    @Autowired
    PatientService patientService;

    @GetMapping("getall-patient")
    public ResponseEntity<List<Patient>> getAll(){
        return new ResponseEntity<>(patientService.getAll(), HttpStatus.OK);
    }

    @PostMapping("add-patient")
    public ResponseEntity<String> add(@Valid @RequestBody PatientDto reqpatient) {
        patientService.save(reqpatient);

        return new ResponseEntity<>("saved", HttpStatus.CREATED);
    }
    @GetMapping("/suggest/{patientId}")
    public ResponseEntity<List<Doctor>> getSuggestDoc(@PathVariable int patientId){
        List<Doctor> list = patientService.getDoc(patientId);
        return new ResponseEntity<>(list,HttpStatus.OK);
    }
    @DeleteMapping("/remove-patient/{patientId}")
    public ResponseEntity<String> deletePatient(@PathVariable int patientId){
        patientService.Delete(patientId);
        return new ResponseEntity<>("Deleted",HttpStatus.OK);
    }


}
