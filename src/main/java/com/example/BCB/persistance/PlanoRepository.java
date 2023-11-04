package com.example.BCB.persistance;

import com.example.BCB.model.PlanoModel;
import com.example.BCB.model.UsuarioModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PlanoRepository extends JpaRepository<PlanoModel, UUID> {
    @Query("SELECT p FROM PlanoModel p WHERE p.nome =:nome")
    PlanoModel findByNome(@Param("nome")String nome);
}
