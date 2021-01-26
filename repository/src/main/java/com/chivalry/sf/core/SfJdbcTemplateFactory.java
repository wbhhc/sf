package com.chivalry.sf.core;

import org.springframework.jdbc.core.JdbcTemplate;

public class SfJdbcTemplateFactory {

    JdbcTemplate jdbcTemplate;

    public SfJdbcTemplateFactory(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public JdbcTemplate Create(){
        return this.jdbcTemplate;
    }
}
