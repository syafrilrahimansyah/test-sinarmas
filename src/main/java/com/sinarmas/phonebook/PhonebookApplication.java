package com.sinarmas.phonebook;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication()
@ComponentScan({"com.sinarmas.phonebook.controller","com.sinarmas.phonebook.service","com.sinarmas.phonebook","com.sinarmas.phonebook.persistence"})
@Import({Config.class, DaoConfig.class})
@EnableJpaRepositories
public class PhonebookApplication {

	public static void main(String[] args) {
		SpringApplication.run(PhonebookApplication.class, args);
	}

}
