package webserver.configuration;

import com.fasterxml.jackson.core.JsonProcessingException;

public class ConfigException extends RuntimeException {

    public ConfigException(String s, JsonProcessingException e) {
    }

    public ConfigException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public ConfigException(Throwable cause) {
        super(cause);
    }

    public ConfigException(String message) {
        super(message);
    }


}
