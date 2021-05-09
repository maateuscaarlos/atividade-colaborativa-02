package br.edu.ifpb.dac.dao;

import br.edu.ifpb.dac.domain.Cliente;

import javax.persistence.NoResultException;
import java.util.List;

public interface ClienteDaoInterface {

    public List<Cliente> listarTodos() throws NoResultException;
    public void salvar(Cliente cliente);
    public void remover(Cliente cliente) throws NoResultException;
    public void atualizar(Cliente cliente);
    public Cliente clienteComCPF(String cpf) throws NoResultException;
}
