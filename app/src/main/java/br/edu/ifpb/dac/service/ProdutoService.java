package br.edu.ifpb.dac.service;

import br.edu.ifpb.dac.dao.ClienteDaoInterface;
import br.edu.ifpb.dac.dao.ProdutoDaoInterface;
import br.edu.ifpb.dac.domain.Cliente;
import br.edu.ifpb.dac.domain.Produto;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import java.util.List;

@Local
@Stateless
public class ProdutoService {

    @EJB
    private ProdutoDaoInterface produtoDao;

    public List<Produto> listarTodos() {
        return produtoDao.listarTodos();
    }

    public List<Produto> listarTodosPorDescricao(String descricao) {
        return produtoDao.listarTodosPorDescricao(descricao);
    }

    public void salvar(Produto produto) {
        produtoDao.salvar(produto);
    }

    public Produto buscar(int id){
        return produtoDao.buscar(id);
    }

    public void remover(Produto produto) {
        try {
            produtoDao.remover(produto);
        } catch (NoResultException ex) {

        }
    }

    public void atualizar(Produto produto) {
        produtoDao.atualizar(produto);
    }
}
