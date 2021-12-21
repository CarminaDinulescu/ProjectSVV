package webserver.configuration;

import org.junit.jupiter.api.Test;
import webserver.exception.InvalidPort;

import static org.junit.jupiter.api.Assertions.*;

class ConfigurationTest {

   @Test
    public void testGoodPortNumber() throws InvalidPort
    {
        ConfigurationManager configuration = new ConfigurationManager();
        configuration.setPort(10008);
    }

    @Test
    public void testInvalidPortNumber() throws InvalidPort {
        ConfigurationManager configuration = new ConfigurationManager();
        assertFalse(configuration.setPort(0));
    }

    @Test
    public void testGoodPort() throws InvalidPort {
        int port = 8080;
        int expectedPort = 8080;
        ConfigurationManager manager = new ConfigurationManager();
        manager.setPort(port);
        assertEquals(expectedPort, manager.getPort());
    }

    @Test
    public void testBadPort() throws InvalidPort {
        int port = 0;
        int expectedPort = 0;
        ConfigurationManager manager = new ConfigurationManager();
        manager.setPort(port);
        assertEquals(expectedPort, manager.getPort());
    }

    @Test
    public void testBadWebroot(){
        String webroot = null;
        ConfigurationManager manager = new ConfigurationManager();
        assertFalse(manager.setWebroot(webroot));
    }

    @Test
    public void testGoodWebroot(){
        String webroot = "   ";
        ConfigurationManager manager = new ConfigurationManager();
        assertTrue(manager.setWebroot(webroot));
    }
}