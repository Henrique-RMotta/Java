/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.senai.henriquemotta.simuladorrpg.service;

import edu.senai.henriquemotta.simuladorrpg.classes.Equipamento;
import edu.senai.henriquemotta.simuladorrpg.model.EquipamentoEnum;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Java_Motta
 */
public class EquipamentoService {
    public static List<Equipamento> ObterEquipamentos(){
        List<Equipamento> equipamentos = new ArrayList<>();
        for (EquipamentoEnum item : EquipamentoEnum.values()) {
            Equipamento e = new Equipamento(); 
            e.setNome(item.getNome());
            e.setBonus(item.getBonus());
            e.setTipo(item.getTipo());
            equipamentos.add(e);
        }
        return equipamentos;
    }
}
