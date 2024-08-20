package com.TrucksAuctions.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.TrucksAuctions.services.CustomUserDetailsService;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    private CustomUserDetailsService customUserDetailsService;

    @Bean
    static PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
        .csrf(csrf -> csrf.disable())
        .authorizeHttpRequests(authorize -> authorize
                .requestMatchers("/styles/**", "/images/**", 
                "/JS/**", "/error/**")
                .permitAll()
                .requestMatchers("/", "/register", "/login", 
                "login-page", "/user/register", "landing-page").permitAll()
                .requestMatchers("/trucks", "/add-trcuks",
                "/trucks/save").authenticated()
                .requestMatchers("/auctions/init")
                .hasAuthority("ROLE_ADMIN")
                .anyRequest().authenticated())
        .formLogin(formLogin -> formLogin
                .loginPage("/login-page").permitAll()
                .loginProcessingUrl("/login")
                .usernameParameter("email")
                .defaultSuccessUrl("/trucks")
                .failureUrl("/login-page?error=true")
                .permitAll())
        .logout(logout -> logout
                .logoutSuccessUrl("/").permitAll());
        return http.build();
    }

    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
        .userDetailsService(customUserDetailsService)
        .passwordEncoder(passwordEncoder());
    }
}