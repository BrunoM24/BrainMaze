package com.academiadecodigo.loseyourself;

import com.academiadecodigo.loseyourself.screens.GameOverScreen;
import com.academiadecodigo.loseyourself.screens.GameScreen;
import com.academiadecodigo.loseyourself.screens.StartScreen;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.*;


public class BrainMaze extends Game {

    Screen statusScreen;

    @Override
    public void create() {


        statusScreen = new StartScreen();
        setScreen(statusScreen);

    }

    @Override
    public void render() {

        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        super.render();

        if (statusScreen instanceof GameScreen && ((GameScreen) statusScreen).isGameOver()) {
         setScreen(new GameOverScreen());
        }
        startingGame();
    }


    @Override
    public void dispose() {
        super.dispose();
    }


    public void startingGame() {
        if (Gdx.input.isButtonPressed(Input.Buttons.LEFT)) {
            statusScreen = new GameScreen();
            setScreen(statusScreen);
        }

    }
}
