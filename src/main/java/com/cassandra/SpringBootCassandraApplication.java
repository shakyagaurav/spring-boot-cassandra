package com.cassandra;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;

@SpringBootApplication
@EnableCassandraRepositories(basePackages = "com.cassandra.repository")
public class SpringBootCassandraApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootCassandraApplication.class, args);
	}

}
