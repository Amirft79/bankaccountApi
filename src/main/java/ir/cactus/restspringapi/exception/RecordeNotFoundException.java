package ir.cactus.restspringapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)

public class RecordeNotFoundException extends Exception{
    @Override
    public String getMessage() {
        return super.getMessage();
    }

    private static final long serialVersionUID = 1L;

    public RecordeNotFoundException(String message) {
        super(message);
    }

    public RecordeNotFoundException(String message, Throwable t) {
        super(message, t);
    }
}
