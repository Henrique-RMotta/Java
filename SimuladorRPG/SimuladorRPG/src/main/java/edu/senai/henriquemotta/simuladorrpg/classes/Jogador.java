/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.senai.henriquemotta.simuladorrpg.classes;
import edu.senai.henriquemotta.simuladorrpg.model.EquipamentoEnum;
import edu.senai.henriquemotta.simuladorrpg.model.TipoEquipamento;
import java.util.List;
/**
 *
 * @author Java_Motta
 */
public class Jogador {
    private String nome; 
    private int nivel; 
    private Equipamento cabeca; 
    private Equipamento armadura; 
    private Equipamento Calcado;
    private Equipamento Mao;
    private Equipamento ItemGeral; 
    private List<Equipamento> inventario; 
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getNivel() {
        return nivel;
    }

    public Equipamento getCabeca() {
        return cabeca;
    }

    public boolean setCabeca(Equipamento cabeca) {
        if(cabeca.getTipo() == TipoEquipamento.CABECAL){
            this.cabeca = cabeca;
            return true;
        } else {
            return false; 
        }
        
    }

    public Equipamento getArmadura() {
        return armadura;
    }

    public boolean setArmadura(Equipamento armadura) {
        if(armadura.getTipo() == TipoEquipamento.ARMADURA){
            this.armadura = armadura;
            return true;
        } else {
            return false; 
        }
    }

    public Equipamento getCalcado() {
        return Calcado;
    }

    public boolean setCalcado(Equipamento Calcado) {
        if(Calcado.getTipo() == TipoEquipamento.CALCADO) {
            this.Calcado = Calcado;
            return true;
        } else {
            return false; 
        }
    }

    public Equipamento getMao() {
        return Mao;
    }

    public boolean setMao(Equipamento Mao) {
        if(Mao.getTipo() == TipoEquipamento.MAO){
            this.Mao = Mao;
            return true;
        } else {
            return false; 
        }
        
    }

    public Equipamento getItemGeral() {
        return ItemGeral;
    }

    public boolean setItemGeral(Equipamento ItemGeral) {
        if (ItemGeral.getTipo() == TipoEquipamento.ITEM_GERAL) {
            this.ItemGeral = ItemGeral;
            return true;
        } else {
            return false; 
        }   
         
        
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    
    
}
