package com.academiadecodigo.loseyourself;

import com.academiadecodigo.loseyourself.screens.TestScreen;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.*;


public class BrainMaze extends Game {

    @Override
    public void create() {
        setScreen(new TestScreen());
    }

    @Override
    public void render() {

        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        super.render();
    }


    @Override
    public void dispose() {
        super.dispose();
    }

}
