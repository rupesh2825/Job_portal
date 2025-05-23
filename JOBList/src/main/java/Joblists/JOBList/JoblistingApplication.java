package Joblists.JOBList;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Job Listing API", version = "1.0", description = "API documentation for Job Listings"))
public class JoblistingApplication {
	public static void main(String[] args) {
		SpringApplication.run(JoblistingApplication.class, args);
	}
}

