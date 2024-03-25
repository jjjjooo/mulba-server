package com.app.mulba.global.config;

import com.app.mulba.global.jwt.service.TokenManager;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PlainSecurityConfig {

    @Value("${token.access-token-expiration-time}")
    private String accessTokenExpirationTime;
    @Value("${token.refresh-token-expiration-time}")
    private String refreshTokenExpirationTime;
    @Value("${token.secret}")
    private String tokenSecret;

    @Bean
    public TokenManager tokenManager(){
        return new TokenManager(accessTokenExpirationTime, refreshTokenExpirationTime, tokenSecret);
    }

}
