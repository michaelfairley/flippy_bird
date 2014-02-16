package com.m12y.flippy_bird.core;

import com.badlogic.gdx.InputProcessor;
import com.m12y.flippy_bird.core.logic.Game;

public class StartInputProcessor implements InputProcessor {
    private final Game game;

    public StartInputProcessor(Game game) {
        this.game = game;
    }

    @Override
    public boolean keyDown(int keycode) {
        FlippyBird.instance.setScreen(new GameScreen(game));
        return true;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        FlippyBird.instance.setScreen(new GameScreen(game));
        return true;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }
}
