package com.academiadecodigo.loseyourself.screens;

import com.academiadecodigo.loseyourself.BrainMaze;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Created by codecadet on 24/11/17.
 */

public class StartScreen implements Screen {

    private BrainMaze game;
    private Texture texture;

    public StartScreen(BrainMaze brainMaze) {
        this.game = brainMaze;
    }

    @Override
    public void show() {
        this.texture = new Texture("over2.png");
    }

    @Override
    public void render(float delta) {

        if(Gdx.input.isKeyPressed(Input.Keys.ENTER)){
            this.game.setScreen(new GameScreen());
        }

        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        this.game.batch.begin();
        this.game.batch.draw(this.texture, 0, 0);
        this.game.batch.end();
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
