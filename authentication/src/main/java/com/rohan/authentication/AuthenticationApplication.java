package com.rohan.authentication;

import com.rohan.authentication.dao.UserDao;
import com.rohan.authentication.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class AuthenticationApplication {

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	public static void main(String[] args) {
		SpringApplication.run(AuthenticationApplication.class, args);
	}

	@Bean
	public CommandLineRunner init(UserDao userDao){
		return args -> {

			User user = new User();
			user.setName("Doe");
			user.setMobile("9790933505");
			user.setUsername("user@demo.com");
			user.setPassword(passwordEncoder.encode("demo"));
			userDao.save(user);
		};
	}

}
