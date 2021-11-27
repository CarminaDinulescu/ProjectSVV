package webserver.main;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import webserver.configuration.Configuration;
import webserver.configuration.ConfigurationManager;
import webserver.core.ServerThread;

import java.io.IOException;

public class WebServer extends Thread {

        private final static Logger LOGGER = LoggerFactory.getLogger(WebServer.class);

        public static void main(String[] args) {

            LOGGER.info("Server starting..");

            ConfigurationManager.getInstance().loadConfigFile("src/main/resources/http.json");
            Configuration conf = ConfigurationManager.getInstance().getCurrentConfiguration();

            LOGGER.info("Using port: " + conf.getPort());

            ServerThread serverThread = null;

            try {
                serverThread = new ServerThread(conf.getPort());
                serverThread.start();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
}