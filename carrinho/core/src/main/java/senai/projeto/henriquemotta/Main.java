package senai.projeto.henriquemotta;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.math.Rectangle;
import senai.projeto.henriquemotta.tiro;
import java.awt.*;
import java.util.concurrent.TimeUnit;
/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class Main extends ApplicationAdapter {
    Texture planoDeFundoTexture;
    Texture persoTexture;
    Texture inimigoTexture;
    Texture tiroTexture;

    Sound tiroSom;
    Music music;

    SpriteBatch spriteBatch;
 
    FitViewport viewport;

    Sprite persoSprite;

    Vector2 touchPos;

    Array<Sprite> inimigosSprite;
    Rectangle persoHitBox;
    Rectangle inimigosHitBox;
    Rectangle tiroHitBox;
    Array<tiro> tiros;
    float Timer;

    int vidaPerso =5;
    @Override
    public void create() {
        planoDeFundoTexture = new Texture("background.png");
        persoTexture = new Texture("carro.png");
        spriteBatch = new SpriteBatch();
        viewport = new FitViewport(8,8);
        persoSprite = new Sprite(persoTexture);
        persoSprite.setSize(1,1);
        persoHitBox = new Rectangle();

        inimigosSprite = new Array<>();
        inimigoTexture = new Texture("inimigo.png");
        inimigosHitBox = new Rectangle();

        tiros = new Array<>();
        tiroTexture = new Texture("tiro.png");
        tiroHitBox = new Rectangle();
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
            persoSprite.translateX(speed * delta);
        } else if (Gdx.input.isKeyPressed(Input.Keys.A)){
            persoSprite.translateX(-speed * delta );
        } else if (Gdx.input.isKeyPressed(Input.Keys.W)){
            persoSprite.translateY(speed * delta);
        }else if (Gdx.input.isKeyPressed(Input.Keys.S)){
            persoSprite.translateY(-speed * delta);
        }
        Timer += delta;
        if(Gdx.input.isTouched()){
                createTiros();
        }
    }

    private void logic() {
        float worldWidth = viewport.getWorldWidth();
        float worldHeight = viewport.getWorldHeight();

        float persoWidth = persoSprite.getWidth();
        float persoHeight = persoSprite.getHeight();
        persoSprite.setX(MathUtils.clamp(persoSprite.getX(),0,worldWidth - persoWidth));
        persoSprite.setY(MathUtils.clamp(persoSprite.getY(),0,worldHeight - persoHeight));
        float delta = Gdx.graphics.getDeltaTime();

        persoHitBox.set(persoSprite.getX(),persoSprite.getY(),persoWidth,persoHeight);

        for(int i = inimigosSprite.size -1; i>=0 ; i--) {
            Sprite inimigoSprite = inimigosSprite.get(i);
            float inimigoWidth = inimigoSprite.getWidth();
            float inimigoHeight = inimigoSprite.getHeight();

            inimigoSprite.translateY((-2f * delta));
            inimigosHitBox.set(inimigoSprite.getX(),inimigoSprite.getY(),inimigoWidth,inimigoHeight);
            System.out.println(vidaPerso);
            if(inimigoSprite.getY() < - inimigoHeight) inimigosSprite.removeIndex(i);
            else if(inimigosHitBox.overlaps(tiroHitBox)){
                    inimigosSprite.removeIndex(i);
            } else if (persoHitBox.overlaps(inimigosHitBox)){
                inimigosSprite.removeIndex(i);
                vidaPerso --;
                if(vidaPerso == 0) {
                   persoSprite.setPosition(0,0);
                    vidaPerso = 5;
                }
            }

        }

        for(int i = tiros.size -1; i>=0; i--) {
            tiro tiro = tiros.get(i);

            tiro.sprite.translateY((5f * delta));
            if(tiro.sprite.getY() >= worldHeight) tiros.removeIndex(i);
            tiroHitBox.set(tiro.sprite.getX(),tiro.sprite.getY(),tiro.sprite.getWidth(),tiro.sprite.getHeight());
        }
        Timer += delta;
        if(Timer > 1f) {
            Timer=0;
            createInimigos();
        }
    }

    private void draw() {
        ScreenUtils.clear(Color.BLACK);
        viewport.apply();
        spriteBatch.setProjectionMatrix(viewport.getCamera().combined);
        spriteBatch.begin();

        float worldWidth = viewport.getWorldWidth();
        float wordHeight = viewport.getWorldHeight();

        spriteBatch.draw(planoDeFundoTexture,0,0,worldWidth,wordHeight);
        persoSprite.draw(spriteBatch);

        for (Sprite inimigoSprite : inimigosSprite){
            inimigoSprite.draw(spriteBatch);
        }

        for (tiro tiro : tiros) {
            tiro.sprite.draw(spriteBatch);
        }
        spriteBatch.end();

    }

    private void createInimigos() {
        float inimigoWidth =1;
        float inimigoHeight =1;

        float worldWidth = viewport.getWorldWidth();
        float worldHeight = viewport.getWorldHeight();

        Sprite inimigoSprite = new Sprite(inimigoTexture);
        inimigoSprite.setSize(inimigoWidth,inimigoHeight);
        inimigoSprite.setX(MathUtils.random(0f, worldHeight - inimigoWidth));
        inimigoSprite.setY(worldHeight);
        inimigosSprite.add(inimigoSprite);
    }

    private void createTiros() {
        float worldWidth = viewport.getWorldWidth();
        float worldHeight = viewport.getWorldHeight();

        Sprite tiroSprite = new Sprite(tiroTexture);
        tiroSprite.setSize(1,1);
        tiroSprite.setX(persoSprite.getX());
        tiroSprite.setY(persoSprite.getY()+1);
        tiros.add(new tiro(tiroSprite));
    }



}
