package senai.projeto.henriquemotta.classes;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;


public class Slayer {
    private float vidaSlayer;
    private float danoSlayer;
    private Equipamento arma;
    private Texture texturaSlayer;
    private Sprite slayerSprite;
    private Rectangle slayerHitBox;

    public Rectangle getSlayerHitBox() {
        return slayerHitBox;
    }

    public void setSlayerHitBox(Rectangle slayerHitBox) {
        this.slayerHitBox = slayerHitBox;
    }

    public Sprite getSlayerSprite() {
        return slayerSprite;
    }

    public void setSlayerSprite(Sprite slayerSprite) {
        this.slayerSprite = slayerSprite;
    }


    public Equipamento getArma() {
        return arma;
    }

    public void setArma(Equipamento arma) {
        this.arma = arma;
    }


    public float getVidaSlayer() {
        return vidaSlayer;
    }

    public void setVidaSlayer(float vidaSlayer) {
        this.vidaSlayer = vidaSlayer;
    }

    public float getDanoSlayer() {
        return danoSlayer;
    }

    public void setDanoSlayer(float danoSlayer) {
        this.danoSlayer = danoSlayer;
    }

    public Texture getTexturaSlayer() {
        return texturaSlayer;
    }

    public void setTexturaSlayer(Texture texturaSlayer) {
        this.texturaSlayer = texturaSlayer;
    }
}
