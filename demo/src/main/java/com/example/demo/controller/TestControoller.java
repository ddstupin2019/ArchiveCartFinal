package com.example.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import java.awt.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

@RestController
@RequestMapping("Test")
public class TestControoller {
    @RequestMapping(value = "/TestVvod", method = RequestMethod.GET)
    public String test(@RequestParam("id") String id, @RequestParam("id1") int id1){
        return "Ввод: "+id+" , "+id1;
    }

    @RequestMapping(value = "/ft", method = RequestMethod.GET)
    public ModelAndView testHTML2(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model){
        model.addAttribute("ame", name);
        return new ModelAndView("lol/testN", HttpStatus.OK);
    }

    @RequestMapping(value = "/ll",method = RequestMethod.POST)
    public String handlePostRequest () {
        System.out.println(1);
        try {
            MultipartHttpServletRequest request=null;
            MultipartFile multipartFile = request.getFile("cart");
            String name = multipartFile.getOriginalFilename();
            BufferedWriter w = Files.newBufferedWriter(Paths.get("с:/Test/" + name));
            w.write(new String(multipartFile.getBytes()));
            w.flush();
            return "response";
        } catch (Exception e) {
            return e.getMessage();
        }
    }
    @RequestMapping(value = "/u", method = RequestMethod.POST)
    public String submit(@RequestParam("file") MultipartFile file, @RequestParam("f") String f, ModelMap modelMap) {
        modelMap.addAttribute("file", file);
        String filePath = "C:\\Users\\ddstu\\Server\\"+System.currentTimeMillis()+file.getOriginalFilename();
        try {
            file.transferTo(new File(filePath));
        } catch (IOException e) {
            return "asd";
        }
        return f;
    }
}
