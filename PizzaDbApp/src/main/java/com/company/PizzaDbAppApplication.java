package com.company;

import com.company.entity.User;
import com.company.respository.UserRepository;
import com.company.service.UserServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

@SpringBootApplication
public class PizzaDbAppApplication{

//	@Autowired
//	UserRepository userRepository;
//
//	@Autowired
//	UserServiceInter userServiceInter;

	public static void main(String[] args) {
		SpringApplication.run(PizzaDbAppApplication.class, args);
	}


//	@Override
//	public void run(String... args) throws Exception {
//		System.err.println("bashladi");
//
//		Page<User> usersPage = userServiceInter.findByFilters("mahammad",null, "baku",1L);
//		System.err.println("pages = "+usersPage.getTotalPages());
//		System.err.println("UserCount = "+usersPage.getTotalElements());
//		System.err.println("users = "+usersPage.get().collect(Collectors.toList()));
//
//		System.err.println("bitdi");
//	}
}
