package br.edu.ifpb.dac.domain.venda;

import br.edu.ifpb.dac.domain.Cliente;
import br.edu.ifpb.dac.domain.Produto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Venda {
    private List<ItemDeVenda> itensDeVenda = new ArrayList<>();
    private Cliente cliente;

    public boolean adicionar(ItemDeVenda itemDeVenda) {

        for (ItemDeVenda i : itensDeVenda) {
            if (i.getProduto().getDescricao().equals(itemDeVenda.getProduto().getDescricao())) {
                incrementar(itemDeVenda.getProduto());
                return true;
            }

        }
        this.itensDeVenda.add(itemDeVenda);
        return true;
    }
    public void incrementar(Produto produto) {
        this.itensDeVenda.stream()
                .filter(lista -> lista.getProduto().getDescricao().equals(produto.getDescricao()))
                .findFirst()
                .get()
                .incrementar();
    }
    public void decrementar(Produto produto) {
        this.itensDeVenda.stream()
                .filter(item -> item.getProduto().getDescricao().equals(produto.getDescricao()))
                .findFirst()
                .get()
                .decrementar();
    }
    public void remover(Produto produto) {
        ItemDeVenda aRemover = this.itensDeVenda.stream()
                .filter(item -> item.getProduto().getDescricao().equals(produto.getDescricao()))
                .findFirst()
                .get();
        if (aRemover.getQuantidade()>1){
            decrementar(aRemover.getProduto());
        }
        else{
            this.itensDeVenda.remove(aRemover);
        }


    }
    public List<ItemDeVenda> itens() {
        return Collections.unmodifiableList(
                itensDeVenda
        );
    }
    public void finalizar(Cliente cliente) {

        this.cliente = cliente;
        System.out.println("Produtos");
        this.itensDeVenda.forEach(
                p -> System.out.println(p.getProduto())
        );
        double total = this.itensDeVenda
                .stream()
                .mapToDouble(ItemDeVenda::getSubtotal)
                .sum();
        System.out.println("Cliente"+cliente);
        System.out.println("Total" + total);
        System.out.println("Carrinho finalizado");
    }

    public List<ItemDeVenda> getItensDeVenda() {
        return itensDeVenda;
    }

    public void setItensDeVenda(List<ItemDeVenda> itensDeVenda) {
        this.itensDeVenda = itensDeVenda;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
