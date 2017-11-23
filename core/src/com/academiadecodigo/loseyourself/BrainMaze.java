package com.academiadecodigo.loseyourself;

import com.academiadecodigo.loseyourself.gameobjects.Player;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class BrainMaze extends ApplicationAdapter {

    private Player player;

    @Override
    public void create() {
        this.player = new Player();
    }

    @Override
    public void render() {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        this.player.render();
    }

    @Override
    public void dispose() {

    }
}
