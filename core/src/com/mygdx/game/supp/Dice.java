/*package com.mygdx.game.supp;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;

import java.util.Random;

import com.mygdx.game.TileBoard3;
import com.mygdx.game.supp.Pawn;

public class Dice
{
    private  Random random = new Random();
    public  int dice;
    public  int tileNum = 0;
    private  int targetTileNum = 0;

    public void rollAndMove()
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
                if(Pawn.checkTileForSpecial(tileNum)) // If contains special
                {
                    targetTileNum = Pawn.getTargetTileNum(Pawn.getTileProperties(tileNum));
                    Pawn.movePawn(tileNum, targetTileNum, dice);
                    // Setting the new tile number
                    tileNum = targetTileNum;
                    // Clearing the targetTileNum for the next occurrence of special tile
                    targetTileNum = 0;
                }else {
                    Pawn.movePawn(tileNum, targetTileNum, dice);
                }
            }else{
                tileNum -= dice;
            }

            System.out.println(dice + "  " + tileNum);
        }
    }

}*/

