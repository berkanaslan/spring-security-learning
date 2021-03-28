package com.berkanaslan.springsecurityexample.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.util.logging.Logger;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.berkanaslan.springsecurityexample")
@PropertySource("classpath:persistence-mysql.properties")
public class SpringSecurityExampleConfig {

    // Set up the variable to hold the properties
    @Autowired
    private Environment environment;

    // Set up a logger for diagnostics
    private Logger logger = Logger.getLogger(getClass().getName());

    // Define a bean for ViewResolver
    @Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();

        viewResolver.setPrefix("/WEB-INF/view/");
        viewResolver.setSuffix(".jsp");

        return viewResolver;
    }

    // Define a bean for our security datasource
    @Bean
    public DataSource securityDataSource() {

        // Create connection pool
        ComboPooledDataSource securityDataSource = new ComboPooledDataSource();

        // Set the JDBC driver class
        try {
            securityDataSource.setDriverClass(environment.getProperty("jdbc.driver"));
        } catch (PropertyVetoException e) {
            throw new RuntimeException(e);
        }

        // Log the connection props
        logger.info(">> jdbc.url=" + environment.getProperty("jdbc.url"));
        logger.info(">> jdbc.user=" + environment.getProperty("jdbc.user"));

        // Set database connection props
        securityDataSource.setJdbcUrl(environment.getProperty("jdbc.url"));
        securityDataSource.setUser(environment.getProperty("jdbc.user"));
        securityDataSource.setPassword(environment.getProperty("jdbc.password"));

        // Set connection pool props
        securityDataSource.setInitialPoolSize(getIntProperty("connection.pool.initialPoolSize"));
        securityDataSource.setMinPoolSize(getIntProperty("connection.pool.minPoolSize"));
        securityDataSource.setMaxPoolSize(getIntProperty("connection.pool.maxPoolSize"));
        securityDataSource.setMaxIdleTime(getIntProperty("connection.pool.maxIdleTime"));

        return securityDataSource;
    }

    private int getIntProperty(String propName) {
        String propValue = environment.getProperty(propName);
        return Integer.parseInt(propValue);
    }
}
