package com.mygdx.game.supp;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Interpolation;
import com.badlogic.gdx.scenes.scene2d.Event;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.mygdx.game.TileBoard3;
import com.mygdx.game.views.PlayScreen;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Stack;

public class QuestionPopup {
    private static QAStorage ques;
    private static Skin skin = new Skin(Gdx.files.internal("skin/uiskin.json"));
    private static Window window;
    private static Image transparentImg;
    private static Stack<QuestionsImport> qA;
    private ArrayList<String> answers;


    public static Label questionDisplay(String name) {
        Label label = new Label(name, skin, "title");
        label.setWrap(true);
//        label.setFontScale(1.2f);
        return label;
    }

    public static Button chooseBtn(String name) {
        Button button = new TextButton(name, skin, "radio");
        button.setTransform(true);
        button.scaleBy(.1f);
        return button;
    }

    public static Button exitBtn(String name) {
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

    public static void createQuestionWindow() {
        // Set a darker transparent background
        transparentBackground();

//        ques = ArrayStorage.getRandomQuesAndAns();
        qA = PlayScreen.questionAnswer;

        SecureRandom random = new SecureRandom();
        int i = random.nextInt(3);

        window = new Window("Question", skin);
        window.add(questionDisplay(PBLQuestions.ques[i])).prefWidth(800).pad(20);
        window.row();

        window.add(chooseBtn(PBLQuestions.ans[i][1])).pad(3);
        window.row();
        window.add(chooseBtn("2. ")).pad(3);
        window.row();
        window.add(chooseBtn("3. ")).pad(3);
        window.row();
        window.add(chooseBtn("4. ")).pad(3);
        window.row();
        window.add(exitBtn("Accept")).padBottom(10).padTop(25);
        window.pack();

        window.setResizable(false);
        window.setMovable(false);
//        window.debug();
        window.setPosition((PlayScreen.w - window.getWidth()) / 2f, ((PlayScreen.h - window.getHeight()) / 2f) + 4);

        // Start by hiding the window (setting the alpha value zero)

        window.setColor(1, 1, 1, 0);

        TileBoard3.mainStage.addActor(window);
        Gdx.input.setInputProcessor(TileBoard3.mainStage);

//        System.out.println(window.getColor());
    }

    public static void showQuestionWindow() {
        // ffffff00 equal to (r:1, g:1, b:1, a:0)
        // ffffffff equal to (r:1, g:1, b:1, a:1)
        window.addAction(Actions.fadeIn(.6f, Interpolation.smooth));
        transparentImg.addAction(Actions.fadeIn(.6f, Interpolation.smooth));
    }

    public static void transparentBackground()
    {
        Texture texture = new Texture(Gdx.files.internal("transparency.png"));
        transparentImg = new Image(texture);
        transparentImg.setColor(1,1,1,0);
        TileBoard3.mainStage.addActor(transparentImg);
    }
}
