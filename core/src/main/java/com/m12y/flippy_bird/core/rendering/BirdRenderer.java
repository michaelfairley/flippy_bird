package com.m12y.flippy_bird.core.rendering;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.m12y.flippy_bird.core.logic.Bird;

public class BirdRenderer {
    private final SpriteBatch spriteBatch;
    private final Texture texture;

    public BirdRenderer(SpriteBatch spriteBatch) {
        this.spriteBatch = spriteBatch;
        texture = new Texture(Gdx.files.internal("bird.png"));
    }

    public void render(Bird bird) {
        spriteBatch.draw(texture, bird.imageLeft(), bird.imageBottom(), 1, 1, 0, 0, 32, 32, false, bird.flipped);
    }
}
