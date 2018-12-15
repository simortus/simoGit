package com.mygdx.game.supp;

import com.badlogic.gdx.Gdx;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Interpolation;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.mygdx.game.views.PlayScreen;


import java.lang.reflect.Array;

import static com.badlogic.gdx.scenes.scene2d.actions.Actions.after;
import static com.badlogic.gdx.scenes.scene2d.actions.Actions.sequence;
import static com.badlogic.gdx.scenes.scene2d.actions.Actions.visible;
import static com.mygdx.game.supp.Dice2.playingPawn;
import static com.mygdx.game.supp.PBLQuestions.pblAns;

import static com.badlogic.gdx.math.MathUtils.random;
import static com.mygdx.game.supp.PBLQuestions.pblRightAns;
import static com.mygdx.game.supp.Pawn.tileProperties;
import static com.mygdx.game.supp.Dice2.tileNum;

public class QuestionPopup {

    private static Skin skin = new Skin(Gdx.files.internal("skin/uiskin.json"));
    private static Window window;
    private static Image transparentImg;

    private static int a;

    private static final int BUT1 = 0;
    private static final int BUT2 = 1;
    private static final int BUT3 = 2;
    private static final int BUT4 = 3;


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


//        button.addListener(new ClickListener(){
//           @Override
//           public void clicked(InputEvent event,float x,float y){
//
////               name.equals()
//
//           }
//        });


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

        boolean pblRightAns;

        window = new Window("Question", skin);

        QAStorage pbl = new QAStorage(PBLQuestions.pblQues[randNr], PBLQuestions.pblAns[randNr], PBLQuestions.pblAns[randNr][PBLQuestions.pblRightAns[randNr]]);


        if (CourseProperties.checkForPbl()) {


            window.add(questionDisplay(pbl.getQuestion())).prefWidth(800).pad(20);
            window.row();

//            window.add(chooseBtn(PBLQuestions.pblAns[randNr][BUT1]));
//            window.row();
//            chooseBtn(PBLQuestions.pblAns[randNr][BUT1]).addListener(new ClickListener(){
//               @Override
//               public void clicked(InputEvent event,float x,float y){
//
//                   System.out.println("dddddddddddddddddd");
//               }
//            });

            for(String answer : pbl.getAnswers()){
                window.add(chooseBtn(answer));
                window.row();
                if(answer.equals(pbl.getRightAnswer())) {
                    System.out.println("action");

                    chooseBtn(answer).addListener(new ClickListener(){
                        @Override
                        public void clicked(InputEvent event,float x,float y){

                            System.out.println("action");

                        }
                    });
                }
//                    chooseBtn(PBLQuestions.pblAns[randNr][a]).addListener(new ClickListener(){
//                        @Override
//                        public void clicked(InputEvent event,float x, float y){
//
//                            System.out.println("00000000");
//                            window.addAction(Actions.fadeOut(.6f, Interpolation.smooth));
//                            transparentImg.addAction(Actions.fadeOut(.6f, Interpolation.smooth));
//
                        }
//                    });
//                }
//            }

//for(int i = 0;i <4; i++) {
//    System.out.println(PBLQuestions.pblAns[randNr][i]);
//    System.out.println("this is right answer   " + pbl.getRightAnswer());
//}

        }


        if (CourseProperties.checkForOop()) {
            QAStorage oop = new QAStorage(OOPQuestions.oopQues[randNr], OOPQuestions.oopAns[randNr], OOPQuestions.oopAns[randNr][OOPQuestions.oopRightAns[randNr]]);

            window.add(questionDisplay(oop.getQuestion())).prefWidth(800).pad(20);
            window.row();

            for ( a = 0; a < 4; a++) {
                window.add(chooseBtn(OOPQuestions.oopAns[randNr][a])).pad(3);
                window.row();
            }
        }


        if (CourseProperties.checkForAlgebra()) {
            QAStorage alg = new QAStorage(ALGQuestions.algQues[randNr], ALGQuestions.algAns[randNr], ALGQuestions.algAns[randNr][ALGQuestions.algRightAns[randNr]]);

            window.add(questionDisplay(alg.getQuestion())).prefWidth(800).pad(20);
            window.row();

            for ( a = 0; a < 4; a++) {
                window.add(chooseBtn(ALGQuestions.algAns[randNr][a])).pad(3);
                window.row();
            }

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

//    public String getQuestionType (String  questionType,int randNr, int a){
//
//        String quest1 ="ALGQuestions.algAns["+randNr+"]["+a+"]";
//
//        switch(questionType){
//            case 1:
//                window.add(chooseBtn(quest1)).pad(3);
//        }
//
//            window.add(chooseBtn(ALGQuestions.algAns[randNr][a])).pad(3);
//            window.row();
//
//    }

    public static void showQuestionWindow() {
        // ffffff00 equal to (r:1, g:1, b:1, a:0)
        // ffffffff equal to (r:1, g:1, b:1, a:1)
        int randNr = random.nextInt(50);
        createQuestionWindow(randNr);

        window.addAction(after(Actions.fadeIn(.6f, Interpolation.smooth)));
        transparentImg.addAction(sequence(Actions.fadeIn(.6f, Interpolation.smooth)));
    }

//    delay((Dice2.dice * .5f))

    private static void transparentBackground() {
        Texture texture = new Texture(Gdx.files.internal("transparency.png"));
        transparentImg = new Image(texture);
        transparentImg.setColor(1, 1, 1, 0);

        PlayScreen.playStage.addActor(transparentImg);
    }
}


