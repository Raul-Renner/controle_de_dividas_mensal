package com.casa.contas.projeto_contas.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.org.apache.xpath.internal.operations.Div;
import org.springframework.beans.factory.annotation.Value;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Devedor implements Serializable {

    private String nome;
    private String apelido;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "devedor_id", unique = true, nullable = false)
    private Integer id;
    @Value(value = "00.00f")
    private float valor_total;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "devedor", cascade = CascadeType.ALL, orphanRemoval = true)
    @CollectionTable(name = "divida")
    @Column(name = "divida")
    private List<Divida> dividas = new ArrayList<Divida>();



    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getApelido() {
        return apelido;
    }

    public void setApelido(String apelido) {
        this.apelido = apelido;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public float getValor_total() {
        return valor_total;
    }

    public void setValor_total(float valor_total) {
        this.valor_total = valor_total;
    }

    public List<Divida> getDividas() {

        return dividas;
    }

    public void setDividas(List<Divida> dividas) {
        this.dividas = dividas;
    }

    @Override
    public String toString() {
        return "Devedor{" +
                "nome='" + nome + '\'' +
                ", apelido='" + apelido + '\'' +
                ", id=" + id +
                ", valor_total=" + valor_total +
                ", dividas=" + dividas +
                '}';
    }
}
