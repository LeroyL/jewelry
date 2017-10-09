package com.jewelry.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableRedisHttpSession(maxInactiveIntervalInSeconds = 1800)
@EnableTransactionManagement
@EntityScan(basePackages = {
		"com.jewelry.core.entity"
})
@EnableJpaRepositories(basePackages = {
		"com.jewelry.core.repository"
})
@SpringBootApplication(scanBasePackages = {
		"com.jewelry.core.service",
		"com.jewelry.client.service",
		"com.jewelry.client.controller"
})
public class ClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClientApplication.class, args);
	}
}
