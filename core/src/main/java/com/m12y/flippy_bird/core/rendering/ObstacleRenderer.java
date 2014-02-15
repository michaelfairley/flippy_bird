package com.m12y.flippy_bird.core.rendering;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.m12y.flippy_bird.core.logic.Game;
import com.m12y.flippy_bird.core.logic.Obstacle;

public class ObstacleRenderer {
    private final ShapeRenderer shapeRenderer;

    public ObstacleRenderer(ShapeRenderer shapeRenderer) {
        this.shapeRenderer = shapeRenderer;
    }

    public void render(Obstacle obstacle) {
        shapeRenderer.setColor(0, 1, 0, 0);
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        shapeRenderer.rect(obstacle.position - Obstacle.WIDTH, 0, Obstacle.WIDTH, obstacle.gapBottom());
        shapeRenderer.rect(obstacle.position - Obstacle.WIDTH, obstacle.gapTop(), Obstacle.WIDTH, Game.HEIGHT-obstacle.gapTop());
        shapeRenderer.end();
    }
}