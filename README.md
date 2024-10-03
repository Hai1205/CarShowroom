
# CarShowroom

## Mô tả
CarShowroom là phần mềm quản lý cửa hàng trưng bày và bán các loại xe ô tô từ nhiều hãng khác nhau trên thế giới. Mục tiêu của dự án là giúp cho việc quản lý showroom trở nên thuận tiện, hiệu quả, với các tính năng chính như nhập và bán xe.

## Yêu cầu hệ thống
- Ngôn ngữ lập trình: Java
- IDE: NetBeans
- Cơ sở dữ liệu: MySQL (MySQL Workbench và XAMPP)
- Thư viện Java hỗ trợ (cần được import vào dự án)

## Cài đặt
1. Tải về và cài đặt **XAMPP** để khởi chạy MySQL server.
2. Mở **MySQL Workbench** và kết nối tới MySQL server.
3. Mở folder database và chạy hai file SQL đi kèm dự án:
   - `createDatabase.sql`: Tạo cơ sở dữ liệu cho dự án.
   - `setDatabase.sql`: Khởi tạo bảng và dữ liệu mẫu.
4. Mở dự án trong **NetBeans** và đảm bảo các thư viện cần thiết đã được cấu hình chính xác.

## Cách sử dụng
1. Sau khi cài đặt thành công, chạy dự án bằng cách tìm file `Main.java` trong package `GUI` và chạy hàm main.
2. Tương tác với giao diện để thực hiện các chức năng như nhập xe mới và bán xe.

## Cấu trúc thư mục
Dự án được phát triển dựa trên mô hình 3 lớp:
- **GUI**: Xử lý phần giao diện người dùng, đảm bảo các thao tác được thực hiện dễ dàng.
- **BUS**: Chịu trách nhiệm xử lý logic nghiệp vụ của hệ thống.
- **DTO**: Cầu nối trung gian giữa `BUS` và `DAL`.
- **DAL**: Kết nối với cơ sở dữ liệu, bao gồm việc lấy và cập nhật dữ liệu từ cơ sở dữ liệu.
- Dự án cũng có hai package lưu trữ hình ảnh liên quan đến các loại xe.

## Tác giả
- [github.com/Hai1205](https://github.com/Hai1205)
