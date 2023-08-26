package br.com.fiap.domain.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "TB_ESTADO", uniqueConstraints = {
        @UniqueConstraint(name = "UK_NM_TB_ESTADO", columnNames = {" NM_TB_ESTADO"}),
        @UniqueConstraint(name = "UK_SG_TB_ESTADO", columnNames = {"SG_TB_ESTADO"})

})
public class Estado {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_TB_ESTADO")
    @SequenceGenerator(name = "SQ_TB_ESTADO",sequenceName = "SQ_TB_ESTADO")
    @Column(name = "ID_TB_ESTADO")
    private Long id;

    @Column(name = "NM_TB_ESTADO",nullable = false)
    private String nome;

    @Column(name = "SG_TB_ESTADO", nullable = false)
    private String sigla;

    public Estado() {
    }

    public Estado(Long id, String nome, String sigla) {
        this.id = id;
        this.nome = nome;
        this.sigla = sigla;
    }


    public Long getId() {
        return id;
    }

    public Estado setId(Long id) {
        this.id = id;
        return this;
    }

    public String getNome() {
        return nome;
    }

    public Estado setNome(String nome) {
        this.nome = nome;
        return this;
    }

    public String getSigla() {
        return sigla;
    }

    public Estado setSigla(String sigla) {
        this.sigla = sigla;
        return this;
    }

    @Override
    public String toString() {
        return "Estado{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", sigla='" + sigla + '\'' +
                '}';
    }
}
