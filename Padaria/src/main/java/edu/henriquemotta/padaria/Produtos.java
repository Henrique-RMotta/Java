/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.henriquemotta.padaria;

/**
 *
 * @author java
 */

public class Produtos {
    private int codigo; 
    private String Descricao; 
    private double preco;
    
    public String toString() {
        return this.Descricao;
    }
    public Produtos(int codigo, String Descricao, double preco) {
        this.codigo = codigo;
        this.Descricao = Descricao;
        this.preco = preco;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return Descricao;
    }

    public void setDescricao(String Descricao) {
        this.Descricao = Descricao;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }
    
}
