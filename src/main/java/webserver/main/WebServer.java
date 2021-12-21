package webserver.main;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import webserver.configuration.ConfigurationManager;
import webserver.core.ServerThread;
import webserver.exception.HttpParsingException;
import webserver.http.Status;

import java.io.*;
import java.net.ServerSocket;
import java.util.Scanner;

public class WebServer {

    private final static Logger LOGGER = LoggerFactory.getLogger(WebServer.class);
    static ServerSocket serverSocket;

    public static void main(String[] args) throws IOException, InterruptedException {

        Status.init();
        ConfigurationManager manager = new ConfigurationManager();

        LOGGER.info("Using port: " + manager.getPort());

        Scanner input = new Scanner(System.in);
        Scanner scanner = new Scanner(System.in);

       try {
            scanner = new Scanner(new File("src/main/resources/TestSite/a.html"));
       } catch (FileNotFoundException e) {
            e.printStackTrace();
       }
       scanner.close();

        String html1="<html><head><title>Simple Server</title></head><body><ch1>this page is a test</ch1></body></html>";
        boolean flag = true;

        if(Status.getServerState()==1) {
            try {
                ServerThread serverThread = new ServerThread(manager.getPort(), manager.getWebroot(), html1);
                serverThread.start();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }

        while (flag) {
            printServerSettingsMenu();

            try {
                switch (input.nextInt()) {
                    case 0:
                        Status.stopWebServer();
                        break;
                    case 1:
                        Status.startWebServer();
                        break;

                    case 2:
                        Status.maintenanceWebServer();
                        break;
                    case 3:
                        System.exit(0);
                }

            } catch (HttpParsingException e) {
                e.printStackTrace();
            }
        }
    }

    public static void printServerSettingsMenu(){
        LOGGER.info("Server settings: ");
        LOGGER.info("Current state: " + Status.getServerState());
        LOGGER.info("-> Set to state 0 (Stopped)");
        LOGGER.info("-> Set to state 1 (Running)");
        LOGGER.info("-> Set to state 2 (Maintenance)");
        LOGGER.info("-> Exit program: 3");
        LOGGER.info("Enter your option:");
//        System.out.flush();
    }

}


