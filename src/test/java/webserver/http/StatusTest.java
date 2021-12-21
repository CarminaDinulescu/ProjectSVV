package webserver.http;

import org.junit.jupiter.api.Test;
import webserver.exception.HttpParsingException;

class StatusTest {

    @Test
    public void testStartStoppedWebServer() throws HttpParsingException {
        Status.init();
        Status.startWebServer();
    }

    @Test
    public void testStartMaintenanceWebServer() throws HttpParsingException{
        Status.init();
        Status.startWebServer();
        Status.maintenanceWebServer();
        Status.startWebServer();
    }

    @Test
    public void testMaintenanceRunningWebServer() throws HttpParsingException{
        Status.init();
        Status.startWebServer();
        Status.maintenanceWebServer();
    }

    @Test
    public void testStopRunningWebServer() throws HttpParsingException{
        Status.init();
        Status.startWebServer();
        Status.stopWebServer();
    }

    @Test
    public void testStopInMaintenanceWebServer() throws HttpParsingException {
        Status.init();
        Status.startWebServer();
        Status.maintenanceWebServer();
        Status.stopWebServer();
    }

    public void testStopStoppedWebServer() throws HttpParsingException{
        Status.init();
        Status.stopWebServer();
    }

    public void testMaintenanceStoppedWebServer() throws HttpParsingException{
        Status.init();
        Status.maintenanceWebServer();
    }

    public void testStartRunningWebServer() throws HttpParsingException {
        Status.init();
        Status.startWebServer();
        Status.startWebServer();
    }
}