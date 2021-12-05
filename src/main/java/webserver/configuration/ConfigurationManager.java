package webserver.configuration;

public class ConfigurationManager {

    private String fileName = null;
    private static ConfigurationManager myConfigManager;
    private static Configuration myCurrentConfiguration;

    public ConfigurationManager(String fileName) {
        this.fileName = fileName;
    }

    public static ConfigurationManager getInstance() {
        if (myConfigManager == null)
            myConfigManager = new ConfigurationManager(getInstance().fileName);
        return myConfigManager;
    }

    public Configuration getCurrentConfiguration() {
            return myCurrentConfiguration;
    }

    public String getFileName( String key) {
        return null;
    }

    public boolean setFileName( String key, String name) {
        return false;
    }

    public void loadConfiguration(){}

    public boolean setPort(int port) {

        if(!PortNumberValidator.validate(port))
            return false;
        return true;
    }

    public String getWebRoot() {
        return null;
    }

    public String getMaintenance() {
        return null;
    }

    public void setWebRoot(String webRoot) {}

    public void setMaintenance(String maintenance) {}

}
