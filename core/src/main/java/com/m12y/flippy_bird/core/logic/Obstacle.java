package com.m12y.flippy_bird.core.logic;

import com.badlogic.gdx.math.MathUtils;

public class Obstacle {
    public float position;
    public final float gap;

    public static final float WIDTH = 1f;
    public static final float GAP_SIZE = 3f;

    public static final int GENERATION_RATE = 60;

    private boolean scored;

    public Obstacle() {
        position = Game.WIDTH + WIDTH;
        gap = MathUtils.random();
        scored = false;
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

    public float leftEdge() {
        return position - WIDTH /2;
    }

    public float rightEdge() {
        return position + WIDTH /2;
    }

    public boolean score(Bird bird) {
        if (scored) return false;

        if (rightEdge() < bird.leftEdge()) {
            scored = true;
            return true;
        } else {
            return false;
        }
    }
}
