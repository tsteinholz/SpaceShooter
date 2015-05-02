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

import com.laststandstudio.space.Networking.Common.Packet;
import com.laststandstudio.space.Networking.Common.PacketHandler;
import com.laststandstudio.space.Networking.Common.Packet02ServerDisconnect;
import com.laststandstudio.space.Networking.Common.Packet01Text;
import com.laststandstudio.space.SpaceShooter;

public class DefaultClientPacketHandler extends PacketHandler {


    @Override
    public void handlePacket(Packet packet) {
        int id = packet.getPacketId();

        switch (id){
            case 1:
                System.out.println("echo: " + ((Packet01Text) packet).getUserInput());
                break;
            case 2:
                SpaceShooter.logger.log("Disconnecting from server.... REASON: " + ((Packet02ServerDisconnect) packet).getDisconnectReason());
                Client.disconnectClient();
                break;
            default:
                System.err.println(packet.getPacketId());
        }
    }
}
