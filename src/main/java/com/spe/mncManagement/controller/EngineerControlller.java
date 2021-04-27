package com.spe.mncManagement.controller;

import com.spe.mncManagement.bean.Project;
import com.spe.mncManagement.bean.Request;
import com.spe.mncManagement.services.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/engineer")
public class EngineerControlller {

    @Autowired
    private RequestService requestService;

    @PostMapping(path = "/sendRequest",
            produces = {"application/json"},
            consumes = {"application/json"})
    public Request sendRequest(@RequestBody Request request){
        System.out.println("------------ controller : add project ---------------\n");
        return requestService.sendRequest(request);

    }
}
