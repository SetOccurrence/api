package br.com.occurrence.api.infrastructure.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories(basePackages = "br.com.occurrence.api.infrastructure.mongo")
public class MongoConfig {
}
