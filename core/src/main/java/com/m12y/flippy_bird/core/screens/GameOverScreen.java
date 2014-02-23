package com.m12y.flippy_bird.core.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.math.MathUtils;
import com.m12y.flippy_bird.core.FlippyBird;
import com.m12y.flippy_bird.core.analytics.Analytics;
import com.m12y.flippy_bird.core.input.GameOverInputProcessor;
import com.m12y.flippy_bird.core.logic.Game;
import com.m12y.flippy_bird.core.rendering.GameRenderer;

public class GameOverScreen implements Screen {
    public static final float DELAY = 0.2f;
    private final Game game;
    private final int highScore;
    private float elapsed;

    public GameOverScreen(Game game) {
        this.game = game;
        Gdx.input.setInputProcessor(null);

        int previousHighScore = FlippyBird.instance.preferences.getInteger("high_score", 0);
        highScore = Math.max(game.score, previousHighScore);
        FlippyBird.instance.preferences.putInteger("high_score", highScore);
        FlippyBird.instance.preferences.flush();

        FlippyBird.instance.analytics.gameOver(game.score);
    }

    @Override
    public void render(float delta) {
        if (elapsed < DELAY) {
            float shade = 0.8f - elapsed / 1f;
            Gdx.gl.glClearColor(shade, shade, shade, 0);
            Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
        } else {
            if (elapsed + delta > DELAY) {
                Gdx.input.setInputProcessor(new GameOverInputProcessor());
            }

            game.fall();
            GameRenderer.instance.render(game);
            GameRenderer.instance.renderStartText("High score:", Integer.toString(highScore));
        }
        elapsed += delta;
    }

    @Override
    public void resize(int width, int height) {
        GameRenderer.instance.resize(width, height);
    }

    @Override
    public void show() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void dispose() {

    }
}
