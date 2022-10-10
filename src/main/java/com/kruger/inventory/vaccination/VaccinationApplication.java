package com.kruger.inventory.vaccination;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * This class will boot the Rest Vaccination API
 */
@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Control Vaccination API", version = "1.0.0"),
					tags = {@Tag(name = "Vaccine Controllers",description = "Maintaining and Quering the Vaccines handled by the Companny Kruger"),
					@Tag(name = "Employee Controllers",description = "Maintaining and Quering the Employees of the Kruger Companny")
					}
					)
public class VaccinationApplication {

	public static void main(String[] args) {
		SpringApplication.run(VaccinationApplication.class, args);
	}

}
