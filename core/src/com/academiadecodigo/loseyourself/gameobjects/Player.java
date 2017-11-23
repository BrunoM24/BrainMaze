package com.academiadecodigo.loseyourself.gameobjects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

public class Player {

    private SpriteBatch batch;
    private Rectangle rectangle;
    private int dir = 0;
    private Sprite sprite;

    public Player() {
        batch = new SpriteBatch();
        this.sprite = new Sprite(new Texture("eminem.png"));
        this.rectangle = new Rectangle();
        this.rectangle.x = 0;
        this.rectangle.y = 0;
        this.rectangle.width = this.sprite.getWidth();
        this.rectangle.height = this.sprite.getHeight();
    }

    public void render() {
        inputHandler();

        this.batch.begin();
        sprite.draw(batch);
        this.batch.end();

        System.out.println(dir);
    }

    private void inputHandler() {
        if(Gdx.input.isKeyPressed(Input.Keys.UP)){
            move();
            return;
        }

        if(Gdx.input.isKeyJustPressed(Input.Keys.LEFT)){
            this.sprite.rotate(90);
            if(this.dir == 0){
                this.dir = 3;
            }else {
                this.dir--;
            }

        }else if(Gdx.input.isKeyJustPressed(Input.Keys.RIGHT)){
            this.sprite.rotate(-90);
            if(this.dir == 3){
                this.dir = 0;
            }else {
                this.dir++;
            }
        }
    }

    private void move() {
        if(dir == 0){
            this.sprite.setY(this.sprite.getY() + 200 * Gdx.graphics.getDeltaTime());
        }
        if(dir == 1){
            this.sprite.setX(this.sprite.getX() + 200 * Gdx.graphics.getDeltaTime());
        }
        if(dir == 2){
            this.sprite.setY(this.sprite.getY() - 200 * Gdx.graphics.getDeltaTime());
        }
        if(dir == 3){
            this.sprite.setX(this.sprite.getX() - 200 * Gdx.graphics.getDeltaTime());
        }
    }
}
