package com.spe.mncManagement.services.implementation;

import com.spe.mncManagement.bean.Credentials;
import com.spe.mncManagement.bean.Employee;
import com.spe.mncManagement.dao.EmployeeDao;
import com.spe.mncManagement.dao.LoginDao;
import com.spe.mncManagement.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private LoginDao loginDao;

    @Autowired
    private EmployeeDao employeeDao;

    @Override
    public Credentials signup(Credentials credentials){
        System.out.println("in service");
        if(loginDao.findByUsernameEquals(credentials.getUsername()) == null)
        {
            System.out.println("\nusername does not exists");
            return loginDao.save(credentials);
        }
        else{
            System.out.println("\nusername exists");

        }
        return null;
    }

    @Override
    public Credentials login(String username, String password){
        System.out.println("service "+username+"  "+password);
        return loginDao.findByUsernameEqualsAndPasswordEquals(username,password);

    }

    @Override
    public Employee update_employee_details(Employee employee){
        System.out.println("populating employee details at the time of signup\n");
        return employeeDao.save(employee);
    }
}
