package com.gamerz.asteroids;

import java.util.HashMap;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.gamerz.controller.InputController;
import com.gamerz.model.ImageInfo;
import com.gamerz.model.Ship;

public class Asteroids extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;
	Ship ship;

	@Override
	public void create() {
		batch = new SpriteBatch();
		// Initialize the ship
		ImageInfo shipImageInfo = new ImageInfo(300, 100, 45, 45, 90, 90, 45, 180, "double_ship.png");
		java.util.Map<String, Object> shipParameters = new HashMap<String, Object>();
		shipParameters.put("vel", new Double[] { 0d, 0d });
		shipParameters.put("angleVel", 0d);
		shipParameters.put("thrust", false);
		ship = new Ship(shipParameters, shipImageInfo);
		Gdx.input.setInputProcessor(new InputController(ship));
	}

	@Override
	public void render() {
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		ship.update();
		ship.draw(batch);
		batch.end();
	}
}
