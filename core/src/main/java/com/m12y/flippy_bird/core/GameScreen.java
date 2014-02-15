package com.m12y.flippy_bird.core;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL10;
import com.m12y.flippy_bird.core.logic.Game;
import com.m12y.flippy_bird.core.rendering.GameRenderer;

public class GameScreen implements Screen {
    private final FlippyBird flippyBird;
    private final Game game;
    private final GameRenderer gameRenderer;

    public GameScreen(FlippyBird flippyBird) {
        this.flippyBird = flippyBird;
        game = new Game();
        gameRenderer = new GameRenderer();
    }

    @Override
    public void render(float delta) {
        game.update(delta);
        gameRenderer.render(game);
    }

    @Override
    public void resize(int width, int height) {
        gameRenderer.resize(width, height);
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
