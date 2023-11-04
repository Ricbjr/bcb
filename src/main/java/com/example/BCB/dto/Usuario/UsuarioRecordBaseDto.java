package com.example.BCB.dto.Usuario;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.util.UUID;

public record UsuarioRecordBaseDto(@NotBlank String nome,
                                   @NotBlank String email,
                                   @NotBlank String telefone,
                                   @NotBlank String cpf,
                                   @NotBlank String cnpj,
                                   @NotBlank String nomeEmpresa,
                                   @NotNull UUID idPlano,
                                   BigDecimal saldo,
                                   long limiteMensagem) {
}
