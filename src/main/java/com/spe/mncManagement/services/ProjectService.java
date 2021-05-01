package com.spe.mncManagement.services;

import com.spe.mncManagement.bean.Project;

import java.util.*;

public interface ProjectService {

    public Project add(Project project);
    public List<Project> getProjectList();
    public Optional<Project> getProject(Long id);
    public Project updateProject(Project project);
    public void deleteProject(Long id);
}
