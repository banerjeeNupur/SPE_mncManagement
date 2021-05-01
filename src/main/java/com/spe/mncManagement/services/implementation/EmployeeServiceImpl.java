package com.spe.mncManagement.services.implementation;

import com.spe.mncManagement.bean.Employee;
import com.spe.mncManagement.bean.Project;
import com.spe.mncManagement.dao.EmployeeDao;
import com.spe.mncManagement.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeDao employeeDao;

    public Employee add(Employee employee){
        System.out.println("--------------- Adding employee ----------------\n");
        return employeeDao.save(employee);
    }

}
