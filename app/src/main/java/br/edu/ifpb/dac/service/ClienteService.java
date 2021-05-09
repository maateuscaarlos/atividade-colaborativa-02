package br.edu.ifpb.dac.service;


import br.edu.ifpb.dac.dao.ClienteDaoInterface;
import br.edu.ifpb.dac.domain.Cliente;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import java.util.List;

@Local
@Stateless
public class ClienteService {

    @EJB
    private ClienteDaoInterface clienteDao;

    public List<Cliente> listarTodos() {
        return clienteDao.listarTodos();
    }

    public String salvar(Cliente cliente) {
        clienteDao.salvar(cliente);
        return cliente.getCpf();
    }

    public void remover(Cliente cliente) {
        try {
            clienteDao.remover(cliente);
        } catch (NoResultException ex) {

        }
    }

    public void atualizar(Cliente cliente) {
        clienteDao.atualizar(cliente);
    }

    public Cliente clienteComCPF(String cpf) {
        try {
            return clienteDao.clienteComCPF(cpf);

        } catch (NoResultException ex) {
            return null;
        }

    }


}
