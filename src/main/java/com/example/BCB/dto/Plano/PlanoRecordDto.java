package com.example.BCB.dto.Plano;

import com.example.BCB.enums.TipoCobrancaPlano;

import java.math.BigDecimal;

public record PlanoRecordDto( String nome,
                              TipoCobrancaPlano tipoCobrancaPlano,
                              BigDecimal valor) {
}
