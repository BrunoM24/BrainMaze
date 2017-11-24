package com.academiadecodigo.loseyourself.Sounds;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;

public class Sounds {

    private static Music go;
    private static Music end;
    private static Music move;

    public static void start(){
        if(go == null){
            go = Gdx.audio.newMusic(Gdx.files.internal("go.wav"));
        }
        go.setVolume(0.5f);
        go.play();
    }

    public static void end(){
        if(end == null){
            end = Gdx.audio.newMusic(Gdx.files.internal("miss.wav"));
        }
        end.setVolume(0.2f);
        end.play();
        //go.dispose();
    }

    public static void move(){
        if(move == null){
            move = Gdx.audio.newMusic(Gdx.files.internal("Footsteps-swamp.wav"));
        }
        move.setVolume(0.2f);
        move.play();
        //go.dispose();
    }
}
