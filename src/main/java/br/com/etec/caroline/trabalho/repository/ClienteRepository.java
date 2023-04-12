package br.com.etec.caroline.trabalho.repository;

import br.com.etec.caroline.trabalho.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
}
