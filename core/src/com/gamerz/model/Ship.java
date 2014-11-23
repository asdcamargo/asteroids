package com.gamerz.model;

import java.util.Map;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.gamerz.config.ConfigurationParameters;
import com.gamerz.utils.GameUtils;

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
		double acceleration = (Double) this.parameters.get("acc");
		if ((Boolean) this.parameters.get("thrust") == true) {
			// Calculate the foward direction of the ship
			double[] forward = GameUtils.angleToVector(Math.toRadians(imageInfo.angle));
			velocity[0] += forward[0] * acceleration;
			velocity[1] += forward[1] * acceleration;
		}
		velocity[0] *= 1 - ConfigurationParameters.FRICTION_FACTOR;
		velocity[1] *= 1 - ConfigurationParameters.FRICTION_FACTOR;
		imageInfo.angle += angleVel;
		imageInfo.posX += velocity[0];
		imageInfo.posY += velocity[1];
	}

	public void accelerate() {
		double acceleration = (Double) this.parameters.get("acc");
		this.parameters.put("acc", acceleration + ConfigurationParameters.ACC_FACTOR);
		this.parameters.put("thrust", true);
	}

	public void stopAccelerate() {
		this.parameters.put("thrust", false);
		this.parameters.put("acc", 0d);
	}

	public void increaseAngle(double factor) {
		double angleVel = (Double) this.parameters.get("angleVel");
		angleVel += factor;
		this.parameters.put("angleVel", angleVel);
	}

	public void stopAccAngle() {
		this.parameters.put("angleVel", 0d);
	}

}
