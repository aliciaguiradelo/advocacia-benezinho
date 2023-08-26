package br.com.fiap.domain.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "TB_PROCESSO", uniqueConstraints = {
        @UniqueConstraint(name = "UK_NUM_TB_PROCESSO", columnNames = "NUM_TB_PROCESSO")
})
public class Processo {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_TB_PROCESSO")
    @SequenceGenerator(name = "SQ_TB_PROCESSO", sequenceName = "SQ_TB_PROCESSO")
    @Column(name = "ID_TB_PROCESSO")
    private Long id;

    @Column(name = "NUM_TB_PROCESSO", nullable = false)
    private String numero;

    @Column(name = "PRO_TB_PROCESSO")

    private Boolean proBono;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(
            name = "ID_TB_ADVOGADO",
            referencedColumnName = "ID_TB_ADVOGADO",
            foreignKey = @ForeignKey(name = "FK_TB_ADVOGADO")
    )
    private Advogado advogado;


    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(
            name = "ID_TP_ACAO",
            referencedColumnName = "ID_TP_ACAO",
            foreignKey = @ForeignKey(name = "FK_TP_ACAO")
    )
    private TipoDeAcao tipoDeAcao;


    public Processo() {
    }

    public Processo(Long id, String numero, Boolean proBono, Advogado advogado, TipoDeAcao tipoDeAcao) {
        this.id = id;
        this.numero = numero;
        this.proBono = proBono;
        this.advogado = advogado;
        this.tipoDeAcao = tipoDeAcao;
    }

    public Long getId() {
        return id;
    }

    public Processo setId(Long id) {
        this.id = id;
        return this;
    }

    public String getNumero() {
        return numero;
    }

    public Processo setNumero(String numero) {
        this.numero = numero;
        return this;
    }

    public Boolean getProBono() {
        return proBono;
    }

    public Processo setProBono(Boolean proBono) {
        this.proBono = proBono;
        return this;
    }

    public Advogado getAdvogado() {
        return advogado;
    }

    public Processo setAdvogado(Advogado advogado) {
        this.advogado = advogado;
        return this;
    }

    public TipoDeAcao getTipoDeAcao() {
        return tipoDeAcao;
    }

    public Processo setTipoDeAcao(TipoDeAcao tipoDeAcao) {
        this.tipoDeAcao = tipoDeAcao;
        return this;
    }


    @Override
    public String toString() {
        return "Processo{" +
                "id=" + id +
                ", numero='" + numero + '\'' +
                ", proBono=" + proBono +
                ", advogado=" + advogado +
                ", tipoDeAcao=" + tipoDeAcao +
                '}';
    }
}
