package com.ddatabase.show.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Configuration
public class ShowConfig {
    @Bean
    public JdbcTemplate jdbctemplate(final DataSource dataSource)
    {
        return new JdbcTemplate(dataSource);
    }

}
