package com.myspringboot.springbootfirst;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.myspringboot.springbootfirst.dao.UserRepository;
import com.myspringboot.springbootfirst.entities.User;

@SpringBootApplication
public class SpringbootfirstApplication {

	public static void main(String[] applicationArguments) {
		ConfigurableApplicationContext context = SpringApplication.run(SpringbootfirstApplication.class,
				applicationArguments);

		System.out.println("Application is running...");

		UserRepository uRepo = context.getBean(UserRepository.class);

		User user = new User("Utkarsh", "utkarsh@gmail.com", "lucknow", "active");

		User resultUser = uRepo.save(user);

		System.out.println(resultUser);
	}

}
