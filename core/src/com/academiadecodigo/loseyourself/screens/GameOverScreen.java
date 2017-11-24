package com.academiadecodigo.loseyourself.screens;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;


/**
 * Created by codecadet on 24/11/17.
 */
public class GameOverScreen implements Screen {

    private Stage gameOver;
    private SpriteBatch spriteBatch;
    private Texture gameOverTexture;

    @Override
    public void show() {

        gameOverTexture = new Texture("thumbnail_over640x480.jpg");
        gameOver = new Stage();

        spriteBatch = new SpriteBatch();

        spriteBatch.begin();
        //  spriteBatch.draw(new Texture(Gdx.files.internal("over2.png")), -50, -50);

        spriteBatch.draw(gameOverTexture, 0, 0, 640, 520);

        spriteBatch.flush();
    }


    @Override
    public void render(float delta) {
        spriteBatch.begin();

        System.out.println("GameOverScreen.show");

        spriteBatch.draw(gameOverTexture, 0, 0, 640, 480);
        spriteBatch.flush();

    }

    @Override
    public void resize(int width, int height) {}


    @Override
    public void pause() {}

    @Override
    public void resume() {}

    @Override
    public void hide() {}

    @Override
    public void dispose() {
        spriteBatch.dispose();
        gameOver.dispose();

    }
}
