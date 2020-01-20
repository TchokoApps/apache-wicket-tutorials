package com.tchokoapps.apache.wicket.springbootexamplewicket.pages.panel.patient;

import com.tchokoapps.apache.wicket.springbootexamplewicket.entities.Patient;
import com.tchokoapps.apache.wicket.springbootexamplewicket.services.PatientService;
import org.apache.wicket.injection.Injector;
import org.apache.wicket.markup.repeater.data.IDataProvider;
import org.apache.wicket.model.AbstractReadOnlyModel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.spring.injection.annot.SpringBean;

import java.util.Iterator;

public class PatientProvider implements IDataProvider<Patient> {

    @SpringBean
    private PatientService patientService;

    public PatientProvider() {
        super();
        Injector.get().inject(this);
    }

    @Override
    public Iterator<? extends Patient> iterator(long first, long count) {
        return patientService.list(first, count).iterator();
    }

    @Override
    public long size() {
        return patientService.count();
    }

    @Override
    public IModel<Patient> model(Patient object) {
        return new AbstractReadOnlyModel<Patient>() {
            @Override
            public Patient getObject() {
                return object;
            }
        };
    }

    @Override
    public void detach() {

    }
}
