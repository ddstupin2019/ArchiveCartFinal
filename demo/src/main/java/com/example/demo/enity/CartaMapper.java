package com.example.demo.enity;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CartaMapper implements RowMapper<Carta> {
    @Override
    public Carta mapRow(ResultSet rs, int rowNum) throws SQLException {
        Carta carta = new Carta();

        carta.setId(rs.getInt("id"));
        carta.setGod(rs.getInt("god"));
        carta.setMashtab(rs.getInt("mashtab"));
        carta.setRelef(rs.getInt("relef"));
        carta.setVid(rs.getInt("vid"));
        carta.setCart(rs.getString("cart"));
        carta.setGroup(rs.getString("group"));
        carta.setMesto(rs.getString("mesto"));
        carta.setSezon(rs.getBoolean("sezon"));

        return carta;
    }
}
