package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.utils.TimeUtils;

import static java.lang.StrictMath.sqrt;

public class Pelota extends Actor {
    Texture textura;
    int velocidad = 4;
    int velocidadY=4;
    EscenarioPrincipal escenario;

    public Pelota(EscenarioPrincipal e, Texture textura) {
        escenario = e;
        this.textura = textura;
        setSize(textura.getWidth(), textura.getHeight());


    }
    @Override
    public void draw(Batch batch, float parentAlpha) {
        batch.draw(textura, getX(), getY());
    }

    public void act(float delta) {


        if (getX() + getWidth() >= Gdx.graphics.getWidth()) {
            //Comenzar
            escenario.Comenzar();
            escenario.getPuntuacionDerecha++;
        }
        if (getX() <= 0) {
            //Comenzar alreves
            escenario.Comenzar();
            escenario.puntuacionIzquierda++;


        }

        if (getY() + getHeight() >= Gdx.graphics.getHeight()) {
            CambiarDireccionY();

        }
        if (getY() <= 0) {
            CambiarDireccionY();
        }

        int perimetrox = 0;
        int circulox = (int) (getX() + (getWidth() / 2));
        int wight = (int) escenario.paletaderecha.getWidth();
        int perimetroy = 0;
        int circuloy = (int) (getY() + (getHeight() / 2));
        int puntoYrectangulo = (int) escenario.paletaderecha.getY();
        int puntoXrectangulo = (int) escenario.paletaderecha.getX();
        int height = (int) escenario.paletaderecha.getHeight();
        int distancia = 0;
        int radio = (int) (getWidth() / 2);

        perimetrox = circulox; // En principio son iguales
        if (perimetrox < puntoXrectangulo) {
            perimetrox = puntoXrectangulo;
        }
        if (perimetrox > puntoXrectangulo + wight) {
            perimetrox = puntoXrectangulo + wight;
        }
        perimetroy = circuloy;
        if (perimetroy < puntoYrectangulo) {
            perimetroy = puntoYrectangulo;
        }
        if (perimetroy > puntoYrectangulo + height) {
            perimetroy = puntoYrectangulo + height;
        }
        distancia = (int) sqrt((circulox - perimetrox) * (circulox - perimetrox) + (circuloy - perimetroy) * (circuloy - perimetroy));
        if (distancia < radio) {
            CambiarDireccion();
        }


        wight = (int) escenario.paletaizquierda.getWidth();

        puntoYrectangulo = (int) escenario.paletaizquierda.getY();
        puntoXrectangulo = (int) escenario.paletaizquierda.getX();
        height = (int) escenario.paletaizquierda.getHeight();


        perimetrox = circulox;
        if (perimetrox < puntoXrectangulo) {
            perimetrox = puntoXrectangulo;
        }
        if (perimetrox > puntoXrectangulo + wight) {
            perimetrox = puntoXrectangulo + wight;
        }
        perimetroy = circuloy;
        if (perimetroy < puntoYrectangulo) {
            perimetroy = puntoYrectangulo;
        }
        if (perimetroy > puntoYrectangulo + height) {
            perimetroy = puntoYrectangulo + height;
        }
        distancia = (int) sqrt((circulox - perimetrox) * (circulox - perimetrox) + (circuloy - perimetroy) * (circuloy - perimetroy));
        if (distancia < radio) {
            CambiarDireccion();
        }


        setX(getX() + velocidad);
        setY(getY() + velocidadY);
    }

    public void CambiarDireccion() {
        if (velocidad == 4) {
            velocidad = -4;
        } else {
            velocidad = 4;
        }


    }
    public  void CambiarDireccionY(){

        if (velocidadY == 4) {
            velocidadY = -4;
        } else {
            velocidadY = 4;
        }

    }


}
