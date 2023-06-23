package br.com.etec.caroline.trabalho.repository.filter;

import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.time.LocalDate;

public class ContasPagFilter {

  @DateTimeFormat(pattern = "yyyy/MM/dd")
  private LocalDate datapag;

  @DateTimeFormat(pattern = "yyyy/MM/dd")
  private LocalDate datavenc;

  private String nomecliente;

  private BigDecimal valor;

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

  public String getNomecliente() {
    return nomecliente;
  }

  public void setNomecliente(String nomecliente) {
    this.nomecliente = nomecliente;
  }

  public BigDecimal getValor() {
    return valor;
  }

  public void setValor(BigDecimal valor) {
    this.valor = valor;
  }
}
