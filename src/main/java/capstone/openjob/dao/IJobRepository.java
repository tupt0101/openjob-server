package capstone.openjob.dao;

import capstone.openjob.entity.JobEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IJobRepository extends JpaRepository<JobEntity,Integer> {
    Optional<List<JobEntity>> findAllByStatus(String status);
    Optional<List<JobEntity>> findJobEntitiesByAccountIdEquals(int id);
}
