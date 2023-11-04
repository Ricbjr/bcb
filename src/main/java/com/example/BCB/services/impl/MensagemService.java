package com.example.BCB.services.impl;

import com.example.BCB.business.Helper.HelperMapper;
import com.example.BCB.business.Mensagem.MensagemBusiness;
import com.example.BCB.dto.Mensagem.MensagemRecordBaseDto;
import com.example.BCB.dto.Mensagem.MensagemRecordDto;
import com.example.BCB.model.MensagemModel;
import com.example.BCB.services.interfaces.IMensagemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class MensagemService implements IMensagemService {
    @Autowired
    MensagemBusiness _mensagemBusiness;


    @Autowired
    HelperMapper mapper;

    public void enviarMensagem(MensagemRecordBaseDto mensagemRecordBaseDto)
    {
        MensagemModel mensagem = mapper.mapearMensagem(mensagemRecordBaseDto);
        _mensagemBusiness.enviarMensagem(mensagem);
    }

    public MensagemModel getMensagemPorId(UUID idMensagem)
    {
        return _mensagemBusiness.getMensagemPorId(idMensagem);
    }

    public MensagemModel atualizarMensagem(UUID idMensagem, MensagemRecordDto mensagemRecordDto)
    {
        return _mensagemBusiness.atualizarMensagem(idMensagem,mensagemRecordDto);
    }

    public void deletarMensagem(UUID idMensagem)
    {
        _mensagemBusiness.deletarMensagem(idMensagem);
    }

    public List<MensagemModel> getMensagensPorUsuario(UUID idUsuario) {
        return _mensagemBusiness.getMensagensPorUsuario(idUsuario);
    }
}
