package com.casa.contas.projeto_contas.util;

import java.io.Serializable;

public class AutenticacaoRequisicao implements Serializable {
    private String username;
    private String password;

    public AutenticacaoRequisicao() {
    }

    public AutenticacaoRequisicao(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
