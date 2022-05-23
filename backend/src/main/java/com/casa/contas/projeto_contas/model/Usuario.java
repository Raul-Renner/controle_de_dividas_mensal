package com.casa.contas.projeto_contas.model;

import com.casa.contas.projeto_contas.model.enums.Papel;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
public class Usuario implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "usuario_id_seq")
    @SequenceGenerator(name = "usuario_id_seq", sequenceName = "usuario_id_seq", allocationSize = 1)
    private Integer id;

    private String email;

    private String nome;

    private String senha;

    @ElementCollection(targetClass = Papel.class, fetch = FetchType.LAZY)
    @Enumerated(EnumType.STRING)
    @CollectionTable(name = "papel")
    @Column(name = "papel")
    @JsonIgnore
    private List<Papel> papeis;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Papel> getPapeis() {
        return papeis;
    }


    public void setPapeis(List<Papel> papeis) {
        this.papeis = papeis;
    }

    public void adicionarPapel(Papel papel){
        if(this.papeis == null){
            this.papeis = new ArrayList<>();
        }
        this.papeis.add(papel);

    }

    public boolean PapelUsuario(Papel papel) {
        return this.papeis.contains(papel);
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.papeis;
    }

    @Override
    public String getPassword() {
        return this.senha;
    }

    @Override
    public String getUsername() {
        return this.email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }



    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", nome='" + nome + '\'' +
                ", senha='" + senha + '\'' +
                ", papeis=" + papeis +
                '}';
    }
}
