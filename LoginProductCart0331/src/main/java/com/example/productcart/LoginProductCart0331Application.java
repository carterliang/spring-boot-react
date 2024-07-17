package com.example.productcart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.productcart.model.*;

@SpringBootApplication
public class LoginProductCart0331Application implements CommandLineRunner {

	@Autowired
	LoginUserDAO userdao;

	public static void main(String[] args) {
		SpringApplication.run(LoginProductCart0331Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
//		userdao.save(new LoginUser("Mary","m123",true));
//		userdao.save(new LoginUser("John","j456",true));
//		userdao.save(new LoginUser("David","d123",false));

	}

}
