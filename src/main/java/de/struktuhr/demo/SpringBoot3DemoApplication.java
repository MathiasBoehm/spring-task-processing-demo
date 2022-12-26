package de.struktuhr.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.util.UUID;

@EnableAsync
@EnableScheduling
@SpringBootApplication
public class SpringBoot3DemoApplication {

	private final static Logger logger = LoggerFactory.getLogger(SpringBoot3DemoApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(SpringBoot3DemoApplication.class, args);
	}

	@Bean
	public String appId() {
		final String appId = UUID.randomUUID().toString();
		logger.info("Initialized with appId {}", appId);
		return appId;
	}
}
