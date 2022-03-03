package com.example.footballManager;

import com.example.footballManager.service.PlayersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class FootballManagerApplication {
@Autowired
	PlayersService playersService;
	public static void main(String[] args) {
		SpringApplication.run(FootballManagerApplication.class, args);
	}

}
