package org.tfe.techcare.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tfe.techcare.domain.patient.*;

import java.util.List;

@Service
public class PatientServices {
    @Autowired
    private PatientRepository repository;

    public List<PatientListData> list() {
        return repository.findAll().stream().map(PatientListData::new).toList();
    }

    public PatientDetailData detail(Long id) {
        Patient patient = repository.getReferenceById(id);
        return new PatientDetailData(patient);
    }

    public Patient register(PatientRegisterData data) {
        return repository.save(new Patient(data));
    }

    public PatientDetailData delete(Long id) {
        var patient = repository.getReferenceById(id);

        repository.delete(patient);

        return new PatientDetailData(patient);
    }

    public PatientDetailData edit(PatientEditData data) {
        var patient = repository.getReferenceById(data.id()); //Objeto do tipo patient

        patient.edit(data);

        repository.save(patient);

        return new PatientDetailData(patient);
    }

}
