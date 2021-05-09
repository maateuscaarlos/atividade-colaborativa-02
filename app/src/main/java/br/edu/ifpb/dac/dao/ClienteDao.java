package br.edu.ifpb.dac.dao;

import br.edu.ifpb.dac.domain.Cliente;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import java.util.List;

@Local
@Stateless(name = "ClienteDao")
public class ClienteDao implements ClienteDaoInterface{

    @PersistenceContext
    private final EntityManager entityManager;

    public ClienteDao() {
        this.entityManager = Persistence.createEntityManagerFactory("loja").createEntityManager();
    }

    @Override
    public List<Cliente> listarTodos() throws NoResultException {
        return entityManager.createQuery("FROM Cliente c").getResultList();
    }

    @Override
    public void salvar(Cliente cliente) {
        entityManager.persist(cliente);
    }

    @Override
    public void remover(Cliente cliente) throws NoResultException {
        Cliente clienteToRemove = entityManager.find(Cliente.class, cliente.getId());
        entityManager.remove(clienteToRemove);
    }

    @Override
    public void atualizar(Cliente cliente) {
        entityManager.merge(cliente);
    }

    @Override
    public Cliente clienteComCPF(String cpf) throws NoResultException {
        return (Cliente) entityManager
                .createQuery("FROM Cliente c WHERE c.cpf = :cpf")
                .setParameter("cpf", cpf)
                .getSingleResult();
    }
}
