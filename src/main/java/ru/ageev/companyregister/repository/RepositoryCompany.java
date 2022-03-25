package ru.ageev.companyregister.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.ageev.companyregister.model.Company;
@Repository
public  interface RepositoryCompany extends JpaRepository<Company,Long> {
    Company findByCompanyName(String name);

}
