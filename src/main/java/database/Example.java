package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Example {
    public static void main(String[] args) {
        // Thông tin kết nối
        String url = "jdbc:mariadb://localhost:3306/shopPT"; // Thay thế bằng URL kết nối MariaDB của bạn
        String username = "root"; // Thay thế bằng tên người dùng của bạn
        String password = "123"; // Thay thế bằng mật khẩu của bạn

        // Kết nối và kiểm tra
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            System.out.println("Kết nối thành công đến MariaDB!");
        } catch (SQLException e) {
            System.out.println("Kết nối thất bại đến MariaDB: " + e.getMessage());
        }
    }
}