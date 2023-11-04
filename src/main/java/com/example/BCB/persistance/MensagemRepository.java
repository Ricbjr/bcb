package com.example.BCB.persistance;

import com.example.BCB.model.MensagemModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface MensagemRepository extends JpaRepository<MensagemModel, UUID> {
    @Query("SELECT m FROM MensagemModel m WHERE m.usuarioEnvio.id =:idUsuario")
    List<MensagemModel> findByUsuarioEnvio(@Param("idUsuario")UUID idUsuario);

    @Query("SELECT count(*) FROM MensagemModel m WHERE m.usuarioEnvio.id =:idUsuario")
    long countQuantidadeMensagensByUsuarioEnvio(@Param("idUsuario")UUID idUsuario);

}
