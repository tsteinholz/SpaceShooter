package org.southriverhi.space.Networking;

import java.util.HashMap;

/**
 * @author Joshua Freedman
 */
public class PacketRegistry {

    private static HashMap<Integer, Class<? extends Packet>> registeredPackets = new HashMap<>();

    public static boolean registerPacket(int id, Class<? extends Packet> packet){
        if(registeredPackets.containsKey(id) || registeredPackets.containsValue(packet)){
            return false;
        }else{
            registeredPackets.put(id, packet);
            return true;
        }
    }

    public static Class<? extends Packet> getPacket(int id){
        if(registeredPackets.containsKey(id)) {
            return registeredPackets.get(id);
        }else{
            return null;
        }
    }

}
