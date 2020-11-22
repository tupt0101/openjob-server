package capstone.openjob.dao;

import capstone.openjob.entity.CompanyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ICompanyRepository extends JpaRepository<CompanyEntity, Integer> {
    Optional<CompanyEntity> findCompanyEntityByNameEquals(String name);
}
