package webserver.exception;

public class InvalidPort extends Throwable{

    public InvalidPort()
    {
        super("Error:Invalid port number");
    }
}
