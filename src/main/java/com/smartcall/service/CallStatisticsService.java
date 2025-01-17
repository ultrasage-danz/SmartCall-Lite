package main.java.com.smartcall.service;

import lombok.Data;
import org.springframework.stereotype.Service;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class CallStatisticsService {
    private final ConcurrentHashMap<String, UserStats> userStats = new ConcurrentHashMap<>();

    @Data
    public static class UserStats {
        private int totalCalls;
        private long totalDuration;
        private int failedCalls;
    }

    public void recordCall(String userId, long duration, boolean successful) {
        userStats.computeIfAbsent(userId, k -> new UserStats())
                .setTotalCalls(userStats.get(userId).getTotalCalls() + 1);
        if (successful) {
            userStats.get(userId).setTotalDuration(
                userStats.get(userId).getTotalDuration() + duration
            );
        } else {
            userStats.get(userId).setFailedCalls(
                userStats.get(userId).getFailedCalls() + 1
            );
        }
    }

    public UserStats getUserStats(String userId) {
        return userStats.getOrDefault(userId, new UserStats());
    }
}