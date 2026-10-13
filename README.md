# TaskFlow – Spring Boot + HTML + MySQL + Docker

## Yêu cầu
- VPS Ubuntu 22.04/24.04, Docker Engine và Docker Compose plugin
- Cổng TCP 80 mở ở UFW và cloud firewall

## Triển khai
```bash
cp .env.example .env
nano .env  # Đổi cả hai mật khẩu mạnh, không commit file này
sudo docker compose up -d --build
sudo docker compose ps
sudo docker compose logs -f backend
```
Truy cập `http://IP_VPS/`.

## Kiểm tra API
```bash
curl http://localhost/api/tasks
curl -X POST http://localhost/api/tasks -H 'Content-Type: application/json' -d '{"title":"Deploy VPS","completed":false}'
```

## Dừng / cập nhật
```bash
sudo docker compose down
sudo docker compose up -d --build
```
Không dùng `down -v` nếu muốn giữ dữ liệu MySQL.

## Lưu ý
Bản demo dùng HTTP, chưa có xác thực. Không đưa dữ liệu nhạy cảm lên ứng dụng công khai. Khi dùng thật, thêm HTTPS, đăng nhập, phân quyền và backup.
