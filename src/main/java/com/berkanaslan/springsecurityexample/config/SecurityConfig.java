package com.berkanaslan.springsecurityexample.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
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
        auth.inMemoryAuthentication().withUser("mary").password("secret123").roles("EMPLOYEE", "MANAGER");
        auth.inMemoryAuthentication().withUser("susan").password("secret123").roles("EMPLOYEE", "ADMIN");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/").hasRole("EMPLOYEE")
                .antMatchers("/leaders/**").hasRole("MANAGER")
                .antMatchers("/systems/**").hasRole("ADMIN")
                .and().formLogin()
                .loginPage("/showLoginPage").loginProcessingUrl("/authenticateTheUser")
                .permitAll().and().logout().permitAll();
    }
}

