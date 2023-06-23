package br.com.etec.caroline.trabalho.model;

import com.mysql.cj.xdevapi.Client;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "contaspag")

public class ContasPag {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private LocalDate datapag;

    private LocalDate datavenc;

    @ManyToOne
    @JoinColumn(name = "idcliente")
    private Cliente cliente;

    private BigDecimal valor;


  public Integer getIdConta() {
    return id;
  }

  public void setIdConta(Integer idConta) {
    this.id = id;
  }

  public LocalDate getDataPag() {
    return datapag;
  }

  public void setDataPag(LocalDate dataPag) {
    this.datapag = dataPag;
  }

  public LocalDate getDataVenc() {
    return datavenc;
  }

  public void setDataVenc(LocalDate dataVenc) {
    this.datavenc = dataVenc;
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
    return id.equals(contasPag.id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id);
  }

}
