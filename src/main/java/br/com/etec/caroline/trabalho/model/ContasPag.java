package br.com.etec.caroline.trabalho.model;

import com.mysql.cj.xdevapi.Client;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "contaspagar")

public class ContasPag {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idConta;

    private LocalDate dataPag;

    private LocalDate dataVenc;

    @ManyToOne
    @JoinColumn(name = "idcliente")
    private Cliente cliente;

    private BigDecimal valor;


  public Integer getIdConta() {
    return idConta;
  }

  public void setIdConta(Integer idConta) {
    this.idConta = idConta;
  }

  public LocalDate getDataPag() {
    return dataPag;
  }

  public void setDataPag(LocalDate dataPag) {
    this.dataPag = dataPag;
  }

  public LocalDate getDataVenc() {
    return dataVenc;
  }

  public void setDataVenc(LocalDate dataVenc) {
    this.dataVenc = dataVenc;
  }

  public Cliente getCliente() {
    return cliente;
  }

  public void setCliente(Cliente cliente) {
    this.cliente = cliente;
  }

  public BigDecimal getValor() {
    return valor;
  }

  public void setValor(BigDecimal valor) {
    this.valor = valor;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    ContasPag contasPag = (ContasPag) o;
    return idConta.equals(contasPag.idConta);
  }

  @Override
  public int hashCode() {
    return Objects.hash(idConta);
  }

}
