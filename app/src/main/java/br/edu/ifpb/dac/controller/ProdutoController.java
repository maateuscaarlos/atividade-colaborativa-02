package br.edu.ifpb.dac.controller;

import br.edu.ifpb.dac.domain.Cliente;
import br.edu.ifpb.dac.domain.Produto;
import br.edu.ifpb.dac.service.ProdutoService;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@Named
@SessionScoped
public class ProdutoController implements Serializable {

    @EJB
    private ProdutoService produtoService;
    private Produto produto;
    private List<Produto> produtos;

    @PostConstruct
    public void init() {
        this.produto = new Produto();
        this.produtos = todos();
        preencherProdutos();
    }
    public List<Produto>todos(){
        return produtoService.listarTodos();
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    public void preencherProdutos(){
        Produto newProduto = new Produto("biscoito recheado", new BigDecimal(1.5));
        Produto newProduto2 = new Produto("biscoito agua e sal", new BigDecimal(3));
        Produto newProduto3 = new Produto("bolacha maria", new BigDecimal(4));
        Produto newProduto4 = new Produto("tareco", new BigDecimal(10));

        produtoService.salvar(newProduto);
        produtoService.salvar(newProduto2);
        produtoService.salvar(newProduto3);
        produtoService.salvar(newProduto4);
        produtos = produtoService.listarTodos();
        System.out.println(produtos);

    }
}
