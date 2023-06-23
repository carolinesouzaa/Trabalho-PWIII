package br.com.etec.caroline.trabalho.repository.filter;

import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.time.LocalDate;

public class ContasPagFilter {

  @DateTimeFormat(pattern = "yyyy/mm/dd")
  private LocalDate dataPag;

  @DateTimeFormat(pattern = "yyyy/mm/dd")
  private LocalDate dataVenc;

  private BigDecimal valor;

  public ContasPagFilter(LocalDate dataPag) {
    this.dataPag = dataPag;
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

  public BigDecimal getValor() {
    return valor;
  }

  public void setValor(BigDecimal valor) {
    this.valor = valor;
  }
}
