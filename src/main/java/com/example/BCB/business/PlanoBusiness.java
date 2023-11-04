package com.example.BCB.business;

import com.example.BCB.dto.Plano.PlanoRecordDto;
import com.example.BCB.exceptions.ValidacaoException;
import com.example.BCB.model.PlanoModel;
import com.example.BCB.persistance.PlanoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
public class PlanoBusiness {
    @Autowired
    PlanoRepository _planoRepository;
    public void criarPlano(PlanoRecordDto planoRecordDto){
        var plano = new PlanoModel();
        BeanUtils.copyProperties(planoRecordDto,plano);
        _planoRepository.save(plano);
    }

    public PlanoModel getPlano(UUID idPlano){
        Optional<PlanoModel> plano = _planoRepository.findById(idPlano);
        if(plano.isEmpty())
        {
            throw new ValidacaoException("Plano não encontrado.");
        }
        return plano.get();
    }
    public PlanoModel atualizarPlano(UUID idPlano, PlanoRecordDto planoRecordDto){
        var plano = getPlano(idPlano);
        BeanUtils.copyProperties(planoRecordDto,plano);
        _planoRepository.save(plano);
        return plano;
    }

    public void deletarPlano(UUID idPlano){
        _planoRepository.delete(getPlano(idPlano));

    }

    public List<PlanoModel> getPlanos() {
        return _planoRepository.findAll();
    }
}
