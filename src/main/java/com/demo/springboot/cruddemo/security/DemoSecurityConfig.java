package com.demo.springboot.cruddemo.security;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class DemoSecurityConfig {

        // @Bean => In Memory
        // public InMemoryUserDetailsManager userDetailsManager() {
        // UserDe tails john = User.builder().username("john")
        // .password("{noop}test123")
        // .roles("EMPLOYEE")
        // .build();

        // UserDetails mary = User.builder().username("mary")
        // .password("{noop}test1234")
        // .roles("EMPLOYEE", "MANAGER")
        // .build();

        // UserDetails susan = User.builder().username("susan")
        // .password("{noop}test12345")
        // .roles("EMPLOYEE", "MANAGER", "ADMIN")
        // .build();

        // return new InMemoryUserDetailsManager(john, mary, susan);
        // }

        // @Bean => Default Schema
        // public UserDetailsManager userDetailsManager(DataSource ds) {
        // return new JdbcUserDetailsManager(ds);
        // }

        @Bean
        public UserDetailsManager userDetailsManager(DataSource ds) {
                JdbcUserDetailsManager manager = new JdbcUserDetailsManager(ds);
                manager.setUsersByUsernameQuery("SELECT user_id, pw, active FROM members WHERE user_id=?");
                manager.setAuthoritiesByUsernameQuery("SELECT user_id, role FROM roles WHERE user_id=?");
                return manager;
        }

        @Bean
        public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
                http.csrf((csrf) -> {
                        csrf.disable();
                });
                http.authorizeHttpRequests((config) -> {
                        config
                                        .requestMatchers(HttpMethod.POST, "/api/members").permitAll()
                                        .requestMatchers(HttpMethod.GET, "/api/employees").hasAnyRole("EMPLOYEE")
                                        .requestMatchers(HttpMethod.GET, "/api/employees/**").hasAnyRole("EMPLOYEE")
                                        .requestMatchers(HttpMethod.POST, "/api/employees").hasAnyRole("MANAGER")
                                        .requestMatchers(HttpMethod.PUT, "/api/employees").hasAnyRole("MANAGER")
                                        .requestMatchers(HttpMethod.DELETE, "/api/employees/**").hasAnyRole("ADMIN");
                });
                http.httpBasic(Customizer.withDefaults());
                return http.build();
        }
}