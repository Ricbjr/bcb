package com.example.BCB.persistance;

import com.example.BCB.model.UsuarioModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.UUID;


@Repository
public interface UsuarioRepository extends JpaRepository <UsuarioModel, UUID>{
    @Query("SELECT u FROM UsuarioModel u WHERE u.telefone =:telefone")
    UsuarioModel findByTelefone(@Param("telefone")String telefone);
}
