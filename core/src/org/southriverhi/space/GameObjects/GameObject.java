/*
 * This file is part of SpaceShooter.
 *
 *  SpaceShooter is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  SpaceShooter is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with SpaceShooter.  If not, see <http://www.gnu.org/licenses/>.
 */

package org.southriverhi.space.GameObjects;

import com.badlogic.gdx.math.Vector2;

public abstract class GameObject {
    protected int length, width;        //The length and width of the GameObject.
    protected Vector2 position;         //A Vector2 of the position.
    protected float velocity;           //A Float representing the GameObject Velocity.

    /**
     * Constructor for Empty or Quick GameObjects.
     */
    public GameObject() {
        this(1, 1, 0, 0, 0);
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
    public GameObject(float x, float y, int length, int width, float velocity) {
        this.position = new Vector2(x, y);
        this.length = length;
        this.width = width;
        this.velocity = velocity;
    }

    /**
     * Gets called every frame.
     *
     * @param delta : Time in between frames in milliseconds.
     */
    public abstract void update(float delta);

    /**
     * @return length of the GameObject.
     */
    public int getLength() {
        return length;
    }

    /**
     * @return width of the GameObject.
     */
    public int getWidth() {
        return width;
    }

    /**
     * @return position of the GameObject.
     */
    public Vector2 getPosition() {
        return position;
    }

    /**
     * @return velocity of the GameObject.
     */
    public float getVelocity() {
        return velocity;
    }

}
