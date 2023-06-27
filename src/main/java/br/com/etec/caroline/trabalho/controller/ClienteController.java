package br.com.etec.caroline.trabalho.controller;

import br.com.etec.caroline.trabalho.model.Cliente;
import br.com.etec.caroline.trabalho.repository.ClienteRepository;
import br.com.etec.caroline.trabalho.repository.filter.ClienteFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

  @Autowired
  private ClienteRepository clienteRepository;

  @GetMapping("/todos")
  public List<Cliente> list() {
    return clienteRepository.findAll();
  }

  @GetMapping()
  public Page<Cliente> pesquisar(ClienteFilter clienteFilter, Pageable pageable) {
    return clienteRepository.filtrar(clienteFilter, pageable);
  }



}
