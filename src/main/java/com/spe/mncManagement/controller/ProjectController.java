package com.spe.mncManagement.controller;

import com.spe.mncManagement.bean.Project;
import com.spe.mncManagement.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/project")
@CrossOrigin(origins = "http://localhost:3000")
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
    public ResponseEntity<List<Project>> getProjectList(){
        return new ResponseEntity<>(projectService.getProjectList(), HttpStatus.OK);
    }

    // get project by ID
    @GetMapping("/view/{projectId}")
    public Optional<Project> getProject(@PathVariable String projectId){
        System.out.println("-------------- view a given project -----------\n");
        return projectService.getProject(Long.parseLong(projectId));
    }

    @PutMapping("/update")
    public Project updateProject(@RequestBody Project project){
        System.out.println("controller : update a given project -----------\n"+project.getId()+"---"+project.getName()+
                "---"+project.getProjectId()+"---"+
                project.getStatus()+"---"+project.getTechnology()+
                "---"+project.getManager_id());
        return projectService.updateProject(project);
    }

    @DeleteMapping("/delete/{projectId}")
    public ResponseEntity<HttpStatus> deleteProject(@PathVariable String projectId){
        System.out.println("deleting project with id: "+ projectId);
        projectService.deleteProject(Long.parseLong(projectId));
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
