package com.spe.mncManagement;

import com.spe.mncManagement.bean.Credentials;
import com.spe.mncManagement.dao.LoginDao;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class MncManagementApplicationTests {
	@Autowired
	LoginDao loginDao;

	@Test
	public void login() {
		Credentials c = loginDao.findByUsernameEqualsAndPasswordEquals("admin","admin");
		String a = c.getUsername();
		Assert.assertNotNull(c);
		Assert.assertEquals("admin",a);
		Assert.assertNotEquals("dheer",a);
	}

}