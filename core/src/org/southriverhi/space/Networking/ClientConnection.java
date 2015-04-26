package org.southriverhi.space.Networking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Created by Freedman on 4/25/2015.
 */
public class ClientConnection extends Thread {
    Socket socket = null;

    ClientConnection(Socket socket) {
        this.socket = socket;
        start();
    }

    public void run() {
        System.out.println("New Client Communication Thread Started");

        try {
            PrintWriter out = new PrintWriter(socket.getOutputStream(),
                    true);
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));

            String inputLine;

            while ((inputLine = in.readLine()) != null) {
                System.out.println("Server: " + inputLine);
                out.println(inputLine);

                if (inputLine.equals("Bye."))
                    break;
            }

            out.close();
            in.close();
            socket.close();
        } catch (IOException e) {
            System.err.println("Problem with Communication Server");
        }
    }

}
