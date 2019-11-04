package com.tchokoapps.apache.wicket.springbootexamplewicket.services;

import com.tchokoapps.apache.wicket.springbootexamplewicket.entities.Patient;
import com.tchokoapps.apache.wicket.springbootexamplewicket.repositories.PatientRepository;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PatientServiceImpl implements PatientService {

    private PatientRepository patientRepository;

    public PatientServiceImpl(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    @Override
    public long count() {
        return patientRepository.count();
    }

    @Override
    public void delete(Long id) {
        patientRepository.deleteById(id);
    }

    @Override
    public void delete(Patient patient) {
        patientRepository.delete(patient);
    }

    @Override
    public Patient findById(Long id) {
        Optional<Patient> patientOpt = patientRepository.findById(id);
        if (!patientOpt.isPresent())
            throw new RuntimeException(String.format("Patient with id=%s has not been found", String.valueOf(id)));
        return patientOpt.get();
    }

    @Override
    public List<Patient> list(long first, long count) {
        return patientRepository.findAll();
    }

    @Override
    public List<Patient> listAll() {
        ArrayList<Patient> patients = new ArrayList<>();
        patientRepository.findAll().forEach(patients::add);
        return patients;
    }

    @Override
    public Patient save(Patient patientObj) {
        return patientRepository.save(patientObj);
    }
}
