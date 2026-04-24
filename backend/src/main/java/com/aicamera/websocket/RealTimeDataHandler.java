\`\`\`java
// websocket/RealTimeDataHandler.java
package com.aicamera.websocket;

import lombok.RequiredArgsConstructor;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
@RequiredArgsConstructor
public class RealTimeDataHandler {
    
    private final SimpMessagingTemplate messagingTemplate;
    
    @Scheduled(fixedRate = 2000) // Every 2 seconds
    public void sendMetricsUpdate() {
        Map<String, Object> metrics = generateMetrics();
        messagingTemplate.convertAndSend("/topic/metrics", metrics);
    }
    
    @Scheduled(fixedRate = 3000) // Every 3 seconds
    public void sendPackageUpdate() {
        Map<String, Object> packageData = generatePackageData();
        messagingTemplate.convertAndSend("/topic/packages", packageData);
    }
    
    private Map<String, Object> generateMetrics() {
        Map<String, Object> metrics = new HashMap<>();
        metrics.put("totalProcessed", 8734 + (int)(Math.random() * 3));
        metrics.put("accuracy", 99.5 + Math.random() * 0.5);
        metrics.put("avgLatency", 15 + Math.random() * 20);
        metrics.put("errorRate", Math.random() * 0.5);
        return metrics;
    }
    
    private Map<String, Object> generatePackageData() {
        // Generate random package data
        Map<String, Object> pkg = new HashMap<>();
        pkg.put("trackingNumber", "VN" + (long)(Math.random() * 1000000000));
        pkg.put("destination", getRandomDestination());
        pkg.put("status", "success");
        return pkg;
    }
    
    private String getRandomDestination() {
        String[] destinations = {"Hà Nội", "TP.HCM", "Đà Nẵng", "Hải Phòng", "Cần Thơ"};
        return destinations[(int)(Math.random() * destinations.length)];
    }
}
\`\`\`

---
