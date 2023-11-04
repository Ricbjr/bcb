package com.example.BCB.business.Mensagem;

import com.example.BCB.business.Usuario.UsuarioBusiness;
import com.example.BCB.dto.Mensagem.MensagemRecordDto;
import com.example.BCB.exceptions.ValidacaoException;
import com.example.BCB.model.MensagemModel;
import com.example.BCB.persistance.MensagemRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
public class MensagemBusiness {

    private final static String ERRO_USUARIO_NAO_PODE_ENVIAR_MSG = "Usuário não pode mais mandar mensagens";
    private final static String ERRO_MSG_NAO_ENCONTRADA = "Mensagem não encontrada.";
    @Autowired
    MensagemRepository _mensagemRepository;

    @Autowired
    ApplicationContext applicationContext;

    public void enviarMensagem(MensagemModel mensagem)
    {
        UsuarioBusiness usuarioBusiness = applicationContext.getBean(UsuarioBusiness.class);
        if(usuarioBusiness.VerificarSePodeEnviarMensagem(mensagem.getUsuarioEnvio()))
        {
            _mensagemRepository.save(mensagem);
            usuarioBusiness.atualizaUsuarioAoEnviarMensagem(mensagem.getUsuarioEnvio());
        }
        else {
            throw new ValidacaoException(ERRO_USUARIO_NAO_PODE_ENVIAR_MSG);
        }
    }
    public MensagemModel getMensagemPorId(UUID idMensagem)
    {
        Optional<MensagemModel> mensagem = _mensagemRepository.findById(idMensagem);
        if(mensagem.isEmpty())
        {
            throw new ValidacaoException(ERRO_MSG_NAO_ENCONTRADA);
        }
        return mensagem.get();
    }

    public MensagemModel atualizarMensagem(UUID idMensagem, MensagemRecordDto mensagemRecordDto)
    {
        var mensagem = getMensagemPorId(idMensagem);
        BeanUtils.copyProperties(mensagemRecordDto,mensagem);
        _mensagemRepository.save(mensagem);
        return mensagem;
    }

    public void deletarMensagem(UUID idMensagem)
    {
        _mensagemRepository.delete(getMensagemPorId(idMensagem));
    }

    public List<MensagemModel> getMensagensPorUsuario(UUID idUsuario) {
        return _mensagemRepository.findByUsuarioEnvio(idUsuario);
    }

    public int QuantidadeDeMensagensDoUsuario(UUID idUsuario){
        return (int)_mensagemRepository.countQuantidadeMensagensByUsuarioEnvio(idUsuario);
    }
}
