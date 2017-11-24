package com.academiadecodigo.loseyourself.screens;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;


/**
 * Created by codecadet on 24/11/17.
 */
public class GameOverScreen implements Screen {

    private Stage gameOver;

    @Override
    public void show() {

        gameOver = new Stage();
        gameOver.addActor(new Label());

    }

    @Override
    public void render(float delta) {

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
    }
}
