package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class Paleta extends Actor {
    Texture textura;
    private int keycode = 0;

    public Paleta(Texture textura) {
        this.textura = textura;
        setSize(textura.getWidth(), textura.getHeight());

    }
    @Override
    public void draw(Batch batch, float parentAlpha) {
        batch.draw(textura, getX(), getY());
    }

    @Override
    public void act(float delta) {
        switch (getKeycode()) {
            case Input.Keys.W:
            case Input.Keys.UP:
                if (getY() + getHeight() <= Gdx.graphics.getHeight()) {
                    setPosition(getX(), getY() + 5);

                }


                break;

            case Input.Keys.S:


            case Input.Keys.DOWN:
                if (getY() >= 0) {

                    setPosition(getX(), getY() - 5);
                }


                break;


        }
    }

    public int getKeycode() {
        return keycode;
    }

    public void setKeycode(int keycode) {
        this.keycode = keycode;
    }
}
