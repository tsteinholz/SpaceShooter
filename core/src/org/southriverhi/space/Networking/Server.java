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

import org.southriverhi.space.Levels.Level;
import org.southriverhi.space.ServerProperties;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.ArrayList;

import static org.southriverhi.space.SpaceShooter.logger;

public class Server {

    private final String name;
    private final short port;
    private final int maxCon;
    private final String password;
    private Level level;

    private static ArrayList<ClientConnection> connections = new ArrayList<ClientConnection>();

    ServerSocket serverSocket = null;

    public Server(ServerProperties sa) {
        name = sa.serverName;
        port = sa.serverPort;
        maxCon = sa.serverMaxConnections;
        password = sa.serverPassword;
        level = sa.serverLevel;

    }

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

    public static void broadcastPacket(Packet packet) {
        for (ClientConnection clientConnection : connections) {
            clientConnection.sendPacket(packet);
        }
    }

    public static void removeConnection(ClientConnection clientConnection) {
        connections.remove(clientConnection);
    }
}
