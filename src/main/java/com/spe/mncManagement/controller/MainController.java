package com.spe.mncManagement.controller;

import com.spe.mncManagement.bean.Credentials;
import com.spe.mncManagement.bean.Employee;
import com.spe.mncManagement.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
public class MainController {

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
        return obj;
    }


    // login
    @PostMapping(path = "/login",
            produces = {"application/json"},
            consumes = {"application/json"})
    public Credentials login(@RequestBody Credentials credentials){
        System.out.println("controller : "+credentials.getUsername()+"  "+credentials.getPassword());
        return userService.login(credentials.getUsername(),credentials.getPassword());

    }
}
