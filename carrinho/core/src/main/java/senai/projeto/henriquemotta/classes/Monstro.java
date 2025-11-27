package senai.projeto.henriquemotta.classes;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;

public class Monstro {
    private float vidaMonstro;
    private String nomeMonstro;
    private Texture texturaMonstro;
    public Sprite sprite;
    public Rectangle hitbox;
    private float velocidade;

    public Sprite getSprite() {
        return sprite;
    }

    public void setSprite(Sprite sprite) {
        this.sprite = sprite;
    }

    public String getNomeMonstro() {
        return nomeMonstro;
    }

    public void setNomeMonstro(String nomeMonstro) {
        this.nomeMonstro = nomeMonstro;
    }

    public Texture getTexturaMonstro() {
        return texturaMonstro;
    }

    public void setTexturaMonstro(Texture texturaMonstro) {
        this.texturaMonstro = texturaMonstro;
    }

    public float getVidaMonstro() {
        return vidaMonstro;
    }

    public void setVidaMonstro(float vidaMonstro) {
        this.vidaMonstro = vidaMonstro;
    }

    public float getVelocidade() {
        return velocidade;
    }

    public void setVelocidade(float velocidade) {
        this.velocidade = velocidade;
    }
}
