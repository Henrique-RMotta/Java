package senai.projeto.henriquemotta.classes;

import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;

public class Equipamento {
    private int danoEquip;
    private Texture texturaEquip;
    private float fireCooldown;
    public int getDanoEquip() {
        return danoEquip;
    }

    public void setDanoEquip(int danoEquip) {
        this.danoEquip = danoEquip;
    }

    public Texture getTextura() {
        return texturaEquip;
    }

    public void setTexturaEquip(Texture texturaEquip) {
        this.texturaEquip = texturaEquip;
    }

    public float getFireCooldown() {
        return fireCooldown;
    }

    public void setFireCooldown(float fireCooldown) {
        this.fireCooldown = fireCooldown;
    }
}
