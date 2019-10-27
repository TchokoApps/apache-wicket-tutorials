package com.tchokoapps.apache.wicket.springbootexamplewicket.services;

import com.tchokoapps.apache.wicket.springbootexamplewicket.entities.Patient;
import java.util.List;

public interface PatientService {

    long count();

    void delete(final Long id);

    void delete(final Patient patient);

    Patient findById(final Long id);

    List<Patient> list(final long first, final long count);

    List<Patient> listAll();

    Patient save(final Patient patientObj);
}
