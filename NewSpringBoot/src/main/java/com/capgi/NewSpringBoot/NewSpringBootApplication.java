package com.capgi.NewSpringBoot;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.annotations.common.util.impl.Log_$logger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cglib.core.Local;


@SpringBootApplication
public class NewSpringBootApplication implements CommandLineRunner {
	public static final Log LOGGER = LogFactory.getLog(NewSpringBootApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(NewSpringBootApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		LOGGER.info("Run");
	}
}
