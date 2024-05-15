import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите выражение (например, a + b): ");
        String input = scanner.nextLine();

        try {
            String[] parts = input.split(" ");
            if (parts.length != 3 && parts.length != 4) {
                throw new Exception("Неправильный формат выражения");
            }

            String num1 = parts[0].substring(1, parts[0].length() -1);
            String num2 = parts[2].substring(1, parts[2].length() -1);
            char operation = parts[1].charAt(0);

            String result = calculate(num1, num2, operation);

            if (result.length() > 40) {
                result = result.substring(0, 40) + "...";
            }

            System.out.println("Результат: " + result);
        } catch (Exception e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }

    public static String calculate(String num1, String num2, char operation) throws Exception {
        switch (operation) {
            case '+':
                return num1 + num2;
            case '-':
                if (num1.contains(num2)) {
                    return num1.replace(num2, "");
                } else {
                    return num1;
                }
            case '*':
                int s1 = Integer.parseInt(num2);
                if (s1 < 1 || s1 > 10) {
                    throw new Exception("Число должно быть от 1 до 10");
                }
                return num1.repeat(s1);
            case '/':
                s1 = Integer.parseInt(num2);
                if (s1 < 1 || s1 > 10) {
                    throw new Exception("Число должно быть от 1 до 10");
                }
                return num1.substring(0, s1);
            default:
                throw new Exception("Неподдерживаемая операция");
        }
    }
}
