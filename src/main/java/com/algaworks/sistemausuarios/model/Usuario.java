package com.algaworks.sistemausuarios.model;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "usuario",
        indexes = { @Index(name = "id_nome", columnList = "nome") },
        uniqueConstraints = { @UniqueConstraint(name = "un_login", columnNames = { "login" })})
public class Usuario {

    @Id
    private Integer id;

    @Column(length = 50, nullable = false)
    private String login;

    @Column(length = 100)
    private String senha;

    @Column(length = 100, nullable = false)
    private String nome;

    @Column(name = "ultimo_acesso")
    private LocalDateTime ultimoAcesso;

    @ManyToOne
    @JoinColumn(name = "dominio_id", nullable = false,
            foreignKey = @ForeignKey(name = "fk_usuario_dominio"))
    private Dominio dominio;

    @ManyToMany
    @JoinTable(name = "usuario_grupo",
            joinColumns = { @JoinColumn(name = "usuario_id",
                    foreignKey = @ForeignKey(name = "fk_usuario_grupo_usuario")) },
            inverseJoinColumns = { @JoinColumn(name = "grupo_id",
                    foreignKey = @ForeignKey(name = "fk_usuario_grupo_grupo")) })
    private List<Grupo> grupos;

    @OneToOne(mappedBy = "usuario")
    private Configuracao configuracao;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
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

    public LocalDateTime getUltimoAcesso() {
        return ultimoAcesso;
    }

    public void setUltimoAcesso(LocalDateTime ultimoAcesso) {
        this.ultimoAcesso = ultimoAcesso;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Dominio getDominio() {
        return dominio;
    }

    public void setDominio(Dominio dominio) {
        this.dominio = dominio;
    }

    public List<Grupo> getGrupos() {
        return grupos;
    }

    public void setGrupos(List<Grupo> grupos) {
        this.grupos = grupos;
    }

    public Configuracao getConfiguracao() {
        return configuracao;
    }

    public void setConfiguracao(Configuracao configuracao) {
        this.configuracao = configuracao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Usuario usuario = (Usuario) o;

        return id.equals(usuario.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
