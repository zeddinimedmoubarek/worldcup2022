package tn.rnu.isi.worldcup;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@EnableJpaRepositories(basePackages="tn.rnu.isi.worldcup")
@SpringBootApplication
public class Worldcup2022Application {

	public static void main(String[] args) {
		SpringApplication.run(Worldcup2022Application.class, args);
	}
}

