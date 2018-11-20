package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
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
import com.badlogic.gdx.scenes.scene2d.actions.MoveToAction;
import com.badlogic.gdx.scenes.scene2d.actions.SequenceAction;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.utils.viewport.FillViewport;

import com.mygdx.game.supp.Dice;

import static com.mygdx.game.supp.DiceDisplay.diceImage;
import static com.mygdx.game.supp.DiceSound.diceAudio;

public class TileBoard3 extends ApplicationAdapter
{
    public static Stage mainStage;

    private OrthographicCamera camera;
    private FillViewport viewport;

    private static TiledMap tiledMap;
    private OrthogonalTiledMapRenderer renderer;

    private static MapLayers layerList;
    private static MapLayer layer;
    private static MapObjects tileList; // List of objects
    private static MapObject tile; // An object from the list
    private static MapProperties tileProperties; // List with object properties


    private Texture texture;
    private static Image pawn;

    int w;
    int h;


    @Override
    public void create()
    {

        // Dimensions of TiledMap
        w = 12800;
        h = 7680;

        camera = new OrthographicCamera();
        camera.setToOrtho(false, w, h);
        camera.update();
        viewport = new FillViewport(w, h, camera);

        mainStage = new Stage(viewport);

        tiledMap = new TmxMapLoader().load("board640C.tmx");
        renderer = new OrthogonalTiledMapRenderer(tiledMap);

        texture = new Texture(Gdx.files.internal("icon.png"));

        // Creating a pawn in a starting position
        pawn = new Image(texture);
        pawn.setSize(texture.getWidth()*8, texture.getHeight()*8);
        layerList = tiledMap.getLayers();
        layer = layerList.get("Tiles");
        tileList = layer.getObjects();
        tile = tileList.get("0");
        tileProperties = tile.getProperties();
        pawn.setPosition((Float) tileProperties.get("x"), (Float) tileProperties.get("y"));
        mainStage.addActor(pawn);

        /*MoveToAction action1 = new MoveToAction();
        action1.setPosition((Float) tileProperties.get("x") + 640, (Float) tileProperties.get("y"));
        action1.setDuration(1);
        action1.setInterpolation(Interpolation.smooth);
        MoveToAction action2 = new MoveToAction();
        action2.setPosition((Float) tileProperties.get("x") + 1920, (Float) tileProperties.get("y") + 1920);
        action2.setDuration(1);
        action2.setInterpolation(Interpolation.smooth);

        SequenceAction sequentialActions = new SequenceAction();
        sequentialActions.addAction(action1);
        sequentialActions.addAction(action2);
        pawn.addAction(sequentialActions);*/
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

    public static void movePawn(int tileNum, int targetTileNum)
    {
        MapProperties tileProperties = getTileProperties(tileNum);
        MapProperties targetTileProperties = getTileProperties(targetTileNum);

        if(targetTileNum == 0)
        {
            MoveToAction action = new MoveToAction();
            action.setPosition((Float) tileProperties.get("x"), (Float) tileProperties.get("y"));
            action.setDuration(1);
            action.setInterpolation(Interpolation.smooth);
            pawn.addAction(action);
//            stage.addActor(pawn);
        }else {
            SequenceAction sequentialActions = new SequenceAction();
            sequentialActions.addAction(Actions.moveTo((Float) tileProperties.get("x"), (Float) tileProperties.get("y"), 1, Interpolation.smooth));
            sequentialActions.addAction(Actions.moveTo((Float) targetTileProperties.get("x"), (Float) targetTileProperties.get("y"), 1, Interpolation.smooth));
            pawn.addAction(sequentialActions);
        }
    }


    @Override
    public void render()
    {
        Gdx.gl.glClearColor(.9038f, .9038f, .9038f, 1);
        Gdx.gl.glBlendFunc(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        camera.update();
        viewport.update(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

//        renderer.setView((OrthographicCamera) viewport.getCamera());
        renderer.setView(camera);
        renderer.render();




        // Instead of batch and sprites
        mainStage.act();
        mainStage.draw();
        Dice.rollAndMove();
        diceAudio();
    }


    @Override
    public void dispose()
    {
        tiledMap.dispose();
        mainStage.dispose();
    }
}
