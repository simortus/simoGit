package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.scenes.scene2d.Stage;

import com.mygdx.game.views.*;

public class TileBoard3 extends Game
{


    public static Stage mainStage;




    private LoadingScreen loadingScreen;
    private MenuScreen menuScreen;
    private PlayScreen playScreen;
    private EndScreen endScreen;

    public static final int MENU = 1;
    public static final int APPLICATION = 2;
    public static final int ENDGAME = 3;

    @Override
    public void create()
    {

        loadingScreen = new LoadingScreen(this);
        setScreen(loadingScreen);
    }

    public void changeScreen(int screen){
        switch(screen){
            case MENU:
                if(menuScreen == null) menuScreen = new MenuScreen(this);
                this.setScreen(menuScreen);
                break;
            case APPLICATION:
                if(playScreen == null) playScreen = new PlayScreen(this);
                this.setScreen(playScreen);
                break;
            case ENDGAME:
                if(endScreen == null) endScreen = new EndScreen(this);
                this.setScreen(endScreen);
                break;

        }
    }
}
