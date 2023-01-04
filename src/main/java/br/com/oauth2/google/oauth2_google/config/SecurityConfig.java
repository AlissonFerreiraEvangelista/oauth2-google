package br.com.oauth2.google.oauth2_google.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.oauth2.server.resource.OAuth2ResourceServerConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
    
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
        .cors().disable()
        .csrf().disable()
        .authorizeHttpRequests((auth)->{
            try {
               auth
               .requestMatchers(HttpMethod.GET, "/publico").permitAll()
               .requestMatchers("/logout").permitAll()
               .anyRequest().authenticated(); 
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        })
        .oauth2Login(Customizer.withDefaults())
        .oauth2ResourceServer(OAuth2ResourceServerConfigurer::jwt);
        return http.build();
    }
}
