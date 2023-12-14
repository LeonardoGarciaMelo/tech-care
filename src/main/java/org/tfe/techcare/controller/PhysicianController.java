package org.tfe.techcare.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.tfe.techcare.domain.physician.*;

import java.util.List;

@RestController
@RequestMapping("physicians")
public class PhysicianController {
    @Autowired
    private PhysicianRepository repository;

    @GetMapping
    public List<PhysicianListData> list() {
        return repository.findAll().stream().map(PhysicianListData :: new).toList();
    }

    @GetMapping("{id}")
    public PhysicianDetailData detail(@PathVariable Long id) {
        Physician physician = repository.getReferenceById(id);
        return new PhysicianDetailData(physician);
    }

    @PostMapping
    public void register(@RequestBody @Valid PhysicianRegisterData data){
        repository.save(new Physician(data));
    }
}
