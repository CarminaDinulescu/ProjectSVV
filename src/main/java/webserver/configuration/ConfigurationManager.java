package webserver.configuration;

import webserver.exception.InvalidPort;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ConfigurationManager {

    public static String webroot = null;
    public int port = 10008;
    public static String maintenanceRoot = null;
    public static String webRootHtml = "<html><head><title></title></head><body><ch1></ch1></body></html>";
    public static String maintenanceRootHtml = "<html><head><title></title></head><body><ch1></ch1></body></html>";

    public int getPort() {
        return port;
    }

    public boolean setPort(int port) throws InvalidPort {
        if(PortNumberValidator.validate(port)) {
            this.port = port;
            return true;
        }else this.port=0;
        return false;
    }

    public String getWebroot() {return webroot;}

    public Boolean setWebroot(String webroot) {
        if(webroot==null)
            return false;
        this.webroot = webroot;
        return true;
    }

    public static String getMaintenanceRoot() {
        return maintenanceRoot;
    }

    public static void setMaintenanceRoot(String maintenanceRoot) {
        ConfigurationManager.maintenanceRoot = maintenanceRoot;
    }

    public static String getWebrootHtml(){
        if(webroot != null){

            Scanner scanner = null;
            try {
                scanner = new Scanner(new File(webroot));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            webRootHtml = scanner.useDelimiter("\\Z").next();
            scanner.close();

        }
        return webRootHtml;
    }

    public static String getMaintenanceHtml(){
        if(maintenanceRoot != null){

            Scanner scanner = null;
            try {
                scanner = new Scanner(new File(maintenanceRoot));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            maintenanceRootHtml = scanner.useDelimiter("\\Z").next();
            scanner.close();

        }
        return maintenanceRootHtml;
    }
}
