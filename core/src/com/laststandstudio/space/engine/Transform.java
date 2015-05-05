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
