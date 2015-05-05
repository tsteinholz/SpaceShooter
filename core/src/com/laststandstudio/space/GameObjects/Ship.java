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
import com.laststandstudio.space.engine.GameObject;
import com.laststandstudio.space.engine.Transform;

public class Ship extends GameObject {

    public Ship() {
        super();
    }

    public Ship(Transform transform) {
        super(transform);
    }

    public Ship(Transform transform, Vector2 size) {
        super(transform, size);
    }

    public Ship(Transform transform, Vector2 size, Vector2 velocity) {
        super(transform, size, velocity);
    }

    @Override
    public void update(float delta) {

    }

    @Override
    public void dispose() {

    }
}
