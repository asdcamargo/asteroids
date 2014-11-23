package com.gamerz.model;

import java.util.Map;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.physics.box2d.World;

/**
 * Abstract superclass of all elements in the pinball field, such as walls,
 * bumpers, and flippers.
 *
 * @author brian
 */

public abstract class Element {

	Map parameters;
	ImageInfo imageInfo;

	public Element(Map parameters, ImageInfo imageInfo) {
		this.parameters = parameters;
		this.imageInfo = imageInfo;
	}

	/**
	 * Creates and returns a FieldElement object from the given map of
	 * parameters. The default class to instantiate is an argument to this
	 * method, and can be overridden by the "class" property of the parameter
	 * map. Calls the no-argument constructor of the default or custom class,
	 * and then calls initialize() passing the parameter map and World.
	 */
	public static Element createFromParameters(Map params, World world, Class<? extends Element> defaultClass,
			ImageInfo imageInfo) {
		try {
			Element instance = defaultClass.getConstructor(Map.class, ImageInfo.class).newInstance(params, imageInfo);
			return instance;
		} catch (Exception ex) {
			throw new RuntimeException(ex);
		}
	}

	/**
	 * Called on every update from Field.tick. Default implementation decrements
	 * flash counter if active, subclasses can override to perform additional
	 * processing, e.g. RolloverGroupElement checking for balls within radius of
	 * rollovers. Subclasses should call super.tick(field).
	 */
	public abstract void update();

	/**
	 * Must be overridden by subclasses to draw the element, using
	 * IFieldRenderer methods.
	 */
	public abstract void draw(SpriteBatch spriteBatch);

	/** Returns the parameter map from which this element was created. */
	public Map getParameters() {
		return parameters;
	}

}
