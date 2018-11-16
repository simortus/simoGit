package com.mygdx.game.supp;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;

import java.util.Random;

import com.mygdx.game.TileBoard2;
import com.mygdx.game.TileBoard3;

public class Dice
{
    static Random random = new Random();
    static int dice;
    static int tileNum = 0;

    public static void rollAndMove()
    {
        if(Gdx.input.isKeyJustPressed(Input.Keys.SPACE))
        {
            dice = random.nextInt(1) + 1 ;
            tileNum += dice;
            if(tileNum <= 100)
            {
                TileBoard3.movePawn(tileNum); // The first thing we want to do
                if(tileNum == 100){
                    System.out.println("CONGRATULATION !!!!");
                }
                if(TileBoard3.checkTileForSpecial(tileNum)) // if it contains special
                {
                    // Delaying the program
                    try { Thread.sleep(1000); }
                    catch(InterruptedException ex) { Thread.currentThread().interrupt();}

                    tileNum = TileBoard3.getTargetTileNum(TileBoard3.getTileProperties(tileNum));
                    TileBoard3.movePawn(tileNum);
                }else {
                    TileBoard3.movePawn(tileNum);
                }
            }else{
                tileNum -= dice;
            }

            System.out.println(dice + "  " + tileNum);
        }
    }

}
