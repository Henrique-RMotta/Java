
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package edu.henriquemotta.eshop;

import Produto.Produto;

/**
 *
 * @author java
 */
public class Eshop {
    public static void main(String[] args) {
        Produto banana = new Produto();//"banana",2,"prata");
        Produto feijao = new Produto(); 
        feijao.setNome("Feijao");
        feijao.setPreco(10);
        feijao.setDescricao("Preto");
        
        System.out.println("Produto:"
        +banana.getNome()
        +banana.getPreco()
        +banana.getDescricao());
    }
}


