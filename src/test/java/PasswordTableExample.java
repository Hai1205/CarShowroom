//import javax.swing.*;
//import javax.swing.table.DefaultTableCellRenderer;
//import java.awt.*;
//
//public class PasswordTableExample {
//    public static void main(String[] args) {
//        JFrame frame = new JFrame();
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.setSize(400, 300);
//
//        // Dữ liệu mẫu với cột mật khẩu
//        Object[][] data = {
//            {"user1", "password1"},
//            {"user2", "password2"},
//            {"user3", "password3"}
//        };
//
//        // Tên các cột
//        String[] columnNames = {"Username", "Password"};
//
//        // Tạo bảng
//        JTable table = new JTable(data, columnNames);
//
//        // Tạo renderer tùy chỉnh cho cột mật khẩu
//        table.getColumnModel().getColumn(1).setCellRenderer(new PasswordCellRenderer());
//
//        frame.add(new JScrollPane(table));
//        frame.setVisible(true);
//    }
//
//    // Renderer tùy chỉnh để hiển thị mật khẩu dưới dạng dấu *
//    static class PasswordCellRenderer extends DefaultTableCellRenderer {
//        @Override
//        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
//            // Chuyển đổi giá trị thành chuỗi các ký tự '*'
//            if (value != null) {
//                String password = value.toString();
//                String maskedPassword = "*".repeat(password.length());
//                value = maskedPassword; // Gán chuỗi dấu '*' thay cho giá trị gốc
//            }
//            return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
//        }
//    }
//}
