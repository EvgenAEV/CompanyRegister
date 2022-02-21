package ru.ageev.companyregister.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.ageev.companyregister.model.Company;

public  interface RepositoryCompany extends JpaRepository<Company,Integer> {

}
