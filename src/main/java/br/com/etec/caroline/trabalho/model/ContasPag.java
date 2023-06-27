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
    private BigDecimal valor;

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

  @ManyToOne
    @JoinColumn(name = "idcliente")
    private Cliente cliente;

  public Cliente getCliente() {
    return cliente;
  }

  public void setCliente(Cliente cliente) {
    this.cliente = cliente;
  }
}
