package ru.ageev.companyregister.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.ageev.companyregister.model.Company;
import ru.ageev.companyregister.service.ServiceCompany;

import java.util.List;
@RestController
public class ControllerCompany {
    private final ServiceCompany serviceCompany;

    @Autowired
    public ControllerCompany(ServiceCompany serviceCompany) {
        this.serviceCompany = serviceCompany;
    }

    @PostMapping(value = "/company")
    public ResponseEntity<?> create(@RequestBody Company company) {
        serviceCompany.create(company);
        return new ResponseEntity<>(HttpStatus.CREATED);

    }
    @GetMapping(value = "/company/{id}")
    public ResponseEntity<?> readId(@PathVariable(name = "id") int id) {
        final Company company = serviceCompany.read(id);
        return company != null
                ? new ResponseEntity<>(company, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/companies/all")
    public ResponseEntity<List<Company>> readAll() {
        final List<Company> companies = serviceCompany.readAll();

        return companies != null &&  !companies.isEmpty()
                ? new ResponseEntity<>(companies, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
