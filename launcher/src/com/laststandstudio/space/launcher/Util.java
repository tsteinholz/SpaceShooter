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

package com.laststandstudio.space.launcher;

import java.io.File;

public class Util {

    public static final String LINUX_INSTALL_DIR = "~" + File.separator + ".local" + File.separator + "share" + File.separator + "LastStandStudio" + File.separator + "SpaceShooter";
    public static final String WINDOWS_INSTALL_DIR = System.getenv("LOCALAPPDATA")  + File.separator + "LastStandStudio" + File.separator + "SpaceShooter";
    public static final String OSX_INSTALL_DIR = "google later";

    public static String getInstallDir() {
        String os = System.getProperty("os.name").toLowerCase();
        if (os.contains("linux")) return LINUX_INSTALL_DIR;
        else if (os.contains("windows")) return WINDOWS_INSTALL_DIR;
        else if (os.contains("mac")) return OSX_INSTALL_DIR;
            // add additional OS support here if necessary!
        else return "We Do not Know what we are Doing! <3";
    }
}
