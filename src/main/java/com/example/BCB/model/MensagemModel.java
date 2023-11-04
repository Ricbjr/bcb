package com.example.BCB.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.io.Serial;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.UUID;

@AllArgsConstructor
@Entity
@Table(name="TB_MENSAGENS")
@Data
@NoArgsConstructor
public class MensagemModel implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID idMensagem;

    @NonNull
    private String texto;

    @ManyToOne
    @JoinColumn(name = "id_usuario_envio")
    private UsuarioModel usuarioEnvio;

    @ManyToOne
    @JoinColumn(name = "id_usuario_recebido")
    private UsuarioModel usuarioRecebido;
    @NonNull
    private Timestamp horarioEnvio;
}
