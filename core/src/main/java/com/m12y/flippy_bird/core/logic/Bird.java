package com.m12y.flippy_bird.core.logic;

public class Bird {
    public float position;
    private float velocity;
    private boolean flipped;

    public static final float CENTER = 2f;
    public static final float SIZE = 1f;
    private static final float GRAVITY = 0.012f;
    private static final float MAX_VELOCITY = 0.23f;
    private static final float DRAG_COEFFICIENT = GRAVITY / MAX_VELOCITY;

    public Bird() {
        position = Game.HEIGHT/2;
        velocity = 0;
        flipped = false;
    }

    public void update() {
        position += velocity;
        velocity += flipped ? GRAVITY : -GRAVITY;
        velocity -= drag();
    }

    public void flip() {
        flipped = !flipped;
    }

    private float drag() {
        return velocity * DRAG_COEFFICIENT;
    }

    public float leftEdge() {
        return CENTER - SIZE /2;
    }

    public float rightEdge() {
        return CENTER + SIZE /2;
    }
}
