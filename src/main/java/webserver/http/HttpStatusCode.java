package webserver.http;

public enum HttpStatusCode {

    /*--- CLIENT ERRORS ---*/

    CLIENT_ERROR_400_BAD_REQUEST(400, "Bad Request"),
    CLIENT_ERROR_401_METHOD_NOT_ALLOWED(400, "Method Not Allowed"),
    CLIENT_ERROR_414_BAD_REQUEST(400, "URI Too Long"),

    /*--- SERVER ERRORS ---*/

    SERVER_ERROR_500_INTERNAL_SERVER_ERROR (500, "Internal Server Error"),
    SERVER_ERROR_501_NOT_IMPLEMENTED (501, "Not Implemented"),
    SERVER_ERROR_503_SERVICE_UNAVAILABLE (503, "Maintenance Server"),
    SERVER_ERROR_505_HTTP_VERSION_NOT_SUPPORTED(505,"Http Version Not Supported"),

    /*--- SERVER STATUS ---*/
    SERVER_STATUS_OK (200, "OK"),
    SERVER_STATUS_STOP (1, "STOP"),
    SERVER_STATUS_EXIT (2, "OK"),
    ;


    public final int STATUS_CODE;
    public final String MESSAGE;

    HttpStatusCode(int STATUS_CODE, String MESSAGE) {
        this.STATUS_CODE = STATUS_CODE;
        this.MESSAGE = MESSAGE;
    }

}
