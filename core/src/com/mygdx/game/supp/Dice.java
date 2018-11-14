package com.mygdx.game.supp;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;

import java.util.Random;

import com.mygdx.game.TileBoard2;

public class Dice
{
    static Random random = new Random();
    static int dice;
    static int diceSum = 0;

    public static void rollAndMove()
    {
        if(Gdx.input.isKeyJustPressed(Input.Keys.SPACE))
        {
            dice = random.nextInt(6) + 1 ;
            diceSum += dice;
            TileBoard2.movePawn(diceSum);
            System.out.println(dice + "  " + diceSum);
        }
    }
}
