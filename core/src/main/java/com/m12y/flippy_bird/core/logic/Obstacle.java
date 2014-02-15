package com.m12y.flippy_bird.core.logic;

import com.badlogic.gdx.math.MathUtils;

public class Obstacle {
    public float position;
    public final float gap;

    public static final float WIDTH = 40;

    public Obstacle() {
        position = 100;
        gap = MathUtils.random();
    }

    public void update() {
        position -= 1;
    }
}
