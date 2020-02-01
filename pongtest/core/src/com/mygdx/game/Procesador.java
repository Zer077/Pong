package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.utils.TimeUtils;


public class Procesador extends InputAdapter {
    EscenarioPrincipal aplication;

    public Procesador(EscenarioPrincipal princ) {
        aplication = princ;

    }

    @Override
    public boolean keyUp(int keycode) {


        switch (keycode) {
            case Input.Keys.W:
            case Input.Keys.S:
                aplication.paletaizquierda.setKeycode(0);


                break;
            case Input.Keys.DOWN:
            case Input.Keys.UP:
                aplication.paletaderecha.setKeycode(0);

                break;


        }
        return true;
    }

    @Override
    public boolean keyDown(int keycode) {
        switch (keycode) {
            case Input.Keys.W:

                aplication.paletaizquierda.setKeycode(Input.Keys.W);


                break;

            case Input.Keys.S:

                aplication.paletaizquierda.setKeycode(Input.Keys.S);

                break;
            case Input.Keys.UP:
                aplication.paletaderecha.setKeycode(Input.Keys.UP);

                break;

            case Input.Keys.DOWN:
                aplication.paletaderecha.setKeycode(Input.Keys.DOWN);

                break;


        }
        return true;
    }
}





