package com.m12y.flippy_bird.core.rendering;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector3;
import com.m12y.flippy_bird.core.logic.Game;
import com.m12y.flippy_bird.core.logic.Obstacle;

public class GameRenderer {
    private final ShapeRenderer shapeRenderer;
    private final OrthographicCamera camera;

    private final BirdRenderer birdRenderer;
    private final ObstacleRenderer obstacleRenderer;

    private final BitmapFont font;
    private final SpriteBatch spriteBatch;

    public static GameRenderer instance;

    private final Texture ceilingTexture;
    private int width;
    private int height;

    public GameRenderer() {
        instance = this;

        camera = new OrthographicCamera();

        shapeRenderer = new ShapeRenderer();
        shapeRenderer.setProjectionMatrix(camera.combined);

        birdRenderer = new BirdRenderer(shapeRenderer);
        obstacleRenderer = new ObstacleRenderer(shapeRenderer);

        spriteBatch = new SpriteBatch();
        font = new BitmapFont();

        ceilingTexture = new Texture(Gdx.files.internal("bricks.png"));
    }

    public void render(Game game) {
        Gdx.gl.glClearColor(0.8f, 0.8f, 0.8f, 0);
        Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);

        birdRenderer.render(game.bird);

        for (Obstacle obstacle : game.obstacles) {
            obstacleRenderer.render(obstacle);
        }

        spriteBatch.begin();
        font.draw(spriteBatch, Integer.toString(game.score), 20, 150);
        renderCeiling(game);
        spriteBatch.end();
    }

    private float unit() {
        return Gdx.graphics.getWidth() / Game.WIDTH;
    }

    private void renderCeiling(Game game) {
        float scrolled = game.ticks() * -Game.SCROLL_SPEED % 1;
        for (; scrolled < Game.WIDTH; scrolled += 1) {
            Vector3 postition = new Vector3(scrolled, Game.HEIGHT, 0);
            camera.project(postition);

            spriteBatch.draw(ceilingTexture, postition.x, postition.y, unit(), unit());
        }
    }

    public void resize(int width, int height) {
        camera.setToOrtho(false, Game.WIDTH, Game.WIDTH * height/(1.0f*width));
        camera.translate(0, Game.HEIGHT + 1 - Game.WIDTH * height/(1.0f*width));
        camera.update();
        shapeRenderer.setProjectionMatrix(camera.combined);
    }
}
