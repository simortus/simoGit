package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.*;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Interpolation;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.MoveToAction;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.utils.viewport.FillViewport;

import com.mygdx.game.supp.Dice;
import com.mygdx.game.supp.TileManager;

import java.util.Random;
import java.util.Scanner;


public class TileBoard2 extends ApplicationAdapter {
    private static Stage stage;

    private OrthographicCamera camera;
    private FillViewport viewport;

    private static TiledMap tiledMap;
    private OrthogonalTiledMapRenderer renderer;

    private static MapLayers layerList;
    private static MapLayer layer;
    private static MapObjects objList;
    private static MapObject obj;
    private static MapProperties objProperties;


    private Texture texture;
    private static Image pawn;

    int w;
    int h;

    private int diceSum = 0;


    @Override
    public void create() {

        // Dimensions of TiledMap
        w = 720;
        h = 540;

        camera = new OrthographicCamera();
        camera.setToOrtho(false, w, h);
        camera.update();
        viewport = new FillViewport(w, h, camera);

        stage = new Stage(viewport);

        tiledMap = new TmxMapLoader().load("board32.tmx");
        renderer = new OrthogonalTiledMapRenderer(tiledMap);

        texture = new Texture(Gdx.files.internal("lion.png"));

        // Creating a pawn in a starting position
        pawn = new Image(texture);
        pawn.setSize(texture.getWidth() * .035f, texture.getHeight() * .035f);
        pawn.setPosition(170, 100);
        stage.addActor(pawn);



//********************************************************************************************
       /*
        // Getting an Array with the layers of our tiledMap
        layerList = tiledMap.getLayers();
        // Getting a specific layer from the layerList
        layer = layerList.get("Tiles");    // Equal to .get(3)
        // Getting a property of the layer (e.g name)
        String layerProperty = layer.getName();

        // Getting an Array of the layer's MapObjects
        MapObjects objectList = layer.getObjects();
        // Checking how many MapObjects the layer has
        int countObjects = objectList.getCount();
        // Getting a MapObject, in our case a created rectangle-tile
        MapObject obg = objectList.get("tile004");

        // Getting an Array of the MapObject properties
        MapProperties obgProperties = obg.getProperties();
        // Getting a Value of the tile's MapProperties using its key
        Object obgLecture = obgProperties.get("lecture");

        System.out.printf("layer: %s%nobjects no.: %d%nTile Name: %s%nLecture: %s%nPositioned: %s x, %s y",
                layerProperty, countObjects, obg.getName(), obgLecture, obgProperties.get("x"), obgProperties.get("y"));
       */
//********************************************************************************************
        /*
        MoveToAction action = new MoveToAction();
        action.setPosition((Float) obgProperties.get("x"), (Float) obgProperties.get("y"));
        action.setDuration(4);
        action.setInterpolation(Interpolation.smooth);
        pawn.addAction(action);
        stage.addActor(pawn);
        */
//********************************************************************************************

    }

    public static void movePawn(int diceSum) {
        layerList = tiledMap.getLayers();
        layer = layerList.get("Tiles");
        objList = layer.getObjects();
        obj = objList.get("tile" + Integer.toString(diceSum));
        objProperties = obj.getProperties();

        MoveToAction action = new MoveToAction();
        action.setPosition((Float) objProperties.get("x"), (Float) objProperties.get("y"));
        action.setDuration(1);
        action.setInterpolation(Interpolation.smooth);
        pawn.addAction(action);
        stage.addActor(pawn);
    }

    /*public void roleDice()
    {
        Random random = new Random();
        int dice;

        if (Gdx.input.isKeyJustPressed(Input.Keys.SPACE))
        {
            dice = random.nextInt(6) + 1 ;
            diceSum += dice;
            movePawn(diceSum);
            System.out.println(dice + "  " + diceSum);
        }
    }*/


    @Override
    public void render() {
        Gdx.gl.glClearColor(.9038f, .9038f, .9038f, 1);
        Gdx.gl.glBlendFunc(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        camera.update();
        viewport.update(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

//        renderer.setView((OrthographicCamera) viewport.getCamera());
        renderer.setView(camera);
        renderer.render();

        Dice.rollAndMove();

        // Instead of batch and sprites
        stage.act();
        stage.draw();
    }


    @Override
    public void dispose() {
        tiledMap.dispose();
    }

}
