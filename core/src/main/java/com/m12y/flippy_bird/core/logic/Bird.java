package com.m12y.flippy_bird.core.logic;

public class Bird {
    public float position;
    private float velocity;
    private boolean flipped;

    public static final float WIDTH = 1f;
    private static final float GRAVITY = 0.01f;

    public Bird() {
        position = Game.HEIGHT/2;
        velocity = 0;
        flipped = false;
    }

    public void update() {
        position += velocity;
        velocity += flipped ? GRAVITY : -GRAVITY;
    }
}
