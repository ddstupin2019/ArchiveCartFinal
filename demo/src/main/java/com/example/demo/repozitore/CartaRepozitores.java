package com.example.demo.repozitore;

import com.example.demo.enity.Carta;
import com.example.demo.enity.CartaMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CartaRepozitores {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public String addCardNOV(Carta carta, boolean inp){
        String v="VirificateCart";
        String n="NoVirificateCart";
        String a;
        if (inp){
                jdbcTemplate.update("INSERT INTO \"VirificateCart\" VALUES (DEFAULT ,'"+carta.getCart()+"',"+carta.getMashtab()+","+carta.getRelef()+", '"
                    +carta.getMesto()+"', "+carta.getGod()+", "+carta.getSezon()+", '"+carta.getGroup()+"'" + ", "+carta.getVid()+");");

        }else {
            jdbcTemplate.update("INSERT INTO \"NoVirificateCart\" VALUES ( DEFAULT ,'"+carta.getCart()+"',"+carta.getMashtab()+","+carta.getRelef()+", '"
                    +carta.getMesto()+"', "+carta.getGod()+", "+carta.getSezon()+", '"+carta.getGroup()+"'" + ", "+carta.getVid()+");");
            System.out.println("INSERT INTO \"NoVirificateCart\" VALUES (DEFAULT ,'"+carta.getCart()+"',"+carta.getMashtab()+","+carta.getRelef()+", '"
                    +carta.getMesto()+"', "+carta.getGod()+", "+carta.getSezon()+", '"+carta.getGroup()+"'" + ", "+carta.getVid()+");");
        }
        return "Запрс успешно выполнен";
    }
    public void delete(Integer id){
        jdbcTemplate.update("DELETE from \"NoVirificateCart\" where \"id\" = ?", id);
    }

    public Carta getNoVIrCart(){
        List<Carta> carta = jdbcTemplate.query("select * from \"NoVirificateCart\" where id >?", new CartaMapper(), 0);
        return carta.get(0);
    }
}
