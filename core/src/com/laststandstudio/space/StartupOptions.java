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

package com.laststandstudio.space;

import com.beust.jcommander.Parameter;
import com.laststandstudio.space.Levels.Level;

public class StartupOptions {

    @Parameter(names = "--dedicated", description = "Starts as a Dedicated Server")
    public boolean dedicatedServer = false;

    @Parameter(names = "--port", description = "Port that the dedicated server runs on. ONLY FOR USE WITH --dedicated")
    public short serverPort = 7683;

    @Parameter(names = "--maxCon", description = "Amount of clients that can join dedicated server. ONLY FOR USE WITH --dedicated")
    public int serverMaxConnections = 8;

    @Parameter(names = "--password", description = "Password for dedicated server. ONLY FOR USE WITH --dedicated")
    public String serverPassword = "";

    @Parameter(names = "--level", description = "Default server level. ONLY FOR USE WITH --dedicated")
    public Level serverLevel = Level.getLevelByName("default");

    @Parameter(names = "--name", description = "Server name. ONLY FOR USE WITH --dedicated")
    public String serverName = "Space Shooter Server";

    @Parameter(names = "--debug", description = "Enable Debugging Mode")
    public boolean debug = false;

}
