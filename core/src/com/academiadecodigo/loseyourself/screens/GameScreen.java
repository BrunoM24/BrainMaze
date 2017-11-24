package com.academiadecodigo.loseyourself.screens;

import com.academiadecodigo.loseyourself.gameobjects.Player;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.Timer;

/**
 * Created by codecadet on 23/11/17.
 */

public class GameScreen extends ScreenAdapter {

    private Player player;
    private Stage gameStage;
    private Stage guiStage;
    private int timerCountDown = 5;
    private Label name;
    private Label counter;
    private boolean gameOver;
    private TmxMapLoader tmxMapLoader;
    private TiledMap map;
    private OrthogonalTiledMapRenderer render;
    private ShapeRenderer shapeRenderer;

    @Override
    public void show() {
        super.show();
        Gdx.gl.glClearColor(0, 0, 0, 1);

        gameStage = new Stage();
        guiStage = new Stage();

        addGameLogic();
        addTimer();

        timer();
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
        guiStage.act();
        render.render();
        gameStage.draw();
        guiStage.draw();
    }

    @Override
    public void dispose() {
        super.dispose();
        gameStage.dispose();
    }

    private void addGameLogic() {

        tmxMapLoader = new TmxMapLoader();
        map = tmxMapLoader.load("Background.tmx");

        this.player = new Player(map);

        render = new OrthogonalTiledMapRenderer(map);

        this.shapeRenderer = new ShapeRenderer();

        gameStage.addActor(player);

        ((OrthographicCamera)gameStage.getCamera()).zoom -= 0.25f;

        gameStage.getCamera().position.set(player.getX(), player.getY(), 0);
    }

    private void addTimer() {
        Table table = new Table();

        table.top();

        table.setFillParent(true);

        name = new Label("Time(seconds)", new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        counter = new Label(String.format("%03d", timerCountDown), new Label.LabelStyle(new BitmapFont(), Color.WHITE));

        table.add(name).expandX().pad(10, 400, 0, 0);
        table.add(counter).expandX().padTop(10);

        guiStage.addActor(table);
    }

    private void timer() {

        final Timer timer = new Timer();
        timer.scheduleTask(new Timer.Task() {

            @Override
            public void run() {

                if (timerCountDown == 0) {
                    dispose();
                    timer.stop();
                    gameOver = true;
                    return;
                }

                timerCountDown--;
                counter.setText(String.format("%03d", timerCountDown));

            }
        }, 1, 1);

    }

    public boolean isGameOver() {
        return gameOver;
    }
}