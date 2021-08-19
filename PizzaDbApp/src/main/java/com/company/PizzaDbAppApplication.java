package com.company;

import com.company.entity.User;
import com.company.respository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class PizzaDbAppApplication {

	@Autowired
	UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(PizzaDbAppApplication.class, args);
	}

	@Bean
	public CommandLineRunner setRunner(){
		CommandLineRunner runner = new CommandLineRunner() {
			@Override
			public void run(String... args) throws Exception {
				List<User> u = userRepository.findAll();
				System.out.println(u);
			}
		};
		return runner;
	}


}
