package com.gamerz.model;

import com.badlogic.gdx.graphics.Texture;

public class ImageInfo {

	int srcX, srxY, width, height, radius, posX, posY, angle;
	String imgName;
	Texture texture;

	public ImageInfo(int posX, int posY, int srcX, int srxY, int width, int height, int radius, int angle,
			String imgName) {
		super();
		this.texture = new Texture(imgName);
		this.srcX = srcX;
		this.srxY = srxY;
		this.posX = posX;
		this.posY = posY;
		this.width = width;
		this.height = height;
		this.radius = radius;
		this.angle = angle;
		this.imgName = imgName;
	}

}
