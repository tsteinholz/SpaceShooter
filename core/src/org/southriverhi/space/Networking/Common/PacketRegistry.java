package org.southriverhi.space.Networking.Common;

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
