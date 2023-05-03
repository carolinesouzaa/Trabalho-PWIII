package br.com.etec.caroline.trabalho.controller;

import br.com.etec.caroline.trabalho.model.ContasPag;
import br.com.etec.caroline.trabalho.repository.ContasPagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RequestMapping("/contaspag")
@RestController
public class ContasPagController {

  @Autowired
  private ContasPagRepository contasPagRepository;

  @GetMapping("/todos")
  public List<ContasPag> list() {
    return contasPagRepository.findAll();
  }
}
