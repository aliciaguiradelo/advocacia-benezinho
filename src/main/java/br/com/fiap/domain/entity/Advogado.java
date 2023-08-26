package br.com.fiap.domain.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "TB_ADVOGADO", uniqueConstraints = {
        @UniqueConstraint(name = "UK_OAB_TB_ADVOGADO", columnNames = {"OAB_TB_ADVOGADO"})
})
public class Advogado {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_TB_ADVOGADO")
    @SequenceGenerator(name = "SQ_TB_ADVOGADO", sequenceName = "SQ_TB_ADVOGADO")
    @Column(name = "ID_TB_ADVOGADO")
    private Long id;

    @Column(name = "NM_TB_ADVOGADO", nullable = false)
    private String nome;

    @Column(name = "OAB_TB_ADVOGADO", nullable = false)
    private String numeroOAB;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST , CascadeType.MERGE})
    @JoinColumn(
            name = "ID_TB_ESTADO",
            referencedColumnName = "ID_TB_ESTADO",
            foreignKey = @ForeignKey(name = "FK_TB_ESTADO")
    )
    private Estado estado;

    public Advogado() {
    }

    public Advogado(Long id, String nome, String numeroOAB, Estado estado) {
        this.id = id;
        this.nome = nome;
        this.numeroOAB = numeroOAB;
        this.estado = estado;
    }

    public Long getId() {
        return id;
    }

    public Advogado setId(Long id) {
        this.id = id;
        return this;
    }

    public String getNome() {
        return nome;
    }

    public Advogado setNome(String nome) {
        this.nome = nome;
        return this;
    }

    public String getNumeroOAB() {
        return numeroOAB;
    }

    public Advogado setNumeroOAB(String numeroOAB) {
        this.numeroOAB = numeroOAB;
        return this;
    }

    public Estado getEstado() {
        return estado;
    }

    public Advogado setEstado(Estado estado) {
        this.estado = estado;
        return this;
    }

    @Override
    public String toString() {
        return "Advogado{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", numeroOAB='" + numeroOAB + '\'' +
                '}';
    }


}
