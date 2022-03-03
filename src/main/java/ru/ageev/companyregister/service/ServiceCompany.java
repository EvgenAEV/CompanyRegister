package ru.ageev.companyregister.service;

import ru.ageev.companyregister.model.Company;

import java.util.List;

public interface ServiceCompany {

    void create(Company company);

    Company readId(long id);

    List<Company> readAll();

    boolean update (Company company,long id);

    boolean delete(long id);

    Company readName (String name);
}