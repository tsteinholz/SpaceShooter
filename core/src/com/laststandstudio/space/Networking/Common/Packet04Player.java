package com.laststandstudio.space.Networking.Common;

import com.laststandstudio.space.GameObjects.Player;

/**
 * ***************************************************************************
 * Space Shooter Software License
 * Version 0.0.2-alpha
 * <p>
 * Copyright (C) 2015 Last Stand Studio
 * <p>
 * SpaceShooter is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * <p>
 * SpaceShooter is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * <p>
 * You should have received a copy of the GNU General Public License
 * along with SpaceShooter.  If not, see <http://www.gnu.org/licenses/>.
 * ***************************************************************************
 */

public class Packet04Player extends Packet {

    Player.PlayerState currentState;

    @Override
    public Integer getPacketId() {
        return 4;
    }
}
