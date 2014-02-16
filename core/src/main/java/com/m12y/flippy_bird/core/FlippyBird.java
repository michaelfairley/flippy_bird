package com.m12y.flippy_bird.core;

import com.badlogic.gdx.Game;
import com.m12y.flippy_bird.core.rendering.GameRenderer;

public class FlippyBird extends Game {
    public static FlippyBird instance;
    public GameRenderer gameRenderer;

    public FlippyBird() {
        instance = this;
    }

    @Override
    public void create() {
        gameRenderer = new GameRenderer();
        setScreen(new StartScreen());
    }
}
