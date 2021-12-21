package webserver.main;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import webserver.configuration.ConfigurationManager;
import webserver.core.ServerThread;
import webserver.exception.HttpParsingException;
import webserver.http.Status;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.Scanner;

public class WebServer {

    private final static Logger LOGGER = LoggerFactory.getLogger(WebServer.class);
    static ServerSocket serverSocket;

    public static void main(String[] args) throws IOException, InterruptedException, HttpParsingException {

        Status.init();
        ConfigurationManager manager = new ConfigurationManager();

        LOGGER.info("Using port: " + manager.getPort());

        Scanner input = new Scanner(System.in);
        String html1 = "";


        try {
            ServerThread serverThread = new ServerThread(manager.getPort(), manager.getWebroot(), html1);
            serverThread.start();

            while (true) {

                try {
                    switch (input.nextInt()) {
                        case 0:
                            Status.stopWebServer();
                            LOGGER.info("Server stopped");
                            break;
                        case 1:
                            Status.startWebServer();
                            html1 = ConfigurationManager.getWebrootHtml();
                            LOGGER.info("Server Started");
                            break;

                        case 2:
                            Status.maintenanceWebServer();
                            html1 = ConfigurationManager.getMaintenanceHtml();
                            LOGGER.info("Maintenance");
                            break;
                        case 3:
                            System.exit(0);
                            serverSocket.close();
                    }
                } catch (HttpParsingException e) {
                    e.printStackTrace();
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}




