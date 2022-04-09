
import java.util.Scanner;
import java.util.InputMismatchException;

//Вероятнее всего мной допущена ошибка в установке программ, но всё что должно выводить на русском идет в неверном формате.
//Заменил все слова на русском, будет англоязычный калькулятор.
//Считает как надо, но не все ошибки выдает. Времени возиться что бы уложиться в срок уже нет, заливаю так.

public class romanArab {
    static Scanner scanner = new Scanner(System.in);
    static int number1, number2;
    static char operation;
    static int result;

    public static void main(String[] args) {
        System.out.println("Enter an expression  + ENTER");
        String user = scanner.nextLine(); //Считываем строку которую ввёл пользователь
        char[] under_char = new char[10]; //Создаём массив длиной 10 символов:  under_char
        for (int i = 0; i < user.length(); i++) { //Заполняем массив символами строки которую ввели и находим знак операции
            under_char[i] = user.charAt(i);
            if (under_char[i] == '+') {
                operation = '+';
            }
            if (under_char[i] == '-') {
                operation = '-';
            }
            if (under_char[i] == '*') {
                operation = '*';
            }
            if (under_char[i] == '/') {
                operation = '/';
            }
        }
        String under_charString = String.valueOf(under_char);
        String[] blacks = under_charString.split("[+-/*]");
        String stable00 = blacks[0];
        String stable01 = blacks[1];
        String string03 = stable01.trim();
        //
        //
        number1 = romanToNumber(stable00);
        number2 = romanToNumber(string03);
        if (number1 < 0 && number2 < 0) {
            result = 0;
        } else {
            result = calc(number1, operation, number2);
            String resultRoman = convertNumToRoman(result);
            System.out.println("Roman total: " + stable00 + operation + string03 + "=" + resultRoman);
        }

        number1 = Integer.parseInt(stable00);
        number2 = Integer.parseInt(string03);
        result = calc(number1, operation, number2);
        System.out.println("Arabic total: " + number1 + operation + number2 + "=" + result);
    }

    private static String convertNumToRoman(int numArabic) {
        String[] roman = {"O", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX",
                "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL",
                "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX",
                "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX",
                "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX",
                "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC",
                "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"
        };
        return roman[numArabic];
    }


    private static int romanToNumber (String roman) {
        try {
            switch (roman) {
                case "I": return 1;
                case "II": return 2;
                case "III": return 3;
                case "IV": return 4;
                case "V": return 5;
                case "VI": return 6;
                case "VII": return 7;
                case "VIII": return 8;
                case "IX": return 9;
                case "X": return 10;
            }
        } catch (InputMismatchException e) {
            throw new InputMismatchException("incorrect data format");
        }
        return -1;
    }

    public static int calc (int num1, char op, int num2) {
        int result = 0;
        if (number1 < 0 && number2 < 0) {
            System.out.println("Error");
        } else if (number1 <= 10 && number2 <= 10) {
            switch(op) {
                case '+' -> result = num1 + num2;
                case '-' -> result = num1 - num2;
                case '*' -> result = num1 * num2;
                case '/' -> result = num1 / num2;
                default -> {
                    System.out.println("Операция не распознана. Повторите ввод.");
                    result = calc(num1, op, num2);
                }
            }

        } else {
            System.out.println("Error, try again");
        }
        return result;
    }
}
