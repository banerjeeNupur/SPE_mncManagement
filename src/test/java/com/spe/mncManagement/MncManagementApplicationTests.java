package com.spe.mncManagement;

import com.spe.mncManagement.bean.Credentials;
import com.spe.mncManagement.bean.Employee;
import com.spe.mncManagement.dao.EmployeeDao;
import com.spe.mncManagement.dao.LoginDao;
import com.spe.mncManagement.dao.ProjectDao;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.*;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class MncManagementApplicationTests {
	@Autowired
	LoginDao loginDao;

	@Autowired
	EmployeeDao employeeDao;

	@Autowired
	ProjectDao projectDao;

	@Test
	public void login() {
		Credentials c = loginDao.findByUsernameEqualsAndPasswordEquals("admin","admin");
		String a = c.getUsername();
		Assert.assertNotNull(c);
		Assert.assertEquals("admin",a);
		Assert.assertNotEquals("dheer",a);

		Credentials c1 = loginDao.findByUsernameEqualsAndPasswordEquals("casper","casper");
		String a1 = c1.getUsername();
		Assert.assertNotNull(c1);
		Assert.assertEquals("casper",a1);
		Assert.assertNotEquals("cas",a1);

		Credentials c2 = loginDao.findByUsernameEqualsAndPasswordEquals("nupur","nupur");
		String a2 = c2.getUsername();
		Assert.assertNotNull(c2);
		Assert.assertEquals("nupur",a2);
		Assert.assertNotEquals("nup",a2);
	}

	@Test
	public void allemployee()
	{
		List<Employee> emp = employeeDao.findAll();
		int num=2;
		Assert.assertEquals(num,emp.size());
	}

}