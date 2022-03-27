package ru.ageev.companyregister.service;

import ru.ageev.companyregister.model.Company;

import java.util.List;

public interface ServiceCompany {

    void create(Company company);

    Company readId(long companyId);

    List<Company> readAll();

    boolean update (Company company,long companyId);

    boolean delete(long companyId);

    Company readName (String name);
}