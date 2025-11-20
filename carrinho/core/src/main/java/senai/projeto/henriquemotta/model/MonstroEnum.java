package senai.projeto.henriquemotta.model;

import com.badlogic.gdx.graphics.Texture;

public enum MonstroEnum {

    CACODEMON("cacodemon_top.png", 20, "Cacodemon"),
    IMP("imp_top.png", 15, "Imp");

    private Texture textura;
    private float vida;
    private String nome;

    MonstroEnum(String texturaPath, float vida, String nome) {
        this.textura = new Texture(texturaPath);
        this.vida = vida;
        this.nome = nome;
    }

    public Texture getTextura() {
        return textura;
    }

    public float getVida() {
        return vida;
    }

    public String getNome() {
        return nome;
    }
}
