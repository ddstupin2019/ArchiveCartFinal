package com.example.demo.enity;

import java.awt.*;
import java.util.List;

public class Parse {
    public static String parseCart(Carta cart){
        String a ="http://localhost:8080/Verified/setCart?cart="+cart.getCart()+"&sezon="+cart.getSezon()+"&mesto="+cart.getMesto()+"&group="+cart.getGroup()+
                "&vid="+cart.getVid()+"&relef="+cart.getRelef()+"&mashtab="+cart.getMashtab();
        return a;
    }

    public static String parseCartTorezout(Carta cart){

        if(cart!=null){
            String a="";
            a +="cart="+cart.getCart()+"&sezon="+cart.getSezon()+"&mesto="+cart.getMesto()+"&group="+cart.getGroup()+
                    "&vid="+cart.getVid()+"&relef="+cart.getRelef()+"&mashtab="+cart.getMashtab()+"\n";
            return a;
        }else{
            return "Нет таких карт";
        }
    }

    public static Carta parseStringToCart(String inp){
        try {
            Carta carta=new Carta();
            String[] inpst1=inp.split(" ");
            for (String s: inpst1){
                String[] a = s.split("=");
                if (a[1].equals("")){
                    return null;
                }
                switch (a[0]){
                    case "cart":
                        carta.setCart("ещё пока не сделал");
                        break;
                    case "sezon":
                        if(a[1].equals("зима")){
                            carta.setSezon(true);
                        }else{
                            carta.setSezon(false);
                        }
                        break;
                    case "mashtab":
                        carta.setMashtab(Integer.valueOf(a[1]));
                        break;
                    case "relef":
                        carta.setRelef(Integer.valueOf(a[1]));
                        break;
                    case "mesto":
                        carta.setMesto(a[1]);
                        break;
                    case "group":
                        carta.setGroup(a[1]);
                        break;
                    case "vid":
                        switch (a[1]){
                            case "классика":
                                carta.setVid(1);
                                break;
                            case "спринт":
                                carta.setVid(2);
                                break;
                            case "лонг":
                                carta.setVid(3);
                                break;
                            case "рогейн":
                                carta.setVid(4);
                                break;
                            case "эстафета":
                                carta.setVid(5);
                                break;
                            case "выбор":
                                carta.setVid(6);
                                break;
                        }
                        break;
                    case "god":
                        carta.setGod(Integer.valueOf(a[1]));
                        break;

                }
                return carta;
            }
        }catch (Exception e){
            return null;
        }
        return null;
    }
}
