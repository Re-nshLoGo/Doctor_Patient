package com.example.Doctor_Patient.exception;

public class RecordNotFound extends RuntimeException {
    public RecordNotFound(String msg){
        super(msg);
    }
}
