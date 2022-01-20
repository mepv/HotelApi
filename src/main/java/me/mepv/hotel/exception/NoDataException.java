package me.mepv.hotel.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class NoDataException extends RuntimeException {

    public NoDataException(String s) {
        super(s);
    }
}
