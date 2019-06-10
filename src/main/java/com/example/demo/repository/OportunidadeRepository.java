package com.example.demo.repository;

import com.example.demo.model.Oportunidade;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OportunidadeRepository extends JpaRepository<Oportunidade,Long> {

    // metodo customizado SQL JPA
    Optional<Oportunidade> findByDescricaoAndNomeProcpecto(String descricao,String nomeProcpecto);


}
