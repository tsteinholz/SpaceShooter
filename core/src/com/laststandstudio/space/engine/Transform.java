package com.laststandstudio.space.engine;

import com.badlogic.gdx.math.Vector2;

/** @Author Thomas Steinholz */
public class Transform {

    /** The (x,y) coordinates */
    public Vector2 coordinates;
    /** The Rotation x and the Rotation y */
    public Vector2 rotation;
    /** The Scale x and the Scale y */
    public Vector2 scale;

    /**
     *
     */
    public Transform() {
        this(new Vector2(0,0));
    }

    /**
     *
     * @param coordinates
     */
    public Transform(Vector2 coordinates) {
        this(coordinates, new Vector2(0,0), new Vector2(1,1));
    }

    /**
     *
     * @param coordinates
     * @param rotation
     */
    public Transform(Vector2 coordinates, Vector2 rotation) {
        this(coordinates, rotation, new Vector2(1,1));
    }

    /**
     *
     * @param coordinates
     * @param rotation
     * @param scale
     */
    public Transform(Vector2 coordinates, Vector2 rotation, Vector2 scale) {
        this.coordinates = coordinates;
        this.rotation = rotation;
        this.scale = scale;
    }
}
