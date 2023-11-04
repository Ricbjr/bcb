package com.example.BCB.dto.Usuario;

import com.example.BCB.model.PlanoModel;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record UsuarioRecordDto(@NotBlank String nome,
                               @NotBlank String email,
                               @NotBlank String telefone,
                               @NotBlank String cpf,
                               @NotBlank String cnpj,
                               @NotBlank String nomeEmpresa,
                               @NotNull PlanoModel plano,
                               BigDecimal saldo,
                               long limiteMensagem) {

}
