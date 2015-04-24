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
     * 
     */
    public GameObject() {
        this(1, 1, 1, 1, 0);
    }

    /**
     *
     * @param x
     * @param y
     * @param length
     * @param width
     * @param velocity
     */
    public GameObject(float x, float y, int length, int width, float velocity) {
        this.position = new Vector2(x, y);
        this.length = length;
        this.width = width;
        this.velocity = velocity;
    }

    /**
     *
     * @param delta
     */
    public void update(float delta) {

    }

    /**
     *
     * @return
     */
    public int getLength() {
        return length;
    }

    /**
     *
     * @return
     */
    public int getWidth() {
        return width;
    }

    /**
     *
     * @return
     */
    public Vector2 getPosition() {
        return position;
    }

    /**
     *
     * @return
     */
    public float getVelocity() {
        return velocity;
    }
}
