package com.example.BCB.services.interfaces;

import com.example.BCB.dto.Usuario.UsuarioRecordBaseDto;
import com.example.BCB.model.UsuarioModel;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public interface IUsuarioService {

    void criarUsuario(UsuarioRecordBaseDto usuarioRecordDto);

    UsuarioModel getUsuarioPorId(UUID idUsuario);

    UsuarioModel getUsuarioPorTelefone(String telefoneUsuario);

    UsuarioModel atualizarUsuario(UUID idUsuario, UsuarioRecordBaseDto usuarioRecordBaseDto);

    void deletarUsuario(UUID idUsuario);

    List<UsuarioModel> getUsuarios();
}
