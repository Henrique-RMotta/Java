package senai.projeto.henriquemotta;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;

public class tiro {
    Sprite sprite;
    Rectangle hitbox;

    tiro(Sprite sprite) {
        this.sprite = sprite;
        this.hitbox = new Rectangle(sprite.getX(), sprite.getY(), sprite.getWidth(), sprite.getHeight());
    }
}
