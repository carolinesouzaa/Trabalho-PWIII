package br.com.etec.caroline.trabalho.repository.projections;

import java.math.BigDecimal;
import java.time.LocalDate;

public class ResumoContas {

    private Integer id;
    private LocalDate datapag;
    private LocalDate datavenc;
    private BigDecimal valor;
    private String nome;


    public ResumoContas(Integer id, LocalDate datapag, LocalDate datavenc, BigDecimal valor, String nome) {
        this.id = id;
        this.datapag = datapag;
        this.datavenc = datavenc;
        this.valor = valor;
        this.nome = nome;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getDatapag() {
        return datapag;
    }

    public void setDatapag(LocalDate datapag) {
        this.datapag = datapag;
    }

    public LocalDate getDatavenc() {
        return datavenc;
    }

    public void setDatavenc(LocalDate datavenc) {
        this.datavenc = datavenc;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
