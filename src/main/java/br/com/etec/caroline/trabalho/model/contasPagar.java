package br.com.etec.caroline.trabalho.model;

import com.mysql.cj.xdevapi.Client;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "contasPagar")

public class contasPagar {

    private Integer idConta;

    private Date dataPag;

    private Date dataVenc;

    @ManyToOne
    @JoinColumn(name = "idCliente")
    private Client cliente;

    private BigDecimal valor;

}
