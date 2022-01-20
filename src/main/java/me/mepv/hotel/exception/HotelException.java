package me.mepv.hotel.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class HotelException extends RuntimeException {

    public HotelException(String s) {
        super(s);
    }
}
