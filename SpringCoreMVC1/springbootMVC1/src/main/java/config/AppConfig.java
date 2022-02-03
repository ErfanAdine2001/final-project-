package config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Profile;
import org.springframework.scheduling.annotation.EnableScheduling;



@Profile("dev")
@EnableAspectJAutoProxy
@Configuration
@EnableScheduling
@ComponentScan("com.example.springbootmvc1")
public class AppConfig {
}
