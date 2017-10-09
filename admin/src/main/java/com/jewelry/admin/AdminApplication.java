package com.jewelry.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

//@EnableRedisHttpSession(maxInactiveIntervalInSeconds = 1800)
@EnableTransactionManagement
@EntityScan(basePackages = {
		"com.jewelry.core.entity"
})
@EnableJpaRepositories(basePackages = {
		"com.jewelry.core.repository"
})
@SpringBootApplication(scanBasePackages = {
		"com.jewelry.core.service",
		"com.jewelry.admin.service",
		"com.jewelry.admin.controller"
})
public class AdminApplication {

	public static void main(String[] args) {
		SpringApplication.run(AdminApplication.class, args);
	}
}
