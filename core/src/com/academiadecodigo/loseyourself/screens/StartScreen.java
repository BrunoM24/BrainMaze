package com.academiadecodigo.loseyourself.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;

/**
 * Created by codecadet on 24/11/17.
 */
public class StartScreen extends Actor implements Screen {

    private Stage gameOver;

    private SpriteBatch batch;
    Texture texture;

    @Override
    public void show() {


        texture = new Texture("thumbnail_begin-screen-640x480.jpg");

        gameOver = new Stage();
        batch = new SpriteBatch();


    }

    @Override
    public void render(float delta) {

        batch.begin();



        batch.draw(texture, 0, 0, 640, 480);
        batch.flush();

        //getStage().act();
        //getStage().draw();
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        batch.dispose();
        gameOver.dispose();
    }


}
