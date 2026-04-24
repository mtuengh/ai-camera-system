\`\`\`java
// model/entity/Camera.java
package com.aicamera.model.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Table(name = "cameras")
@Data
public class Camera {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(unique = true, nullable = false)
    private String cameraId;
    
    private String name;
    private String location;
    
    @Enumerated(EnumType.STRING)
    private CameraType type;
    
    @Enumerated(EnumType.STRING)
    private CameraStatus status;
    
    private Integer fps;
    private String resolution;
    
    private Integer detectionCount;
    
    private Boolean isRecording;
    
    @Column(name = "last_active")
    private LocalDateTime lastActive;
    
    @Column(name = "created_at")
    private LocalDateTime createdAt;
}

enum CameraType {
    OCR,
    DIMENSION_3D,
    QUALITY_CHECK,
    SAFETY
}

enum CameraStatus {
    ACTIVE,
    WARNING,
    OFFLINE
}
\`\`\`
