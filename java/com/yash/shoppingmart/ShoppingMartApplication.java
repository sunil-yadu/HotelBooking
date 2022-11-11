package com.yash.shoppingmart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;

@SpringBootApplication(exclude= HibernateJpaAutoConfiguration.class)
public class ShoppingMartApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShoppingMartApplication.class, args);
	}

}
