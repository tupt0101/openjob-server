package capstone.openjob.skill.controller;

import capstone.openjob.entity.CategoryEntity;
import capstone.openjob.entity.SkillEntity;
import capstone.openjob.skill.service.ISkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/v1/skill-management")
@CrossOrigin(value = "http://localhost:4200")
public class SkillController {

    @Autowired
    private ISkillService skillService;

    HttpHeaders httpHeaders = new HttpHeaders();

    @RequestMapping(value = "/skill", method = RequestMethod.POST)
    @ResponseBody
    ResponseEntity<SkillEntity> createSkill(@RequestBody SkillEntity skillEntity) {
        if(skillEntity.getName() == null || skillEntity.getName().isEmpty()) {
            httpHeaders.set("error", "Name is empty");
            return new ResponseEntity<>(httpHeaders, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(skillService.createSkill(skillEntity), HttpStatus.OK);
    }

    @RequestMapping(value = "/skill", method = RequestMethod.PUT)
    @ResponseBody
    ResponseEntity<SkillEntity> updateSkill(@RequestBody SkillEntity skillEntity) {
        if(skillEntity.getName() == null || skillEntity.getName().isEmpty()) {
            httpHeaders.set("error", "Name is empty");
            return new ResponseEntity<>(httpHeaders, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(skillService.updateSkill(skillEntity), HttpStatus.OK);
    }

    @RequestMapping(value = "/skills", method = RequestMethod.GET)
    @ResponseBody
    ResponseEntity<List<SkillEntity>> getAllSkill() {

        return new ResponseEntity<List<SkillEntity>>(skillService.getAllSkill(), HttpStatus.OK);
    }

    @RequestMapping(value = "/skill/{id}", method = RequestMethod.GET)
    @ResponseBody
    ResponseEntity<SkillEntity> getSkillById(@PathVariable("id") int id) {

        return new ResponseEntity<SkillEntity>(skillService.getSkillById(id), HttpStatus.OK);
    }

}
