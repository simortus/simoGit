package com.mygdx.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.mygdx.game.TileBoard2;

public class LaunchTileBoard2
{
    public static void main (String[] args)
    {
        LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();

        config.width = 720;
        config.height = 600;
//        config.backgroundFPS = 60;
//        config.foregroundFPS = 60;

        new LwjglApplication(new TileBoard2(), config);
    }
}
