package com.example.demo.controller;

import com.example.demo.enity.*;
import com.example.demo.repozitore.CartaRepozitores;
import com.example.demo.repozitore.FilterRepozitores;
import com.google.gson.Gson;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("Verified")
public class VerifiedcardsController {

    @Autowired
    CartaRepozitores cartaRepozitores;
    @Autowired
    FilterRepozitores filterRepozitores;

    @RequestMapping(value = "/setCart", method = RequestMethod.GET)
    public String setCart(@RequestParam("cart") MultipartFile file, @RequestParam("sezon") Boolean sezon, @RequestParam("mesto") String mesto, @RequestParam("group") String group, @RequestParam("vid") Integer vid, @RequestParam("relef") Integer relef, @RequestParam("mashtab") Integer mashtab , Model model){
        Carta carta=new Carta();
        String cart = file.getOriginalFilename()+System.currentTimeMillis();
        String filePath = "C:\\Users\\ddstu\\Server\\"+cart;
        try {
            file.transferTo(new File(filePath));
        } catch (IOException e) {
            return "asd";
        }
        carta.setCart(cart);
        carta.setSezon(sezon);
        carta.setMesto(mesto);
        carta.setGroup(group);
        carta.setVid(vid);
        carta.setRelef(relef);
        carta.setMashtab(mashtab);


        cartaRepozitores.delete(1);

        return cartaRepozitores.addCardNOV(carta,true);
    }

    public static Filters f;

    @RequestMapping(value = "/getCart", method = RequestMethod.POST)
    public ModelAndView getCart(@RequestParam("sezon") String sezon, @RequestParam("mashtab") Integer mashtab,
                           @RequestParam("relef") Integer relef,
                           @RequestParam("mesto") String mesto,@RequestParam("group") String group,
                           @RequestParam("vid") String vid, @RequestParam("god") Integer god, Model model){
        Filters filters=new Filters();

        filters.setGroup(group);
        filters.setMashtab(mashtab);
        if (mesto.equals("0")){
            System.out.println("11111111111111111111111111111111111111111111111111111111111111");
        }
        filters.setMesto(mesto);
        filters.setRelef(relef);
        if (sezon.equals("зима")) {
            filters.setSezon(true);
        } else {
            filters.setSezon(false);
        }
        switch (vid) {
            case "классика":
                filters.setVid(1);
                break;
            case "спринт":
                filters.setVid(0);
                break;
            case "лонг":
                filters.setVid(2);
                break;
            case "выбор":
                filters.setVid(3);
                break;
            case "рогейн":
                filters.setVid(4);
                break;
            case "0":
                filters.setVid(-1);
                break;
        }
        filters.setGod(god);
        filters.setId(0);

        Carta cart=filterRepozitores.getCart(filters);

        System.out.println("1111");
        while (cart!=null){
            if(Poisk.poisk(cart, filters.getMesto())){
                model.addAttribute("filCart", YndecsDiscSviz.getFileUrl(cart.getCart()));
                f=filters;
                f.setId(cart.getId());
                return new ModelAndView("lol/getCart/rezTrue", HttpStatus.OK);
            }else{
                filters.setId(cart.getId());
                cart=filterRepozitores.getCart(filters);
            }
        }
        return new ModelAndView("lol/getCart/False", HttpStatus.OK);
    }
    @RequestMapping(value = "/getCart2", method = RequestMethod.GET)
    public ModelAndView getCart2(Model model){
        Carta cart=filterRepozitores.getCart(f);

        while (cart!=null){
            if(Poisk.poisk(cart, f.getMesto())){
                model.addAttribute("filCart", YndecsDiscSviz.getFileUrl(cart.getCart()));
                f.setId(cart.getId());
                return new ModelAndView("lol/getCart/rezTrue", HttpStatus.OK);
            }else{
                f.setId(cart.getId());
                cart=filterRepozitores.getCart(f);
            }
        }
        return new ModelAndView("lol/getCart/False", HttpStatus.OK);
    }

    @RequestMapping(value = "/getCartSt", method = RequestMethod.GET)
    public ModelAndView getCartSt(){
        System.out.println(123);
        return new ModelAndView("lol/getCart/filter_a", HttpStatus.OK);
    }

}
