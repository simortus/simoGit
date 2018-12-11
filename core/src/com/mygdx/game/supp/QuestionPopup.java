package com.mygdx.game.supp;

import com.badlogic.gdx.Gdx;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Interpolation;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.mygdx.game.views.PlayScreen;

import static com.badlogic.gdx.scenes.scene2d.actions.Actions.after;
import static com.badlogic.gdx.scenes.scene2d.actions.Actions.sequence;
import static com.mygdx.game.supp.PBLQuestions.pblAns;
import static com.mygdx.game.supp.PBLQuestions.pblQues;
import static com.mygdx.game.supp.PBLQuestions.pblRightAns;

public class QuestionPopup
{
    private static Skin skin = new Skin(Gdx.files.internal("skin/uiskin.json"));
    private static Window window;
    private static Image transparentImg;

    private static Label questionDisplay(String name) {
        Label label = new Label(name, skin, "title");
        label.setWrap(true);
//        label.setFontScale(1.2f);
        return label;
    }

    private static Button chooseBtn(String name) {
        Button button = new TextButton(name, skin);
        button.setTransform(true);
        button.scaleBy(.1f);
        return button;
    }

    private static Button exitBtn(String name) {
        Button button = new TextButton(name, skin);
        button.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                window.addAction(Actions.fadeOut(.6f, Interpolation.smooth));
                transparentImg.addAction(Actions.fadeOut(.6f, Interpolation.smooth));
            }
        });
        return button;
    }

    public static void createQuestionWindow(int randNr) {
        // Set a darker transparent background
        transparentBackground();

        QAStorage pbl = new QAStorage(pblQues[randNr],pblAns[randNr],pblAns[randNr][pblRightAns[randNr]]);

        window = new Window("Question", skin);
        window.add(questionDisplay(pbl.getQuestion())).prefWidth(800).pad(20);
        window.row();
        for(int a = 0;a < 4; a++) {
            window.add(chooseBtn(pblAns[randNr][a])).pad(3);
            window.row();
        }
        window.add(exitBtn("Accept")).padBottom(10).padTop(25);
        window.pack();

        window.setResizable(false);
        window.setMovable(false);
//        window.debug();
        window.setPosition((PlayScreen.mapW - window.getWidth()) / 2f, ((PlayScreen.mapH - window.getHeight()) / 2f) + 4);
        window.toFront();

        // Start by hiding the window (setting the alpha value zero)

        window.setColor(1, 1, 1, 0);

        PlayScreen.playStage.addActor(window);
        Gdx.input.setInputProcessor(PlayScreen.playStage);

//        System.out.println(window.getColor());
    }

    public static void showQuestionWindow() {
        // ffffff00 equal to (r:1, g:1, b:1, a:0)
        // ffffffff equal to (r:1, g:1, b:1, a:1)
        window.addAction(after(Actions.fadeIn(.6f, Interpolation.smooth)));
        transparentImg.addAction(sequence(Actions.fadeIn(.6f, Interpolation.smooth)));
    }

//    delay((Dice2.dice * .5f))

    private static void transparentBackground()
    {
        Texture texture = new Texture(Gdx.files.internal("transparency.png"));
        transparentImg = new Image(texture);
        transparentImg.setColor(1,1,1,0);

        PlayScreen.playStage.addActor(transparentImg);
    }
}
