package com.example.erfan_adine_ptest.security.config;

import io.jsonwebtoken.security.Keys;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import javax.crypto.SecretKey;


@Configuration
@RequiredArgsConstructor
public class JwtSecretKey {
    private  final JwtConfig config;

    @Bean
    public SecretKey secretKey(){
        return Keys.hmacShaKeyFor(config.getSecretKey().getBytes());
    }
}
