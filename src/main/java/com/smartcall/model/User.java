package main.java.com.smartcall.model;

import lombok.Data;

@Data
public class User {
    private Long id;
    private String username;
    private String password;
    private String fullName;
    private String status; // ONLINE, OFFLINE, IN_CALL
}