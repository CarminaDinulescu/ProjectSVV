package webserver.http;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class HttpVersionTest {

    @Test
    void getBestCompatibleVersionExactMatch() {
        HttpVersion version = null;
        try {
            version = HttpVersion.getRequestCompatibleVersion("HTTP/1.1");
        } catch (BadHttpVersionException e) {
            fail();
        }

        assertNotNull(version);
        assertEquals(version, HttpVersion.HTTP_1_1);
    }

    @Test
    void getBestCompatibleVersionBadFormat() {
        HttpVersion version = null;
        try {
            version = HttpVersion.getRequestCompatibleVersion("http/1.1");
            fail();

        } catch (BadHttpVersionException e) {

        }

    }

    @Test
    void getBestCompatibleVersionHigherVersion() {
        HttpVersion version = null;
        try {
            version = HttpVersion.getRequestCompatibleVersion("HTTP/1.1");

            assertNotNull(version);
            assertEquals(version, HttpVersion.HTTP_1_1);

        } catch (BadHttpVersionException e) {

            fail();
        }

    }

}