package com.example.demo.controller;

import com.example.demo.enity.Carta;
import com.example.demo.enity.YndecsDiscSviz;
import com.example.demo.repozitore.CartaRepozitores;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.FileEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.IOException;

@RestController
@RequestMapping("NoVerified")
public class NoVerifiedardsController {

    @Autowired
    CartaRepozitores cartaRepozitores;

    @RequestMapping(value = "/setCartRez", method = RequestMethod.POST)
    public ModelAndView setCartrez(@RequestParam("file") MultipartFile file, @RequestParam("sezon") String sezon,
                                   @RequestParam("mesto") String mesto, @RequestParam("group") String group,
                                   @RequestParam("vid") String vid, @RequestParam("relef") Integer relef,
                                   @RequestParam("mashtab") Integer mashtab , @RequestParam("god") Integer god ,ModelMap modelMap){
        if(file!=null && sezon!=null && mesto!=null && group!=null && vid!=null && relef!=null && mashtab!=null){
            Carta carta=new Carta();
            String cart = System.currentTimeMillis()+".jpg";


            String filePath = "C:\\Users\\ddstu\\AndroidStudioProjects\\demo\\src\\main\\resources\\templates\\lol\\assets\\"+cart;

            String url = YndecsDiscSviz.getUrl(cart);

            try {

                file.transferTo(new File(filePath));
                File file1 = new File(filePath);
                YndecsDiscSviz.setFile(file1, url);

            } catch (IOException e) {
                System.out.println("hjlkhjhjkhjhjhjhjhjhjhjhjhjhjhjhj");
                return new ModelAndView("lol/addCartD/addCartRezE", HttpStatus.OK);
            }

            carta.setCart(cart);
            if(sezon.equals("зима")){
                carta.setSezon(true);
            }else{
                carta.setSezon(false);
            }

            carta.setMesto(mesto);
            carta.setGroup(group);
            carta.setGod(god);
            switch (vid){
                case "классика":
                    carta.setVid(0);
                    break;
                case "спринт":
                    carta.setVid(2);
                    break;
                case "лонг":
                    carta.setVid(1);
                    break;
                case "выбор":
                    carta.setVid(3);
                    break;
                case "рогейн":
                    carta.setVid(4);
                    break;
            }
            carta.setRelef(relef);
            carta.setMashtab(mashtab);

            cartaRepozitores.delete(carta.getId());
            cartaRepozitores.addCardNOV(carta, false);
            return new ModelAndView("lol/addCartD/addCartRez", HttpStatus.OK);
        }
            return new ModelAndView("lol/addCartD/addCartRezE", HttpStatus.OK);
    }

    @RequestMapping(value = "/setCart", method = RequestMethod.GET)
    public ModelAndView getCart(){
        return new ModelAndView("lol/addCartD/addCart", HttpStatus.OK);
    }

    public static Integer id = 0;
    public static String cartI = "";

    @RequestMapping(value = "/getCart", method = RequestMethod.GET)
    public ModelAndView getCart(@RequestParam("password") String pas, Model model){
        if(pas.equals("dimaCrut")){
            String rezout="";

            Carta cart=cartaRepozitores.getNoVIrCart();

            id=cart.getId();
            cartI=cart.getCart();

            model.addAttribute("provCart", YndecsDiscSviz.getFileUrl(cart.getCart()));
            if(!cart.getSezon()){
                model.addAttribute("provSezon", "лето");
            }else {
                model.addAttribute("provSezon", "зима");
            }
            model.addAttribute("provMashtab", cart.getMashtab());
            model.addAttribute("provRelef", cart.getRelef());
            model.addAttribute("provMesto", cart.getMesto());
            model.addAttribute("provGroup", cart.getGroup());
            switch (cart.getVid()){
                case 0:
                    model.addAttribute("provVid", "классика");
                    break;
                case 1:
                    model.addAttribute("provVid", "лонг");
                    break;
                case 2:
                    model.addAttribute("provVid", "спринт");
                    break;
                case 3:
                    model.addAttribute("provVid", "выбор");
                    break;
                case 4:
                    model.addAttribute("provVid", "рогейн");
                    break;
            }
            model.addAttribute("provGod", cart.getGod());

            return new ModelAndView("lol/StartAct", HttpStatus.OK);
        }else{
            return new ModelAndView("lol/AdminContr/StartActExept", HttpStatus.OK);
        }
    }

    @RequestMapping(value = "/getCartRezoutT", method = RequestMethod.POST)
    public ModelAndView getCartRezT(@RequestParam("sezon") String sezon,
                                    @RequestParam("mesto") String mesto, @RequestParam("group") String group,
                                    @RequestParam("vid") String vid, @RequestParam("relef") Integer relef,
                                    @RequestParam("mashtab") Integer mashtab){

         try {
             Carta carta = new Carta();

             carta.setCart(cartI);
             if (sezon.equals("зима")) {
                 carta.setSezon(true);
             } else {
                 carta.setSezon(false);
             }

             carta.setMesto(mesto);
             carta.setGroup(group);
             switch (vid) {
                 case "классика":
                     carta.setVid(1);
                     break;
                 case "спринт":
                     carta.setVid(0);
                     break;
                 case "лонг":
                     carta.setVid(2);
                     break;
                 case "выбор":
                     carta.setVid(3);
                     break;
                 case "рогейн":
                     carta.setVid(4);
                     break;
             }
             carta.setRelef(relef);
             carta.setMashtab(mashtab);
             carta.setId(1);
             cartaRepozitores.delete(id);
             cartaRepozitores.addCardNOV(carta, true);
             return new ModelAndView("lol/AdminContr/RezAct", HttpStatus.OK);
         }catch (Exception e){

             return new ModelAndView("lol/AdminContr/RezAcExept", HttpStatus.OK);
         }
    }

    @RequestMapping(value = "/getCartRezoutF", method = RequestMethod.POST)
    public ModelAndView getCartRezF(@RequestParam("sezon") String sezon,
                                    @RequestParam("mesto") String mesto, @RequestParam("group") String group,
                                    @RequestParam("vid") String vid, @RequestParam("relef") Integer relef,
                                    @RequestParam("mashtab") Integer mashtab , Model model) {
        cartaRepozitores.delete(id);
        return new ModelAndView("lol/AdminContr/RezActFalse", HttpStatus.OK);
    }
}
