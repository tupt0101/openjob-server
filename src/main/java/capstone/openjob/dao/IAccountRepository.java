package capstone.openjob.dao;

import capstone.openjob.entity.AccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IAccountRepository extends JpaRepository<AccountEntity, Integer> {
    Optional<AccountEntity> findAccountEntitiesByEmailEquals(String email);
}
