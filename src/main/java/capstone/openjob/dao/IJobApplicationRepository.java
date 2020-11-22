package capstone.openjob.dao;

import capstone.openjob.entity.JobApplicationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IJobApplicationRepository extends JpaRepository<JobApplicationEntity, Integer> {
    Optional<List<JobApplicationEntity>> findJobApplicationEntitiesByJobIdEquals(int jobId);
}
