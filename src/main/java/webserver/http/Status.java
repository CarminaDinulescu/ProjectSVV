package webserver.http;

import webserver.exception.HttpParsingException;

public class Status {
    private static int serverState ;

    public static void init(){
        serverState = 0;
    }

    public static int getServerState(){
        return serverState;
    }

    public static void setServerState(int serverState) {
        Status.serverState = serverState;
    }

    public static void startWebServer() throws HttpParsingException {
        if(serverState == 200)
            throw new HttpParsingException(
                    HttpStatusCode.SERVER_STATUS_OK);
        serverState = 200;
    }


    public static void stopWebServer() throws HttpParsingException {
        if(serverState == 0)
            throw new HttpParsingException(
                    HttpStatusCode.SERVER_STATUS_STOP);
        serverState = 0;
    }


    public static void maintenanceWebServer() throws HttpParsingException{
        if(serverState == 503)
            throw new HttpParsingException(
                    HttpStatusCode.SERVER_ERROR_503_SERVICE_UNAVAILABLE);
        serverState = 503;
    }
}
