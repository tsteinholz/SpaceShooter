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
import org.southriverhi.space.StartupArgs;

import java.io.IOException;
import java.net.ServerSocket;

public class Server {

    final String name;
    final short port;
    final int maxCon;
    final String password;
    Level level;

    ServerSocket serverSocket = null;

    public Server(StartupArgs sa) {
        name = sa.serverName;
        port = sa.serverPort;
        maxCon = sa.serverMaxConnections;
        password = sa.serverPassword;
        level = sa.serverLevel;

        try {
            serverSocket = new ServerSocket(port);
            System.out.println("Server Socket Created!");

            while(true) {
                System.out.println("Waiting for new connection!");
                new ClientConnection(serverSocket.accept());
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

    public void start() throws Exception {

    }
}
