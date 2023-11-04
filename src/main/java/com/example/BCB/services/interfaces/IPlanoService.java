package com.example.BCB.services.interfaces;

import com.example.BCB.dto.Plano.PlanoRecordDto;
import com.example.BCB.model.PlanoModel;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public interface IPlanoService {

    void criarPlano(PlanoRecordDto planoRecordDto);

    PlanoModel getPlano(UUID idPlano);
    PlanoModel atualizarPlano(UUID idPlano, PlanoRecordDto planoRecordDto);

    void deletarPlano(UUID idPlano);

    List<PlanoModel> getPlanos();
}
