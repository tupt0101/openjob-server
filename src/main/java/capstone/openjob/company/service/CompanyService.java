package capstone.openjob.company.service;

import capstone.openjob.dao.ICompanyRepository;
import capstone.openjob.entity.CompanyEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyService implements ICompanyService {

    @Autowired
    private ICompanyRepository ICompanyRepository;

    @Override
    public CompanyEntity createCompany(CompanyEntity companyEntity) {
        return ICompanyRepository.save(companyEntity);
    }

    @Override
    public CompanyEntity updateCompany(CompanyEntity companyEntity) {
        return ICompanyRepository.save(companyEntity);
    }

    @Override
    public List<CompanyEntity> getAllCompany() {
        return ICompanyRepository.findAll();
    }

    @Override
    public CompanyEntity findCompanyById(int id) {
        if (ICompanyRepository.findById(id).isPresent()) {
            return ICompanyRepository.findById(id).get();
        } else return null;
    }
}
