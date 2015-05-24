package com.laststandstudio.space.Addons;

import java.io.Serializable;
import java.net.URI;

public class AddonResourceInfo implements Serializable {

    private String name;
    private String version;
    private URI repo;

    public URI getRepo() {
        return repo;
    }

    public void setRepo(URI repo) {
        this.repo = repo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }
}
