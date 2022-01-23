package com.example.erfan_adine_p1_2.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Profile;

@ComponentScan("com.example.erfan_adine_p1_2")
@Profile({"test","dev"})
@EnableAspectJAutoProxy
@Configuration
public class AppConfig {
}
