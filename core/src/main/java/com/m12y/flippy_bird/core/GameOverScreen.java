package com.m12y.flippy_bird.core;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.m12y.flippy_bird.core.logic.Game;
import com.m12y.flippy_bird.core.rendering.GameRenderer;

public class GameOverScreen implements Screen {
    private final Game game;

    public GameOverScreen(Game game) {
        this.game = game;
        Gdx.input.setInputProcessor(new GameOverInputProcessor());
    }

    @Override
    public void render(float delta) {
        GameRenderer.instance.render(game);
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
