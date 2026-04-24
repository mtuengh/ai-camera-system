# Tài liệu API - Hệ thống AI Camera

### 1. Dashboard Metrics
- **URL:** `/api/metrics`
- **Method:** `GET`
- **Mô tả:** Trả về độ chính xác OCR, số lượng bưu kiện và độ trễ hệ thống.

### 2. Quản lý bưu kiện (OCR & 3D)
- **URL:** `/api/packages`
- **Method:** `GET`
- **Dữ liệu trả về:** Danh sách đối tượng Package (trackingNumber, volume, gateNumber).

### 3. Cảnh báo an toàn
- **URL:** `/api/safety/events`
- **Method:** `GET`
- **Mô tả:** Lấy danh sách các sự kiện xâm nhập vùng cấm (SafetyAlert).
