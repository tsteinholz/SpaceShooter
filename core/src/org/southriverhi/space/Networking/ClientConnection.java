/*
 * This file is part of SpaceShooter.
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
 */

package org.southriverhi.space.Networking;

import java.io.*;
import java.net.Socket;

public class ClientConnection extends Thread {
    Socket socket = null;
    ObjectOutputStream out;
    ObjectInputStream in;

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
                System.out.println("Pid: " + packet.getPacketId());
                if (packet.getPacketId() == 1) {
                    SimpleTextPacket simpleTextPacket = (SimpleTextPacket) packet;
                    System.out.println("Server: " + simpleTextPacket.getUserInput());

                    Packet sPacket1 = new SimpleTextPacket(simpleTextPacket.getUserInput());
                    Server.broadcastPacket(sPacket1);
                    if (simpleTextPacket.getUserInput().equals("Bye."))
                        break;

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

    public synchronized void sendPacket(Packet packet) {
        try {
            out.writeObject(packet);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
