package com.m12y.flippy_bird.core.logic;

import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.utils.Array;

public class Game {
    public final Bird bird;
    public int score;
    public final Array<Obstacle> obstacles;

    private float elapsed;
    private static final float TPS = 60;

    public static final float WIDTH = 10;
    public static final float HEIGHT = 13;

    public static final float SCROLL_SPEED = 0.1f;

    public Game() {
        bird = new Bird();
        obstacles = new Array<Obstacle>(false, 3);
    }

    public int ticks() {
        return MathUtils.floor(elapsed * TPS);
    }

    public void noopdate(float delta) {
        elapsed += delta;
    }

    public boolean update(float delta) {
        int currentTick = ticks();
        elapsed += delta;
        int targetTick = ticks();
        for (; currentTick < targetTick; currentTick += 1) {
            updateChildren();
            addAndRemoveObstacles(currentTick);
            score();
            if (collision()) {
                return true;
            }
        }
        return false;
    }

    private boolean collision() {
        if (bird.bottomEdge() < 0) return true;
        if (bird.topEdge() > Game.HEIGHT) return true;
        for (Obstacle obstacle : obstacles) {
            if (obstacle.isColliding(bird.rect())) return true;
        }

        return false;
    }

    private void addAndRemoveObstacles(int currentTick) {
        if (currentTick % Obstacle.GENERATION_RATE == 24) {
            for (Obstacle obstacle : obstacles) {
                if (obstacle.position < 0) {
                    obstacles.removeValue(obstacle, true);
                }
            }
            obstacles.add(new Obstacle());
            assert obstacles.size <= 3;
        }
    }

    private void updateChildren() {
        bird.update();
        for (Obstacle obstacle : obstacles) {
            obstacle.update();
        }
    }

    private void score() {
        for (Obstacle obstacle : obstacles) {
            if (obstacle.score(bird)) {
                score++;
            }
        }
    }

    public void fall() {
        if (bird.flipped) {
            if (bird.topEdge() < Game.HEIGHT) bird.fall();
        } else {
            if (bird.bottomEdge() > 0) bird.fall();
        }
    }
}
