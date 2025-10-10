/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.henriquemotta.padaria.service;
import java.util.ArrayList;
import java.util.List;
import edu.henriquemotta.padaria.Produtos;
import edu.henriquemotta.padaria.ProdutoEnum;
import java.util.Random;
/**
 *
 * @author java
 */
public class ProdutoService {
    private static Random r = new Random();
    public static List<Produtos> inicializarProdutos() {
        List<Produtos> produtos = new ArrayList<>();
        for(ProdutoEnum item: ProdutoEnum.values()){
            Produtos produto = new Produtos();
            produto.setCodigo(item.getCodigo());
            produto.setDescricao(item.getDescricao());
            produto.setPreco(item.getPreco());
            produto.setSaldoEstoque(r.nextInt(5,20));
            produtos.add(produto);
        }
        return produtos;
    }
}
