package com.conzax.fourcups;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.UUID;

//@SpringBootApplication(exclude = {ErrorMvcAutoConfiguration.class})
@SpringBootApplication
public class FourcupsApplication {

	public static void main(String[] args) {
		SpringApplication.run(FourcupsApplication.class, args);

		UUID uuid = UUID.randomUUID();
		String uuid1 = uuid.toString().replace("-", "");

		System.out.println(uuid1);
		System.out.println(uuid.toString());
	}
}
