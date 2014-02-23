package com.m12y.flippy_bird.core;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.m12y.flippy_bird.core.analytics.Analytics;
import com.m12y.flippy_bird.core.rendering.GameRenderer;
import com.m12y.flippy_bird.core.screens.StartScreen;

public class FlippyBird extends Game {
    public static FlippyBird instance;
    public GameRenderer gameRenderer;
    public Analytics analytics;
    public String platform;
    public Preferences preferences;

    public FlippyBird(String platform) {
        instance = this;
        this.platform = platform;
    }

    @Override
    public void create() {
        gameRenderer = new GameRenderer();
        preferences = Gdx.app.getPreferences("flippy_bird_prefernces");
        analytics = new Analytics();
        setScreen(new StartScreen());
    }
}
