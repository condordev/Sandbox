package de.sgrad.dependencyinjection;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class DependencyInjectionApplication {

	public static void main(String[] args) {

		ConfigurableApplicationContext context = SpringApplication.run(DependencyInjectionApplication.class, args);
		Customer c =  context.getBean(Customer.class);
		c.display();
	}


}


