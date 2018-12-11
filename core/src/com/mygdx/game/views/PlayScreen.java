package com.mygdx.game.views;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.maps.*;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Interpolation;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.actions.SequenceAction;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.utils.Timer;
import com.badlogic.gdx.utils.viewport.FillViewport;
import com.mygdx.game.TileBoard3;
import com.mygdx.game.supp.Dice;
import com.mygdx.game.supp.Pawn;
import com.mygdx.game.supp.QuestionPopup;
import com.mygdx.game.supp.QuestionsImport;

import java.io.File;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

import static com.mygdx.game.TileBoard3.mainStage;
import static com.mygdx.game.supp.Dice.tileNum;
import static com.mygdx.game.supp.DiceSound.diceAudio;

public class PlayScreen implements Screen {
    private TileBoard3 parent;

    private OrthographicCamera camera;
    private FillViewport viewport;

    private static TiledMap tiledMap;
    private OrthogonalTiledMapRenderer renderer;

    private static MapLayers layerList;
    private static MapLayer layer;
    private static MapObjects tileList; // List of objects
    private static MapObject tile; // An object from the list
    private static MapProperties tileProperties; // List with object properties

    private static Timer timer;


    private Texture texture,sheet;
    private static Image pawn,pawn1,gradeSheet;

    public static int w;
    public static int h;

//    private Stack<QuestionsImport> qA;
    private ArrayList<String> answers;
    public static ArrayList<Stack<QuestionsImport>> topics;
    public static Stack<QuestionsImport> questionAnswer;
    public static Stack<QuestionsImport> questionBackUp;


    public PlayScreen(TileBoard3 tileBoard3){
        parent = tileBoard3;
    }

    @Override
    public void show() {

        File questions = new File("pblquestions.txt");
        questionAnswer = new Stack<QuestionsImport>();
        QuestionsImport.filler(questionAnswer,questions);
        Collections.shuffle(questionAnswer);

        questionBackUp = new Stack<QuestionsImport>();
        questionBackUp.addAll(questionAnswer);

        topics = new ArrayList<Stack<QuestionsImport>>();
        Collections.shuffle(topics);

//        Pawn player1 = new Pawn("Player1",Dice.dice);
//        player1.setTileNumber(0);


// Dimensions of TiledMap
        w = 1408;
        h = 1152;

        timer = new Timer();

        camera = new OrthographicCamera();
        camera.setToOrtho(false, w, h);
        camera.update();
        viewport = new FillViewport(w, h, camera);

        mainStage = new Stage(viewport);

        tiledMap = new TmxMapLoader().load("board64B.tmx");
        renderer = new OrthogonalTiledMapRenderer(tiledMap);

        texture = new Texture(Gdx.files.internal("icon.png"));
        sheet = new Texture(Gdx.files.internal("gradesheet.png"));

        gradeSheet = new Image(sheet);
        gradeSheet.setPosition(1050f,256f);
        gradeSheet.setSize(350f,400f);


        // Creating a pawn in a starting position
        getTileProperties(0);
        pawn = new Image(texture);
        pawn.setSize(texture.getWidth() * .8f, texture.getHeight() * .8f);
        pawn.setPosition((Float) tileProperties.get("x"), (Float) tileProperties.get("y"));
        mainStage.addActor(pawn);

        // Creating second player in startion position
        getTileProperties(-1);
        pawn1 = new Image(texture);
        pawn1.setSize(texture.getWidth() * .8f, texture.getHeight() * .8f);
        pawn1.setPosition((Float) tileProperties.get("x"),(Float) tileProperties.get("y"));
        mainStage.addActor(pawn1);

        QuestionPopup.createQuestionWindow();

    }

    @Override
    public void render(float delta) {

        Gdx.gl.glClearColor(.9038f, .9038f, .9038f, 1);
        Gdx.gl.glBlendFunc(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        camera.update();
        viewport.update(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

        renderer.setView((OrthographicCamera) viewport.getCamera());
        renderer.setView(camera);
        renderer.render();

        // Instead of batch and sprites
        mainStage.act();
        mainStage.draw();
        Dice.rollAndMove();
        if(tileNum == 100){

            mainStage.addActor(gradeSheet);

            timer.schedule(new Timer.Task() {
                @Override
                public void run() {
                    parent.changeScreen(TileBoard3.ENDGAME);

                }
            },5);
            tileNum = 0;
        }
        if(Gdx.input.isKeyJustPressed(Input.Keys.D)){
            QuestionPopup.showQuestionWindow();
        }
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        tiledMap.dispose();
        mainStage.dispose();
    }

    // Getting the properties of the current tile using the dice
    // Used in checkTileForSpecial and movePawn
    public static MapProperties getTileProperties(int tileNum)
    {
        layerList = tiledMap.getLayers();
        layer = layerList.get("Tiles");
        tileList = layer.getObjects();
        tile = tileList.get(Integer.toString(tileNum));
        tileProperties = tile.getProperties();

        return tileProperties;
    }


    public static int getTargetTileNum(MapProperties tileProperties)
    {
        // Returns the value of the "goto" property
        return (Integer) tileProperties.get("goto");
    }

    // Checking if the tile contains the special property and if yes getting it
    public static boolean checkTileForSpecial(int tileNum)
    {
        MapProperties tileProperties = getTileProperties(tileNum);
        boolean containSpecial = tileProperties.containsKey("special");

        if (containSpecial)
        {
            return true;
        }

        return false;
    }

    // This method can get divided
    public static void movePawn(int tileNum, int targetTileNum, int dice)
    {
        dice -= 1;
        SequenceAction sequenceAction = new SequenceAction();
        while(dice >= 0)
        {
            tileNum -= dice;
            MapProperties tileProperties = getTileProperties(tileNum);
            sequenceAction.addAction(Actions.moveTo((Float) tileProperties.get("x"), (Float) tileProperties.get("y"), .5f, Interpolation.smooth));
            tileNum += dice;
            dice -= 1;
        }

        if (targetTileNum != 0)
        {
            MapProperties targetTileProperties = getTileProperties(targetTileNum);
            sequenceAction.addAction(Actions.moveTo((Float) targetTileProperties.get("x"), (Float) targetTileProperties.get("y"), 1, Interpolation.smooth));
        }

        pawn.addAction(sequenceAction);
    }


}
