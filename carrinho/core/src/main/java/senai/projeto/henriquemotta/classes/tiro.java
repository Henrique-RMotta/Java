package senai.projeto.henriquemotta.classes;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;

public class tiro {
    public Sprite sprite;
    public Rectangle hitbox;
    public Texture tiroTexture;
    public tiro(Sprite sprite) {
        this.sprite = sprite;
        this.hitbox = new Rectangle(sprite.getX(), sprite.getY(), sprite.getWidth(), sprite.getHeight());
    }
}
