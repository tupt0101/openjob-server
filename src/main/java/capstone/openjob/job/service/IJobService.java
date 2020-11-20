package capstone.openjob.job.service;

import capstone.openjob.entity.JobEntity;

import java.util.List;

public interface IJobService {
    JobEntity createJob(JobEntity job);
    JobEntity updateJob(JobEntity job);
    List<JobEntity> getAllJob();
    JobEntity closeJob(int id);
    JobEntity getJobById(int id);
    JobEntity getJobByAccountId(int id);
    List<JobEntity> getOpenJob();
}
