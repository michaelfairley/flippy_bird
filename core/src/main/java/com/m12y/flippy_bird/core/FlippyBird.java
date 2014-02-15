package com.m12y.flippy_bird.core;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;

public class FlippyBird extends Game {
    @Override
    public void create() {
        setScreen(new GameScreen(this));
    }
}
