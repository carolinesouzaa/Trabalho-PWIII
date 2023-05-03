package br.com.etec.caroline.trabalho.repository.filter;

import java.math.BigDecimal;
import java.util.Date;

public class ContasPagFilter {

  private Date dataPag;

  public Date getDataPag() {
    return dataPag;
  }

  public void setDataPag(Date dataPag) {
    this.dataPag = dataPag;
  }

  public Date getDataVenc() {
    return dataVenc;
  }

  public void setDataVenc(Date dataVenc) {
    this.dataVenc = dataVenc;
  }

  public BigDecimal getValor() {
    return valor;
  }

  public void setValor(BigDecimal valor) {
    this.valor = valor;
  }

  private Date dataVenc;

  private BigDecimal valor;

}
