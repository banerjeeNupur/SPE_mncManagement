package com.spe.mncManagement.dao;

import com.spe.mncManagement.bean.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectDao extends JpaRepository<Project, Long> {


}
