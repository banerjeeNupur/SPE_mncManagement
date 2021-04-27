package com.spe.mncManagement.services.implementation;

import com.spe.mncManagement.bean.Project;
import com.spe.mncManagement.dao.ProjectDao;
import com.spe.mncManagement.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    private ProjectDao projectDao;

    public Project add(Project project){
        System.out.println("--------------- Adding project ----------------\n");
        return projectDao.save(project);
    }

    public List<Project> getProjectList(){
        return  projectDao.findAll();
    }

    public Optional<Project> getProject(Long id){
        System.out.println("--------------- Service impl : view project ----------------\n");
        return projectDao.findById(id);
    }

    // update a given project
    public Project updateProject(Project project){
        System.out.println("--------------- Service impl : update project ----------------\n");
        Project p = new Project();
        Long id = project.getId();
        projectDao.deleteById(id);
        p.setProjectId(project.getProjectId()); p.setManager_id(project.getManager_id()); p.setName(project.getName());
        p.setStatus(project.getStatus()); p.setTechnology(project.getTechnology());
        return projectDao.save(p);

    }
}
