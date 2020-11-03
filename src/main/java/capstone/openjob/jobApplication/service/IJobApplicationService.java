package capstone.openjob.jobApplication.service;

import capstone.openjob.entity.JobApplicationEntity;

import java.util.List;

public interface IJobApplicationService {
    JobApplicationEntity createJobApplication(JobApplicationEntity jobApplicationEntity);
    JobApplicationEntity updateJobApplication(JobApplicationEntity jobApplicationEntity);
    List<JobApplicationEntity> getAllJobApplication();
    JobApplicationEntity getJobApplicationById (int id);
}
