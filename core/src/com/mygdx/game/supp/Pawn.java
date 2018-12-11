package com.mygdx.game.supp;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

public class Pawn
{
//    ArrayStorage questions = new ArrayStorage();


    private String name;
    private int tileNumber;

public Pawn(String name,int position){
    this.name = name;
    this.tileNumber = position;
}

    public static Image createPawn()
    {
        Texture texture = new Texture(Gdx.files.internal("icon.png"));
        Image pawn = new Image(texture);

        return pawn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTileNumber() {
        return tileNumber;
    }

    public void setTileNumber(int tileNumber) {
        this.tileNumber += tileNumber;
    }

}
