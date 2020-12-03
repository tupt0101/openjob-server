package capstone.openjob.job.service;

import capstone.openjob.dao.IJobRepository;
import capstone.openjob.entity.JobEntity;
import capstone.openjob.job.constant.JobStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobService implements IJobService{
    @Autowired
    private IJobRepository IJobRepository;


    @Override
    public JobEntity createJob(JobEntity job) {
        return IJobRepository.save(job);
    }

    @Override
    public JobEntity updateJob(JobEntity job) {
        return IJobRepository.save(job);
    }

    @Override
    public List<JobEntity> getAllJob() {
        return IJobRepository.findAll();
    }

    @Override
    public JobEntity closeJob(int id) {
        JobEntity job = IJobRepository.getOne(id);
        job.setStatus(JobStatus.CLOSED.getValue());
        return IJobRepository.save(job);
    }

    @Override
    public JobEntity getJobById(int id) {
        if (IJobRepository.findById(id).isPresent()) {
            return IJobRepository.findById(id).get();
        } else return null;
    }

    @Override
    public List<JobEntity> getJobByAccountId(int id) {
        if (IJobRepository.findJobEntitiesByAccountIdEquals(id).isPresent()) {
            return IJobRepository.findJobEntitiesByAccountIdEquals(id).get();
        } else return null;    }

    @Override
    public List<JobEntity> getOpenJob() {
        if (IJobRepository.findAllByStatus("Published").isPresent()) {
            return IJobRepository.findAllByStatus("Published").get();
        } else return null;
    }

    @Override
    public List<JobEntity> searchJob(String search) {
        return IJobRepository.searchJob(search);
    }
}
