package com.m12y.flippy_bird.java;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

import com.m12y.flippy_bird.core.FlippyBird;

public class FlippyBirdDesktop {
	public static void main (String[] args) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.useGL20 = true;
        config.width = 640/2;
        config.height = 1136/2;
		new LwjglApplication(new FlippyBird("Desktop"), config);
	}
}
