package com.m12y.flippy_bird.core.rendering;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector3;
import com.m12y.flippy_bird.core.logic.Game;
import com.m12y.flippy_bird.core.logic.Obstacle;

public class ObstacleRenderer {
    private final SpriteBatch spriteBatch;
    private final Texture texture;

    public ObstacleRenderer(SpriteBatch spriteBatch) {
        this.spriteBatch = spriteBatch;
        texture = new Texture(Gdx.files.internal("obstacle.png"));
    }

    public void render(Obstacle obstacle) {
        spriteBatch.begin();

        for (int i = 0; i < Game.HEIGHT; i++) {
            if (i >= obstacle.gapBottom() && i < obstacle.gapTop()) continue;

            spriteBatch.draw(texture, obstacle.leftEdge(), i, 1, 1);
        }

        spriteBatch.end();
    }
}
