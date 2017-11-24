package com.academiadecodigo.loseyourself.screens;

import com.academiadecodigo.loseyourself.BrainMaze;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;

/**
 * Created by codecadet on 24/11/17.
 */

public class StartScreen implements Screen {

    private BrainMaze game;
    private Texture texture;

    public StartScreen(BrainMaze game) {
        this.game = game;
    }

    @Override
    public void show() {
        this.texture = new Texture("thumbnail_begin-screen-640x480.jpg");
    }

    @Override
    public void render(float delta) {
        if(Gdx.input.isKeyJustPressed(Input.Keys.ENTER)){
            this.game.setScreen(new GameScreen(this.game));
        }

        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        this.game.batch.begin();
        this.game.batch.draw(this.texture, 0, 0, 640, 480);
        this.game.batch.end();
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

    }
}
