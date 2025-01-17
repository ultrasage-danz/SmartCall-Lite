package main.java.com.smartcall.service;

import com.smartcall.model.Call;
import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class CallService {
    private final Map<Long, Call> calls = new ConcurrentHashMap<>();

    public Call initiateCall(String callerId, String receiverId) {
        Call call = new Call();
        call.setCallerId(callerId);
        call.setReceiverId(receiverId);
        call.setStatus("INITIATED");
        calls.put(call.getId(), call);
        return call;
    }

    public Call endCall(Long callId) {
        Call call = calls.get(callId);
        if (call != null) {
            call.setStatus("ENDED");
        }
        return call;
    }
}