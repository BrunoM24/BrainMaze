package com.academiadecodigo.loseyourself.screens;

import com.academiadecodigo.loseyourself.gameobjects.Player;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Stage;

/**
 * Created by codecadet on 23/11/17.
 */

public class TestScreen extends ScreenAdapter {
    private Player player;
    private Stage gameStage;

    private TmxMapLoader tmxMapLoader;
    private TiledMap map;
    private OrthogonalTiledMapRenderer render;
    private ShapeRenderer shapeRenderer;

    @Override
    public void show() {
        super.show();

        gameStage = new Stage();

        tmxMapLoader = new TmxMapLoader();
        map = tmxMapLoader.load("Background.tmx");

        this.player = new Player(map);

        render = new OrthogonalTiledMapRenderer(map);

        this.shapeRenderer = new ShapeRenderer();

        gameStage.addActor(player);

        ((OrthographicCamera)gameStage.getCamera()).zoom -= 0.25f;

        gameStage.getCamera().position.set(player.getX(), player.getY(), 0);

        Gdx.gl.glClearColor(0, 0, 0, 1);
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        shapeRenderer.setProjectionMatrix(gameStage.getCamera().combined);
        for(MapObject object : map.getLayers().get(1).getObjects()){
            if(object instanceof RectangleMapObject) {
                Rectangle rectangle = ((RectangleMapObject) object).getRectangle();

                shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
                shapeRenderer.setColor(Color.BLACK);
                shapeRenderer.rect(rectangle.x, rectangle.y, rectangle.width, rectangle.height);
                shapeRenderer.end();
            }
        }

        gameStage.getCamera().position.set(player.getX(), player.getY(), 0);
        render.setView((OrthographicCamera) this.gameStage.getCamera());

        gameStage.act();
        render.render();
        gameStage.draw();
    }

    @Override
    public void dispose() {
        map.dispose();
        render.dispose();
        gameStage.dispose();
        shapeRenderer.dispose();
    }
}