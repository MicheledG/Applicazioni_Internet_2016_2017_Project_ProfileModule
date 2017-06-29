package it.polito.ai.profile.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@ComponentScan(basePackages = "it.polito.ai")
@EnableWebMvc
public class AppConfig {
}
