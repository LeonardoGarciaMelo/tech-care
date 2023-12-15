package org.tfe.techcare.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import org.tfe.techcare.domain.physician.*;

import java.util.List;

@RestController
@RequestMapping("physicians")
public class PhysicianController {
    @Autowired
    private PhysicianRepository repository;

    @GetMapping
    public ResponseEntity<List<PhysicianListData>> list() {
        var response = repository.findAll().stream().map(PhysicianListData::new).toList();
        return ResponseEntity.ok(response);
    }

    @GetMapping("{id}")
    public ResponseEntity<PhysicianDetailData> detail(@PathVariable Long id) {
        Physician physician = repository.getReferenceById(id);
        return ResponseEntity.ok(new PhysicianDetailData(physician));
    }

    @PostMapping
    public ResponseEntity<PhysicianDetailData> register(
            @RequestBody @Valid PhysicianRegisterData data, UriComponentsBuilder uriBuilder
    ) {
        var physician = repository.save(new Physician(data));

        var physicianInfo = uriBuilder.path("/physicians/{id}").buildAndExpand(physician.getId()).toUri();

        return ResponseEntity.created(physicianInfo).body(new PhysicianDetailData(physician));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<PhysicianDetailData> delete(@PathVariable Long id) {
        var physician = repository.getReferenceById(id);

        repository.delete(physician);

        return ResponseEntity.ok(new PhysicianDetailData(physician));
    }
}
