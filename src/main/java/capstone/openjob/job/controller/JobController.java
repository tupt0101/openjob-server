package capstone.openjob.job.controller;


//import capstone.openjob.account.service.IAccountService;

import capstone.openjob.common.CommonUtils;
import capstone.openjob.entity.JobEntity;
import capstone.openjob.job.service.IJobService;
import capstone.openjob.oauth2.services.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.util.Comparator;
import java.util.List;

@RestController
@RequestMapping(path = "/v1/job-management")
@CrossOrigin(value = "http://localhost:4200")
public class JobController {
    @Autowired
    private IJobService jobService;

//    @Autowired
//    private IAccountService accountService;

    @Autowired
    private CustomUserDetailsService userDetailsService;

    HttpHeaders httpHeaders = new HttpHeaders();

    @RequestMapping(value = "/jobs", method = RequestMethod.GET)
    @ResponseBody
    ResponseEntity<List<JobEntity>> getAllJob() {
        List<JobEntity> jobList = jobService.getAllJob();
        if (!CollectionUtils.isEmpty(jobList)) {
            jobList.sort(Comparator.comparingInt(JobEntity::getId).reversed());
        }
        return new ResponseEntity<List<JobEntity>>(jobList, HttpStatus.OK);

    }

    @PostMapping(value = "/job", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    ResponseEntity<JobEntity> createJob(@RequestBody JobEntity job) {
//        if (job.getTitle() == null || job.getTitle().isEmpty()) {
//            httpHeaders.set("error", "Title is empty");
//            return new ResponseEntity<>(httpHeaders, HttpStatus.BAD_REQUEST);
//        }
//        if (job.getDescription() == null || job.getDescription().isEmpty()) {
//            httpHeaders.set("error", "Apply from is empty");
//            return new ResponseEntity<>(httpHeaders, HttpStatus.BAD_REQUEST);
//        }
//
//        if (job.getApplyTo() == null) {
//            httpHeaders.set("error", "Apply to is empty");
//            return new ResponseEntity<>(httpHeaders, HttpStatus.BAD_REQUEST);
//        }
//
//        if (job.getCreateDate() == null) {
//            httpHeaders.set("error", "Create Date is empty");
//            return new ResponseEntity<>(httpHeaders, HttpStatus.BAD_REQUEST);
//        }
//
//        if (job.getCompanyId() == null) {
//            httpHeaders.set("error", "Company Id is empty");
//            return new ResponseEntity<>(httpHeaders, HttpStatus.BAD_REQUEST);
//        }
//
//        if (job.getCurrency() == null || job.getCurrency().isEmpty()) {
//            httpHeaders.set("error", "Currency is empty");
//            return new ResponseEntity<>(httpHeaders, HttpStatus.BAD_REQUEST);
//        }
//
//        if (job.getSalaryFrom() < 0 ) {
//            httpHeaders.set("error", "Invalid salary is empty");
//            return new ResponseEntity<>(httpHeaders, HttpStatus.BAD_REQUEST);
//        }
//        if (job.getSalaryTo() == null ) {
//            httpHeaders.set("error", "Invalid salary to is empty");
//            return new ResponseEntity<>(httpHeaders, HttpStatus.BAD_REQUEST);
//        }
//        if (job.getStatus() == null || job.getStatus().isEmpty()) {
//            httpHeaders.set("error", "Status is empty");
//            return new ResponseEntity<>(httpHeaders, HttpStatus.BAD_REQUEST);
//        }
//        if (job.getVacancies() == null) {
//            httpHeaders.set("error", "Vacancies is empty");
//            return new ResponseEntity<>(httpHeaders, HttpStatus.BAD_REQUEST);
//        }
//        if (job.getJobType() == null || job.getJobType().isEmpty()) {
//            httpHeaders.set("error", "Job type is empty");
//            return new ResponseEntity<>(httpHeaders, HttpStatus.BAD_REQUEST);
//        }
//        if (job.getCategoryId() == null ) {
//            httpHeaders.set("error", "Category is empty");
//            return new ResponseEntity<>(httpHeaders, HttpStatus.BAD_REQUEST);
//        }
//        if (job.getLocation() == null || job.getLocation().isEmpty()) {
//            httpHeaders.set("error", "Location is empty");
//            return new ResponseEntity<>(httpHeaders, HttpStatus.BAD_REQUEST);
//        }
//        if (job.getAccountId() == null ) {
//            httpHeaders.set("error", "Account Id is empty");
//            return new ResponseEntity<>(httpHeaders, HttpStatus.BAD_REQUEST);
//        }

        job.setCreateDate(java.time.LocalDateTime.now());
        return new ResponseEntity<>(jobService.createJob(job), HttpStatus.OK);
    }

    @RequestMapping(value = "/job", method = RequestMethod.PUT)
    @ResponseBody
    ResponseEntity<JobEntity> updateJob(@RequestBody JobEntity job) {
        if (job.getTitle() == null || job.getTitle().isEmpty()) {
            httpHeaders.set("error", "Title is empty");
            return new ResponseEntity<>(httpHeaders, HttpStatus.BAD_REQUEST);
        }
        if (job.getDescription() == null || job.getDescription().isEmpty()) {
            httpHeaders.set("error", "Apply from is empty");
            return new ResponseEntity<>(httpHeaders, HttpStatus.BAD_REQUEST);
        }

        if (job.getApplyTo() == null) {
            httpHeaders.set("error", "Apply to is empty");
            return new ResponseEntity<>(httpHeaders, HttpStatus.BAD_REQUEST);
        }

        if (job.getCreateDate() == null) {
            httpHeaders.set("error", "Create Date is empty");
            return new ResponseEntity<>(httpHeaders, HttpStatus.BAD_REQUEST);
        }

        if (job.getCompanyId() == null) {
            httpHeaders.set("error", "Company Id is empty");
            return new ResponseEntity<>(httpHeaders, HttpStatus.BAD_REQUEST);
        }

        if (job.getCurrency() == null || job.getCurrency().isEmpty()) {
            httpHeaders.set("error", "Currency is empty");
            return new ResponseEntity<>(httpHeaders, HttpStatus.BAD_REQUEST);
        }

        if (job.getSalaryFrom() < 0) {
            httpHeaders.set("error", "Invalid salary is empty");
            return new ResponseEntity<>(httpHeaders, HttpStatus.BAD_REQUEST);
        }
        if (job.getSalaryTo() == null) {
            httpHeaders.set("error", "Invalid salary to is empty");
            return new ResponseEntity<>(httpHeaders, HttpStatus.BAD_REQUEST);
        }
        if (job.getStatus() == null || job.getStatus().isEmpty()) {
            httpHeaders.set("error", "Status is empty");
            return new ResponseEntity<>(httpHeaders, HttpStatus.BAD_REQUEST);
        }
        if (job.getVacancies() == null) {
            httpHeaders.set("error", "Vacancies is empty");
            return new ResponseEntity<>(httpHeaders, HttpStatus.BAD_REQUEST);
        }
        if (job.getJobType() == null || job.getJobType().isEmpty()) {
            httpHeaders.set("error", "Job type is empty");
            return new ResponseEntity<>(httpHeaders, HttpStatus.BAD_REQUEST);
        }
//        if (job.getCategoryId() == null ) {
//            httpHeaders.set("error", "Category is empty");
//            return new ResponseEntity<>(httpHeaders, HttpStatus.BAD_REQUEST);
//        }
        if (job.getLocation() == null || job.getLocation().isEmpty()) {
            httpHeaders.set("error", "Location is empty");
            return new ResponseEntity<>(httpHeaders, HttpStatus.BAD_REQUEST);
        }
        if (job.getAccountId() == null) {
            httpHeaders.set("error", "Account Id is empty");
            return new ResponseEntity<>(httpHeaders, HttpStatus.BAD_REQUEST);
        }


        return new ResponseEntity<>(jobService.updateJob(job), HttpStatus.OK);
    }

    @RequestMapping(value = "/job/{id}/close", method = RequestMethod.PUT)
    @ResponseBody
    ResponseEntity<JobEntity> closeJob(@PathVariable("id") int id) {
        if (jobService.getJobById(id) == null) {
            httpHeaders.set("error", "Can not find job to update");
            return new ResponseEntity<>(httpHeaders, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(jobService.closeJob(id), HttpStatus.OK);
    }


    @RequestMapping(value = "/job/{id}", method = RequestMethod.GET)
    @ResponseBody
    ResponseEntity<JobEntity> getJobById(@PathVariable("id") int id) {
        return new ResponseEntity<JobEntity>(jobService.getJobById(id), HttpStatus.OK);
    }

    @RequestMapping(value = "/open-jobs", method = RequestMethod.GET)
    @ResponseBody
    ResponseEntity<List<JobEntity>> getAllOpenJob() {
        List<JobEntity> jobList = jobService.getOpenJob();
        if (!CollectionUtils.isEmpty(jobList)) {
            jobList.sort(Comparator.comparingInt(JobEntity::getId).reversed());
        }
        return new ResponseEntity<List<JobEntity>>(jobList, HttpStatus.OK);
    }

    @RequestMapping(value = "/job-by-account-id/{id}", method = RequestMethod.GET)
    @ResponseBody
    ResponseEntity<List<JobEntity>> getJobByAccountId(@PathVariable("id") int id) {
        return new ResponseEntity<List<JobEntity>>(jobService.getJobByAccountId(id), HttpStatus.OK);
    }

    @RequestMapping(value = "/job-by-criteria", method = RequestMethod.GET)
    @ResponseBody
    ResponseEntity<List<JobEntity>> getJobByCriteria(@RequestParam("criteria") String criteria,
                                                     @RequestParam(value = "numOfElement") Integer numOfElement,
                                                     @RequestParam(value = "page") Integer page,
                                                     @RequestParam(value = "sort") String sort) {
        Pageable pageable = CommonUtils.configPageable(numOfElement, page, sort);
        return new ResponseEntity<List<JobEntity>>(jobService.searchJob(criteria, pageable), HttpStatus.OK);
    }
}
