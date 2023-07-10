package com.employeeproject.employeeproject.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.employeeproject.employeeproject.repository.employeerepository;

import jakarta.validation.Valid;



@RestController
@RequestMapping("/api/v1")
public class employee
 {
    employeerepository employeerepository;
    employee employee;
    @Autowired
    @PostMapping(value = "/citizen")
    public ResponseEntity<String> createCitizen(@Valid @RequestBody  employee employee) {
        if (employee.getname() == null){
            return new ResponseEntity(" Employee Name  Blank Plese Enter", HttpStatus.BAD_REQUEST);
        }
        else if (employee.gethousename() == null){
            return new ResponseEntity(" Employee House Name  Blank Plese Enter", HttpStatus.BAD_REQUEST);
        }

        else{
            employee emp = employeerepository.save(employee);
            int id = emp.getId();
            return ResponseEntity.status(HttpStatus.CREATED)
                    .header("Location", "/api/v1/citizen/" + id)
                    .body("Citizen created");

        }
    }
    private Object gethousename() {
        return null;
    }
    private int getId() {
        return 0;
    }
    private Object getname() {
        return null;
    }
    
}
