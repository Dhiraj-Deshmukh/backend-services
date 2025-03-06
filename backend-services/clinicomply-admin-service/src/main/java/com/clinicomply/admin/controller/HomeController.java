package com.clinicomply.admin.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1/test")
public class HomeController {

    @GetMapping
    public String getSTatus(){
        return "<div style=\"display: flex; justify-content: center; align-items: center;background-color:tomato;\">" +
                "<h1 style=\"text-align: center;\">Admin Service - Active</h1>" +
                "</div>\n";
    }
}
