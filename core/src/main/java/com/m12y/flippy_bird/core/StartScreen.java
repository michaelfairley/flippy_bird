package com.m12y.flippy_bird.core;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.m12y.flippy_bird.core.logic.Game;
import com.m12y.flippy_bird.core.rendering.GameRenderer;

public class StartScreen implements Screen {
    private final Game game;

    public StartScreen() {
        this.game = new Game();
        Gdx.input.setInputProcessor(new StartInputProcessor(game));
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
