package capstone.openjob.account.controller;

import capstone.openjob.account.service.IAccountService;
import capstone.openjob.entity.AccountEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/v1/account-mananagement")
@CrossOrigin(value = "http://localhost:4200")
public class AccountController {

    @Autowired
    private IAccountService accountService;

    HttpHeaders httpHeaders = new HttpHeaders();

    @RequestMapping(value = "/account", method = RequestMethod.POST)
    @ResponseBody
    ResponseEntity<AccountEntity> createAccount(@RequestBody AccountEntity accountEntity) {
        if (accountEntity.getEmail() == null || accountEntity.getEmail().isEmpty()) {
            httpHeaders.set("error", "Email is empty");
            return new ResponseEntity<>(httpHeaders, HttpStatus.BAD_REQUEST);
        } else if (accountEntity.getPassword() == null || accountEntity.getPassword().isEmpty()) {
            httpHeaders.set("error", "Password is empty");
            return new ResponseEntity<>(httpHeaders, HttpStatus.BAD_REQUEST);
        } else if (accountEntity.getRole() == null || accountEntity.getRole().isEmpty()) {
            httpHeaders.set("error", "Role is empty");
            return new ResponseEntity<>(httpHeaders, HttpStatus.BAD_REQUEST);
        } else if (accountEntity.getPhoneNo() == null) {
            httpHeaders.set("error", "Phone No is empty");
            return new ResponseEntity<>(httpHeaders, HttpStatus.BAD_REQUEST);
        } else if (accountEntity.getCv() == null) {
            httpHeaders.set("error", "Cv is empty");
            return new ResponseEntity<>(httpHeaders, HttpStatus.BAD_REQUEST);
        } else if (accountService.findAccountByEmail(accountEntity.getEmail()) != null) {
            httpHeaders.set("error", "This email is already registered");
            return new ResponseEntity<>(httpHeaders, HttpStatus.BAD_REQUEST);
        } else if (accountService.findAccountEntityById(accountEntity.getId()) != null) {
            httpHeaders.set("error", "Account already exist");
            return new ResponseEntity<>(httpHeaders, HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity<>(accountService.createAccount(accountEntity), HttpStatus.OK);
        }
    }


    @RequestMapping(value = "/account", method = RequestMethod.PUT)
    @ResponseBody
    ResponseEntity<AccountEntity> updateAccount(@RequestBody AccountEntity accountEntity) {

        if (accountEntity.getEmail() == null || accountEntity.getEmail().isEmpty()) {
            httpHeaders.set("error", "Email is empty");
            return new ResponseEntity<>(httpHeaders, HttpStatus.BAD_REQUEST);
        } else if (accountEntity.getPassword() == null || accountEntity.getPassword().isEmpty()) {
            httpHeaders.set("error", "Password is empty");
            return new ResponseEntity<>(httpHeaders, HttpStatus.BAD_REQUEST);
        } else if (accountEntity.getRole() == null || accountEntity.getRole().isEmpty()) {
            httpHeaders.set("error", "Role is empty");
            return new ResponseEntity<>(httpHeaders, HttpStatus.BAD_REQUEST);
        } else if (accountEntity.getPhoneNo() == null) {
            httpHeaders.set("error", "Phone No is empty");
            return new ResponseEntity<>(httpHeaders, HttpStatus.BAD_REQUEST);
        } else if (accountEntity.getCv() == null) {
            httpHeaders.set("error", "Cv is empty");
            return new ResponseEntity<>(httpHeaders, HttpStatus.BAD_REQUEST);
        } else if (accountService.findAccountByEmail(accountEntity.getEmail()) != null) {
            httpHeaders.set("error", "This email is already registered");
            return new ResponseEntity<>(httpHeaders, HttpStatus.BAD_REQUEST);
        } else if (accountService.findAccountEntityById(accountEntity.getId()) == null) {
            httpHeaders.set("error", "Account doesn't exist");
            return new ResponseEntity<>(httpHeaders, HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity<>(accountService.updateAccount(accountEntity), HttpStatus.OK);
        }

    }

    @RequestMapping(value = "/accounts", method = RequestMethod.GET)
    @ResponseBody
    ResponseEntity<List<AccountEntity>> getAllAccount() {
        return new ResponseEntity<List<AccountEntity>>(accountService.getAllAccount(), HttpStatus.OK);
    }

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    @ResponseBody
    ResponseEntity<List<AccountEntity>> test() {
        return new ResponseEntity<List<AccountEntity>>(accountService.getAllAccount(), HttpStatus.OK);
    }

    @RequestMapping(value = "/account/{id}", method = RequestMethod.GET)
    @ResponseBody
    ResponseEntity<AccountEntity> getAccountById(@PathVariable("id") int id) {
        return new ResponseEntity<AccountEntity>(accountService.findAccountEntityById(id), HttpStatus.OK);
    }

    @RequestMapping(value = "/account-by-email/{email}", method = RequestMethod.GET)
    @ResponseBody
    ResponseEntity<AccountEntity> getAccountByMail(@PathVariable("email") String email) {
        return new ResponseEntity<AccountEntity>(accountService.findAccountByEmail(email), HttpStatus.OK);
    }
}
