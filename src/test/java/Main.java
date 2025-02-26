public class Main {
    public static void main(String[] args) {
        String input = "300 triệu VND";
        // Sử dụng replaceAll để giữ lại các ký tự số
        String number = input.replaceAll("[^0-9]", "");
        System.out.println(number);
    }
}
