package org.southriverhi.space.Addons;

public abstract class AddonEvent {

	String name = "event";
	private boolean cancelled = false;

	public String getName() {
		return name;
	}

	public boolean isCancelled() {
		return cancelled;
	}

	public void setCancelled(boolean cancelled) {
		this.cancelled = cancelled;
	}

}
