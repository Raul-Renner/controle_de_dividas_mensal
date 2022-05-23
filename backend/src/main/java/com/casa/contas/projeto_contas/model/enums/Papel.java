package com.casa.contas.projeto_contas.model.enums;

import org.springframework.security.core.GrantedAuthority;

public enum Papel implements GrantedAuthority {

    DEVEDOR("Devedor"), ADIMNISTRADOR("Administrador");

    private String descricao;

    Papel(String valor) {
        this.descricao = valor;
    }

    public String getDescricao() {
        return descricao;
    }

    @Override
    public String getAuthority() {
        return this.toString();
    }
}
