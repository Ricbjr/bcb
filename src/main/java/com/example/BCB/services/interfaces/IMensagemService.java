package com.example.BCB.services.interfaces;

import com.example.BCB.dto.Mensagem.MensagemRecordBaseDto;
import com.example.BCB.dto.Mensagem.MensagemRecordDto;
import com.example.BCB.model.MensagemModel;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public interface IMensagemService {

    void enviarMensagem(MensagemRecordBaseDto mensagemRecordBaseDto);

    MensagemModel getMensagemPorId(UUID idMensagem);

    MensagemModel atualizarMensagem(UUID idMensagem, MensagemRecordDto mensagemRecordDto);

    void deletarMensagem(UUID idMensagem);

    List<MensagemModel> getMensagensPorUsuario(UUID idUsuario);
}
