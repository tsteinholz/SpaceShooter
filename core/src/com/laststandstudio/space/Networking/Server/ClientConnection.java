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

package com.laststandstudio.space.Networking.Server;

import com.laststandstudio.space.Networking.Common.Packet;
import com.laststandstudio.space.Networking.Common.Packet01Text;
import com.laststandstudio.space.Networking.Common.Packet03ServerDisconnect;
import com.laststandstudio.space.Networking.Common.PacketRegistry;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 * @author Joshua Freedman
 */
public class ClientConnection extends Thread {

    /** Socket Object that stores the Client's Socket Connection */
    Socket socket = null;

    /** A reference to the OutputStream of the socket. */
    ObjectOutputStream out;

    /** A reference to the InputStream of the socket. */
    ObjectInputStream in;

    /**
     * Parameter is the socket object of the client.
     * @param socket
     */
    ClientConnection(Socket socket) {
        this.socket = socket;
        start();
    }

    public void run() {
        System.out.println("New Client Communication Thread Started");

        try {
            out = new ObjectOutputStream(socket.getOutputStream());
            in = new ObjectInputStream(socket.getInputStream());

            Object inObj;
            while ((inObj = in.readObject()) != null) {
                Packet packet = (Packet) inObj;

                PacketRegistry.submitPacket(packet);
                if (packet.getPacketId() == 1) {
                    Packet01Text textPacket01 = (Packet01Text) packet;
                    if(textPacket01.getUserInput().equals("Bye."))
                    {
                        out.writeObject(new Packet03ServerDisconnect("You typed Bye...").prepare());
                    }
                }
            }
            out.close();
            in.close();
            socket.close();
        } catch (IOException e) {
            System.err.println("Problem with Communication Server");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            Server.removeConnection(this);
        }
    }

    /**
     * Syncronized method to send a packet to the client.
     * @see com.laststandstudio.space.Networking.Common.Packet
     * @param packet
     */
    public synchronized void sendPacket(Packet packet) {
        try {
            out.writeObject(packet);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
