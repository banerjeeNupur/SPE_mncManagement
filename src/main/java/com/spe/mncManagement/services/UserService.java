package com.spe.mncManagement.services;

import com.spe.mncManagement.bean.Credentials;
import com.spe.mncManagement.bean.Employee;

public interface UserService {

    public Credentials login(String username, String password);
    public Credentials signup(Credentials credentials);
    public Employee update_employee_details(Employee employee);
}
