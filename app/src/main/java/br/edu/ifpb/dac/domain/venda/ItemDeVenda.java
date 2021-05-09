package br.edu.ifpb.dac.domain.venda;

import br.edu.ifpb.dac.domain.Produto;

import java.math.BigDecimal;

public class ItemDeVenda {
    private Produto produto;
    private int quantidade = 1;

    public ItemDeVenda(Produto produto) {
        this.produto = produto;
    }
    private static BigDecimal multiply ( int a, BigDecimal b ) {
        return BigDecimal.valueOf( a ).multiply( b );
    }

    public double getSubtotal(){
        return multiply(quantidade, produto.getValor()).doubleValue();
    }

    public void incrementar() {
        this.quantidade++;
    }

    public void decrementar() {
        this.quantidade--;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    @Override
    public String toString() {
        return "ItemDeVenda{" +
                "produto=" + produto +
                ", quantidade=" + quantidade +
                '}';
    }
}
