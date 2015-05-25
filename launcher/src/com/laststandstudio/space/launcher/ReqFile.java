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

public class ReqFile {

    private String identifier;
    private String name;
    private String version;
    private String path;
    private String fileName;
    private AssetType type;

    public ReqFile(String identifier, String name, String version, String type, String path, String fileName) {
        this.identifier = identifier;
        this.name = name;
        this.version = version;
        this.type = AssetType.valueOf(type);
        this.path = path.endsWith(File.separator) ? path : path + File.separator;
        this.fileName = fileName;
    }

    @Override
    public String toString() {

        return "<" + getIdentifier() + "," + getName() + "," + getVersion() + "," + getType().name() + "," + getPath() + "," + getFileName() + ">";
    }

    public String getPath() {
        return path;
    }

    public String getIdentifier() {
        return identifier;
    }

    public String getName() {
        return name;
    }

    public String getVersion() {
        return version;
    }

    public AssetType getType() {
        return type;
    }

    public String getFileName() {
        return fileName;
    }

    public enum AssetType {
        MEDIA, FILE, TEMP, EXE, ARCHIVE, LINK
    }
}
