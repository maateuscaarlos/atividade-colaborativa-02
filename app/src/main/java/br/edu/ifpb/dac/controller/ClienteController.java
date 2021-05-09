package br.edu.ifpb.dac.controller;


import br.edu.ifpb.dac.domain.Cliente;
import br.edu.ifpb.dac.service.ClienteService;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;

import java.util.List;

@Named
@SessionScoped
public class ClienteController implements Serializable {

    @EJB
    private ClienteService clienteService;

    private Cliente cliente;
    private List<Cliente>clientes;

    @PostConstruct
    public void init() {
        this.cliente = new Cliente();
        this.clientes = todos();
        preencherClinte();
    }

    public List<Cliente> todos(){
        return clienteService.listarTodos();
    }
    public Cliente getCliente() {
        return cliente;
    }
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    public List<Cliente> getClientes() {
        return clientes;
    }
    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }
    public void preencherClinte(){
        Cliente newCliente = new Cliente("Mateus Carlos","05555555555" );
        clienteService.salvar(newCliente);
        this.clientes = clienteService.listarTodos();
        this.cliente = clienteService.clienteComCPF("05555555555");

    }
}
