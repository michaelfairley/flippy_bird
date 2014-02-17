package com.m12y.flippy_bird.core.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.m12y.flippy_bird.core.FlippyBird;
import com.m12y.flippy_bird.core.input.GameInputProcessor;
import com.m12y.flippy_bird.core.logic.Game;
import com.m12y.flippy_bird.core.rendering.GameRenderer;

public class GameScreen implements Screen {
    private final Game game;

    public GameScreen(Game game) {
        this.game = game;
        Gdx.input.setInputProcessor(new GameInputProcessor(this.game));
    }

    @Override
    public void render(float delta) {
        if (game.update(delta)) {
            FlippyBird.instance.setScreen(new GameOverScreen(game));
        }
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
