package webserver.core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerThread extends Thread {

    private final static Logger LOGGER = LoggerFactory.getLogger(ServerThread.class);

    private final int port;
    private final String webroot;
    private ServerSocket serverSocket;
    private String html;

    public ServerThread(int port, String webroot, String html ) throws IOException {
        this.port = port;
        this.webroot = webroot;
        this.serverSocket = new ServerSocket(this.port);
        this.html = html;
    }

    public void run(){

        try {

            LOGGER.info("Waiting for connection");

            while (serverSocket.isBound() && !serverSocket.isClosed()) {
                Socket socket = serverSocket.accept();
                LOGGER.info("Connection accepted.");

                ServerThreadWorker workerThread = new ServerThreadWorker(socket, html);
                workerThread.start();
            }
        }
        catch (IOException e) {
            LOGGER.error("Accept failed", e);
        }
        finally {
            if(serverSocket!=null){
                try {
                    serverSocket.close();
                } catch (IOException e) {}
            }
        }
    }
}


