package br.edu.ifpb.dac.controller;


import br.edu.ifpb.dac.domain.Cliente;
import br.edu.ifpb.dac.domain.Produto;
import br.edu.ifpb.dac.domain.venda.ItemDeVenda;
import br.edu.ifpb.dac.service.CarrinhoDeCompras;
import br.edu.ifpb.dac.service.ProdutoService;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.spi.CDI;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpSession;
import java.io.Serializable;
import java.util.List;

@Named
@SessionScoped
public class CarrinhoController implements Serializable {

    @EJB
    private CarrinhoDeCompras carrinho;
    @EJB
    private ProdutoService produtoService;
    private Produto produto;
    private Cliente cliente;
    private String idProduto;

    @PostConstruct
    public void init() {
        this.cliente = new Cliente();
        this.produto = new Produto();
    }
    public String novo() {
        int valor1 = Integer.valueOf(idProduto);
        produto = produtoService.buscar(valor1);
        this.carrinho.adicionar(new ItemDeVenda(produto));
        this.produto = null;
        System.out.println(this.carrinho);
        return null;

    }
    public String remover(Produto produto) {
        System.out.println(produto);
        carrinho.remover(produto);
        System.out.println(carrinho);
        return null;
    }
    public List<ItemDeVenda> todosOsProdutos() {
        return this.carrinho.itens();
    }
    public String checkout(Cliente cliente1) {
        this.carrinho.finalizar(cliente1);

        recuperarNovaInstanciaCarrinho();

        return "index?faces-redirect=true";
    }
    private void recuperarNovaInstanciaCarrinho() {
        System.out.println("renovando a instância");
        this.carrinho = CDI.current()
                .select(CarrinhoDeCompras.class)
                .get();
    }

    public Produto getProduto() {
        return produto;
    }
    public void setProduto(Produto produto) {
        this.produto = produto;
    }
    public Cliente getCliente() {
        return cliente;
    }
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    public String getIdProduto() {
        return idProduto;
    }
    public void setIdProduto(String idProduto) {
        this.idProduto = idProduto;
    }
}
