package com.burakyildiz.springboot;

import com.burakyildiz.springboot.business.concretes.CategoryManager;
import com.burakyildiz.springboot.business.concretes.ProductManager;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringBootHomeworkApplication {

	public static void main(String[] args) {

		ConfigurableApplicationContext applicationContext = SpringApplication.run(SpringBootHomeworkApplication.class, args);

		CategoryManager categoryManager = applicationContext.getBean(CategoryManager.class);
		ProductManager productManager = applicationContext.getBean(ProductManager.class);
	}

}
