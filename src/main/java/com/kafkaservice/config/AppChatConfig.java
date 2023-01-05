package com.kafkaservice.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@ComponentScan({"com.example.appchat.service", "com.example.appchat.actor", "com.example.appchat.config"})
@EnableJpaRepositories(basePackages = {"com.example.appchat.repository"})
@EntityScan("com.example.appchat.model.entity")
@ConfigurationPropertiesScan("com.example.appchat.config")
public class AppChatConfig {
}
