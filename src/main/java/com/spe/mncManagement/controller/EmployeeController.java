package com.spe.mncManagement.controller;

import com.spe.mncManagement.bean.Employee;
import com.spe.mncManagement.bean.Project;
import com.spe.mncManagement.bean.Request;
import com.spe.mncManagement.services.EmployeeService;
import com.spe.mncManagement.services.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/engineer")
public class EmployeeController {

//    @Autowired
//    private RequestService requestService;

    @Autowired
    private EmployeeService employeeService;

//    @PostMapping(path = "/sendRequest",
//            produces = {"application/json"},
//            consumes = {"application/json"})
//    public Request sendRequest(@RequestBody Request request){
//        System.out.println("------------ controller : add project ---------------\n");
//        return requestService.sendRequest(request);
//
//    }

    @PostMapping(path = "/add",
            produces = {"application/json"},
            consumes = {"application/json"})
    public Employee add(@RequestBody Employee employee){
        System.out.println("------------ controller : add project ---------------\n");
        return employeeService.add(employee);

    }


}
