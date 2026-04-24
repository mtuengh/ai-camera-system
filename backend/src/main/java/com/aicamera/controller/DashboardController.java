#### Dashboard Controller
\`\`\`java
// controller/DashboardController.java
package com.aicamera.controller;

import com.aicamera.model.dto.DashboardMetricsDTO;
import com.aicamera.service.DashboardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/dashboard")
@RequiredArgsConstructor
public class DashboardController {
    
    private final DashboardService dashboardService;
    
    @GetMapping("/metrics")
    public ResponseEntity<DashboardMetricsDTO> getMetrics() {
        return ResponseEntity.ok(dashboardService.getCurrentMetrics());
    }
    
    @GetMapping("/latency")
    public ResponseEntity<List<Map<String, Object>>> getLatencyData() {
        return ResponseEntity.ok(dashboardService.getLatencyData());
    }
    
    @GetMapping("/throughput")
    public ResponseEntity<List<Map<String, Object>>> getThroughputData() {
        return ResponseEntity.ok(dashboardService.getThroughputData());
    }
    
    @GetMapping("/gates/status")
    public ResponseEntity<List<Map<String, Object>>> getGateStatus() {
        return ResponseEntity.ok(dashboardService.getGateStatus());
    }
    
    @GetMapping("/packages/recent")
    public ResponseEntity<List<Map<String, Object>>> getRecentPackages(
            @RequestParam(defaultValue = "15") int limit) {
        return ResponseEntity.ok(dashboardService.getRecentPackages(limit));
    }
}
\`\`\`

