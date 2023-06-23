package br.com.etec.caroline.trabalho.repository.projections;

import java.util.Date;

public class ResumoContas {

    private Long id;
    private String nomecliente;
    private Date data;

    public ResumoContas(Long id, Date data, String nomecliente) {
        this.id = id;
        this.data = data;
        this.nomecliente = nomecliente;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomecliente() {
        return nomecliente;
    }

    public void setNomecliente(String nomecliente) {
        this.nomecliente = nomecliente;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }
}
