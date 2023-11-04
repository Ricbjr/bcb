package com.example.BCB.enums;

import lombok.Getter;

public enum TipoCobrancaPlano {
    DINHEIRO("Dinheiro",1),
    QUANTIDADE("Quantidade",2);


    @Getter
    private String descricao;
    @Getter
    private int valor;

    TipoCobrancaPlano(String descricao,int valor) {
        this.descricao = descricao;
        this.valor = valor;
    }
}
