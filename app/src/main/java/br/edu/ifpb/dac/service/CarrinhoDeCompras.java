package br.edu.ifpb.dac.service;

import br.edu.ifpb.dac.domain.Cliente;
import br.edu.ifpb.dac.domain.Produto;
import br.edu.ifpb.dac.domain.venda.ItemDeVenda;
import br.edu.ifpb.dac.domain.venda.Venda;

import javax.ejb.Remove;
import javax.ejb.Stateful;
import java.util.List;

@Stateful
public class CarrinhoDeCompras {

    private Cliente cliente;

    private final Venda venda = new Venda();

    public void adicionar(ItemDeVenda itemDeVenda) {
        this.venda.adicionar(itemDeVenda);
    }

    public void incrementar(Produto produto) {
        this.venda.incrementar(produto);
    }

    public void decrementar(Produto produto) {
        this.venda.decrementar(produto);
    }

    public void remover(Produto produto) {
        this.venda.remover(produto);
    }

    public List<ItemDeVenda> itens() {
        return this.venda.itens();
    }

    @Remove
    public void finalizar(Cliente cliente) {
        this.venda.finalizar(cliente);
    }
}
