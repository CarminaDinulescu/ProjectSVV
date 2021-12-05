package webserver.configuration;

import webserver.exception.InvalidPort;

public class Configuration {

    private int port;

    public int getPort() {
        return port;
    }

    public boolean setPort(int port) throws InvalidPort {
        return false;
    }

}
