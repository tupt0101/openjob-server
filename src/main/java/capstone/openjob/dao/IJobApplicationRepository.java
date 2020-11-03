package capstone.openjob.dao;

import capstone.openjob.entity.JobApplicationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IJobApplicationRepository extends JpaRepository<JobApplicationEntity, Integer> {
}
