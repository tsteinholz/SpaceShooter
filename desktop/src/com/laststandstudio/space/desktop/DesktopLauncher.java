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

package com.laststandstudio.space.desktop;

import com.badlogic.gdx.Files;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.beust.jcommander.JCommander;
import com.laststandstudio.space.engine.Networking.Server.Server;
import com.laststandstudio.space.StartupOptions;
import com.laststandstudio.space.SpaceShooter;

import java.awt.*;

public class DesktopLauncher {

    public static void main(String[] args) {

        LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
        StartupOptions startupOptions = new StartupOptions();

        new JCommander(startupOptions, args);

        if (startupOptions.dedicatedServer) {
            try {
                new SpaceShooter(startupOptions);
                new Server(startupOptions).start();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return;
        }

        config.title = "South River Space Shooter";
        //TODO: Fix the auto Resolution Generator for Dual Monitor Support.
        config.height = startupOptions.debug ? 6 * 100 : Toolkit.getDefaultToolkit().getScreenSize().height;
        config.width = startupOptions.debug ? 11 * 100 : Toolkit.getDefaultToolkit().getScreenSize().width;
        config.fullscreen = !startupOptions.debug;
        config.resizable = startupOptions.debug;
        config.vSyncEnabled = true;
        config.useHDPI = true;
        config.allowSoftwareMode = true;

        config.addIcon("splash/favicon-blue.png", Files.FileType.Internal);

        new LwjglApplication(new SpaceShooter(startupOptions), config);
    }
}
