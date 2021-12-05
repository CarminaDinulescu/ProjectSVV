package webserver.configuration;

public class PortNumberValidator {

    public static boolean validate(int portNumber)
    {
        if (portNumber <= 0){
            return false;
        }
        return true;
    }
}
