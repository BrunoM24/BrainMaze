package com.academiadecodigo.loseyourself.gameobjects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

public class Player {

    private SpriteBatch batch;
    private Texture img;
    private Rectangle rectangle;

    public Player() {
        batch = new SpriteBatch();
        img = new Texture("eminem2.png");
        this.rectangle = new Rectangle();
        this.rectangle.x = 0;
        this.rectangle.y = 0;
        this.rectangle.width = this.img.getWidth();
        this.rectangle.height = this.img.getHeight();
    }

    public void render() {

        teste();

        this.batch.begin();
        this.batch.draw(img, this.rectangle.x, this.rectangle.y);
        this.batch.end();
    }

    private void teste() {
        if(Gdx.input.isKeyPressed(Input.Keys.LEFT)) this.rectangle.x -= 200 * Gdx.graphics.getDeltaTime();
        if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)) this.rectangle.x += 200 * Gdx.graphics.getDeltaTime();
        if(Gdx.input.isKeyPressed(Input.Keys.UP)) this.rectangle.y += 200 * Gdx.graphics.getDeltaTime();
        if(Gdx.input.isKeyPressed(Input.Keys.DOWN)) this.rectangle.y -= 200 * Gdx.graphics.getDeltaTime();
    }
}
