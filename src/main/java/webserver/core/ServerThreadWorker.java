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
            String html = "<html>\n" +
                    "<head>\n" +
                    " <title>Welcome!</title>\n" +
                    " </head>\n" +
                    " <body BGCOLOR=\"#FFFFFF\" leftMargin=0 topMargin=0 rightMargin=0 marginheight=\"0\" marginwidth=\"0\">\n" +
                    "  <center>\n" +
                    "   Hello, It works !!! <br />\n" +
                    "   <table>\n" +
                    "   \n" +
                    "   <tr><td>  <a href=\"http://google.com\">do external links work?</a>\n" +
                    "   </td><td> <img src=\"http://www.loose.upt.ro/~mihai/yes.jpg\" height=\"30px\" />\n" +
                    "   </td></tr>\n" +
                    "   \n" +
                    "   <tr><td>  <a href=\"https://tasty.co/recipe/macarons\">do simple relative internal links work?</a> <br />\n" +
                    "   </td><td> <img src=\"a.jpg\" height=\"30px\" />\n" +
                    "   </td></tr>\n" +
                    "\n" +
                    "   <tr><td>  <a href=\"http://labs.cs.upt.ro/~oose/pmwiki.php/SVV/Lab1\">do general relative links work</a> <br />\n" +
                    "   </td><td> <img src=\"aaa/yes.jpg\" height=\"30px\" />\n" +
                    "   </td></tr>\n" +
                    "\n" +
                    "   <tr><td>  <a href=\"http://labs.cs.upt.ro/~oose/pmwiki.php/SVV/Lab2\">do simple absolute links work</a> <br />\n" +
                    "   </td><td> <img src=\"/yes.jpg\" height=\"30px\" />\n" +
                    "   </td></tr>\n" +
                    "\n" +
                    "   <tr><td>  <a href=\"http://labs.cs.upt.ro/~oose/pmwiki.php/SVV/Lab3\">do general absolute links work</a> <br />\n" +
                    "   </td><td> <img src=\"/aaa/bbb/yes.jpg\" height=\"30px\" />\n" +
                    "   </td></tr>\n" +
                    "\n" +
                    "   <tr><td>  <a href=\"http://labs.cs.upt.ro/~oose/pmwiki.php/SVV/Lab5\">do URLs with spaces work</a> <br />\n" +
                    "   </td><td> <img src=\"ye s.jpg\" height=\"30px\" />\n" +
                    "   </td></tr>\n" +
                    "\n" +
                    "   <tr><td>  <a href=\"http://labs.cs.upt.ro/~oose/pmwiki.php/SVV/Lab6\">do URLs with %20 work</a> <br />\n" +
                    "   </td><td> <img src=\"ye%20s.jpg\" height=\"30px\" />\n" +
                    "   </td></tr>\n" +
                    "\n" +
                    "   <tr><td>  <a href=\"http://labs.cs.upt.ro/~oose/pmwiki.php/SVV/Lab7\">do TXT files work</a> <br />\n" +
                    "   </td><td> \n" +
                    "   </td></tr>\n" +
                    "\n" +
                    "  </center>\n" +
                    "</body>\n" +
                    "</html>";
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
