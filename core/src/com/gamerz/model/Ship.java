package com.gamerz.model;

import java.util.Map;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.gamerz.config.ConfigurationParameters;
import com.gamerz.utils.GameUtils;

@SuppressWarnings("unchecked")
public class Ship extends Element {

	public Ship(Map parameters, ImageInfo imageInfo) {
		super(parameters, imageInfo);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void draw(SpriteBatch spriteBatch) {
		int srcX = imageInfo.srcX;
		int srcY = imageInfo.srxY;
		int width = imageInfo.width;
		int height = imageInfo.height;
		int posX = imageInfo.posX;
		int posY = imageInfo.posY;
		if ((Boolean) this.parameters.get("thrust") == true) {
			srcX = 90;
			srcY = 0;
		} else {
			srcX = 0;
			srcY = 0;
		}
		spriteBatch.draw(this.imageInfo.texture, posX, posY, 45, 45, width, height, 1, 1, imageInfo.angle, srcX, srcY,
				width, height, false, false);
	}

	@Override
	public void update() {
		Double[] velocity = (Double[]) this.parameters.get("vel");
		double angleVel = (Double) this.parameters.get("angleVel");
		imageInfo.posX += velocity[0];
		imageInfo.posY += velocity[1];
		System.out.println("Thrust: " + this.parameters.get("thrust"));
		System.out.println("Velx: " + velocity[0]);
		System.out.println("Vely: " + velocity[1]);
		if ((Boolean) this.parameters.get("thrust") == true) {
			// Calculate the forward direction of the ship
			double[] forward = GameUtils.angleToVector(Math.toRadians(imageInfo.angle));
			velocity[0] += forward[0] * ConfigurationParameters.ACC_FACTOR;
			velocity[1] += forward[1] * ConfigurationParameters.ACC_FACTOR;
		}
		// Adds a friction to the velocity
		velocity[0] *= 1 - ConfigurationParameters.FRICTION_FACTOR;
		velocity[1] *= 1 - ConfigurationParameters.FRICTION_FACTOR;
		imageInfo.angle += angleVel;
	}

	public void accelerate() {
		this.parameters.put("thrust", true);
	}

	public void stopAccelerate() {
		this.parameters.put("thrust", false);
	}

	public void increaseAngle(double factor) {
		double angleVel = (Double) this.parameters.get("angleVel");
		angleVel += factor;
		this.parameters.put("angleVel", angleVel);
	}

	public void stopAccAngle() {
		this.parameters.put("angleVel", 0d);
	}

	public static double round(double value, int places) {
		if (places < 0) {
			throw new IllegalArgumentException();
		}
		long factor = (long) Math.pow(10, places);
		value = value * factor;
		value = Math.floor(value);
		return value / factor;
	}

}
