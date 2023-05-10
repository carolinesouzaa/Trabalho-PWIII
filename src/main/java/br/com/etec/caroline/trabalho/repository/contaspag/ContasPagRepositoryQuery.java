package br.com.etec.caroline.trabalho.repository.contaspag;

import br.com.etec.caroline.trabalho.model.ContasPag;
import br.com.etec.caroline.trabalho.repository.filter.ContasPagFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ContasPagRepositoryQuery {
    public Page<ContasPag> filtrar(ContasPagFilter contasPagFilter, Pageable pageable);
}
