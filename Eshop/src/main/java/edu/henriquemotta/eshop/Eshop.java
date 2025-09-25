
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package edu.henriquemotta.eshop;

import Produto.Produto;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author java
 */
public class Eshop {
    public static void main(String[] args) throws IOException {
        Produto feijao = new Produto("1010"); 
        feijao.setNome("Feijao");
        feijao.setPreco(10);
        feijao.setSaldo((float)10);
        
        Produto banana = new Produto("1020");
        banana.setNome("Banana");
        banana.setPreco(2);
        banana.setSaldo((float)5);
        
        Produto arroz = new Produto("1025");
        arroz.setNome("Arroz");
        arroz.setPreco(20);
        arroz.setSaldo((float)15);
        
        Produto goiaba = new Produto("1022");
        goiaba.setNome("Goiaba");
        goiaba.setPreco(5);
        goiaba.setSaldo((float)3);
        
        Produto garrafa = new Produto("1024");
        garrafa.setNome("Garrafa");
        garrafa.setPreco(50);
        garrafa.setSaldo((float)40);
        
        InputStreamReader isr =
                new InputStreamReader(System.in);
        BufferedReader reader = 
                new BufferedReader(isr);
        int qtd;
        qtd = Integer.parseInt(reader.readLine());
        
        String codigo_input;
        codigo_input = reader.readLine();
        
        String produto_input;
        produto_input = reader.readLine();
        
        int preco_input; 
        preco_input = Integer.parseInt(reader.readLine());
        
        Produto prod1 = new Produto(codigo_input);
        prod1.setNome(produto_input);
        prod1.setPreco(preco_input);
        
        System.out.println("");
        System.out.println("Nome Cadastrado:"+prod1.getNome()+"\n"+"Preco:"+prod1.getPreco());
        
        System.out.println("");
        System.out.println("Venda:"+feijao.getCodigo()+"\n"+feijao.getNome()+"\n"+feijao.getPreco()+"x"+qtd+"="+(qtd*feijao.getPreco()));
        System.out.println("Produto:"
            +"Nome:"+feijao.getNome()
            +"Preco:"+feijao.getPreco()
            +"Codigo:"+feijao.getCodigo());
    }

    
}
