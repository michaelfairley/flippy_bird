package com.m12y.flippy_bird.core.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.m12y.flippy_bird.core.FlippyBird;
import com.m12y.flippy_bird.core.input.StartInputProcessor;
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
        game.noopdate(delta);
        GameRenderer.instance.render(game);

        String action;
        if (FlippyBird.instance.platform.equals("ios")) {
            action = "Tap anywhere";
        } else {
            action = "Press any key";
        }
        GameRenderer.instance.renderStartText(action, "to flip");
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
