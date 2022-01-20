package me.mepv.hotel.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ApiResponse {

    public static final String HOTEL_CREATED = "created";
    public static final String HOTEL_UPDATED = "updated";
    public static final String HOTEL_DELETED = "deleted";
    private String message;

    public static String message (String s) {
        return String.format("Hotel have been %s" + " successfully", s);
    }
}
