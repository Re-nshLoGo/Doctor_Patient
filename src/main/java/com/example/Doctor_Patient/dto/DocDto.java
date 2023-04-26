package com.example.Doctor_Patient.dto;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DocDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer doctorId;

    @NotEmpty(message = "please enter a name")
    private String docName;

    @NotEmpty(message = "email is mandatory")
    @Email(message = "please enter a valid email eg: abc@gmail.com")
    private String  email;

    @NotEmpty(message = "please enter 10 digit mobile number")
    @Length(min = 10 , max = 10,message = "please enter a 10 digit phone number")
    private String phone_Number;

    @NotEmpty(message = "please enter city")
    private String city;

    @NotEmpty(message = "please enter specialization")
    private String specializedIn;


}
