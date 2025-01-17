package main.java.com.smartcall.model;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class Call {
    private Long id;
    private String callerId;
    private String receiverId;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private String status; // INITIATED, ONGOING, ENDED
    private Integer duration;
}