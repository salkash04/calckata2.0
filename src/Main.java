import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите выражение (например, a + b): ");
        String input = scanner.nextLine();

        try {
            String[] parts = input.split(" ");
            if (parts.length != 3 && parts.length != 4)
            {
                throw new Exception("Неправильный формат выражения");
            }

            String num1 = parts[0].replace("\"", "");
            String num2 = parts[2].replace("\"", "");
            String num3 = parts[2].replace("\"", "");

            char minus = '-';
            char operation = parts[1].charAt(0);
            String result;

            result = (operation == '+' || operation == '*' || operation == '/') ? calculate(num1, num2, num3, operation) : calculate(num1, num2, num3, '-');



            if (operation == '*' || operation == '/')
            {
                if (parts[1].contains("\"")) throw new Exception("Нужно делить или умножать на число");
            }

            if (result.length() > 40)
            {
                result = result.substring(0, 40) + "...";
            }

            System.out.println("Результат: " + result);
        } catch (Exception e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }

    public static String calculate(String num1, String num2, String num3, char operation) throws Exception {
        String result = "";
        switch (operation) {
            case '+':
                result  = "\"" + num1 + num2 + "\"";
                break;
            case '-':
                if (num1.contains(num2))
                {
                    result = "\"" + num1.replace(num2, "") + "\"";
                } else {
                    result = "\"" + num1  + "\"";
                }
                break;
            case '*':
                int s1 = Integer.parseInt(num3);
                if (s1 < 1 || s1 > 10)
                {
                    throw new Exception("Число должно быть от 1 до 10");
                }
                result = "\"" + num1.repeat(s1) + "\"";
                break;
            case '/':
                s1 = Integer.parseInt(num3);
                if (s1 < 1 || s1 > 10)
                {
                    throw new Exception("Число должно быть от 1 до 10");
                }
                result = "\"" + num1.substring(0, s1) + "\"";
                break;
//            default:
//                throw new Exception("Неподдерживаемая операция");
        }
        return result;
    }

}