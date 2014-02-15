package com.m12y.flippy_bird.core.rendering;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.m12y.flippy_bird.core.logic.Game;
import com.m12y.flippy_bird.core.logic.Obstacle;

public class GameRenderer {
    private final ShapeRenderer shapeRenderer;
    private final OrthographicCamera camera;

    private final BirdRenderer birdRenderer;
    private final ObstacleRenderer obstacleRenderer;

    public GameRenderer() {
        camera = new OrthographicCamera();

        shapeRenderer = new ShapeRenderer();
        shapeRenderer.setProjectionMatrix(camera.combined);

        birdRenderer = new BirdRenderer(shapeRenderer);
        obstacleRenderer = new ObstacleRenderer(shapeRenderer);
    }

    public void render(Game game) {
        Gdx.gl.glClearColor(0.8f, 0.8f, 0.8f, 0);
        Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);

        birdRenderer.render(game.bird);

        for (Obstacle obstacle : game.obstacles) {
            obstacleRenderer.render(obstacle);
        }
    }

    public void resize(int width, int height) {
        camera.setToOrtho(false, Game.WIDTH, Game.WIDTH * height/(1.0f*width));
        camera.translate(0, Game.HEIGHT - Game.WIDTH * height/(1.0f*width));
        camera.update();
        shapeRenderer.setProjectionMatrix(camera.combined);
    }
}
