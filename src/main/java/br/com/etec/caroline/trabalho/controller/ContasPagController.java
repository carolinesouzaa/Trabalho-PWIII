package br.com.etec.caroline.trabalho.controller;


import br.com.etec.caroline.trabalho.model.ContasPag;
import br.com.etec.caroline.trabalho.repository.ContasPagRepository;
import br.com.etec.caroline.trabalho.repository.filter.ContasPagFilter;
import br.com.etec.caroline.trabalho.repository.projections.ResumoContas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/contaspag")
public class ContasPagController {

    @Autowired
    private ContasPagRepository contasPagRepository;

    @GetMapping("/todos")
    public List<ContasPag> listarTodasContas(){
        return contasPagRepository.findAll();
    }

    @GetMapping()
    public Page<ResumoContas> pesquisar(ContasPagFilter contasPagFilter, Pageable pageable){
        return contasPagRepository.filtrar(contasPagFilter, pageable);
    }
}
