package com.example.BCB.dto.Mensagem;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record MensagemRecordBaseDto(@NotBlank String texto,
                                    @NotNull UUID usuarioEnvio,
                                    @NotNull UUID usuarioRecebido) {
}
