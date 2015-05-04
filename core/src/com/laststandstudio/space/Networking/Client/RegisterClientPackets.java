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

package com.laststandstudio.space.Networking.Client;

import com.laststandstudio.space.Networking.Common.*;

public class RegisterClientPackets {

    public static void register() {
        DefaultClientPacketHandler defaultClientPacketHandler = new DefaultClientPacketHandler();
        PacketRegistry.registerPacket(1, Packet01Text.class, defaultClientPacketHandler);
        PacketRegistry.registerPacket(2, Packet02ServerJoin.class, defaultClientPacketHandler);
        PacketRegistry.registerPacket(2, Packet03ServerDisconnect.class, defaultClientPacketHandler);
        PacketRegistry.registerPacket(4, Packet04Player.class, defaultClientPacketHandler);
        PacketRegistry.registerPacket(5, Packet05ChatCommand.class, defaultClientPacketHandler);
        PacketRegistry.registerPacket(6, Packet06ChatMessage.class, defaultClientPacketHandler);
        PacketRegistry.registerPacket(7, Packet08AssetResource.class, defaultClientPacketHandler);
        PacketRegistry.registerPacket(8, Packet07AddonResource.class, defaultClientPacketHandler);
    }
}
