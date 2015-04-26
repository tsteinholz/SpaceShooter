package org.southriverhi.space.Addons;

public abstract class SpaceShooterPlugin {
	protected String name;

	public void loadP(AddonLoadEvent event) {
		load(event);
	}

	public void unloadP(AddonUnloadEvent event) {
		unload(event);
	}

	public void startP(AddonStartEvent event) {
		start(event);
	}

	public void stopP(AddonStopEvent event) {
		stop(event);
	}

	public void runP(AddonRunEvent event) {
		run(event);
	}

	protected abstract void load(AddonLoadEvent event);

	protected abstract void unload(AddonUnloadEvent event);

	protected abstract void start(AddonStartEvent event);

	protected abstract void stop(AddonStopEvent event);

	protected abstract void run(AddonRunEvent event);

	public abstract String getPluginName();
}
