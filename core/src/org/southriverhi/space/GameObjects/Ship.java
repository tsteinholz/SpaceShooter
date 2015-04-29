

package org.southriverhi.space.GameObjects;

import com.badlogic.gdx.math.Vector2;

public class Ship extends GameObject {

    /**
     * Constructor for Empty or Quick GameObjects.
     */
    public Ship() {
        super();
    }

    /**
     * Constructor for the GameObject Class.
     *
     * @param x        : The X-Coordinate Value for the GameObject.
     * @param y        : The Y-Coordinate Value for the GameObject
     * @param length   : The Length of the GameObject.
     * @param width    : The Width of the GameObject.
     * @param velocity : The speed of the GameObject.
     */
    public Ship(float x, float y, int length, int width, float velocity) {
        super(x, y, length, width, velocity);
    }

    /**
     * @return length of the GameObject.
     */
    @Override
    public int getLength() {
        return super.getLength();
    }

    /**
     * Gets called every frame.
     *
     * @param delta : Time in between frames in milliseconds.
     */
    @Override
    public void update(float delta) {

    }

    /**
     * @return width of the GameObject.
     */
    @Override
    public int getWidth() {
        return super.getWidth();
    }

    /**
     * @return position of the GameObject.
     */
    @Override
    public Vector2 getPosition() {
        return super.getPosition();
    }

    /**
     * @return velocity of the GameObject.
     */
    @Override
    public float getVelocity() {
        return super.getVelocity();
    }

    /**
     * @return the integer Object ID
     */
    @Override
    public int getObjectid() {
        return 0;
    }
}
