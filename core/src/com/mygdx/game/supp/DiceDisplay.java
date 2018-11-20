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
import static com.mygdx.game.supp.Dice.dice;

public class DiceDisplay {
    static int dicePosX = 1920;
    static int dicePosY = 5760;

    public static Texture tex1, tex2, tex3, tex4, tex5, tex6;
    public static Image img1, img2, img3, img4, img5, img6;

    public static void diceImage() {

        tex1=new Texture(Gdx.files.internal("dice1.png"));
        tex2=new Texture(Gdx.files.internal("dice2.png"));
        tex3=new Texture(Gdx.files.internal("dice3.png"));
        tex4=new Texture(Gdx.files.internal("dice4.png"));
        tex5=new Texture(Gdx.files.internal("dice5.png"));
        tex6=new Texture(Gdx.files.internal("dice6.png"));

        img1=new Image(tex1);
        img2=new Image(tex2);
        img3=new Image(tex3);
        img4=new Image(tex4);
        img5=new Image(tex5);
        img6=new Image(tex6);

        if (Gdx.input.isKeyJustPressed(Input.Keys.SPACE)) {

            switch (dice) {
                case 1:
                    mainStage.addActor(img1);
                    img1.setPosition(dicePosX, dicePosY);

                    break;

                case 2:
                    mainStage.addActor(img2);
                    img2.setPosition(dicePosX, dicePosY);

                    break;

                case 3:
                    mainStage.addActor(img3);
                    img3.setPosition(dicePosX, dicePosY);

                    break;

                case 4:
                    mainStage.addActor(img4);
                    img4.setPosition(dicePosX, dicePosY);

                    break;

                case 5:
                    mainStage.addActor(img5);
                    img5.setPosition(dicePosX, dicePosY);

                    break;

                case 6:
                    mainStage.addActor(img6);
                    img6.setPosition(dicePosX, dicePosY);

                    break;

            }
        }
    }
}
