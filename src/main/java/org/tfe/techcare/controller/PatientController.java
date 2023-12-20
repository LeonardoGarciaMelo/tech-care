package org.tfe.techcare.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import org.tfe.techcare.domain.patient.*;
import org.tfe.techcare.services.PatientServices;

import java.util.List;

@RestController
@RequestMapping("patients")
public class PatientController {
    @Autowired
    private PatientServices service;

    @GetMapping
    public ResponseEntity<List<PatientListData>> list() {
        return ResponseEntity.ok(service.list());
    }

    @GetMapping("{id}")
    public ResponseEntity<PatientDetailData> detail(@PathVariable Long id) {
        return ResponseEntity.ok((service.detail(id)));
    }

    @PostMapping
    public ResponseEntity<PatientDetailData> register(
            @RequestBody @Valid PatientRegisterData data, UriComponentsBuilder uriBuilder
    ) {
        var patient = service.register(data);

        var patientInfo = uriBuilder.path("/patients/{id}").buildAndExpand(patient.getId()).toUri();

        return ResponseEntity.created(patientInfo).body(new PatientDetailData(patient));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<PatientDetailData> delete(@PathVariable Long id) {
       var patient = service.delete(id);

       return ResponseEntity.ok(patient);
    }

    @PutMapping
    public ResponseEntity<PatientDetailData> edit(@RequestBody @Valid PatientEditData data) {
        return ResponseEntity.ok(service.edit(data));
    }
}