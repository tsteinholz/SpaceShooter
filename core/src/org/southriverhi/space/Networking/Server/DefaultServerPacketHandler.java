package org.southriverhi.space.Networking.Server;

import org.southriverhi.space.Networking.Client.Client;
import org.southriverhi.space.Networking.Common.Packet;
import org.southriverhi.space.Networking.Common.Packet01Text;
import org.southriverhi.space.Networking.Common.Packet02ServerDisconnect;
import org.southriverhi.space.Networking.Common.PacketHandler;
import org.southriverhi.space.SpaceShooter;

/**
 * Created by Freedman on 5/2/2015.
 */
public class DefaultServerPacketHandler extends PacketHandler {

    @Override
    public void handlePacket(Packet packet) {
        int id = packet.getPacketId();

        switch (id) {
            case 1:
                Packet01Text textPacket01 = (Packet01Text) packet;

                System.out.println("echo: " + textPacket01.getUserInput());
                Packet sPacket1 = new Packet01Text(textPacket01.getUserInput());
                Server.broadcastPacket(sPacket1);
                break;
            case 2:
                SpaceShooter.logger.log("Disconnecting from client.... REASON: " + ((Packet02ServerDisconnect) packet).getDisconnectReason());
                Client.disconnectClient();
                break;
            default:
                System.err.println(packet.getPacketId());
        }
    }

}
