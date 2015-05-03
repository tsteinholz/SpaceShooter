/******************************************************************************
 * Space Shooter Software License
 * Version 0.0.2-alpha
 *
 * Copyright (C) 2015 Last Stand Studio
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
 *****************************************************************************/

package com.laststandstudio.space.GameObjects;

import com.badlogic.gdx.math.Vector2;

public class Ship extends GameObject {

    public static final int ID = 0;


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

}
