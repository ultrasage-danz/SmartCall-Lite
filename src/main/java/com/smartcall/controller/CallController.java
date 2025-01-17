package main.java.com.smartcall.controller;

import com.smartcall.model.Call;
import com.smartcall.service.CallService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/calls")
@RequiredArgsConstructor
public class CallController {
    private final CallService callService;

    @PostMapping("/initiate")
    public Call initiateCall(@RequestParam String callerId, @RequestParam String receiverId) {
        return callService.initiateCall(callerId, receiverId);
    }

    @PostMapping("/{callId}/end")
    public Call endCall(@PathVariable Long callId) {
        return callService.endCall(callId);
    }
}