package org.tfe.techcare.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import org.tfe.techcare.domain.pacient.*;

import java.util.List;

@RestController
@RequestMapping("pacients")
public class PacientController {
    @Autowired
    private PacientRepository repository;

    @GetMapping
    public ResponseEntity<List<PacientListData>> list() {
        var response = repository.findAll().stream().map(PacientListData::new).toList();
        return ResponseEntity.ok(response);
    }

    @GetMapping("{id}")
    public ResponseEntity<PacientDetailData> detail(@PathVariable Long id) {
        Pacient pacient = repository.getReferenceById(id);
        return ResponseEntity.ok(new PacientDetailData(pacient));
    }

    @PostMapping
    public ResponseEntity<PacientDetailData> register(
            @RequestBody @Valid PacientRegisterData data, UriComponentsBuilder uriBuilder
    ) {
        var pacient = repository.save(new Pacient(data));

        var pacientInfo = uriBuilder.path("/pacients/{id}").buildAndExpand(pacient.getId()).toUri();

        return ResponseEntity.created(pacientInfo).body(new PacientDetailData(pacient));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<PacientDetailData> delete(@PathVariable Long id) {
       var pacient = repository.getReferenceById(id);

       repository.delete(pacient);

       return ResponseEntity.ok(new PacientDetailData(pacient));
    }
}