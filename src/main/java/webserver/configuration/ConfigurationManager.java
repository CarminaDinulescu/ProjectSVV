package webserver.configuration;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import webserver.util.Json;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import static webserver.util.Json.parse;

public class ConfigurationManager {

    private static ConfigurationManager myConfigManager;
    private static Configuration myCurrentConfiguration;

    private ConfigurationManager() {}

    public static ConfigurationManager getInstance() {

        if (myConfigManager == null)
            myConfigManager = new ConfigurationManager();
        return myConfigManager;
    }

    public void loadConfigFile (String filePath) {

        FileReader fileReader = null;

        try {
            fileReader = new FileReader(filePath);
        }
        catch (FileNotFoundException e) {
            throw new ConfigException(e);
        }

        StringBuffer sb = new StringBuffer();
        int i;

        try {
            while ((i = fileReader.read()) != -1) {
                sb.append((char) i);
            }
        }
        catch (IOException e) {
            throw new ConfigException(e);
        }

        JsonNode conf = null;

        try {
            conf = parse(sb.toString());
        }
        catch (IOException e) {
            throw new ConfigException("Error parsing");
        }

        try {
            myCurrentConfiguration = Json.fromJson(conf, Configuration.class);
        }
        catch (JsonProcessingException e) {
            throw new ConfigException("Error parsing the conf file internal", e);
        }
    }

    public Configuration getCurrentConfiguration() {
        if (myCurrentConfiguration == null) {
            throw new ConfigException("No current configuration");
        }

        return myCurrentConfiguration;
    }

}
