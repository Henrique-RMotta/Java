package senai.projeto.henriquemotta.services;
import senai.projeto.henriquemotta.classes.Equipamento;
import senai.projeto.henriquemotta.model.EquipamentoEnum;

import java.util.ArrayList;
import java.util.List;


public class equipamentoService {
        public static List<Equipamento> ObterEquipamentos() {
            List<Equipamento> equipamentos = new ArrayList<>();
            for (EquipamentoEnum equipamento : EquipamentoEnum.values()){
                Equipamento e = new Equipamento();
                e.setDanoEquip(equipamento.getDano());
                e.setTexturaEquip(equipamento.getTextura());
                e.setFireCooldown(equipamento.getFireCooldown());
                e.setTiroSom(equipamento.getTiroSom());
                equipamentos.add(e);
            }
            return equipamentos;
        }
}
