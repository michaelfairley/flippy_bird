package com.m12y.flippy_bird.html;

import com.m12y.flippy_bird.core.FlippyBird;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.backends.gwt.GwtApplication;
import com.badlogic.gdx.backends.gwt.GwtApplicationConfiguration;

public class FlippyBirdHtml extends GwtApplication {
	@Override
	public ApplicationListener getApplicationListener () {
		return new FlippyBird();
	}
	
	@Override
	public GwtApplicationConfiguration getConfig () {
		return new GwtApplicationConfiguration(320, 568);
	}
}
