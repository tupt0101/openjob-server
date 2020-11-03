package capstone.openjob.company.controller;


import capstone.openjob.company.service.ICompanyService;
import capstone.openjob.entity.CompanyEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/v1/candidate-management")
public class CompanyController {

    @Autowired
    private ICompanyService companyService;

    HttpHeaders httpHeaders = new HttpHeaders();

    @RequestMapping(value = "/company", method = RequestMethod.POST)
    @ResponseBody
    ResponseEntity<CompanyEntity> createCompany(@RequestBody CompanyEntity companyEntity) {
        if(companyEntity.getName() == null) {
            httpHeaders.set("error", "Name is empty");
            return new ResponseEntity<>(httpHeaders, HttpStatus.BAD_REQUEST);
        } else if(companyEntity.getLocation() == null || companyEntity.getLocation().isEmpty()) {
            httpHeaders.set("error", "Location is empty");
            return new ResponseEntity<>(httpHeaders, HttpStatus.BAD_REQUEST);
        } else if(companyEntity.getTaxCode() == null || companyEntity.getTaxCode().isEmpty()) {
            httpHeaders.set("error", "Tax Code is empty");
            return new ResponseEntity<>(httpHeaders, HttpStatus.BAD_REQUEST);
        } else if(companyEntity.getEmail() == null || companyEntity.getEmail().isEmpty()) {
            httpHeaders.set("error", "Email is empty");
            return new ResponseEntity<>(httpHeaders, HttpStatus.BAD_REQUEST);
        } else if(companyEntity.getPhoneNo() == null || companyEntity.getPhoneNo().isEmpty()) {
            httpHeaders.set("error", "Phone Number is empty");
            return new ResponseEntity<>(httpHeaders, HttpStatus.BAD_REQUEST);
        } else if(companyEntity.getDescription() == null || companyEntity.getDescription().isEmpty()) {
            httpHeaders.set("error", "Description is empty");
            return new ResponseEntity<>(httpHeaders, HttpStatus.BAD_REQUEST);
        } else if(companyEntity.getAvatar() == null || companyEntity.getAvatar().isEmpty()) {
            httpHeaders.set("error", "Avatar is empty");
            return new ResponseEntity<>(httpHeaders, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(companyService.createCompany(companyEntity), HttpStatus.OK);
    }

    @RequestMapping(value = "/company", method = RequestMethod.PUT)
    @ResponseBody
    ResponseEntity<CompanyEntity> updateCompany(@RequestBody CompanyEntity companyEntity) {
        if(companyEntity.getName() == null) {
            httpHeaders.set("error", "Name is empty");
            return new ResponseEntity<>(httpHeaders, HttpStatus.BAD_REQUEST);
        } else if(companyEntity.getLocation() == null || companyEntity.getLocation().isEmpty()) {
            httpHeaders.set("error", "Location is empty");
            return new ResponseEntity<>(httpHeaders, HttpStatus.BAD_REQUEST);
        } else if(companyEntity.getTaxCode() == null || companyEntity.getTaxCode().isEmpty()) {
            httpHeaders.set("error", "Tax Code is empty");
            return new ResponseEntity<>(httpHeaders, HttpStatus.BAD_REQUEST);
        } else if(companyEntity.getEmail() == null || companyEntity.getEmail().isEmpty()) {
            httpHeaders.set("error", "Email is empty");
            return new ResponseEntity<>(httpHeaders, HttpStatus.BAD_REQUEST);
        } else if(companyEntity.getPhoneNo() == null || companyEntity.getPhoneNo().isEmpty()) {
            httpHeaders.set("error", "Phone Number is empty");
            return new ResponseEntity<>(httpHeaders, HttpStatus.BAD_REQUEST);
        } else if(companyEntity.getDescription() == null || companyEntity.getDescription().isEmpty()) {
            httpHeaders.set("error", "Description is empty");
            return new ResponseEntity<>(httpHeaders, HttpStatus.BAD_REQUEST);
        } else if(companyEntity.getAvatar() == null || companyEntity.getAvatar().isEmpty()) {
            httpHeaders.set("error", "Avatar is empty");
            return new ResponseEntity<>(httpHeaders, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(companyService.updateCompany(companyEntity), HttpStatus.OK);
    }

    @RequestMapping(value = "/companies", method = RequestMethod.GET)
    @ResponseBody
    ResponseEntity<List<CompanyEntity>> getAllCandidate() {

        return new ResponseEntity<List<CompanyEntity>>(companyService.getAllCompany(), HttpStatus.OK);
    }

    @RequestMapping(value = "/company/{id}", method = RequestMethod.GET)
    @ResponseBody
    ResponseEntity<CompanyEntity> getCandidateById(@PathVariable("id") int id) {

        return new ResponseEntity<CompanyEntity>(companyService.findCompanyById(id), HttpStatus.OK);
    }
}


