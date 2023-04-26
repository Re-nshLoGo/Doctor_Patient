package com.example.Doctor_Patient.dto;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PatientDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer patientId;
    @NotEmpty(message = "please enter a name")
    private String name;
    @NotEmpty(message = "Enter email")
    @Email(message = "enter a valid email eg: abc@gmail.com")
    private String email;
    @NotEmpty(message = "please enter a 10 digit phone number")
    @Length(min = 10 , max = 10,message = "please enter a 10 digit phone number")
    private String phoneNum;
    @NotEmpty(message = "please enter symptom")
    private String symptom;
    @NotEmpty(message = "please enter city")
    private String city;

}

