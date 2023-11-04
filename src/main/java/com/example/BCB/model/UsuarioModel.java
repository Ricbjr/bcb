package com.example.BCB.model;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "TB_USUARIOS")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UsuarioModel implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID idUsuario;
    @NonNull
    private String nome;
    @NonNull
    private String email;

    @NonNull
    @Column(unique = true)
    private String telefone;

    @NonNull
    @Column(unique = true)
    private String cpf;

    @NonNull
    private String cnpj;

    @NonNull
    private String nomeEmpresa;

    @ManyToOne
    @JoinColumn(name = "id_plano")
    private PlanoModel plano;

    private BigDecimal saldo;

    private long limiteMensagem;
}
