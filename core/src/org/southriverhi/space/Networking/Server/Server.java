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

package org.southriverhi.space.Networking.Server;

import org.southriverhi.space.Levels.Level;
import org.southriverhi.space.Networking.Common.Packet;
import org.southriverhi.space.ServerProperties;
import org.southriverhi.space.Utils.Logger;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.ArrayList;

/**
 * @author Joshua Freedman
 */
public class Server {

    public static Logger logger;


    /**
     * Server Name.
     */
    private final String name;
    /**
     * Server Port.
     */
    private final short port;
    /**
     * Max Connections Allowed.
     */
    private final int maxCon;
    /**
     * Server Password.
     */
    private final String password;
    /**
     * Current Level.
     */
    private Level level;

    /**
     * ArrayList of ClientConnections.
     *
     * @see ClientConnection
     */
    private static ArrayList<ClientConnection> connections = new ArrayList<ClientConnection>();

    /**
     * The ServerSocket that accepts the TCP requests.
     */
    ServerSocket serverSocket = null;

    /**
     * Default constructor, takes a ServerProperties object that contains the settings.
     *
     * @param sa
     * @see org.southriverhi.space.ServerProperties
     */
    public Server(ServerProperties sa) {
        name = sa.serverName;
        port = sa.serverPort;
        maxCon = sa.serverMaxConnections;
        password = sa.serverPassword;
        level = sa.serverLevel;

        logger = new Logger();

        RegisterServerPackets.register();

    }

    /**
     * Sets up and starts the server.
     *
     * @throws Exception
     */
    public void start() throws Exception {
        try {
            serverSocket = new ServerSocket(port);
            logger.log("Server Socket Created!");

            while (true) {
                logger.log("Waiting for new connection!");
                connections.add(new ClientConnection(serverSocket.accept()));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                serverSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    /**
     * Method used for broadcasting a packet to all clients connected to the server.
     *
     * @param packet
     * @see org.southriverhi.space.Networking.Common.Packet
     */
    public static void broadcastPacket(Packet packet) {
        for (ClientConnection clientConnection : connections) {
            System.out.println("sending to: "+clientConnection.socket.getInetAddress().toString());
            clientConnection.sendPacket(packet);
        }
    }

    /**
     * Removes the passed in ClientConnection from the connections list.
     *
     * @param clientConnection
     * @see ClientConnection
     */
    public static void removeConnection(ClientConnection clientConnection) {
        connections.remove(clientConnection);
    }
}
