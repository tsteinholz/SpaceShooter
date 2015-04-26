package org.southriverhi.space.Networking;

/**
 * Created by Freedman on 4/26/2015.
 */
public class SimpleTextPacket extends Packet {

    private String uInput;

    public SimpleTextPacket(String userInput) {
        uInput = userInput;
    }

    @Override
    public short getPacketId() {
        return 1;
    }

    public String getUserInput(){
        return uInput;
    }
}
