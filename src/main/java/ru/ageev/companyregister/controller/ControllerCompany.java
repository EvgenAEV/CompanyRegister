package ru.ageev.companyregister.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.ageev.companyregister.model.Company;
import ru.ageev.companyregister.service.ServiceCompany;

import java.util.List;
@RestController
@RequestMapping ("/company")
public class ControllerCompany {
    private final ServiceCompany serviceCompany;

    @Autowired
    public ControllerCompany(ServiceCompany serviceCompany) {
        this.serviceCompany = serviceCompany;
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody Company company) {
        serviceCompany.create(company);
        return new ResponseEntity<>("id new company " + company.getId(),HttpStatus.CREATED);

    }
    @GetMapping("/{id}")
    public ResponseEntity<?> readId(@PathVariable(name = "id") long id) {
        final Company company = serviceCompany.read(id);
        return company != null
                ? new ResponseEntity<>(company, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Company>> readAll() {
        final List<Company> companies = serviceCompany.readAll();

        return companies != null &&  !companies.isEmpty()
                ? new ResponseEntity<>(companies, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable(name = "id") long id, @RequestBody Company company) {
        final boolean updated = serviceCompany.update(company, id);

        return updated
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable(name = "id") long id){
        final boolean deleted = serviceCompany.delete(id);
        return deleted
                ? new ResponseEntity<>(HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }
}
