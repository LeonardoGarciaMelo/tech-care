package org.tfe.techcare.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tfe.techcare.domain.pacient.*;

import java.util.List;

@Service
public class PacientServices {
    @Autowired
    private PacientRepository repository;

    public List<PacientListData> list() {
        return repository.findAll().stream().map(PacientListData::new).toList();
    }

    public PacientDetailData detail(Long id) {
        Pacient pacient = repository.getReferenceById(id);
        return new PacientDetailData(pacient);
    }

    public Pacient register(PacientRegisterData data) {
        return repository.save(new Pacient(data));
    }

    public PacientDetailData delete(Long id) {
        var pacient = repository.getReferenceById(id);

        repository.delete(pacient);

        return new PacientDetailData(pacient);
    }

    public PacientDetailData edit(PacientEditData data) {
        var pacient = repository.getReferenceById(data.id()); //Objeto do tipo patient

        pacient.edit(data);

        repository.save(pacient);

        return new PacientDetailData(pacient);
    }

}
