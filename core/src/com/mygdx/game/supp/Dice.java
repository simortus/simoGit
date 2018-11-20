package com.mygdx.game.supp;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;

import java.util.Random;

import com.mygdx.game.TileBoard3;

public class Dice
{
    private static Random random = new Random();
    private static int dice;
    private static int tileNum = 0;
    private static int targetTileNum = 0;

    public static void rollAndMove()
    {
        if(Gdx.input.isKeyJustPressed(Input.Keys.SPACE))
        {
            dice = random.nextInt(6) + 1 ;
            tileNum += dice;
            if(tileNum <= 100)
            {
                if(tileNum == 100){
                    System.out.println("CONGRATULATION !!!!");
                }
                if(TileBoard3.checkTileForSpecial(tileNum)) // If contains special
                {
                    /*// Delaying the program
                    try { Thread.sleep(1000); }
                    catch(InterruptedException ex) { Thread.currentThread().interrupt();}*/

                    targetTileNum = TileBoard3.getTargetTileNum(TileBoard3.getTileProperties(tileNum));
                    TileBoard3.movePawn(tileNum, targetTileNum);
                    // Setting the new tile number
                    tileNum = targetTileNum;
                    // Clearing the targetTileNum for the next occurrence of special tile
                    targetTileNum = 0;
                }else {
                    TileBoard3.movePawn(tileNum, targetTileNum);
                }
            }else{
                tileNum -= dice;
            }

            System.out.println(dice + "  " + tileNum);
        }
    }

}
