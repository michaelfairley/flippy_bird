package com.m12y.flippy_bird.core.rendering;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.m12y.flippy_bird.core.logic.Bird;

public class BirdRenderer {
    private final ShapeRenderer shapeRenderer;

    public BirdRenderer(ShapeRenderer shapeRenderer) {
        this.shapeRenderer = shapeRenderer;
    }

    public void render(Bird bird) {
        shapeRenderer.setColor(1, 0, 0, 0);
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        shapeRenderer.rect(bird.leftEdge(), bird.position - Bird.SIZE / 2, Bird.SIZE, Bird.SIZE);
        shapeRenderer.end();
    }
}
