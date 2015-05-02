package org.southriverhi.space.Networking.Server;

import org.southriverhi.space.Networking.Common.Packet01Text;
import org.southriverhi.space.Networking.Common.Packet02ServerDisconnect;
import org.southriverhi.space.Networking.Common.PacketRegistry;

/**
 * Created by Freedman on 5/2/2015.
 */
public class RegisterServerPackets {


    public static void register() {
        DefaultServerPacketHandler defaultServerPacketHandler = new DefaultServerPacketHandler();
        PacketRegistry.registerPacket(1, Packet01Text.class, defaultServerPacketHandler);
        PacketRegistry.registerPacket(2, Packet02ServerDisconnect.class, defaultServerPacketHandler);
    }
}
