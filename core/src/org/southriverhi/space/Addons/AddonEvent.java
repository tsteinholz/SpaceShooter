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

package org.southriverhi.space.Addons;

public abstract class AddonEvent {

    String name = "event";
    private boolean cancelled = false;

    /**
     * @return name.
     */
    public String getName() {
        return name;
    }

    /**
     * @return if the event is cancelled.
     */
    public boolean isCancelled() {
        return cancelled;
    }

    /**
     * @param cancelled if the event is cancelled or not.
     */
    public void setCancelled(boolean cancelled) {
        this.cancelled = cancelled;
    }

}
