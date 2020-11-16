package capstone.openjob.jobApplication.service;

import capstone.openjob.dao.IJobApplicationRepository;
import capstone.openjob.entity.JobApplicationEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobApplicationService implements IJobApplicationService{

    @Autowired
    private IJobApplicationRepository IJobApplicationRepository;

    @Override
    public JobApplicationEntity createJobApplication(JobApplicationEntity jobApplicationEntity) {
        return IJobApplicationRepository.save(jobApplicationEntity);
    }

    @Override
    public JobApplicationEntity updateJobApplication(JobApplicationEntity jobApplicationEntity) {
        return IJobApplicationRepository.save(jobApplicationEntity);
    }

    @Override
    public List<JobApplicationEntity> getAllJobApplication() {
        return IJobApplicationRepository.findAll();
    }

    @Override
    public JobApplicationEntity getJobApplicationById(int id) {
        if(IJobApplicationRepository.findById(id).isPresent()) {
            return IJobApplicationRepository.findById(id).get();
        } else return null;
    }

    @Override
    public List<JobApplicationEntity> getJobApplicationByJobId(int jobId) {
        if(IJobApplicationRepository.findJobApplicationEntitiesByJobIdEquals(jobId).isPresent()) {
         return IJobApplicationRepository.findJobApplicationEntitiesByJobIdEquals(jobId).get();
        } else return null;
    }
}
