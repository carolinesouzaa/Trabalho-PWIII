package br.com.etec.caroline.trabalho.repository.cliente;

import br.com.etec.caroline.trabalho.model.Cliente;
import br.com.etec.caroline.trabalho.repository.filter.ClienteFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ClienteRepositoryQuery {
    public Page <Cliente> filtrar(ClienteFilter clienteFilter, Pageable pageable);
}
