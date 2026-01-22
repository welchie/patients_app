package org.weewelchie.patients;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.persistence.autoconfigure.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
public class PatientsApplication {

	public static void main(String[] args) {
		SpringApplication.run(PatientsApplication.class, args);
	}

}
