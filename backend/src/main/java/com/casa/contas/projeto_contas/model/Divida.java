package com.casa.contas.projeto_contas.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.text.DateFormat;
import java.time.LocalDate;

@Entity
public class Divida implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "divida_id", unique = true, nullable = false)
    private Integer id;

    private float valor;
    private String descricao;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate data;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "devedor_id", referencedColumnName = "devedor_id", nullable = false)
    @JsonIgnore
    private Devedor devedor;

    public Divida() {
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Devedor getDevedor() {
        return devedor;
    }

    public void setDevedor(Devedor devedor) {
        this.devedor = devedor;
    }

    @Override
    public String toString() {
        return "Divida{" +
                "id=" + id +
                ", valor=" + valor +
                ", descricao='" + descricao + '\'' +
                ", data=" + data +
                '}';
    }
}
