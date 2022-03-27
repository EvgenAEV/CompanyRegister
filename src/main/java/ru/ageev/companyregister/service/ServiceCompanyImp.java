package ru.ageev.companyregister.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
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
        if (repositoryCompany.exists(Example.of(company))) {
            repositoryCompany.findAll();
        } else {
            repositoryCompany.save(company);
        }
    }

    @Override
    public Company readId(long companyId) {
        return repositoryCompany.getById(companyId);
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
    public boolean update(Company company, long companyId) {
        if (repositoryCompany.existsById(companyId)) {
            company.setCompanyId(companyId);
            repositoryCompany.save(company);
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(long companyId) {
        if (repositoryCompany.existsById(companyId)) {
            repositoryCompany.deleteById(companyId);
            return true;
        }
        return false;
    }
}


