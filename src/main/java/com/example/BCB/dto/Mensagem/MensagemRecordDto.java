package com.example.BCB.dto.Mensagem;

import com.example.BCB.model.UsuarioModel;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.sql.Timestamp;

public record MensagemRecordDto(@NotBlank String texto,
                                @NotNull UsuarioModel usuarioEnvio,
                                @NotNull UsuarioModel usuarioRecebido,
                                @NotNull Timestamp horarioEnvio) {
}
