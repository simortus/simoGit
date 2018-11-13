package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.utils.viewport.FillViewport;
import com.badlogic.gdx.utils.viewport.FitViewport;

public class TileBoard extends ApplicationAdapter
{
    private TiledMap tiledMap;
    private OrthogonalTiledMapRenderer renderer;

    private OrthographicCamera camera;
    private FillViewport viewport;

    int w;
    int h;


    @Override
    public void create ()
    {
        w = 720;
        h = 540;

        camera = new OrthographicCamera();
        camera.setToOrtho(false, w, h);
        //camera.translate(352,0);
        camera.update();
        viewport = new FillViewport(w,h,camera);

        tiledMap = new TmxMapLoader().load("board05.tmx");
        renderer = new OrthogonalTiledMapRenderer(tiledMap);

//        renderer.setView(camera);
//        renderer.render();
    }


    @Override
    public void render ()
    {
        Gdx.gl.glClearColor(.9038f, .9038f, .9038f, 1);
        Gdx.gl.glBlendFunc(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        camera.update();
        viewport.update(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
//        renderer.setView((OrthographicCamera) viewport.getCamera());
        renderer.setView(camera);
        renderer.render();
    }


    @Override
    public void dispose ()
    {
        tiledMap.dispose();
    }

}
