package com.m12y.flippy_bird.core.logic;

import com.badlogic.gdx.math.MathUtils;

public class Obstacle {
    public float position;
    public final float gap;

    public static final float WIDTH = 1f;
    public static final float GAP_SIZE = 2f;

    public static final int GENERATION_RATE = 60;

    public Obstacle() {
        position = Game.WIDTH;
        gap = MathUtils.random();
    }

    public void update() {
        position -= 0.1;
    }

    public float gapBottom() {
        return (Game.HEIGHT - GAP_SIZE) * gap;
    }

    public float gapTop() {
        return (Game.HEIGHT - GAP_SIZE) * gap + GAP_SIZE;
    }
}
