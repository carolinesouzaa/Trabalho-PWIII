package br.com.etec.caroline.trabalho.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "cliente")

public class cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer idCliente;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        cliente cliente = (cliente) o;
        return idCliente.equals(cliente.idCliente);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idCliente);
    }

    public Integer getId() {
        return idCliente;
    }

    public void setId(Integer id) {
        this.idCliente = id;
    }

    private String nome;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @JsonIgnore
    @OneToMany(mappedBy = "cliente")
    private List<contasPagar> contaCliente = new ArrayList<>();

}
