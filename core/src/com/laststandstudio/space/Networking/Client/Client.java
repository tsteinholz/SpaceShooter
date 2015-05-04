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

package com.laststandstudio.space.Networking.Client;

import com.laststandstudio.space.Networking.Common.Packet;
import com.laststandstudio.space.Networking.Common.Packet01Text;
import com.laststandstudio.space.Networking.Common.PacketRegistry;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {

    private boolean connected = false;
    private static ClientThread thread = null;
    private static String serverHostname = new String("127.0.0.1");

    private static Socket echoSocket = null;
    private static ObjectOutputStream out = null;
    private static ObjectInputStream in = null;

    static {
    }


    public synchronized static void startClient() {
        disconnectClient();
        thread = new ClientThread();
        thread.start();
        RegisterClientPackets.register();

    }

    public static void disconnectClient() {
        if (thread != null) {
            thread.closeConnection();
            thread = null;
        }
    }

    public static void sendPacketToServer(Packet packet) {
        if (thread != null) {
            thread.sendPacket(packet);
        }
    }

    private static class ClientThread extends Thread {

        @Override
        public void run() {

            try {

                try {
                    echoSocket = new Socket(serverHostname, 7683);
                    out = new ObjectOutputStream(echoSocket.getOutputStream());
                    in = new ObjectInputStream(echoSocket.getInputStream());
                } catch (UnknownHostException e) {
                    System.err.println("Don't know about host: " + serverHostname);
                } catch (IOException e) {
                    System.err.println("Couldn't get I/O for "
                            + "the connection to: " + serverHostname);
                }

                BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
                String userInput;

                while ((userInput = stdIn.readLine()) != null) {
                    Packet packet = new Packet01Text(userInput);
                    out.writeObject(packet.prepare());
                    Packet newPacket = (Packet) in.readObject();
                    PacketRegistry.submitPacket(newPacket);


                    /*
                                        if (newPacket.getPacketId() == 1) {
                        System.out.println("echo: " + ((TextPacket01) newPacket).getUserInput());
                    } else {
                        System.err.println(newPacket.getPacketId());
                    }

                    if (newPacket.getPacketId() == 2) {
                        SpaceShooter.logger.log("Disconnecting from server.... REASON: " + ((ServerDisconnectPacket02) newPacket).getJoinReason());
                        break;
                    }

                     */

                }
                stdIn.close();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                closeConnection();
            }
        }

        public void closeConnection() {
            try {
                out.close();

                in.close();
                echoSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public void sendPacket(Packet packet) {
            packet.prepare();
            try {
                out.writeObject(packet);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
