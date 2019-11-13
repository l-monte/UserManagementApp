package com.lman.application;

import com.lman.application.entitites.User;
import com.lman.application.entitites.UserId;
import com.lman.application.repositories.UserRepository;
import com.lman.application.utils.IdGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.sql.Timestamp;
import java.util.stream.Stream;

@SpringBootApplication
public class Application {

	@Autowired
	IdGenerator idGenerator;

	@Autowired
	UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@PostConstruct
	public void init() {

		System.out.println("MONTE: Application::init() [creating User instance]");

		Stream.of("John", "Frank", "Elizabet", "Julie", "Jennifer", "Helen", "Rachel", "Majkel").forEach(name -> {
			User user = new User(
						new UserId(idGenerator.uniqueId()),
						name,
						"Nowak",
						name + "@domain.com",
						new Timestamp(System.currentTimeMillis())
			);

			userRepository.save(user);
		});

		userRepository.findAll().forEach(System.out::println);
	}

}
