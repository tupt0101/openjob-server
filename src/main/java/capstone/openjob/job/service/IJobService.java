package capstone.openjob.job.service;

import capstone.openjob.entity.JobEntity;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IJobService {
    JobEntity createJob(JobEntity job);
    JobEntity updateJob(JobEntity job);
    List<JobEntity> getAllJob();
    JobEntity closeJob(int id);
    JobEntity getJobById(int id);
    List<JobEntity> getJobByAccountId(int id);
    List<JobEntity> getOpenJob();
    List<JobEntity> searchJob(String search, Pageable pageable);
}
