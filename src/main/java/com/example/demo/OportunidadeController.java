package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


// GET http://localhost:8080/oportunidades
@RestController
@RequestMapping("/oportunidades")
public class OportunidadeController {

    @GetMapping
    public String listat(){
        return  "hello";
    }
}
