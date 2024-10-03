/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JTextField;
import java.time.Year;

/**
 *
 * @author ASUS
 */
public class Tool {

    public static String randomID() {
        Random random = new Random();
        long value = random.nextLong() % 10000000000L; // Số ngẫu nhiên từ 0 đến 9999999999
        return String.format("%010d", Math.abs(value));
    }

    public static LocalDate strToDate(String date) {
        return LocalDate.parse(date, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }

    public static boolean isValidDateFormat(String dateStr) {
        try {
            LocalDate.parse(dateStr, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            return true;
        } catch (DateTimeParseException e) {
            return false;
        }
    }

    public static boolean isDouble(String str) {
        try {
            double value = Double.parseDouble(str);
            return value > 0;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static boolean isDiscount(String str) {
        try {
            double value = Double.parseDouble(str);
            return (value > 0 && value < 1);
        } catch (NumberFormatException e) {
            return false;
        }
    }
    
    public static boolean checkMFG(String str) { 
    try {
        int value = Integer.parseInt(str);
        int currentYear = Year.now().getValue();
        return value >= 1885 && value <= currentYear;
    } catch (NumberFormatException e) {
        return false;
    }
}

    public static boolean isInt(String str) {
        try {
            int value = Integer.parseInt(str);
            return value > 0;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static boolean checkPassword(String password) {
        if (password.length() > 200) {
            return false;
        }

        // minimum 6 characters, at least 1 uppercase, atleast 1 number, at least 1 special
        String pattern = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[\\W_]).{6,}$";
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(password);
        return m.matches();
    }

    public static boolean checkUserName(String username) {
        if (username.length() > 200) {
            return false;
        }

        String pattern = "^[a-zA-Z0-9]+$";
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(username);
        return m.matches();
    }

    public static boolean checkPhone(String phone) {
        String pattern = "^(0|\\+84)[1-9]\\d{8}$";
        Pattern regex = Pattern.compile(pattern);
        Matcher matcher = regex.matcher(phone);
        return matcher.matches();
    }

    public static String getCurrentDate() {
        LocalDate currenDate = LocalDate.now();
        return currenDate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }

    public static boolean isName(String name) {
        if (name.length() > 200) {
            return false;
        }

        String pattern = "^[a-zA-Z\\s]+$";
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(name);
        return m.matches();
    }

    public static boolean checkTextField(JTextField textField) {
        return "".equals(textField.getText()) || textField.getText() == null;
    }
}
