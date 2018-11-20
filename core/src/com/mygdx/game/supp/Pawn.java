package com.mygdx.game.supp;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

public class Pawn
{
    public static Image createPawn()
    {
        Texture texture = new Texture(Gdx.files.internal("icon.png"));
        Image pawn = new Image(texture);

        return pawn;
    }

}
