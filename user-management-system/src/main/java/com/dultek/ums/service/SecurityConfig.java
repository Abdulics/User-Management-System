package com.dultek.ums.service;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class SecurityConfig {

    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource) {
        return new JdbcUserDetailsManager(dataSource);
    }
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(configurer ->
                        configurer
                                .requestMatchers("/", "/css/**").permitAll()
                                .requestMatchers("/employees/list").hasRole("EMPLOYEE")
                                .requestMatchers("/employees/profile/**").hasRole("EMPLOYEE")
                                .requestMatchers("/employees/showFormForAdd/**").hasRole("MANAGER")
                                .requestMatchers("/employees/showFormForUpdate/**").hasRole("ADMIN")
                                .requestMatchers("/employees/delete/**").hasRole("ADMIN")
                                .anyRequest().authenticated()
                )
                .formLogin(form ->
                        form
                                .loginPage("/login")  // Specify the correct login page URL
                                .loginProcessingUrl("/authUser")
                                .defaultSuccessUrl("/employees/profile")
                                .permitAll()
                )
                .logout(logout -> logout.permitAll()
                        .logoutSuccessUrl("/"))
                .exceptionHandling(configurer -> configurer.accessDeniedPage("/access-denied"));

        return http.build();
    }

}
