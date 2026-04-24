-- Tạo bảng bưu kiện
CREATE TABLE packages (
    id SERIAL PRIMARY KEY,
    tracking_number VARCHAR(50),
    destination VARCHAR(100),
    length DOUBLE PRECISION,
    width DOUBLE PRECISION,
    height DOUBLE PRECISION,
    volume DOUBLE PRECISION,
    status VARCHAR(20)
);

-- Dữ liệu mẫu để hiển thị lên Dashboard
INSERT INTO packages (tracking_number, destination, length, width, height, volume, status)
VALUES 
('VN98490860', 'TP. Hồ Chí Minh', 65.0, 40.0, 35.0, 91.0, 'PROCESSED'),
('VN12345678', 'Hà Nội', 30.0, 20.0, 15.0, 9.0, 'PENDING');

-- Tạo bảng trạng thái cổng
CREATE TABLE gates (
    id SERIAL PRIMARY KEY,
    name VARCHAR(20),
    status VARCHAR(20),
    processed_count INTEGER
);

INSERT INTO gates (name, status, processed_count)
VALUES ('Gate A1', 'ACTIVE', 1250), ('Gate A2', 'ERROR', 840);
