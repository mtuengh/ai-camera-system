\`\`\`java
// model/entity/Package.java
package com.aicamera.model.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Table(name = "packages")
@Data
public class Package {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(unique = true, nullable = false)
    private String trackingNumber;
    
    private String destination;
    private String address;
    
    // Dimensions
    private Double length;
    private Double width;
    private Double height;
    private Double volume;
    private Double weight;
    
    // Status
    @Enumerated(EnumType.STRING)
    private PackageStatus status;
    
    private Integer gateNumber;
    
    @Column(name = "scanned_at")
    private LocalDateTime scannedAt;
    
    @Column(name = "processed_at")
    private LocalDateTime processedAt;
    
    @Column(name = "created_at")
    private LocalDateTime createdAt;
    
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
    
    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
        updatedAt = LocalDateTime.now();
    }
    
    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }
}

enum PackageStatus {
    SCANNED,
    MEASURED,
    INSPECTED,
    SORTED,
    REJECTED,
    COMPLETED
}
\`\`\`
