package com.m12y.flippy_bird.core.logic;

import com.badlogic.gdx.math.Rectangle;

public class Bird {
    public float position;
    private float velocity;
    public boolean flipped;

    public static final float CENTER = 2f;
    public static final float WIDTH = 0.9f;
    public static final float HEIGHT = 0.8f;
    private static final float GRAVITY = 0.012f;
    private static final float TERMINAL_VELOCITY = 0.23f;
    private static final float DRAG_COEFFICIENT = GRAVITY / TERMINAL_VELOCITY;

    public Bird() {
        position = Game.HEIGHT/2;
        velocity = 0;
        flipped = false;
    }

    public void update() {
        fall();
    }

    public void fall() {
        position += velocity;
        velocity += flipped ? GRAVITY : -GRAVITY;
        velocity -= drag();
    }

    public void stop() {
        velocity = 0;
    }

    public void flip() {
        flipped = !flipped;
    }

    private float drag() {
        return velocity * DRAG_COEFFICIENT;
    }

    public float leftEdge() {
        return CENTER - WIDTH / 2;
    }

    public float bottomEdge() {
        return position - HEIGHT / 2;
    }

    public float topEdge() {
        return position + HEIGHT / 2;
    }

    public float imageBottom() {
        return position - 0.5f;
    }

    public float imageLeft() {
        return CENTER - 0.5f;
    }

    public Rectangle rect() {
        return new Rectangle(leftEdge(), bottomEdge(), WIDTH, HEIGHT);
    }
}
