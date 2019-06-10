package com.example.demo.controller;

import com.example.demo.model.Oportunidade;
import com.example.demo.repository.OportunidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import sun.rmi.runtime.Log;

import javax.validation.Valid;
import javax.xml.ws.Response;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;


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

    @GetMapping("/{id}")
    public ResponseEntity<Oportunidade> buscar(@PathVariable Long id){
        Optional<Oportunidade> oportunidade =  oportunidadeRepository.findById(id);

        if (!oportunidade.isPresent()){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(oportunidade.get());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED) // mudando o numero de status de 200 para 201
    public Oportunidade adicionar(@Valid @RequestBody Oportunidade oportunidade){

        Optional<Oportunidade> oportunidaExistente = oportunidadeRepository.
                findByDescricaoAndNomeProcpecto(oportunidade.getDescricao(),oportunidade.getNomeProcpecto());

        if (oportunidaExistente.isPresent()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Já Existe um prospecto com a mesma descrição ! ");
        }
        return oportunidadeRepository.save(oportunidade);
    }

    @DeleteMapping
    public void deleteAllTable(){
        oportunidadeRepository.deleteAll();
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        oportunidadeRepository.deleteById(id);
    }
}
