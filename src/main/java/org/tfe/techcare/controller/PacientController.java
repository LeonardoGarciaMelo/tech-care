package org.tfe.techcare.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.tfe.techcare.domain.pacient.*;

import java.util.List;

@RestController
@RequestMapping("pacients")
public class PacientController {
    @Autowired
    private PacientRepository repository;

    @GetMapping
    public List<PacientListData> list() {
        return repository.findAll().stream().map(PacientListData::new).toList();
    }

    @GetMapping("{id}")
    public PacientDetailData detail(@PathVariable Long id){
        Pacient pacient = repository.getReferenceById(id);
        return new PacientDetailData(pacient);
    }

    @PostMapping
    public void register(@RequestBody @Valid PacientRegisterData data) {
        repository.save(new Pacient(data));
    }
}