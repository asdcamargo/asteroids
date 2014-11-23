package com.gamerz.controller;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.InputProcessor;
import com.gamerz.config.ConfigurationParameters;
import com.gamerz.model.Ship;

public class InputController implements InputProcessor {

	private Ship ship;

	public InputController(Ship ship) {
		this.ship = ship;
	}

	@Override
	public boolean keyDown(int keycode) {
		// Increase acceleration
		if (Gdx.input.isKeyPressed(Keys.UP)) {
			ship.accelerate();
		}
		if (Gdx.input.isKeyPressed(Keys.RIGHT)) {
			ship.increaseAngle(-ConfigurationParameters.ANGLE_ACC);
		}
		if (Gdx.input.isKeyPressed(Keys.LEFT)) {
			ship.increaseAngle(ConfigurationParameters.ANGLE_ACC);
		}
		return false;
	}

	@Override
	public boolean keyUp(int keycode) {
		if (!Gdx.input.isKeyPressed(Keys.UP)) {
			ship.stopAccelerate();
		}
		if (!Gdx.input.isKeyPressed(Keys.RIGHT)) {
			ship.stopAccAngle();
		}
		if (!Gdx.input.isKeyPressed(Keys.LEFT)) {
			ship.stopAccAngle();
		}
		return false;
	}

	@Override
	public boolean keyTyped(char character) {
		return false;
	}

	@Override
	public boolean touchDown(int x, int y, int pointer, int button) {
		return false;
	}

	@Override
	public boolean touchUp(int x, int y, int pointer, int button) {
		return false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean scrolled(int amount) {
		// TODO Auto-generated method stub
		return false;
	}
}
