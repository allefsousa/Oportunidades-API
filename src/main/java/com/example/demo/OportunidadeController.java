package com.example.demo;

import com.example.demo.model.Oportunidade;
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

    @GetMapping
    public List<Oportunidade> listat(){
        Oportunidade oportunidade = new Oportunidade();
        oportunidade.setId(1L);
        oportunidade.setDescricao("Desenvolvimento de software");
        oportunidade.setNomeProcpecto("Grupo logistico Berasil");
        oportunidade.setValor(new BigDecimal(490000));



        return Arrays.asList(oportunidade);
    }
}
