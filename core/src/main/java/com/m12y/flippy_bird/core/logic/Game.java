package com.m12y.flippy_bird.core.logic;

import com.badlogic.gdx.utils.Array;

public class Game {
    public final Bird bird;
    private int score;
    public final Array<Obstacle> obstacles;

    private int tick;

    public Game() {
        bird = new Bird();
        obstacles = new Array<Obstacle>(false, 5);
        obstacles.add(new Obstacle());
    }

    public void update() {
        tick++;
//        bird.update();
        for (Obstacle obstacle : obstacles) {
            obstacle.update();
        }
        // collision
        // score
    }
}
