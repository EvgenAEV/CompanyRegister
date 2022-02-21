package ru.ageev.companyregister.service;

import ru.ageev.companyregister.model.Company;

import java.util.List;

public interface ServiceCompany {

    void create(Company company);

    Company read(int id);

//    Company readCountry(String country);

    List<Company> readAll();
}