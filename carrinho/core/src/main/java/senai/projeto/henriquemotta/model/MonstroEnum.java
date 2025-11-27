package senai.projeto.henriquemotta.model;

import com.badlogic.gdx.graphics.Texture;

public enum MonstroEnum {

    CACODEMON("cacodemon_top.png", 20, "Cacodemon",4.5f),
    IMP("imp_top.png", 15, "Imp",6f),
    BARON_OF_HELL("baron_top.png", 180, "Baron of Hell",3f),
    DAVOTH("davoth_top.png", 220, "Davoth",2.5f);

    private Texture textura;
    private float vida;
    private String nome;
    private float velocidade;

    MonstroEnum(String texturaPath, float vida, String nome, float velocidade) {
        this.textura = new Texture(texturaPath);
        this.vida = vida;
        this.nome = nome;
        this.velocidade = velocidade;
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

    public float getVelocidade() {
        return velocidade;
    }
}
