/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.senai.henriquemotta.simuladorrpg.service;
import java.util.ArrayList;
import java.util.List;
import edu.senai.henriquemotta.simuladorrpg.model.MonstroEnum;
import edu.senai.henriquemotta.simuladorrpg.classes.Monstro;
/**
 *
 * @author Java_Motta
 */
public class MonstroService {
    public static List<Monstro> ObterMonstros() {
        List<Monstro> monstros = new ArrayList(); 
        for (MonstroEnum item : MonstroEnum.values()) {
            Monstro m = new Monstro() ; 
            m.setNivel(item.getNivel());
            m.setNome(item.getNome());
            monstros.add(m);
        }
        return monstros;
    }
}
