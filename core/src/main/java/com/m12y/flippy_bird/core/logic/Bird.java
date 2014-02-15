package com.m12y.flippy_bird.core.logic;

public class Bird {
    public float position;
    private float velocity;
    private boolean flipped;

    public static final float WIDTH = 30;

    public Bird() {
        position = 500;
        velocity = 0;
        flipped = false;
    }

    public void update() {
        position += velocity;
        velocity += flipped ? 0.1f : -0.1f;
    }
}
