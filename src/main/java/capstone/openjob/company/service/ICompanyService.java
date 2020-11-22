package capstone.openjob.company.service;

import capstone.openjob.entity.CompanyEntity;

import java.util.List;

public interface ICompanyService {
    CompanyEntity  createCompany(CompanyEntity candidateEntity);
    CompanyEntity updateCompany(CompanyEntity candidateEntity);
    List<CompanyEntity> getAllCompany();
    CompanyEntity findCompanyById(int id);
    CompanyEntity findCompanyByName(String name);

}
