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

package com.laststandstudio.space.engine;

import com.badlogic.gdx.math.Vector2;

/** @Author Thomas Steinholz */
public abstract class GameObject {

    /** Vector2 representing (Length, Width) in pixels */
    protected Vector2 size;
    /** The Transform of the Game Object */
    protected Transform transform;
    /** The Velocity of the GameObject*/
    protected Vector2 velocity;

    /** Base Class for All Entities. */
    public GameObject() {
        this(new Transform(new Vector2(0,0)));
    }

    /**
     * Base Class for All Entities.
     *
     * @param transform : Location in 2D space of the Game Object.
     */
    public GameObject(Transform transform) {
        this(transform, new Vector2(0,0));
    }

    /**
     * Base Class for All Entities.
     *
     * @param transform : Location in 2D space of the Game Object.
     * @param size : Length and width of the object in pixels (Length, Width).
     */
    public GameObject(Transform transform, Vector2 size) {
        this(transform, size, new Vector2(0,0));
    }

    /**
     * Base Class for All Entities.
     *
     * @param transform : Location in 2D space of the Game Object.
     * @param size : Length and width of the object in pixels (Length, Width).
     * @param velocity : The speed / velocity of the Game Object (speed x, speed y).
     */
    public GameObject(Transform transform, Vector2 size, Vector2 velocity) {
        this.transform = transform;
        this.size = size;
        this.velocity = velocity;
    }

    /**
     * Gets called every frame.
     *
     * @param delta : Time in between frames in milliseconds.
     */
    public abstract void update(float delta);

    /** Called when being Disposed */
    public abstract void dispose();

    /** @return The Transform of the Game Object. */
    public Transform getTransform() { return transform; }

    /** @return The Size of the Game Object as a Vector2 (Length, Width). */
    public Vector2 getSize() { return size; }

    /** */
    public Vector2 getVelocity() { return velocity; }

    /**
     *
     * @param transform : Location in 2D space of the Game Object.
     */
    public void setTransform(Transform transform) { this.transform = transform; }

    /**
     *
     * @param size : Length and width of the object in pixels (Length, Width).
     */
    public void setSize(Vector2 size) { this.size = size; }

    /**
     *
     * @param velocity : The speed / velocity of the Game Object (speed x, speed y).
     */
    public void setVelocity(Vector2 velocity) { this.velocity = velocity; }
}
