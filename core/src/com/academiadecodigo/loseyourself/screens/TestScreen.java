package com.academiadecodigo.loseyourself.screens;

import com.academiadecodigo.loseyourself.gameobjects.Player;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.Timer;

/**
 * Created by codecadet on 23/11/17.
 */
public class TestScreen extends ScreenAdapter {
    private Player player;
    private Stage gameStage;
    private Stage guiStage;
    private int timerCountDown = 10;
    private Label name;
    private Label counter;

    @Override
    public void show() {
        super.show();
        Table table = new Table();

        table.top();

        table.setFillParent(true);

        gameStage = new Stage();
        guiStage = new Stage();
        this.player = new Player(true);
        gameStage.addActor(player);

        guiStage.addActor(name = new Label("Time(seconds)", new Label.LabelStyle(new BitmapFont(), Color.WHITE)));
        guiStage.addActor(counter = new Label(String.format("%03d", timerCountDown), new Label.LabelStyle(new BitmapFont(), Color.WHITE)));

        table.add(name).expandX().pad(10,400,0,0);
        table.add(counter).expandX().padTop(10);

        guiStage.addActor(table);
        timer();
    }

    @Override
    public void render(float delta) {
        super.render(delta);


        gameStage.act();
        guiStage.act();
        gameStage.getCamera().position.set(player.getX(), player.getY(), 0);
        gameStage.draw();

        guiStage.draw();

    }

    @Override
    public void dispose() {
        super.dispose();
        guiStage.dispose();
        gameStage.dispose();
    }

    private void timer() {
        final Timer timer = new Timer();
        timer.scheduleTask(new Timer.Task() {

            @Override
            public void run() {

                if (timerCountDown == 0) {
                    timer.stop();
                    return;
                }

                timerCountDown--;
                counter.setText(String.format("%03d", timerCountDown));

            }
        }, 1, 1);

    }


}