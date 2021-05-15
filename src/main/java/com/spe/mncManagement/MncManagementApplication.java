package com.spe.mncManagement;

import com.spe.mncManagement.bean.Credentials;
import com.spe.mncManagement.dao.LoginDao;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;

@SpringBootApplication (exclude = HibernateJpaAutoConfiguration.class)
public class MncManagementApplication {

	@Autowired
	LoginDao loginDao;

	public static void main(String[] args) {
		SpringApplication.run(MncManagementApplication.class, args);
	}



	@Bean
	InitializingBean Credentials(){
		return () -> {
			loginDao.save(new Credentials(1L,"admin","admin","admin"));
		};
	}



}
