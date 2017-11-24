package com.academiadecodigo.loseyourself.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.utils.Scaling;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.sun.prism.image.ViewPort;


/**
 * Created by codecadet on 24/11/17.
 */
public class GameOverScreen implements Screen {

    private Stage gameOver;
    private Sprite endSprite;
    private SpriteBatch spriteBatch;
    Texture texture;

    @Override
    public void show() {

        texture = new Texture("thumbnail_over640x480.jpg");
        gameOver = new Stage();
        spriteBatch = new SpriteBatch();


    }


    @Override
    public void render(float delta) {
        spriteBatch.begin();

        System.out.println("GameOverScreen.show");

        spriteBatch.draw(texture, 0, 0, 640, 480);
        spriteBatch.flush();

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
        spriteBatch.dispose();
        gameOver.dispose();

    }
}
