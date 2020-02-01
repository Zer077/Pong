package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;

public class MyGdxGame extends Game {

    @Override
    public void create () {
        setScreen(new EscenarioPrincipal(this));
        System.out.println(Gdx.graphics.getHeight() + "     "+ Gdx.graphics.getWidth());

    }
}
