package team.worlder.api.starwars.config;

import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("team.worlder.api.starwars")
@ConfigurationPropertiesScan("team.worlder.api.starwars.properties")
@PropertySource("classpath:application-${spring.profiles.active:prod}.properties")
public class TestConfig {
}