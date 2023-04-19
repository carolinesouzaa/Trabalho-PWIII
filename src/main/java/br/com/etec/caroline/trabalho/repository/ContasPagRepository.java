package br.com.etec.caroline.trabalho.repository;

import br.com.etec.caroline.trabalho.model.ContasPag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface ContasPagRepository extends JpaRepository<ContasPag, Integer> {
}
