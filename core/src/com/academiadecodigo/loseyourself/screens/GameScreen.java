package com.academiadecodigo.loseyourself.screens;

import com.academiadecodigo.loseyourself.BrainMaze;
import com.academiadecodigo.loseyourself.Sounds.Sounds;
import com.academiadecodigo.loseyourself.gameobjects.Player;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.MapObjects;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.Timer;

/**
 * Created by codecadet on 23/11/17.
 */

public class GameScreen extends ScreenAdapter {

    private BrainMaze game;
    private Player player;
    private Stage gameStage;
    private Stage guiStage;
    private Stage background;
    private int timerCountDown = 60;
    private Label name;
    private Label counter;
    private boolean gameOver;
    private TmxMapLoader tmxMapLoader;
    private TiledMap map;
    private OrthogonalTiledMapRenderer render;
    private ShapeRenderer shapeRenderer;


    private boolean doorFlag;


    public GameScreen(BrainMaze game) {
        this.game = game;
    }

    @Override
    public void show() {
        super.show();

        Gdx.gl.glClearColor(0, 0, 0, 1);

        gameStage = new Stage();
        guiStage = new Stage();
        background = new Stage();

        addGameLogic();
        addTimer();

        Sounds.start();
        timer();
        doorTimer();

        for (MapObject object : map.getLayers().get("ObjectLayer1").getObjects()) {
            if (object.getName() == null) {
                continue;
            }

            if (object.getName().equals("door2")) {
                object.setVisible(false);
            }
        }
    }

    @Override
    public void render(float delta) {
        super.render(delta);

        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        shapeRenderer.setProjectionMatrix(gameStage.getCamera().combined);
        for (MapObject object : map.getLayers().get("ObjectLayer1").getObjects()) {
            if (object instanceof RectangleMapObject) {
                Rectangle rectangle = ((RectangleMapObject) object).getRectangle();

                shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
                shapeRenderer.setColor(Color.WHITE);
                shapeRenderer.rect(rectangle.x, rectangle.y, rectangle.width, rectangle.height);
                shapeRenderer.end();
            }
        }

        gameStage.getCamera().position.set(player.getX(), player.getY(), 0);
        render.setView((OrthographicCamera) this.gameStage.getCamera());

        checkForPowerUp();

        gameStage.act();
        guiStage.act();
        render.render();
        gameStage.draw();
        guiStage.draw();
        drawMov();
    }

    private void drawMov() {
        System.out.println("teste");
        MapObjects mapObjects = map.getLayers().get("ObjectLayer1").getObjects();
        for (MapObject mapObject : mapObjects) {

            if (mapObject.getName() == null) {

                continue;
            }

            if (mapObject instanceof RectangleMapObject && mapObject.isVisible()) {
                Rectangle rectangle = ((RectangleMapObject) mapObject).getRectangle();

                shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
                shapeRenderer.setColor(Color.WHITE);
                shapeRenderer.rect(rectangle.x, rectangle.y, rectangle.width, rectangle.height);
                shapeRenderer.end();
            }
        }
    }

    @Override
    public void dispose() {
        super.dispose();
        guiStage.dispose();
        gameStage.dispose();
    }

    private void addGameLogic() {

        tmxMapLoader = new TmxMapLoader();
        map = tmxMapLoader.load("Background.tmx");

        this.player = new Player(map);

        render = new OrthogonalTiledMapRenderer(map);

        this.shapeRenderer = new ShapeRenderer();

        gameStage.addActor(player);

        ((OrthographicCamera) gameStage.getCamera()).zoom -= 0.25f;

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

    private void checkForPowerUp() {
        MapObjects powerUps = map.getLayers().get("ObjectLayer2").getObjects();
        for (MapObject mapObject : powerUps) {
            if (!mapObject.isVisible()) {
                continue;
            }
            if (mapObject instanceof RectangleMapObject) {

                Rectangle rectangle = ((RectangleMapObject) mapObject).getRectangle();
                if (Intersector.overlaps(rectangle, player.getRectangle())) {
                    timerCountDown += 10;
                    mapObject.setVisible(false);
                }
            }

        }
    }

    private void timer() {

        final Timer timer = new Timer();
        timer.scheduleTask(new Timer.Task() {

            @Override
            public void run() {

                if (timerCountDown == 0) {
                    Sounds.end();
                    dispose();
                    timer.stop();
                    gameOver = true;
                    game.setScreen(new GameOverScreen(game));
                    return;
                }

                timerCountDown--;
                counter.setText(String.format("%03d", timerCountDown));

            }
        }, 1, 1);

    }

    private void doorTimer() {

        final Timer timer = new Timer();
        timer.scheduleTask(new Timer.Task() {

            @Override
            public void run() {

                doorFlag = !doorFlag;
                for (MapObject object : map.getLayers().get("ObjectLayer1").getObjects()) {
                    if (object.getName() == null) {
                        continue;
                    }

                    object.setVisible(!object.isVisible());
                }
                return;
            }
        }, 1, 5);

    }

    public boolean isGameOver() {
        return gameOver;
    }
}