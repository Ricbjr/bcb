package com.example.BCB.services.impl;

import com.example.BCB.business.PlanoBusiness;
import com.example.BCB.dto.Plano.PlanoRecordDto;
import com.example.BCB.model.PlanoModel;
import com.example.BCB.services.interfaces.IPlanoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PlanoService implements IPlanoService {

    @Autowired
    PlanoBusiness _planoBusiness;

    public void criarPlano(PlanoRecordDto planoRecordDto){
        _planoBusiness.criarPlano(planoRecordDto);
    }

    public PlanoModel getPlano(UUID idPlano){
        return _planoBusiness.getPlano(idPlano);
    }
    public PlanoModel atualizarPlano(UUID idPlano, PlanoRecordDto planoRecordDto){
        return _planoBusiness.atualizarPlano(idPlano,planoRecordDto);
    }

    public void deletarPlano(UUID idPlano){
        _planoBusiness.deletarPlano(idPlano);

    }

    public List<PlanoModel> getPlanos() {
        return _planoBusiness.getPlanos();
    }
}
