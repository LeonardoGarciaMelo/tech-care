package org.tfe.techcare.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tfe.techcare.domain.physician.*;

import java.util.List;

@Service
public class PhysicianServices {
    @Autowired
    private PhysicianRepository repository;

    public List<PhysicianListData> list() {
        return repository.findAll().stream().map(PhysicianListData::new).toList();
    }

    public PhysicianDetailData detail(Long id) {
        Physician physician = repository.getReferenceById(id);
        return new PhysicianDetailData(physician);
    }

    public Physician register(PhysicianRegisterData data) {
        return repository.save(new Physician(data));
    }

    public PhysicianDetailData delete(Long id) {
        var physician = repository.getReferenceById(id);

        repository.delete(physician);

        return new PhysicianDetailData(physician);
    }

    public PhysicianDetailData edit(PhysicianEditData data) {
        var physician = repository.getReferenceById(data.id());

        physician.edit(data);

        repository.save(physician);

        return new PhysicianDetailData(physician);
    }
}
