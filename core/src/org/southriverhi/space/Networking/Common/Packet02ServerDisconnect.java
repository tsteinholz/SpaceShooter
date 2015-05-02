package org.southriverhi.space.Networking.Common;

/**
 * Created by Freedman on 5/2/2015.
 */
public class Packet02ServerDisconnect extends Packet {

    private String disconnectReason = "";


    public Packet02ServerDisconnect(String disconnectReason) {
        this.disconnectReason = disconnectReason;
    }

    @Override
    public Integer getPacketId() {
        return 2;
    }

    public String getDisconnectReason() {
        return disconnectReason;
    }
}
