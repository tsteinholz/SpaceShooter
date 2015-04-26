package org.southriverhi.space;

import org.southriverhi.space.Levels.Level;

/**
 * Created by Freedman on 4/25/2015.
 */
public class StartupArgs {
    public boolean dedicatedServer = false;
    public short serverPort = 7683;
    public int serverMaxConnections = 8;
    public String serverPassword = "";
    public Level serverLevel = Level.getLevelByName("default");
    public String serverName = "Good Ol' Server";
}
