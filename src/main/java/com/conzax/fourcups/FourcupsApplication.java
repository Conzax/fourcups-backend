package com.conzax.fourcups;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication(exclude = {ErrorMvcAutoConfiguration.class})
@Controller
public class FourcupsApplication {

	public static void main(String[] args) {
		SpringApplication.run(FourcupsApplication.class, args);
	}

	@GetMapping(value = "/")
	public String index() {
		return "index";
	}

}
