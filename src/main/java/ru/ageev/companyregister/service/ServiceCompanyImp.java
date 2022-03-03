package ru.ageev.companyregister.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.ageev.companyregister.model.Company;
import ru.ageev.companyregister.repository.RepositoryCompany;
import java.util.List;

@Service
public class ServiceCompanyImp implements ServiceCompany {
    private final RepositoryCompany repositoryCompany;

    @Autowired
    public ServiceCompanyImp(RepositoryCompany repositoryCompany) {
        this.repositoryCompany = repositoryCompany;
    }

    @Override
    public void create(Company company) {
        repositoryCompany.save(company);
    }

    @Override
    public Company readId(long id) {
        return repositoryCompany.getById(id);
    }

    @Override
    public List<Company> readAll() {
        return repositoryCompany.findAll();
    }

    @Override
    public Company readName(String name) {
        return repositoryCompany.findByCompanyName(name);
    }

    @Override
    public boolean update(Company company, long id) {
        if (repositoryCompany.existsById(id)) {
            company.setId(id);
            repositoryCompany.save(company);
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(long id) {
        if (repositoryCompany.existsById(id)) {
            repositoryCompany.deleteById(id);
            return true;
        }
        return false;
    }
}


