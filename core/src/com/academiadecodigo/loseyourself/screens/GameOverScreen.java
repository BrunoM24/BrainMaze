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


    @Override
    public void show() {

        Texture texture = new Texture("over2.png");
        gameOver = new Stage();

        spriteBatch = new SpriteBatch();

        spriteBatch.begin();
        //  spriteBatch.draw(new Texture(Gdx.files.internal("over2.png")), -50, -50);

        spriteBatch.draw(texture, 0, 0, 640, 520);
        System.out.println(gameOver.getHeight());
        System.out.println(gameOver.getWidth());
        spriteBatch.flush();
    }


    @Override
    public void render(float delta) {


    }

    @Override
    public void resize(int width, int height) {
     /*   Vector2 size = Scaling.fit.apply(800, 700, width, height);
        int viewportX = (int)(width - size.x) / 2;
        int viewportY = (int)(height - size.y) / 2;
        int viewportWidth = (int)size.x;
        int viewportHeight = (int)size.y;
        Viewport viewPort = new FitViewport(viewportWidth,viewportHeight);
        gameOver.setViewport(viewPort);*/
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
