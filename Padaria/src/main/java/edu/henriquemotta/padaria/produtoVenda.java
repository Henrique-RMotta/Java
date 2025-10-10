/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.henriquemotta.padaria;
import edu.henriquemotta.padaria.Produtos;
/**
 *
 * @author java
 */
public class produtoVenda {
    private Produtos produto;
    private int quantidade;
    private double total;

    public Produtos getProduto() {
        return produto;
    }

    public void setProduto(Produtos produto) {
        this.produto = produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal() {
        this.total = this.quantidade * this.produto.getPreco();
    }

    @Override
    public String toString() {
        return quantidade +"*" + produto.getDescricao() + "=" + total;
    }
    
    
}
