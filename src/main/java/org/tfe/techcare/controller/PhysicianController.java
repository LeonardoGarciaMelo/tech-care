package org.tfe.techcare.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import org.tfe.techcare.domain.physician.*;
import org.tfe.techcare.services.PhysicianServices;

import java.util.List;

@RestController
@RequestMapping("physicians")
public class PhysicianController {
    @Autowired
    private PhysicianServices service;

    @GetMapping
    public ResponseEntity<List<PhysicianListData>> list() {
        return ResponseEntity.ok(service.list());
    }

    @GetMapping("{id}")
    public ResponseEntity<PhysicianDetailData> detail(@PathVariable Long id) {
        return ResponseEntity.ok(service.detail(id));
    }

    @PostMapping
    public ResponseEntity<PhysicianDetailData> register(
            @RequestBody @Valid PhysicianRegisterData data, UriComponentsBuilder uriBuilder
    ) {
        var physician = service.register(data);

        var physicianInfo = uriBuilder.path("/physicians/{id}").buildAndExpand(physician.getId()).toUri();

        return ResponseEntity.created(physicianInfo).body(new PhysicianDetailData(physician));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<PhysicianDetailData> delete(@PathVariable Long id) {
        return ResponseEntity.ok(service.delete(id));
    }

    @PutMapping
    public ResponseEntity<PhysicianDetailData> edit(@RequestBody @Valid PhysicianEditData data) {
        return ResponseEntity.ok(service.edit(data));
    }
}
