package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.TimeUtils;

public class EscenarioPrincipal extends Pantalla {

    Pelota pelota;
    Paleta paletaderecha;
    Paleta paletaizquierda;
    Stage stage;
    BitmapFont bit;
    SpriteBatch batch;
    Texture fondo;
    int puntuacionIzquierda=0;
    int getPuntuacionDerecha=0;

    public EscenarioPrincipal(MyGdxGame myGdxGame) {
        super(myGdxGame);
        batch = new SpriteBatch();
        bit = new BitmapFont();
bit.getData().setScale(3,3);
        Gdx.input.setInputProcessor(new Procesador(this));
        pelota = new Pelota(this, new Texture("pelota.png"));
        paletaderecha = new Paleta(new Texture("paleta.png"));
        paletaizquierda = new Paleta(new Texture("paleta.png"));
        fondo=new Texture("fondo.png");

    }


    @Override
    public void show() {
        stage = new Stage();
        stage.addActor(pelota);
        stage.addActor(paletaderecha);
        stage.addActor(paletaizquierda);
        paletaizquierda.setPosition(10, Gdx.graphics.getHeight() / 2);
        paletaderecha.setPosition(Gdx.graphics.getWidth() - 30, Gdx.graphics.getHeight() / 2);
        pelota.setPosition(Gdx.graphics.getHeight() / 2, Gdx.graphics.getHeight() / 2);

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0.4f, 0.5f, 0.8f, 1f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();

        batch.draw(fondo,0,0);
        bit.draw(batch, puntuacionIzquierda +"                  "+ getPuntuacionDerecha, (Gdx.graphics.getWidth()/3)-20, Gdx.graphics.getHeight()-10);

        batch.end();
        stage.act();
        stage.draw();
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void hide() {
        stage.dispose();
    }

    @Override
    public void dispose() {
        stage.dispose();
        }



    public void Comenzar() {
        pelota.setX(Gdx.graphics.getWidth() / 2);
        pelota.setY(Gdx.graphics.getHeight() / 2);
        pelota.CambiarDireccion();


    }

}
