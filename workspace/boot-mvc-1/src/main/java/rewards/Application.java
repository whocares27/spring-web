package rewards;

import org.springframework.boot.SpringApplication;

// TODO 01: Mark this as a Spring Boot application
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	// TODO 01a: Look at the files under src/main/resources
	/*
	 * The schema.sql and data.sql (formerly test-data.sql) files
	 * have been moved under src/main/resources, since Spring Boot's
	 * auto-configuration uses them by default.
	 * 
	 * In application.properties, no spring.datasource.url was provided.
	 * As such, Spring Boot's auto-configuration will look at the classpath
	 * for embedded databases (e.g. HSQLDB) to initialize.
	 */

}
