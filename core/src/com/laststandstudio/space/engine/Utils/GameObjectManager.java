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

package com.laststandstudio.space.engine.Utils;

import com.laststandstudio.space.engine.GameObject;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author Thomas Steinholz
 */
public class GameObjectManager {

    private HashMap<String, GameObject> gameObjects;

    /**
     * A simple constructor for building the Game Object Manager.
     */
    public GameObjectManager() {
        this(new HashMap<String, GameObject>());
    }

    /**
     * A complete constructor for building the GameObjectManager.
     *
     * @param gameObjects : A Hashmap containing GameObjects with a pairing key.
     */
    public GameObjectManager(HashMap<String, GameObject> gameObjects) {
        this.gameObjects = gameObjects;
    }

    /**
     * Adds a GameObject to the Manager.
     *
     * @param key : The key used to access the Game Object.
     * @param gameObject : The GameObject being stored.
     */
    public void load(String key, GameObject gameObject) {
        this.gameObjects.put(key, gameObject);
    }

    public GameObject get(String key) {
        return this.gameObjects.get(key);
    }

    /**
     * Removes a selected key from the Manager.
     *
     * @param key : The String used to access the GameObject.
     * @return the GameObject being removed.
     */
    public GameObject remove (String key) {
        return this.gameObjects.remove(key);
    }

    /**
     * Called once per frame.
     *
     * @param delta : time inbetween frames.
     */
    public void update(float delta) {
        for(Map.Entry<String, GameObject> x : gameObjects.entrySet()) {
            x.getValue().update(delta);
        }
    }

    /**
     * Called when destroying.
     */
    public void dispose() {
        this.gameObjects.clear();
    }
}
