package org.southriverhi.space.Levels;

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
