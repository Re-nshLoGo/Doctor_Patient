package com.example.Doctor_Patient.dao;

import com.example.Doctor_Patient.model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DocRepository extends JpaRepository<Doctor,Integer> {


    @Query(value = "select * from tbl_doctor where specialized_in = :Speciality",nativeQuery = true)
    public List<Doctor> findAllBySpecializedIn(String Speciality);
    @Query(value = "select * from tbl_doctor where city = :city",nativeQuery = true)
    public List<Doctor> findByCity(String city);
}
