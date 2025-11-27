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
import senai.projeto.henriquemotta.classes.Equipamento;
import senai.projeto.henriquemotta.classes.Monstro;
import senai.projeto.henriquemotta.classes.tiro;
import senai.projeto.henriquemotta.services.equipamentoService;
import senai.projeto.henriquemotta.services.monstroService;
import senai.projeto.henriquemotta.classes.Slayer;
import senai.projeto.henriquemotta.services.equipamentoService;
import java.util.ArrayList;

/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class Main extends ApplicationAdapter {
    Texture planoDeFundoTexture;
    Texture inimigoTexture;
    Texture tiroTexture;
    Sound tiroSom;
    Music music;


    SpriteBatch spriteBatch;

    FitViewport viewport;

    Vector2 touchPos;

    Array<Monstro> inimigos;
    Rectangle inimigosHitBox;
    Rectangle tiroHitBox;
    Array<tiro> tiros;
    ArrayList<Equipamento> Equipamentos;
    float Timer;;
    Texture fogoArma;

    float fireTimer = 0;
    public Slayer slayer = new Slayer();
    public ArrayList<Monstro> monstros;
    @Override
    public void create() {
        planoDeFundoTexture = new Texture("background.png");
        slayer.setTexturaSlayer(new Texture ("carro.png"));
        spriteBatch = new SpriteBatch();
        viewport = new FitViewport(8,8);
        slayer.setSlayerSprite(new Sprite (slayer.getTexturaSlayer()));
        slayer.getSlayerSprite().setSize(1,1);
        slayer.setSlayerHitBox(new Rectangle());
        slayer.setVidaSlayer(5);
        fogoArma = new Texture("foguinho.png");
        inimigos = new Array<>();
        inimigoTexture = new Texture("inimigo.png");
        inimigosHitBox = new Rectangle();

        tiros = new Array<>();
        tiroTexture = new Texture("tiro.png");
        tiroHitBox = new Rectangle();

        Equipamentos = new ArrayList<>();
        Equipamentos = (ArrayList<Equipamento>) equipamentoService.ObterEquipamentos();
        slayer.setDanoSlayer(Equipamentos.get(MathUtils.random(0, Equipamentos.size()-1)).getDanoEquip());
        slayer.setArma(Equipamentos.get(MathUtils.random(0,Equipamentos.size()-1)));
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
        slayer.getSlayerSprite().setTexture(slayer.getTexturaSlayer());
        if(Gdx.input.isKeyPressed(Input.Keys.D)){
            slayer.getSlayerSprite().translateX(speed * delta);
        } else if (Gdx.input.isKeyPressed(Input.Keys.A)){
            slayer.getSlayerSprite().translateX(-speed * delta );
        } else if (Gdx.input.isKeyPressed(Input.Keys.W)){
            slayer.getSlayerSprite().translateY(speed * delta);
        }else if (Gdx.input.isKeyPressed(Input.Keys.S)){
            slayer.getSlayerSprite().translateY(-speed * delta);
        }
        Timer += delta;
        fireTimer += Gdx.graphics.getDeltaTime();
        if(Gdx.input.isTouched() && fireTimer >= slayer.getArma().getFireCooldown()){
                createTiros();
                slayer.getSlayerSprite().setTexture(fogoArma);
            fireTimer = 0; // reseta o contador
        }
    }

    private void logic() {
        float worldWidth = viewport.getWorldWidth();
        float worldHeight = viewport.getWorldHeight();

        float persoWidth = slayer.getSlayerSprite().getWidth();
        float persoHeight = slayer.getSlayerSprite().getHeight();
        slayer.getSlayerSprite().setX(MathUtils.clamp(slayer.getSlayerSprite().getX(),0,worldWidth - persoWidth));
        slayer.getSlayerSprite().setY(MathUtils.clamp(slayer.getSlayerSprite().getY(),0,worldHeight - persoHeight));
        float delta = Gdx.graphics.getDeltaTime();
        System.out.println("Arma:" + slayer.getArma() + "Dano:" + slayer.getDanoSlayer());
        slayer.getSlayerHitBox().set(slayer.getSlayerSprite().getX(),slayer.getSlayerSprite().getY(),persoWidth,persoHeight);
        for(int i = inimigos.size -1; i>=0 ; i--) {
            Monstro monstroAtual = inimigos.get(i);
            Sprite inimigoSprite = monstroAtual.getSprite();
            float inimigoWidth = inimigoSprite.getWidth();
            float inimigoHeight = inimigoSprite.getHeight();
            inimigoSprite.translateY((-monstroAtual.getVelocidade() * delta));
            inimigosHitBox.set(inimigoSprite.getX(), inimigoSprite.getY(), inimigoWidth, inimigoHeight);
            if (inimigoSprite.getY() < -inimigoHeight) inimigos.removeIndex(i);
            else if (slayer.getSlayerHitBox().overlaps(inimigosHitBox)){
                inimigos.removeIndex(i);
                slayer.setVidaSlayer(slayer.getVidaSlayer()-1);
                if(slayer.getVidaSlayer() == 0) {
                   slayer.getSlayerSprite().setPosition(0,0);
                    slayer.setVidaSlayer(5);
                }
            }
            for (int t = tiros.size - 1; t >= 0; t--) {
                tiro tiro = tiros.get(t);
                tiro.hitbox.set(tiro.sprite.getX(), tiro.sprite.getY(),
                    tiro.sprite.getWidth(), tiro.sprite.getHeight());

                if (inimigosHitBox.overlaps(tiro.hitbox)) {
                    tiros.removeIndex(t);
                    monstroAtual.setVidaMonstro(monstroAtual.getVidaMonstro() - slayer.getDanoSlayer());
                    if(monstroAtual.getVidaMonstro() <= 0) {
                        inimigos.removeIndex(i);
                    }


                    break; // sai do loop de tiros
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
        slayer.getSlayerSprite().draw(spriteBatch);

        for (Monstro monstros : inimigos){
            monstros.getSprite().draw(spriteBatch);
        }

        for (tiro tiro : tiros) {
            tiro.sprite.draw(spriteBatch);
        }
        drawLifeBar(spriteBatch);
        spriteBatch.end();

    }

    private void createInimigos() {
            float inimigoWidth =1;
            float inimigoHeight =1;

            float worldWidth = viewport.getWorldWidth();
            float worldHeight = viewport.getWorldHeight();

            monstros = (ArrayList<Monstro>) monstroService.ObterMonstros();
            Monstro novoMonstro = monstros.get(MathUtils.random(0,monstros.size()-1));
            Sprite inimigoSprite = new Sprite(novoMonstro.getTexturaMonstro());
            novoMonstro.setSprite(inimigoSprite);
            inimigoSprite.setSize(inimigoWidth,inimigoHeight);
            inimigoSprite.setX(MathUtils.random(0f, worldHeight - inimigoWidth));
            inimigoSprite.setY(worldHeight);
            inimigos.add(novoMonstro);


    }

    private void createTiros() {
        float worldWidth = viewport.getWorldWidth();
        float worldHeight = viewport.getWorldHeight();

        Sprite tiroSprite = new Sprite(tiroTexture);
        tiroSprite.setSize(1,1);
        tiroSprite.setX(slayer.getSlayerSprite().getX());
        tiroSprite.setY(slayer.getSlayerSprite().getY()+1);
        tiros.add(new tiro(tiroSprite));
    }

    private void drawLifeBar(SpriteBatch batch) {
        float x = 0.5f;        // posição X no mundo
        float y = 7.5f;        // posição Y no topo
        float width = 3f;      // largura total
        float height = 0.3f;   // altura da barra

        // Porcentagem da vida
        float percent = (float) slayer.getVidaSlayer() / 5;

        // Fundo da barra (cinza escuro)
        batch.setColor(Color.DARK_GRAY);
        batch.draw(planoDeFundoTexture, x, y, width, height);

        // Barra cheia proporcional (verde → amarelo → vermelho)
        Color color;
        if (percent > 0.6f) color = Color.GREEN;
        else if (percent > 0.3f) color = Color.YELLOW;
        else color = Color.RED;

        batch.setColor(color);
        batch.draw(planoDeFundoTexture, x, y, width * percent, height);

        // Resetar cor para evitar bugs
        batch.setColor(Color.WHITE);
    }



}
