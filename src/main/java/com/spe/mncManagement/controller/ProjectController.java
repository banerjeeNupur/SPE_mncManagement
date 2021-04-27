package com.spe.mncManagement.controller;

import com.spe.mncManagement.bean.Project;
import com.spe.mncManagement.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/project")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    // add a new project
    @PostMapping(path = "/add",
            produces = {"application/json"},
            consumes = {"application/json"})
    public Project add(@RequestBody Project project){
        System.out.println("------------ controller : add project ---------------\n");
        return projectService.add(project);

    }

    // list of all the projects
    @GetMapping("/list")
    public List<Project> getProjectList(){
        return projectService.getProjectList();
    }

    // get project by ID
    @GetMapping("/view/{projectId}")
    public Optional<Project> getProject(@PathVariable String projectId){
        System.out.println("-------------- view a given project -----------\n");
        return projectService.getProject(Long.parseLong(projectId));
    }

    @PutMapping("/update")
    public Project updateProject(@RequestBody Project project){
        System.out.println("controller : update a given project -----------\n");
        return projectService.updateProject(project);
    }
}
