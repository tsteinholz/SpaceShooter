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

package com.laststandstudio.space.Levels;

import com.laststandstudio.space.engine.Level;

import java.util.HashMap;

public class LevelRegistry {

    private static HashMap<String, Level> loadedLevels = new HashMap<String, Level>();

    public static boolean registerLevel(String name, Level level) {
        if (!loadedLevels.containsKey(name)) {
            loadedLevels.put(name,level);
            return true;
        } else {
            return false;
        }
    }

    public static Level getLevel(String name){
        return loadedLevels.get(name);
    }
}
