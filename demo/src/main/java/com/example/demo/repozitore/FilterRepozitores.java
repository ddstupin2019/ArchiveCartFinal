package com.example.demo.repozitore;

import com.example.demo.enity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FilterRepozitores {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Carta getCart(Filters filters){
        String zapros = "select * from \"VirificateCart\" where ";
        try {
            String a = " and ";
            zapros += "\"id\">" + filters.getId();
            zapros+=a;
            zapros += "\"sezon\"=" + filters.getSezon();
            if (filters.getMashtab() != 0) {
                zapros += a;
                zapros += "\"mashtab\"=" + filters.getMashtab();
            }
            if (filters.getRelef() != 0) {
                zapros += a;
                zapros += "\"relef\"=" + filters.getRelef();
            }
            if (filters.getVid() != -1) {
                zapros += a;
                zapros += "\"vid\"=" + filters.getVid();
            }
            if (filters.getGod() != 0) {
                zapros += a;
                zapros += "\"god\"=" + filters.getGod();
            }

            System.out.println(zapros);
            List<Carta> persons = jdbcTemplate.query(zapros, new CartaMapper());

            return persons.get(0);
        }catch (Exception e){
            System.out.println(zapros);
            return null;
        }
    }
}
