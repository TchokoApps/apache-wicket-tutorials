package com.tchokoapps.apache.wicket.springbootexamplewicket.repositories;

import com.tchokoapps.apache.wicket.springbootexamplewicket.entities.Patient;
import com.tchokoapps.apache.wicket.springbootexamplewicket.entities.Sex;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PatientRepository extends CrudRepository<Patient, Long> {
    public List<Patient> findPatientBySex(Sex sex);
    public List<Patient> findPatientByActive(boolean active);
}