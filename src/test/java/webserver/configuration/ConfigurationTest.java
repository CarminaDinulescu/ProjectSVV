package webserver.configuration;

import org.junit.jupiter.api.Test;
import webserver.exception.InvalidPort;


import static org.junit.jupiter.api.Assertions.*;

class ConfigurationTest {
    @Test
    public void test() throws InvalidPort
    {
        ConfigurationManager manager = new ConfigurationManager("Valid");
        manager.setPort(1);
    }

    @Test
    public void testInvalidPortNumber() throws InvalidPort {
        Configuration  conf = new Configuration ();
        assertFalse(conf.setPort(0));
    }

    @Test
    public void testValidPortNumber() throws InvalidPort {
        Configuration  conf = new Configuration ();
        assertFalse(conf.setPort(8080));
    }

    @Test
    public void testValidLoadConfiguration()
    {
        ConfigurationManager conf = new ConfigurationManager("valid");
        conf.loadConfiguration();
    }

    @Test
    public void testInvalidLoadConfigurationFile()
    {
        ConfigurationManager conf = new ConfigurationManager("invalid");
        conf.loadConfiguration();
    }
}