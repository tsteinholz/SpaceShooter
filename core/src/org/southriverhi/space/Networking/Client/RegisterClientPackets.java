package org.southriverhi.space.Networking.Client;

import org.southriverhi.space.Networking.Common.Packet01Text;
import org.southriverhi.space.Networking.Common.Packet02ServerDisconnect;
import org.southriverhi.space.Networking.Common.PacketRegistry;

/**
 * Created by Freedman on 5/2/2015.
 */
public class RegisterClientPackets {

    public static void register() {
        System.out.println("\n\nRegister....\n\n");
        DefaultClientPacketHandler defaultClientPacketHandler = new DefaultClientPacketHandler();
        PacketRegistry.registerPacket(1, Packet01Text.class, defaultClientPacketHandler);
        PacketRegistry.registerPacket(2, Packet02ServerDisconnect.class, defaultClientPacketHandler);
    }
}
