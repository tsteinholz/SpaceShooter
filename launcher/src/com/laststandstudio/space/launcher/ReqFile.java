package com.laststandstudio.space.launcher;

import java.io.File;

/**
 * Created by Freedman on 5/23/2015.
 */
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
