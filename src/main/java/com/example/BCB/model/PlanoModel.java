package com.example.BCB.model;

import com.example.BCB.enums.TipoCobrancaPlano;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.UUID;

@Data
@Entity
@Table(name="TB_PLANOS")
@AllArgsConstructor
@NoArgsConstructor
public class PlanoModel implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID idPlano;
    @NonNull
    private String nome;

    @NonNull
    @Enumerated(EnumType.STRING)
    private TipoCobrancaPlano tipoCobrancaPlano;

    private BigDecimal valor;
}
