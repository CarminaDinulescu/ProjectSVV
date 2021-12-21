package webserver.core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class ServerThreadWorker extends Thread {

    private final static Logger LOGGER = LoggerFactory.getLogger(ServerThreadWorker.class);
    private final Socket socket;
    private final String html;

    public ServerThreadWorker(Socket socket, String html) {
        this.socket = socket;
        this.html = html;
    }

    public void run() {
        InputStream inputStream = null;
        OutputStream outputStream = null;

        try {

            inputStream = socket.getInputStream();
            outputStream = socket.getOutputStream();

            final String crlf = "\n\r";
            String html = "<html><head><title>Simple Server</title></head><body><ch1>this page is a test</ch1></body></html>";
            String response =
                    "HTTP/1.1 200 OK"
                            + crlf
                            + "Content-Lenght" + html.getBytes().length + crlf + crlf
                            + crlf
                            + html
                            + crlf + crlf;

            outputStream.write(response.getBytes());

            LOGGER.info("Connection processing finished");

            } catch (IOException e) {
                LOGGER.error("Problem with communication", e);

            }
        finally {
            if(inputStream!=null){
                try {
                    inputStream.close();
                } catch (IOException e) {}
            }

            if(outputStream!=null){
                try {
                    outputStream.close();
                } catch (IOException e) {}
            }

            if(socket!=null){
                try {
                    socket.close();
                } catch (IOException e) {}
            }
        }
    }
}
