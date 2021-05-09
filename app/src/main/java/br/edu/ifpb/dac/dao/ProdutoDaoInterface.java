package br.edu.ifpb.dac.dao;

import br.edu.ifpb.dac.domain.Produto;

import javax.persistence.NoResultException;
import java.util.List;

public interface ProdutoDaoInterface {
    public List<Produto> listarTodos() throws NoResultException;
    public List<Produto> listarTodosPorDescricao(String descricao) throws NoResultException;
    public Produto buscar(int id)throws NoResultException;
    public void salvar(Produto produto);
    public void remover(Produto produto) throws NoResultException;
    public void atualizar(Produto produto);
}
