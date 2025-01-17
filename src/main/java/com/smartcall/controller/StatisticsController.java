package main.java.com.smartcall.controller;

import com.smartcall.service.CallStatisticsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/stats")
@RequiredArgsConstructor
public class StatisticsController {
    private final CallStatisticsService statisticsService;

    @GetMapping("/user/{userId}")
    public CallStatisticsService.UserStats getUserStats(@PathVariable String userId) {
        return statisticsService.getUserStats(userId);
    }
}