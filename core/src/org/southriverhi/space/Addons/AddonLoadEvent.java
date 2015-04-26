package org.southriverhi.space.Addons;

import java.util.List;

public class AddonLoadEvent extends AddonEvent {

	List<SpaceShooterPlugin> pluginsLoaded = null;

	public AddonLoadEvent(String name, List<SpaceShooterPlugin> pluginsLoaded) {
		// TODO Auto-generated constructor stub
		this.pluginsLoaded = pluginsLoaded;
		this.name = name;
	}

	public List<SpaceShooterPlugin> getPluginsLoaded() {
		return pluginsLoaded;
	}

}
