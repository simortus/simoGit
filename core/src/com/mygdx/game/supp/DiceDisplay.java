package com.mygdx.game.supp;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.Files;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import static com.mygdx.game.TileBoard3.mainStage;

public class DiceDisplay {
    static int dicePosX = 1920;
    static int dicePosY = 5760;

    public static Texture tex;
    public static Image img;

    public static void diceImage(int dice) {

//        tex1=new Texture(Gdx.files.internal("dice1.png"));
//        tex2=new Texture(Gdx.files.internal("dice2.png"));
//        tex3=new Texture(Gdx.files.internal("dice3.png"));
//        tex4=new Texture(Gdx.files.internal("dice4.png"));
//        tex5=new Texture(Gdx.files.internal("dice5.png"));
//        tex6=new Texture(Gdx.files.internal("dice6.png"));

        tex=new Texture(Gdx.files.internal("dice" + dice + ".png"));


        img  = new Image(tex);
        img.setPosition(dicePosX, dicePosY);


            mainStage.addActor(img);
            switch (dice) {
                case 1:
                    img = new Image(tex);

                    break;

                case 2:
                    img = new Image(tex);

                    break;

                case 3:
                    img = new Image(tex);

                    break;

                case 4:
                    img = new Image(tex);

                    break;

                case 5:
                    img = new Image(tex);

                    break;

                case 6:
                    img = new Image(tex);

                    break;

            }

    }
}
