package com.academiadecodigo.loseyourself.gameobjects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.maps.MapLayer;
import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.MapObjects;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTile;
import com.badlogic.gdx.maps.tiled.TiledMapTileSet;
import com.badlogic.gdx.maps.tiled.TiledMapTileSets;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Actor;


public class Player extends Actor {

    private Rectangle rectangle;
    private int dir = 0;
    private Sprite sprite;
    private MapLayer collide;
    private MapObjects mapObjects;
    private TiledMapTileSets tiledMapTileSets;
    private TiledMap map;

    public Player(TiledMap map) {

        this.sprite = new Sprite(new Texture("eminem.png"));
        this.rectangle = new Rectangle();
        this.rectangle.x = 0;
        this.rectangle.y = 0;
        this.rectangle.width = this.sprite.getWidth();
        this.rectangle.height = this.sprite.getHeight();
        this.collide = map.getLayers().get(1);
        this.mapObjects = collide.getObjects();
        this.tiledMapTileSets = map.getTileSets();
        this.map = map;
    }

    @Override
    public void act(float delta) {
        super.act(delta);

        inputHandler();
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);
        sprite.draw(batch);
    }

    private void inputHandler() {
        if (Gdx.input.isKeyPressed(Input.Keys.UP)) {
            move();
            return;
        }

        if (Gdx.input.isKeyJustPressed(Input.Keys.LEFT)) {
            this.sprite.rotate(90);
            if (this.dir == 0) {
                this.dir = 3;
            } else {
                this.dir--;
            }

        } else if (Gdx.input.isKeyJustPressed(Input.Keys.RIGHT)) {
            this.sprite.rotate(-90);
            if (this.dir == 3) {
                this.dir = 0;
            } else {
                this.dir++;
            }
        }
    }


    public float getX() {

        return sprite.getX();
    }

    public float getY() {

        return sprite.getY();
    }

    private void move() {

        float x = 0, y = 0;

        switch (dir){
            case 0:
                y = 200;
                break;
            case 1:
                x = 200;
                break;
            case 2:
                y = -200;
                break;
            case 3:
                x = -200;
                break;

        }


        for(MapObject object : map.getLayers().get(1).getObjects()){

            if(object instanceof RectangleMapObject) {

                Rectangle rectangle = ((RectangleMapObject) object).getRectangle();
                if(Intersector.overlaps(rectangle, new Rectangle(this.sprite.getX() + x * Gdx.graphics.getDeltaTime(), this.sprite.getY() + y * Gdx.graphics.getDeltaTime(), this.sprite.getWidth(), this.sprite.getHeight()))){
                    return;
                }
            }
        }

        this.sprite.setX(this.sprite.getX() + x * Gdx.graphics.getDeltaTime());
        this.sprite.setY(this.sprite.getY() + y * Gdx.graphics.getDeltaTime());
    }

    public Sprite getSprite() {
        return sprite;
    }
}