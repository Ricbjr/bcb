package com.example.BCB.business.Helper;

import com.example.BCB.business.PlanoBusiness;
import com.example.BCB.business.Usuario.UsuarioBusiness;
import com.example.BCB.dto.Mensagem.MensagemRecordBaseDto;
import com.example.BCB.dto.Mensagem.MensagemRecordDto;
import com.example.BCB.dto.Usuario.UsuarioRecordBaseDto;
import com.example.BCB.dto.Usuario.UsuarioRecordDto;
import com.example.BCB.model.MensagemModel;
import com.example.BCB.model.UsuarioModel;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.util.UUID;

@Component
public class HelperMapper {
    @Autowired
    ApplicationContext applicationContext;
    public UsuarioModel mapearUsuario(UsuarioRecordBaseDto usuarioRecordBaseDto)
    {
        PlanoBusiness planoBusiness = applicationContext.getBean(PlanoBusiness.class);
        UsuarioRecordDto usuarioRecordDto = new UsuarioRecordDto(usuarioRecordBaseDto.nome(),
                usuarioRecordBaseDto.email(),
                usuarioRecordBaseDto.telefone(),
                usuarioRecordBaseDto.cpf(),
                usuarioRecordBaseDto.cnpj(),
                usuarioRecordBaseDto.nomeEmpresa(),
                planoBusiness.getPlano(usuarioRecordBaseDto.idPlano()),
                usuarioRecordBaseDto.saldo(),
                usuarioRecordBaseDto.limiteMensagem());
        UsuarioModel usuario = new UsuarioModel();
        BeanUtils.copyProperties(usuarioRecordDto,usuario);
        return usuario;
    }

    public UsuarioModel mapearUsuario(UUID idUsuario, UsuarioRecordBaseDto usuarioRecordBaseDto)
    {
        PlanoBusiness planoBusiness = applicationContext.getBean(PlanoBusiness.class);
        UsuarioRecordDto usuarioRecordDto = new UsuarioRecordDto(usuarioRecordBaseDto.nome(),
                usuarioRecordBaseDto.email(),
                usuarioRecordBaseDto.telefone(),
                usuarioRecordBaseDto.cpf(),
                usuarioRecordBaseDto.cnpj(),
                usuarioRecordBaseDto.nomeEmpresa(),
                planoBusiness.getPlano(usuarioRecordBaseDto.idPlano()),
                usuarioRecordBaseDto.saldo(),
                usuarioRecordBaseDto.limiteMensagem());
        UsuarioModel usuario = new UsuarioModel();
        BeanUtils.copyProperties(usuarioRecordDto,usuario);
        usuario.setIdUsuario(idUsuario);
        return usuario;
    }

    public MensagemModel mapearMensagem(MensagemRecordBaseDto mensagemRecordBaseDto) {
        UsuarioBusiness usuarioBusiness = applicationContext.getBean(UsuarioBusiness.class);
        MensagemRecordDto mensagemRecordDto = new MensagemRecordDto(mensagemRecordBaseDto.texto(),
                usuarioBusiness.getUsuarioPorId(mensagemRecordBaseDto.usuarioEnvio()),
                usuarioBusiness.getUsuarioPorId(mensagemRecordBaseDto.usuarioRecebido()),
                new Timestamp(System.currentTimeMillis()));
        MensagemModel mensagem = new MensagemModel();
        BeanUtils.copyProperties(mensagemRecordDto,mensagem);
        return mensagem;
    }
}
