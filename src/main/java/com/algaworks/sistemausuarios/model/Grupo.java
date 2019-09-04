package com.algaworks.sistemausuarios.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "grupo",
        uniqueConstraints = { @UniqueConstraint(name = "un_nome", columnNames = { "nome" }) })
public class Grupo {

    @Id
    private Integer id;

    @Column(length = 100, nullable = false)
    private String nome;

    @ManyToMany(mappedBy = "grupos")
    private List<Usuario> usuarios;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Grupo dominio = (Grupo) o;

        return id.equals(dominio.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
