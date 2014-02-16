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

    public Game() {
        bird = new Bird();
        obstacles = new Array<Obstacle>(false, 3);
    }

    public void update(float delta) {
        int currentTick = MathUtils.floor(elapsed * TPS);
        elapsed += delta;
        int targetTick = MathUtils.floor(elapsed * TPS);
        for (; currentTick < targetTick; currentTick += 1) {
            bird.update();
            for (Obstacle obstacle : obstacles) {
                obstacle.update();
            }

            if (currentTick % Obstacle.GENERATION_RATE == 0) {
                for (Obstacle obstacle : obstacles) {
                    if (obstacle.position < 0) {
                        obstacles.removeValue(obstacle, true);
                    }
                }
                obstacles.add(new Obstacle());
                assert obstacles.size <= 3;
            }

            // collision

            for (Obstacle obstacle : obstacles) {
                if (obstacle.score(bird)) {
                    score++;
                }
            }
        }
    }
}
