package ru.ageev.companyregister.service;

import org.springframework.stereotype.Service;
import ru.ageev.companyregister.model.Company;
import ru.ageev.companyregister.repository.RepositoryCompany;

import java.util.List;
@Service
public class ServiceCompanyImp implements ServiceCompany {
    private final RepositoryCompany repositoryCompany;

    public ServiceCompanyImp(RepositoryCompany repositoryCompany) {
        this.repositoryCompany = repositoryCompany;
    }


    @Override
    public void create(Company company) {
        repositoryCompany.save(company);
    }

    @Override
    public Company read(int id) {
        return repositoryCompany.getById(id);
    }

//    @Override
//    public Company readCountry(String country) {
//        return repositoryCompany.toString(country);
//    }

    @Override
    public List<Company> readAll() {
        return repositoryCompany.findAll();
    }
}


