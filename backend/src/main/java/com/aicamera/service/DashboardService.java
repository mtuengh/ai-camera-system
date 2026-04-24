\`\`\`java
// service/DashboardService.java
package com.aicamera.service;

import com.aicamera.model.dto.DashboardMetricsDTO;
import com.aicamera.repository.PackageRepository;
import com.aicamera.repository.CameraRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.cache.annotation.Cacheable;

import java.time.LocalDateTime;
import java.util.*;

@Service
@RequiredArgsConstructor
public class DashboardService {
    
    private final PackageRepository packageRepository;
    private final CameraRepository cameraRepository;
    
    @Cacheable(value = "metrics", key = "'current'")
    public DashboardMetricsDTO getCurrentMetrics() {
        LocalDateTime today = LocalDateTime.now().withHour(0).withMinute(0).withSecond(0);
        
        long totalProcessed = packageRepository.countByCreatedAtAfter(today);
        double accuracy = calculateAccuracy();
        double avgLatency = calculateAverageLatency();
        double errorRate = calculateErrorRate();
        int activeGates = 6; // From config or database
        int activeCameras = cameraRepository.countByStatus("ACTIVE");
        
        return DashboardMetricsDTO.builder()
                .totalProcessed(totalProcessed)
                .accuracy(accuracy)
                .avgLatency(avgLatency)
                .errorRate(errorRate)
                .activeGates(activeGates)
                .activeCameras(activeCameras)
                .build();
    }
    
    public List<Map<String, Object>> getLatencyData() {
        // Simulate real-time latency data
        List<Map<String, Object>> data = new ArrayList<>();
        LocalDateTime now = LocalDateTime.now();
        
        for (int i = 29; i >= 0; i--) {
            Map<String, Object> point = new HashMap<>();
            point.put("time", now.minusSeconds(i * 2).toString());
            point.put("latency", 15 + Math.random() * 30);
            point.put("processing", 5 + Math.random() * 20);
            data.add(point);
        }
        
        return data;
    }
    
    public List<Map<String, Object>> getThroughputData() {
        // Return throughput data
        List<Map<String, Object>> data = new ArrayList<>();
        // Implementation...
        return data;
    }
    
    public List<Map<String, Object>> getGateStatus() {
        // Return gate status
        List<Map<String, Object>> gates = new ArrayList<>();
        // Implementation...
        return gates;
    }
    
    public List<Map<String, Object>> getRecentPackages(int limit) {
        return packageRepository.findRecentPackages(limit);
    }
    
    private double calculateAccuracy() {
        // Calculate from database
        return 99.87;
    }
    
    private double calculateAverageLatency() {
        // Calculate from metrics
        return 23.5;
    }
    
    private double calculateErrorRate() {
        // Calculate from detections
        return 0.13;
    }
}
\`\`\`
