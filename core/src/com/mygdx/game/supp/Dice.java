package com.mygdx.game.supp;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;

import java.util.Random;

import com.mygdx.game.TileBoard3;
import com.mygdx.game.views.PlayScreen;

public class Dice
{
    private static Random random = new Random();
    public static int dice;
    public static int tileNum = 0;
    private static int targetTileNum = 0;

    public static void rollAndMove()
    {
        if(Gdx.input.isKeyJustPressed(Input.Keys.SPACE))
        {
            dice = random.nextInt(6) + 1 ;
            DiceDisplay.diceImage(dice);
            tileNum += dice;
            if(tileNum <= 100)
            {
//                if(tileNum == 100){
//                    System.out.println("CONGRATULATION !!!!");
//                }
                if(PlayScreen.checkTileForSpecial(tileNum)) // If contains special
                {
                    targetTileNum = PlayScreen.getTargetTileNum(PlayScreen.getTileProperties(tileNum));
                    PlayScreen.movePawn(tileNum, targetTileNum, dice);
                    // Setting the new tile number
                    tileNum = targetTileNum;
                    // Clearing the targetTileNum for the next occurrence of special tile
                    targetTileNum = 0;
                }else {
                    PlayScreen.movePawn(tileNum, targetTileNum, dice);
                }
            }else{
                tileNum -= dice;
            }

            System.out.println(dice + "  " + tileNum);
        }
    }

}
