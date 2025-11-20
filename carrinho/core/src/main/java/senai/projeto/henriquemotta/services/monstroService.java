package senai.projeto.henriquemotta.services;
import senai.projeto.henriquemotta.classes.Monstro;
import senai.projeto.henriquemotta.model.MonstroEnum;

import java.util.ArrayList;
import java.util.List;

public class monstroService {
    public static List<Monstro> ObterMonstros() {
        List<Monstro> monstros = new ArrayList<>();
        for (MonstroEnum monstro : MonstroEnum.values()){
            Monstro m = new Monstro();
            m.setVidaMonstro(monstro.getVida());
            m.setTexturaMonstro(monstro.getTextura());
            m.setNomeMonstro(monstro.getNome());
            monstros.add(m);
        }
        return monstros;
    }
}
