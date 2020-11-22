package capstone.openjob.jobApplication.controller;


import capstone.openjob.entity.JobApplicationEntity;
import capstone.openjob.jobApplication.service.IJobApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/v1/job-application-management")
@CrossOrigin(value = "http://localhost:4200")
public class JobApplicationController {

    @Autowired
    private IJobApplicationService jobApplicationService;

    HttpHeaders httpHeaders = new HttpHeaders();

    @RequestMapping(value = "/job-application", method = RequestMethod.POST)
    @ResponseBody
    ResponseEntity<JobApplicationEntity> createJobApplication(@RequestBody JobApplicationEntity jobApplicationEntity) {
        if(jobApplicationEntity.getJobId() == null) {
            httpHeaders.set("error", "Job Id is empty");
            return new ResponseEntity<>(httpHeaders, HttpStatus.BAD_REQUEST);
        } else if(jobApplicationEntity.getAccountId() == null) {
            httpHeaders.set("error", "Account Id is empty");
            return new ResponseEntity<>(httpHeaders, HttpStatus.BAD_REQUEST);
        } else if(jobApplicationEntity.getApplyAt() == null) {
            httpHeaders.set("error", "Apply at date is empty");
            return new ResponseEntity<>(httpHeaders, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(jobApplicationService.createJobApplication(jobApplicationEntity), HttpStatus.OK);
    }

    @RequestMapping(value = "/job-application", method = RequestMethod.PUT)
    @ResponseBody
    ResponseEntity<JobApplicationEntity> updateJobApplication(@RequestBody JobApplicationEntity jobApplicationEntity) {
        if(jobApplicationEntity.getJobId() == null) {
            httpHeaders.set("error", "Job Id is empty");
            return new ResponseEntity<>(httpHeaders, HttpStatus.BAD_REQUEST);
        } else if(jobApplicationEntity.getAccountId() == null) {
            httpHeaders.set("error", "Account Id is empty");
            return new ResponseEntity<>(httpHeaders, HttpStatus.BAD_REQUEST);
        } else if(jobApplicationEntity.getApplyAt() == null) {
            httpHeaders.set("error", "Apply at date is empty");
            return new ResponseEntity<>(httpHeaders, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(jobApplicationService.updateJobApplication(jobApplicationEntity), HttpStatus.OK);
    }

    @RequestMapping(value = "/job-applications", method = RequestMethod.GET)
    @ResponseBody
    ResponseEntity<List<JobApplicationEntity>> getAllJobApplication() {

        return new ResponseEntity<List<JobApplicationEntity>>(jobApplicationService.getAllJobApplication(), HttpStatus.OK);
    }

    @RequestMapping(value = "/job-application/{id}", method = RequestMethod.GET)
    @ResponseBody
    ResponseEntity<JobApplicationEntity> getJobApplicationById(@PathVariable("id") int id) {

        return new ResponseEntity<JobApplicationEntity>(jobApplicationService.getJobApplicationById(id), HttpStatus.OK);
    }

    @RequestMapping(value = "/job-application/find-by-job-id/{jobId}", method = RequestMethod.GET)
    @ResponseBody
    ResponseEntity<List<JobApplicationEntity>> getJobApplicationsByJobId(@PathVariable("jobId") int jobId) {

        return new ResponseEntity<List<JobApplicationEntity>>(jobApplicationService.getJobApplicationByJobId(jobId), HttpStatus.OK);
    }


}
