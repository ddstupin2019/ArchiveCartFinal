package com.example.demo.enity;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CartsMapper implements RowMapper<Carta> {
    @Override
    public Carta mapRow(ResultSet rs, int rowNum) throws SQLException {
        return null;
    }
}
