package com.m12y.flippy_bird.core.rendering;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector3;
import com.m12y.flippy_bird.core.logic.Game;
import com.m12y.flippy_bird.core.logic.Obstacle;

public class GameRenderer {
    private final ShapeRenderer shapeRenderer;
    private final ShapeRenderer textShapeRenderer;
    private final OrthographicCamera camera;
    private final OrthographicCamera textCamera;

    private final BirdRenderer birdRenderer;
    private final ObstacleRenderer obstacleRenderer;

    private final BitmapFont scoreFont;
    private final SpriteBatch spriteBatch;
    private final SpriteBatch textSpriteBatch;

    public static GameRenderer instance;

    private final Texture ceilingTexture;
    private final Texture floorTexture;

    public GameRenderer() {
        instance = this;

        camera = new OrthographicCamera();
        textCamera = new OrthographicCamera();

        shapeRenderer = new ShapeRenderer();
        shapeRenderer.setProjectionMatrix(camera.combined);
        textShapeRenderer = new ShapeRenderer();

        spriteBatch = new SpriteBatch();
        textSpriteBatch = new SpriteBatch();

        FileHandle fontFile = Gdx.files.internal("score.fnt");
        FileHandle fontImageFile = Gdx.files.internal("score.png");
        Texture texture = new Texture(fontImageFile);
        texture.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        scoreFont = new BitmapFont(fontFile, new TextureRegion(texture), false);

        birdRenderer = new BirdRenderer(spriteBatch);
        obstacleRenderer = new ObstacleRenderer(spriteBatch);

        ceilingTexture = new Texture(Gdx.files.internal("bricks.png"));
        floorTexture = new Texture(Gdx.files.internal("stone.png"));
    }

    public void render(Game game) {
        Gdx.gl.glClearColor(0, 0, 0, 0);
        Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);


        spriteBatch.begin();

        birdRenderer.render(game.bird);

        for (Obstacle obstacle : game.obstacles) {
            obstacleRenderer.render(obstacle);
        }

        renderCeiling(game);
        renderFloor(game);
        spriteBatch.end();

        renderScore(game);
    }

    private void renderScore(Game game) {
        String scoreString = Integer.toString(game.score);
        float width = scoreFont.getBounds(scoreString).width;

        textSpriteBatch.begin();
        scoreFont.draw(textSpriteBatch, scoreString, (textCamera.viewportWidth - width) / 2, 380f);
        textSpriteBatch.end();
    }

    private void renderCeiling(Game game) {
        float scrolled = game.ticks() * -Game.SCROLL_SPEED % 1;
        for (; scrolled < Game.WIDTH; scrolled += 1) {
            spriteBatch.draw(ceilingTexture, scrolled, Game.HEIGHT, 1, 1);
        }
    }

    private void renderFloor(Game game) {
        float scrolled = game.ticks() * -Game.SCROLL_SPEED % 1;
        for (; scrolled < Game.WIDTH; scrolled += 1) {
            spriteBatch.draw(floorTexture, scrolled, -1, 1, 1);
        }
    }

    public void resize(int width, int height) {
        camera.setToOrtho(false, Game.WIDTH, Game.WIDTH * height / (1.0f * width));
        camera.translate(0, Game.HEIGHT + 1 - Game.WIDTH * height / (1.0f * width));
        camera.update();

        float textScale = width / 320.f;

        textCamera.setToOrtho(false, width/textScale, height/textScale);
        textCamera.translate(0, (Game.HEIGHT + 1 - Game.WIDTH * height / (1.0f * width)) * (width / Game.WIDTH) / textScale);
        textCamera.update();

        shapeRenderer.setProjectionMatrix(camera.combined);
        spriteBatch.setProjectionMatrix(camera.combined);

        textShapeRenderer.setProjectionMatrix(textCamera.combined);
        textSpriteBatch.setProjectionMatrix(textCamera.combined);
    }

    public void renderStartText(String line1, String line2) {
        float width1 = scoreFont.getBounds(line1).width;
        float width2 = scoreFont.getBounds(line2).width;

        float backgroundWidth = Math.max(width1, width2) + 40;

        textShapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        textShapeRenderer.setColor(0, 0, 0, 0);
        textShapeRenderer.rect(
                (textCamera.viewportWidth - backgroundWidth) / 2,
                30,
                backgroundWidth,
                140
        );
        textShapeRenderer.end();

        textSpriteBatch.begin();
        scoreFont.draw(textSpriteBatch, line1, (textCamera.viewportWidth - width1) / 2, 150f);
        scoreFont.draw(textSpriteBatch, line2, (textCamera.viewportWidth - width2) / 2, 90f);
        textSpriteBatch.end();
    }
}
