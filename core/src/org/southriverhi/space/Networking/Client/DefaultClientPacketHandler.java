package org.southriverhi.space.Networking.Client;

import org.southriverhi.space.Networking.Common.Packet;
import org.southriverhi.space.Networking.Common.PacketHandler;
import org.southriverhi.space.Networking.Common.Packet02ServerDisconnect;
import org.southriverhi.space.Networking.Common.Packet01Text;
import org.southriverhi.space.SpaceShooter;

/**
 * Created by Freedman on 5/2/2015.
 */
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
