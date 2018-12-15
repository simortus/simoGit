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

import static com.badlogic.gdx.math.MathUtils.random;

public class QuestionPopup {

    private static Skin skin = new Skin(Gdx.files.internal("skin/uiskin.json"));
    private static Window window;
    private static Image transparentImg;




    private static Label questionDisplay(String name) {
        Label label = new Label(name, skin, "title");
        label.setWrap(true);
        return label;
    }


    public static void createQuestionWindow(final int randNr) {
        // Set a darker transparent background
        transparentBackground();


        window = new Window("Question", skin);


        if (CourseProperties.checkForPbl()) {

            final QAStorage pbl = new QAStorage(PBLQuestions.pblQues[randNr], PBLQuestions.pblAns[randNr], PBLQuestions.pblAns[randNr][PBLQuestions.pblRightAns[randNr]]);

            window.add(questionDisplay(pbl.getQuestion())).prefWidth(800).pad(20);
            window.row();

            Button ans1 = new TextButton(PBLQuestions.pblAns[randNr][0],skin);
            ans1.setTransform(true);
            ans1.scaleBy(.1f);

            window.add(ans1);
            window.row();

            ans1.addListener(new ClickListener(){
                @Override
                public void clicked(InputEvent event,float x,float y){

                    if(PBLQuestions.pblAns[randNr][0].equals(pbl.getRightAnswer())){
                        window.addAction(Actions.fadeOut(.6f, Interpolation.smooth));
                        transparentImg.addAction(Actions.fadeOut(.6f, Interpolation.smooth));

                    } else{
                        System.out.println("this is not the right answer");
                    }

                }
            });

            Button ans2 = new TextButton(PBLQuestions.pblAns[randNr][1],skin);
            ans2.setTransform(true);
            ans2.scaleBy(.1f);

            window.add(ans2);
            window.row();

            ans2.addListener(new ClickListener(){
                @Override
                public void clicked(InputEvent event,float x,float y){

                    if(PBLQuestions.pblAns[randNr][1].equals(pbl.getRightAnswer())){
                        window.addAction(Actions.fadeOut(.6f, Interpolation.smooth));
                        transparentImg.addAction(Actions.fadeOut(.6f, Interpolation.smooth));

                    } else{
                        System.out.println("this is not the right answer");
                    }

                }
            });
            Button ans3 = new TextButton(PBLQuestions.pblAns[randNr][2],skin);
            ans3.setTransform(true);
            ans3.scaleBy(.1f);

            window.add(ans3);
            window.row();

            ans3.addListener(new ClickListener(){
                @Override
                public void clicked(InputEvent event,float x,float y){

                    if(PBLQuestions.pblAns[randNr][2].equals(pbl.getRightAnswer())){
                        window.addAction(Actions.fadeOut(.6f, Interpolation.smooth));
                        transparentImg.addAction(Actions.fadeOut(.6f, Interpolation.smooth));

                    } else{
                        System.out.println("this is not the right answer");
                    }

                }
            });
            Button ans4 = new TextButton(PBLQuestions.pblAns[randNr][3],skin);
            ans4.setTransform(true);
            ans4.scaleBy(.1f);

            window.add(ans4);
            window.row();

            ans4.addListener(new ClickListener(){
                @Override
                public void clicked(InputEvent event,float x,float y){

                    if(PBLQuestions.pblAns[randNr][3].equals(pbl.getRightAnswer())){
                        window.addAction(Actions.fadeOut(.6f, Interpolation.smooth));
                        transparentImg.addAction(Actions.fadeOut(.6f, Interpolation.smooth));

                    } else{
                        System.out.println("this is not the right answer");
                    }

                }
            });
        }


        if (CourseProperties.checkForOop()) {
            final QAStorage oop = new QAStorage(OOPQuestions.oopQues[randNr], OOPQuestions.oopAns[randNr], OOPQuestions.oopAns[randNr][OOPQuestions.oopRightAns[randNr]]);

            window.add(questionDisplay(oop.getQuestion())).prefWidth(800).pad(20);
            window.row();

            Button ans1 = new TextButton(OOPQuestions.oopAns[randNr][0],skin);
            ans1.setTransform(true);
            ans1.scaleBy(.1f);

            window.add(ans1);
            window.row();

            ans1.addListener(new ClickListener(){
                @Override
                public void clicked(InputEvent event,float x,float y){

                    if(OOPQuestions.oopAns[randNr][0].equals(oop.getRightAnswer())){
                        window.addAction(Actions.fadeOut(.6f, Interpolation.smooth));
                        transparentImg.addAction(Actions.fadeOut(.6f, Interpolation.smooth));

                    } else{
                        System.out.println("this is not the right answer");
                    }

                }
            });
            Button ans2 = new TextButton(OOPQuestions.oopAns[randNr][1],skin);
            ans2.setTransform(true);
            ans2.scaleBy(.1f);

            window.add(ans2);
            window.row();

            ans2.addListener(new ClickListener(){
                @Override
                public void clicked(InputEvent event,float x,float y){

                    if(OOPQuestions.oopAns[randNr][1].equals(oop.getRightAnswer())){
                        window.addAction(Actions.fadeOut(.6f, Interpolation.smooth));
                        transparentImg.addAction(Actions.fadeOut(.6f, Interpolation.smooth));

                    } else{
                        System.out.println("this is not the right answer");
                    }
                }
            });
            Button ans3 = new TextButton(OOPQuestions.oopAns[randNr][2],skin);
            ans3.setTransform(true);
            ans3.scaleBy(.1f);

            window.add(ans3);
            window.row();

            ans3.addListener(new ClickListener(){
                @Override
                public void clicked(InputEvent event,float x,float y){

                    if(OOPQuestions.oopAns[randNr][2].equals(oop.getRightAnswer())){
                        window.addAction(Actions.fadeOut(.6f, Interpolation.smooth));
                        transparentImg.addAction(Actions.fadeOut(.6f, Interpolation.smooth));

                    } else{
                        System.out.println("this is not the right answer");
                    }

                }
            });
            Button ans4 = new TextButton(OOPQuestions.oopAns[randNr][3],skin);
            ans4.setTransform(true);
            ans4.scaleBy(.1f);

            window.add(ans4);
            window.row();

            ans4.addListener(new ClickListener(){
                @Override
                public void clicked(InputEvent event,float x,float y){

                    if(OOPQuestions.oopAns[randNr][3].equals(oop.getRightAnswer())){
                        window.addAction(Actions.fadeOut(.6f, Interpolation.smooth));
                        transparentImg.addAction(Actions.fadeOut(.6f, Interpolation.smooth));

                    } else{
                        System.out.println("this is not the right answer");
                    }

                }
            });

        }


        if (CourseProperties.checkForAlgebra()) {
            final QAStorage alg = new QAStorage(ALGQuestions.algQues[randNr], ALGQuestions.algAns[randNr], ALGQuestions.algAns[randNr][ALGQuestions.algRightAns[randNr]]);

            window.add(questionDisplay(alg.getQuestion())).prefWidth(800).pad(20);
            window.row();

            Button ans1 = new TextButton(ALGQuestions.algAns[randNr][0],skin);
            ans1.setTransform(true);
            ans1.scaleBy(.1f);

            window.add(ans1);
            window.row();

            ans1.addListener(new ClickListener(){
                @Override
                public void clicked(InputEvent event,float x,float y){

                    if(ALGQuestions.algAns[randNr][0].equals(alg.getRightAnswer())){
                        window.addAction(Actions.fadeOut(.6f, Interpolation.smooth));
                        transparentImg.addAction(Actions.fadeOut(.6f, Interpolation.smooth));

                    } else{
                        System.out.println("this is not the right answer");
                    }

                }
            });
            Button ans2 = new TextButton(ALGQuestions.algAns[randNr][1],skin);
            ans2.setTransform(true);
            ans2.scaleBy(.1f);

            window.add(ans2);
            window.row();

            ans2.addListener(new ClickListener(){
                @Override
                public void clicked(InputEvent event,float x,float y){

                    if(ALGQuestions.algAns[randNr][1].equals(alg.getRightAnswer())){
                        window.addAction(Actions.fadeOut(.6f, Interpolation.smooth));
                        transparentImg.addAction(Actions.fadeOut(.6f, Interpolation.smooth));

                    } else{
                        System.out.println("this is not the right answer");
                    }

                }
            });
            Button ans3 = new TextButton(ALGQuestions.algAns[randNr][2],skin);
            ans3.setTransform(true);
            ans3.scaleBy(.1f);

            window.add(ans3);
            window.row();

            ans3.addListener(new ClickListener(){
                @Override
                public void clicked(InputEvent event,float x,float y){

                    if(ALGQuestions.algAns[randNr][2].equals(alg.getRightAnswer())){
                        window.addAction(Actions.fadeOut(.6f, Interpolation.smooth));
                        transparentImg.addAction(Actions.fadeOut(.6f, Interpolation.smooth));

                    } else{
                        System.out.println("this is not the right answer");
                    }

                }
            });
            Button ans4 = new TextButton(ALGQuestions.algAns[randNr][3],skin);
            ans4.setTransform(true);
            ans4.scaleBy(.1f);

            window.add(ans4);
            window.row();

            ans4.addListener(new ClickListener(){
                @Override
                public void clicked(InputEvent event,float x,float y){

                    if(ALGQuestions.algAns[randNr][3].equals(alg.getRightAnswer())){
                        window.addAction(Actions.fadeOut(.6f, Interpolation.smooth));
                        transparentImg.addAction(Actions.fadeOut(.6f, Interpolation.smooth));

                    } else{
                        System.out.println("this is not the right answer");
                    }

                }
            });

        }


        window.pack();
        window.setResizable(false);
        window.setMovable(false);
        window.setPosition((PlayScreen.mapW - window.getWidth()) / 2f, ((PlayScreen.mapH - window.getHeight()) / 2f) + 4);
        window.toFront();

        // Start by hiding the window (setting the alpha value zero)

        window.setColor(1, 1, 1, 0);

        PlayScreen.playStage.addActor(window);
        Gdx.input.setInputProcessor(PlayScreen.playStage);

    }

    public static void showQuestionWindow() {
        int randNr = random.nextInt(50);
        createQuestionWindow(randNr);

        window.addAction(after(Actions.fadeIn(.6f, Interpolation.smooth)));
        transparentImg.addAction(sequence(Actions.fadeIn(.6f, Interpolation.smooth)));
    }


    private static void transparentBackground() {
        Texture texture = new Texture(Gdx.files.internal("transparency.png"));
        transparentImg = new Image(texture);
        transparentImg.setColor(1, 1, 1, 0);

        PlayScreen.playStage.addActor(transparentImg);
    }
}


