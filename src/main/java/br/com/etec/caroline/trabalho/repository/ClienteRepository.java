package br.com.etec.caroline.trabalho.repository;

import br.com.etec.caroline.trabalho.model.Cliente;
import br.com.etec.caroline.trabalho.repository.cliente.ClienteRepositoryQuery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer>, ClienteRepositoryQuery {
}
