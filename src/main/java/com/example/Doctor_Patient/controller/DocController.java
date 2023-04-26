package com.example.Doctor_Patient.controller;


import com.example.Doctor_Patient.dto.DocDto;
import com.example.Doctor_Patient.model.Doctor;
import com.example.Doctor_Patient.service.DocService;
import jakarta.annotation.Nullable;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/doctor")
public class DocController {
    @Autowired
    DocService docService;
    @PostMapping("/add")
    public ResponseEntity<Doctor> adddoc(@Valid @RequestBody DocDto doctor){
        Doctor savedoc = docService.savedoc(doctor);

        return new ResponseEntity<>(savedoc, HttpStatus.CREATED);

    }
    @GetMapping("/get-all")
    public ResponseEntity<List<Doctor>> getAlldoc(@Nullable @RequestParam String docId){
        return new ResponseEntity<>(docService.fetchAll(docId),HttpStatus.OK);
    }


}
