/*
 * This file is part of SpaceShooter.
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
 */

package org.southriverhi.space.desktop;

import com.badlogic.gdx.Files;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import org.southriverhi.space.Levels.Level;
import org.southriverhi.space.Networking.Server;
import org.southriverhi.space.SpaceShooter;
import org.southriverhi.space.StartupArgs;

import java.awt.*;

public class DesktopLauncher {

    public static void main(String[] arg) {

        boolean debug = false;

        LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
        StartupArgs startupArgs = new StartupArgs();

        for (String s : arg) {
            if (s.equalsIgnoreCase("--dedicated")) {
                startupArgs.dedicatedServer = true;
            } else if (s.toLowerCase().startsWith("--port:")) {
                startupArgs.serverPort = Short.parseShort(s.substring(7));
            } else if (s.toLowerCase().startsWith("--maxconnections:")) {
                startupArgs.serverMaxConnections = Integer.parseInt(s.substring(17));
            } else if (s.toLowerCase().startsWith("--password:")) {
                startupArgs.serverPassword = s.substring(11);
            } else if (s.toLowerCase().startsWith("--level:")) {
                startupArgs.serverLevel = Level.getLevelByName(s.substring(8));
            } else if (s.toLowerCase().startsWith("--name:")) {
                startupArgs.serverName = s.substring(7);
            } else if (s.equalsIgnoreCase("--debug")) {
                debug = true;
            }
        }

        if (startupArgs.dedicatedServer) {
            try { new Server(startupArgs).start(); }
            catch (Exception e) { e.printStackTrace(); }
            return;
        }

        config.title                = "South River Space Shooter";
        config.height               = debug ? 6 * 100 : Toolkit.getDefaultToolkit().getScreenSize().height;
        config.width                = debug ? 11 * 100 : Toolkit.getDefaultToolkit().getScreenSize().width;
        config.resizable            = debug;
        config.fullscreen           = !debug;
        config.vSyncEnabled         = true;
        config.useHDPI              = true;
        config.allowSoftwareMode    = true;

        config.addIcon("splash/favicon-blue.png", Files.FileType.Internal);

        new LwjglApplication(new SpaceShooter(), config);
    }
}
