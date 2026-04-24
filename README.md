# AI CAMERA CONTROL SYSTEM

## Introduction
AI Camera Control System is a smart logistics monitoring system that uses AI-powered cameras to automate package sorting, monitoring, and warehouse operations. The system provides real-time data visualization, camera control, and system configuration through a web-based dashboard.

---

## Technologies Used

### Backend
- Java 17
- Spring Boot 3.2.x
- Spring Security (JWT - planned)
- Spring Data JPA
- WebSocket (real-time updates)
- PostgreSQL / MySQL
- Redis (caching)

### Frontend
- React 18 + TypeScript
- Tailwind CSS
- Recharts (data visualization)
- Vite (build tool)

---

## Project Structure

### Backend

ai-camera-backend/
├── controller/
├── service/
├── repository/
├── model/
├── config/
├── websocket/
└── resources/


### Frontend

ai-camera-system/
├── src/app/
│ ├── App.tsx
│ └── components/
├── styles/
├── package.json
└── vite.config.ts


---

## Main Features

### Dashboard
- Displays key metrics:
  - Total processed packages
  - AI accuracy
  - Processing latency
  - Error rate
- Real-time data updates every few seconds

### Gate Status Monitoring
- Shows status of sorting gates (Active / Waiting / Error)
- Displays processed package count per gate
- Helps detect congestion or system issues

### Package Status Tracking
- Success: correctly scanned and sorted
- Warning: errors such as incorrect OCR or abnormal size
- Helps reduce misclassification and delivery issues

### AI Features
- OCR Recognition: detects tracking codes and addresses
- 3D Measurement: calculates package dimensions
- Defect Detection: identifies damaged packages
- Safety Monitoring: detects unsafe situations
- Edge Processing: reduces latency by processing locally
- Network Monitoring: ensures stable data transmission

### Camera System
- Multiple cameras (OCR, 3D, QC, Safety)
- Real-time status (ACTIVE / STOP)
- Start/Stop recording via API

### System Control & Configuration
- Monitor system modules:
  - Main System
  - OCR Engine
  - Dimension Sensor
  - Defect Detection
  - Safety Monitor
  - Edge Nodes
  - Network
- Adjustable parameters:
  - OCR sensitivity
  - Measurement accuracy
  - Defect threshold
  - Safety radius
- Toggle features:
  - Edge processing
  - Auto restart
  - Alerts

---

## API Endpoints

### Dashboard
- GET /api/dashboard/metrics
- GET /api/dashboard/gates/status
- GET /api/dashboard/packages/recent

### Cameras
- GET /api/cameras
- POST /api/cameras/{id}/recording

### Features
- GET /api/ocr/stats
- GET /api/dimension/measurements
- GET /api/defects/detections
- GET /api/safety/events

---

## How to Run

### Backend
```bash
mvn spring-boot:run
Frontend
npm install
npm run dev

Application runs at:

Backend: http://localhost:8080
Frontend: http://localhost:5173
