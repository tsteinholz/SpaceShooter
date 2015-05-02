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

package com.laststandstudio.space.Networking.Common;

import java.util.HashMap;

/**
 * @author Joshua Freedman
 */
public class PacketRegistry {

    private static HashMap<Integer, Class<? extends Packet>> registeredPackets = new HashMap<>();
    private static HashMap<Integer, Object> registeredPacketHandlers = new HashMap<>();


    public static boolean registerPacket(Integer id, Class<? extends Packet> packet, PacketHandler handler) {
        if (registeredPackets.containsKey(id) || registeredPackets.containsValue(packet) || registeredPacketHandlers.containsKey(id)) {
            return false;
        } else {
            registeredPackets.put(id, packet);
            registeredPacketHandlers.put(id, handler);
            return true;
        }
    }

    public static Class<? extends Packet> getPacket(Integer id) {
        if (registeredPackets.containsKey(id)) {
            return registeredPackets.get(id);
        } else {
            return null;
        }
    }

    public static void submitPacket(Packet packet) {

        if (registeredPackets.containsKey(packet.getPacketId())) {
            ((PacketHandler)registeredPacketHandlers.get(packet.getPacketId())).handlePacket(packet);
        }
    }
}
