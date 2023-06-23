package br.com.etec.caroline.trabalho.repository.filter;

import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.time.LocalDate;

public class ContasPagFilter {

  @DateTimeFormat(pattern = "yyyy/mm/dd")
  private LocalDate datapag;

  @DateTimeFormat(pattern = "yyyy/mm/dd")
  private LocalDate datavenc;

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

  public BigDecimal getValor() {
    return valor;
  }

  public void setValor(BigDecimal valor) {
    this.valor = valor;
  }
}
