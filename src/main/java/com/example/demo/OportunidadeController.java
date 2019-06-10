package com.example.demo;

import com.example.demo.model.Oportunidade;
import com.example.demo.repository.OportunidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;


// GET http://localhost:8080/oportunidades
@RestController
@RequestMapping("/oportunidades")
public class OportunidadeController {

    @Autowired
    private OportunidadeRepository oportunidadeRepository;


    @GetMapping
    public List<Oportunidade> listat(){
        return oportunidadeRepository.findAll();
    }
}
