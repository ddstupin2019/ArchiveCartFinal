package com.example.demo.controller;

import org.jsoup.Jsoup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.swing.text.Document;

@RestController
public class MainConttroller {

    @RequestMapping("/")
    public ModelAndView testHTML(){
        return new ModelAndView("lol/start", HttpStatus.OK);
    }
    }

