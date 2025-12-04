package senai.projeto.henriquemotta.model;

import com.badlogic.gdx.graphics.Texture;

public enum EquipamentoEnum {

    SUPER_SHOTGUN(90, "carro.png", 0.65f),     // forte, recarga lenta
    BALISTA(100, "balista.png", 0.75f),                // dano alto, recarga ainda maior
    ROCKET_LAUNCHER(120, "rocket_launcher.png", 1.0f), // tiro mais forte → cooldown alto
    PLASMA_RIFLE(60, "plasma_rifle.png", 0.20f),       // rápida e fraca
    HEAVY_CANNON(50, "heavy_cannon.png", 0.25f);       // rápida, precisa

    private final int dano;
    private final Texture textura;
    private final float fireCooldown; // tempo entre tiros

    EquipamentoEnum(int dano, String texturaPath, float fireCooldown) {
        this.dano = dano;
        this.textura = new Texture(texturaPath);
        this.fireCooldown = fireCooldown;
    }

    public int getDano() {
        return dano;
    }

    public Texture getTextura() {
        return textura;
    }

    public float getFireCooldown() {
        return fireCooldown;
    }
}
