package com.spe.mncManagement.dao;

import com.spe.mncManagement.bean.Request;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RequestDao extends JpaRepository<Request,Long> {
}
