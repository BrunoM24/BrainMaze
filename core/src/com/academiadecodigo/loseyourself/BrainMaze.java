package com.academiadecodigo.loseyourself;

import com.academiadecodigo.loseyourself.screens.GameOverScreen;
import com.academiadecodigo.loseyourself.screens.GameScreen;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.*;


public class BrainMaze extends Game {

    GameScreen gameScreen;

    @Override
    public void create() {
        setScreen(gameScreen = new GameScreen());

    }

    @Override
    public void render() {

        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        super.render();

        if (gameScreen.isGameOver()) {
            setScreen(new GameOverScreen());
        }

    }


    @Override
    public void dispose() {
        super.dispose();
    }


}
