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
public class Transform {

    /**
     * Default Values:
     *    Coordinates  : x = 0 | y = 0
     *    Rotation     : x = 0 | y = 0
     *    Scale        : x = 1 | y = 1
     */

    /** The (x,y) coordinates */
    public Vector2 coordinates;
    /** The Rotation x and the Rotation y */
    public Vector2 rotation;
    /** The Scale x and the Scale y */
    public Vector2 scale;

    /** A location in 2D space that includes the Coordinates, Rotation, and Scale of the Game Object. */
    public Transform() {
        this(new Vector2(0,0));
    }

    /**
     * A location in 2D space that includes the Coordinates, Rotation, and Scale of the Game Object.
     *
     * @param coordinates : Vector2 of the corresponding (x,y) coordinates.
     */
    public Transform(Vector2 coordinates) {
        this(coordinates, new Vector2(0,0), new Vector2(1,1));
    }

    /**
     * A location in 2D space that includes the Coordinates, Rotation, and Scale of the Game Object.
     *
     * @param coordinates : Vector2 of the corresponding (x,y) coordinates.
     * @param rotation : Vector2 of the corresponding (x,y) rotation.
     */
    public Transform(Vector2 coordinates, Vector2 rotation) {
        this(coordinates, rotation, new Vector2(1,1));
    }

    /**
     * A location in 2D space that includes the Coordinates, Rotation, and Scale of the Game Object.
     *
     * @param coordinates : Vector2 of the corresponding (x,y) coordinates.
     * @param rotation : Vector2 of the corresponding (x,y) rotation.
     * @param scale : Vector2 of the corresponding (x,y) scale.
     */
    public Transform(Vector2 coordinates, Vector2 rotation, Vector2 scale) {
        this.coordinates = coordinates;
        this.rotation = rotation;
        this.scale = scale;
    }
}
