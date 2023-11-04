package com.example.BCB.enums;

import org.springframework.validation.annotation.Validated;
@Validated
public enum TipoConversa {
    WHATSAPP(1),
    SMS(2);


    private final int valor;

    TipoConversa(int valor) {
        this.valor = valor;
    }

    public int getTipoConversa() {
        return valor;
    }
}
