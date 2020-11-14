package capstone.openjob.category.controller;


import capstone.openjob.entity.CategoryEntity;
import capstone.openjob.category.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/v1/recruiter-management")
@CrossOrigin(value = "http://localhost:4200")
public class CategoryController {

    @Autowired
    private ICategoryService categoryService;

    HttpHeaders httpHeaders = new HttpHeaders();

    @RequestMapping(value = "/category", method = RequestMethod.POST)
    @ResponseBody
    ResponseEntity<CategoryEntity> createRecruiter(@RequestBody CategoryEntity categoryEntity) {
    if(categoryEntity.getName() == null) {
        httpHeaders.set("error", "Name is empty");
        return new ResponseEntity<>(httpHeaders, HttpStatus.BAD_REQUEST);
    }
        return new ResponseEntity<>(categoryService.createCategory(categoryEntity), HttpStatus.OK);
    }

    @RequestMapping(value = "/category", method = RequestMethod.PUT)
    @ResponseBody
    ResponseEntity<CategoryEntity> updateRecruiter(@RequestBody CategoryEntity categoryEntity) {
        if(categoryEntity.getName() == null) {
            httpHeaders.set("error", "Name is empty");
            return new ResponseEntity<>(httpHeaders, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(categoryService.updateCategory(categoryEntity), HttpStatus.OK);
    }

    @RequestMapping(value = "/categories", method = RequestMethod.GET)
    @ResponseBody
    ResponseEntity<List<CategoryEntity>> getAllRecruiter() {

        return new ResponseEntity<List<CategoryEntity>>(categoryService.getAllCategory(), HttpStatus.OK);
    }

    @RequestMapping(value = "/category/{id}", method = RequestMethod.GET)
    @ResponseBody
    ResponseEntity<CategoryEntity> getRecruiterById(@PathVariable("id") int id) {

        return new ResponseEntity<CategoryEntity>(categoryService.getCategoryById(id), HttpStatus.OK);
    }


}
