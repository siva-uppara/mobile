package fi.cgi.hrtime.microservice.mobile.exception;

@SuppressWarnings("serial")
public class MobileNotFoundException
        extends
        Exception {

    public MobileNotFoundException(String message) {
        super(message);
    }
}
