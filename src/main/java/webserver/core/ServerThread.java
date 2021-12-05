package webserver.core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerThread extends Thread {

    protected Socket clientSocket;
    private final static Logger LOGGER = LoggerFactory.getLogger(ServerThread.class);

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = null;

        try {
            serverSocket = new ServerSocket(10008);

            LOGGER.info("Connection Socket Created");

            try {
                while (serverSocket.isBound() && !(serverSocket.isClosed())) {

                    LOGGER.info("Waiting for Connection");

                    Socket socket = serverSocket.accept();

                    LOGGER.info("Connection accepted: " + socket.getInetAddress());
                }
            }
            catch (IOException e) {
                LOGGER.error("Accept failed.", e);
            }
        }
        catch (IOException e) {
            LOGGER.error("Could not listen on port: 10008.", e);

        } finally {

            if (serverSocket != null) {
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    LOGGER.error("Could not close port: 10008.", e);
                }
            }
        }
    }

    private ServerThread (Socket clientSocket) throws IOException {
        this.clientSocket = clientSocket;
        start();
    }

    public void run() {
        LOGGER.info("New Communication Thread Started");

        try {
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(),
                    true);
            BufferedReader in = new BufferedReader(new InputStreamReader(
                    clientSocket.getInputStream()));

            String inputLine;

            while ((inputLine = in.readLine()) != null) {
                System.out.println("Server: " + inputLine);
                out.println(inputLine);

                if (inputLine.trim().equals(""))
                    break;
            }

            out.close();
            in.close();
            clientSocket.close();
        }
        catch (IOException e) {
            LOGGER.error("Problem with Communication Server", e);
        }
    }
}










