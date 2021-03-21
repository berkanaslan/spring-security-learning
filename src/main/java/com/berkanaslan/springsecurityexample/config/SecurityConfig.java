package com.berkanaslan.springsecurityexample.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @author Berkan Aslan
 * 21.03.2021
 */

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser("john").password("secret123").roles("EMPLOYEE");
        auth.inMemoryAuthentication().withUser("mary").password("secret123").roles("MANAGER");
        auth.inMemoryAuthentication().withUser("susan").password("secret123").roles("ADMIN");
    }

}

