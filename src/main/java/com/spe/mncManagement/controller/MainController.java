package com.spe.mncManagement.controller;

import com.spe.mncManagement.bean.Credentials;
import com.spe.mncManagement.bean.Employee;
import com.spe.mncManagement.bean.Project;
import com.spe.mncManagement.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;


@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class MainController {

    Logger logger = LoggerFactory.getLogger(MainController.class);

    @Autowired
    private UserService userService;

    // register : returns null if the username already exists
    // populates the employee and credentials table otherwise
    @PostMapping(path = "/signup",
                produces = {"application/json"},
                consumes = {"application/json"})
    public Credentials signup(@RequestBody Credentials credentials){
        System.out.println("controller : "+credentials.getUsername()+"  "
                            +credentials.getPassword()+" "+credentials.getEmpId()+"  "+credentials.getUser_type() );

        Credentials obj = new Credentials();
        obj = userService.signup(credentials);

        if(obj == null) return new Credentials();
        Employee e = new Employee();
        e.setEmpId(obj.getEmpId());
        e.setArea_of_expertise("");
        e.setFirst_name("");
        e.setLast_name("");
        userService.update_employee_details(e);
        logger.info("user registered");
        return obj;
    }


    // login
    @PostMapping(path = "/login",
            produces = {"application/json"},
            consumes = {"application/json"})
    public ResponseEntity<Credentials> login(@RequestBody Credentials credentials){
        System.out.println("controller : "+credentials.getUsername()+"  "+credentials.getPassword());
        Credentials c = userService.login(credentials.getUsername(),credentials.getPassword());
        if(c==null){
            logger.info("login : invalid credentials");
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        logger.info("login : successful");
        return new ResponseEntity<>(c, HttpStatus.OK);

    }

    // list of all the employees
    @GetMapping("/listEmployees")
    public ResponseEntity<List<Credentials>> getUserList(){
        logger.info("returning list of all the employees");
        return new ResponseEntity<>(userService.getUserList(), HttpStatus.OK);
    }

    // list the developers
    @GetMapping("/list/dev")
    public ResponseEntity<List<Employee>> getDevList(){
        logger.info("returning list of all the developers");
        return new ResponseEntity<>(userService.getDevList(), HttpStatus.OK);
    }

}
