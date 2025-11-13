package senai.projeto.henriquemotta;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.math.Rectangle;
import java.awt.*;

/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class Main extends ApplicationAdapter {
    Texture planoDeFundoTexture;
    Texture carrinhoTexture;
    Texture carrinhosCairTexture;

    Sound batida;
    Music music;

    SpriteBatch spriteBatch;

    FitViewport viewport;

    Sprite carrinhoSprite;

    Vector2 touchPos;

    Array<Sprite> carrinhosSprite;

    Rectangle carrinhoHitBox;
    Rectangle carrinhosHitBox;

    float Timer;

    @Override
    public void create() {
        planoDeFundoTexture = new Texture("background.png");
        carrinhoTexture = new Texture("carro.png");

        spriteBatch = new SpriteBatch();
        viewport = new FitViewport(8,10);

        carrinhoSprite = new Sprite(carrinhoTexture);
        carrinhoSprite.setSize(1,1);
    }


    @Override
    public void resize(int width, int height) {
        viewport.update(width,height,true);
    }
    @Override
    public void render() {
        input();
        logic();
        draw();
    }

    private void input() {
        float speed = 4f;
        float delta = Gdx.graphics.getDeltaTime();

        if(Gdx.input.isKeyPressed(Input.Keys.D)){
            carrinhoSprite.translateX(speed * delta);
        } else if (Gdx.input.isKeyPressed(Input.Keys.A)){
            carrinhoSprite.translateX(-speed * delta );
        } else if (Gdx.input.isKeyPressed(Input.Keys.W)){
            carrinhoSprite.translateY(speed * delta);
        }else if (Gdx.input.isKeyPressed(Input.Keys.S)){
            carrinhoSprite.translateY(-speed * delta);
        }
    }

    private void logic() {
        float worldWidth = viewport.getWorldWidth();
        float worldHeight = viewport.getWorldHeight();

        float carrinhoWidth = carrinhoSprite.getWidth();
        float carrinhoHeight = carrinhoSprite.getHeight();
        carrinhoSprite.setX(MathUtils.clamp(carrinhoSprite.getX(),2,5));
        carrinhoSprite.setY(MathUtils.clamp(carrinhoSprite.getY(),0,worldHeight - carrinhoHeight));

    }

    private void draw() {
        ScreenUtils.clear(Color.BLACK);
        viewport.apply();
        spriteBatch.setProjectionMatrix(viewport.getCamera().combined);
        spriteBatch.begin();

        float worldWidth = viewport.getWorldWidth();
        float wordHeight = viewport.getWorldHeight();

        spriteBatch.draw(planoDeFundoTexture,0,0,worldWidth,wordHeight);
        carrinhoSprite.draw(spriteBatch);
        spriteBatch.end();

    }
}
