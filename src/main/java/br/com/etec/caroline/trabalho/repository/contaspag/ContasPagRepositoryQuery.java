package br.com.etec.caroline.trabalho.repository.contaspag;

import br.com.etec.caroline.trabalho.model.ContasPag;
import br.com.etec.caroline.trabalho.repository.filter.ContasPagFilter;
import br.com.etec.caroline.trabalho.repository.projections.ResumoContas;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ContasPagRepositoryQuery {
    public Page<ResumoContas> filtrar(ContasPagFilter contasPagFilter, Pageable pageable);
}
