package com.example.BCB.services.impl;

import com.example.BCB.business.Usuario.UsuarioBusiness;
import com.example.BCB.business.Helper.HelperMapper;
import com.example.BCB.dto.Usuario.UsuarioRecordBaseDto;
import com.example.BCB.model.UsuarioModel;
import com.example.BCB.services.interfaces.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UsuarioService implements IUsuarioService {

    @Autowired
    UsuarioBusiness usuarioBusiness;

    @Autowired
    HelperMapper mapper;
    public void criarUsuario(UsuarioRecordBaseDto usuarioRecordBaseDto)
    {
        UsuarioModel usuario = mapper.mapearUsuario(usuarioRecordBaseDto);
        usuarioBusiness.criarUsuario(usuario);
    }

    public UsuarioModel getUsuarioPorId(UUID idUsuario)
    {
        return usuarioBusiness.getUsuarioPorId(idUsuario);
    }

    public UsuarioModel getUsuarioPorTelefone(String telefoneUsuario)
    {
        return usuarioBusiness.getUsuarioPorTelefone(telefoneUsuario);
    }

    public UsuarioModel atualizarUsuario(UUID idUsuario, UsuarioRecordBaseDto usuarioRecordBaseDto) {
        UsuarioModel usuario = mapper.mapearUsuario(idUsuario, usuarioRecordBaseDto);

        usuarioBusiness.atualizarUsuario(usuario);

        return usuario;
    }

    public void deletarUsuario(UUID idUsuario)
    {
        usuarioBusiness.deletarUsuario(idUsuario);
    }

    public List<UsuarioModel> getUsuarios() {
        return usuarioBusiness.getUsuarios();
    }
}
