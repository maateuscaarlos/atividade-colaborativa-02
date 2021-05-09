package br.edu.ifpb.dac.dao;

import br.edu.ifpb.dac.domain.Produto;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import java.util.List;

@Local
@Stateless(name = "ProdutoDao")
public class ProdutoDao implements ProdutoDaoInterface{

    @PersistenceContext
    private final EntityManager entityManager;

    public ProdutoDao() {
        this.entityManager = Persistence.createEntityManagerFactory("loja").createEntityManager();
    }
    @Override
    public List<Produto> listarTodos() throws NoResultException {
        return entityManager.createQuery("FROM Produto p").getResultList();
    }

    @Override
    public List<Produto> listarTodosPorDescricao(String descricao) throws NoResultException {
        return entityManager
                .createQuery("FROM Produto p WHERE p.descricao LIKE :descricao")
                .setParameter("descricao","%"+ descricao.toLowerCase()+"%")
                .getResultList();
    }

    @Override
    public Produto buscar(int id) throws NoResultException {
        return (Produto) entityManager
                .createQuery("FROM Produto p WHERE p.id = :id")
                .setParameter("id", id)
                .getSingleResult();
    }

    @Override
    public void salvar(Produto produto) {
        entityManager.persist(produto);
    }

    @Override
    public void remover(Produto produto) throws NoResultException {
        Produto produtoToRemove = entityManager.find(Produto.class, produto.getId());
        entityManager.remove(produtoToRemove);
    }

    @Override
    public void atualizar(Produto produto) {
        entityManager.merge(produto);
    }
}
