package com.spe.mncManagement.services.implementation;

import com.spe.mncManagement.bean.Employee;
import com.spe.mncManagement.bean.Project;
import com.spe.mncManagement.dao.EmployeeDao;
import com.spe.mncManagement.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeDao employeeDao;

    public Employee add(Employee employee){
        System.out.println("--------------- Adding employee ----------------\n");
        return employeeDao.save(employee);
    }

    public Optional<Employee> getEmployee(Long id){
        System.out.println("--------------- employee impl : get emp ----------------\n");
        Optional<Employee> e = employeeDao.findByEmpId(id);
        System.out.println(e);
        return  e;
    }

    // update employee details
    @Transactional
    public Employee updateEmpDetails(Employee employee){
        System.out.println("--------------- Service impl : update employee details ----------------\n");
        Employee e = new Employee();
        Long id = employee.getEmpId();
        System.out.println("before employee deleted");
        employeeDao.deleteEmployeeByEmpId(id);

        System.out.println("employee deleted");
        e.setLast_name(employee.getLast_name());
        e.setFirst_name(employee.getFirst_name());
        e.setArea_of_expertise(employee.getArea_of_expertise());
        e.setEmpId(employee.getEmpId());
        return employeeDao.save(e);

    }


}
