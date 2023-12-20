package org.tfe.techcare.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import org.tfe.techcare.domain.pacient.*;
import org.tfe.techcare.services.PacientServices;

import java.util.List;

@RestController
@RequestMapping("pacients")
public class PacientController {
    @Autowired
    private PacientServices service;

    @GetMapping
    public ResponseEntity<List<PacientListData>> list() {
        return ResponseEntity.ok(service.list());
    }

    @GetMapping("{id}")
    public ResponseEntity<PacientDetailData> detail(@PathVariable Long id) {
        return ResponseEntity.ok((service.detail(id)));
    }

    @PostMapping
    public ResponseEntity<PacientDetailData> register(
            @RequestBody @Valid PacientRegisterData data, UriComponentsBuilder uriBuilder
    ) {
        var pacient = service.register(data);

        var pacientInfo = uriBuilder.path("/pacients/{id}").buildAndExpand(pacient.getId()).toUri();

        return ResponseEntity.created(pacientInfo).body(new PacientDetailData(pacient));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<PacientDetailData> delete(@PathVariable Long id) {
       var pacient = service.delete(id);

       return ResponseEntity.ok(pacient);
    }

    @PutMapping
    public ResponseEntity<PacientDetailData> edit(@RequestBody @Valid PacientEditData data) {
        return ResponseEntity.ok(service.edit(data));
    }
}