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

package org.southriverhi.space.Addons;

public abstract class SpaceShooterAddon {

	/**
	 *
	 */
	protected String name;

    /**
     *
     * @param event
     */
	public void loadP(AddonLoadEvent event) {
		load(event);
	}

    /**
     *
     * @param event
     */
	public void unloadP(AddonUnloadEvent event) {
		unload(event);
	}

    /**
     *
     * @param event
     */
	public void startP(AddonStartEvent event) {
		start(event);
	}

    /**
     *
     * @param event
     */
	public void stopP(AddonStopEvent event) {
		stop(event);
	}

    /**
     *
     * @param event
     */
	public void runP(AddonRunEvent event) {
		run(event);
	}

    /**
     *
     * @param event
     */
	protected abstract void load(AddonLoadEvent event);

    /**
     *
     * @param event
     */
	protected abstract void unload(AddonUnloadEvent event);

    /**
     *
     * @param event
     */
	protected abstract void start(AddonStartEvent event);

    /**
     *
     * @param event
     */
	protected abstract void stop(AddonStopEvent event);

    /**
     *
     * @param event
     */
	protected abstract void run(AddonRunEvent event);

    /**
     *
     * @return
     */
	public abstract String getPluginName();
}
