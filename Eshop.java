
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
        Produto feijao = new Produto("1010"); 
        feijao.setNome("Feijao");
        feijao.setPreco(10);
        feijao.setSaldo((float)10);
        
        System.out.println("Produto:"
            +feijao.getNome()
            +feijao.getPreco()
            +feijao.getCodigo());
    }
}


