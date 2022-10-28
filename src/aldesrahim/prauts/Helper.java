package aldesrahim.prauts;

import java.text.DecimalFormat;
import java.util.Scanner;
import java.util.function.Function;

public class Helper {
    public static String strRepeat(String str, Integer len) {
        return String.valueOf(str).repeat(Math.max(0, len));
    }

    public static String ask(String question) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print(question);
            String answer = scanner.nextLine();
            if (answer.isEmpty()) {
                continue;
            }
            return answer;
        }
    }

    public static <T> String ask(String question, Function<T, Boolean> validation) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print(question);
            String answer = scanner.nextLine();
            if (answer.isEmpty() || validation.apply((T) answer).equals(false)) {
                continue;
            }
            return answer;
        }
    }

    public static Double askDouble(String question) {
        Scanner scanner = new Scanner(System.in);
        try {
            while (true) {
                System.out.print(question);
                String answer = scanner.nextLine();
                if (answer.isEmpty()) {
                    continue;
                }
                return Double.parseDouble(answer);
            }
        } catch (NumberFormatException nfe) {
            System.out.println("Input must be numeric");
            return Helper.askDouble(question);
        }
    }

    public static <T> Double askDouble(String question, Function<T, Boolean> validation) {
        Scanner scanner = new Scanner(System.in);
        try {
            while (true) {
                System.out.print(question);
                String answer = scanner.nextLine();
                if (answer.isEmpty() || validation.apply((T) answer).equals(false)) {
                    continue;
                }
                return Double.parseDouble(answer);
            }
        } catch (NumberFormatException nfe) {
            System.out.println("Input must be numeric");
            return Helper.askDouble(question, validation);
        }
    }

    public static Integer askInt(String question) {
        return Helper.askDouble(question).intValue();
    }

    public static <T> Integer askInt(String question, Function<T, Boolean> validation) {
        return Helper.askDouble(question, validation).intValue();
    }

    public static void pause(String text) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(text);
        scanner.nextLine();
    }

    public static void pause() {
        Helper.pause("Press ENTER to continue");
    }

    public static String numberFormat(Object val) {
        DecimalFormat formatter = new DecimalFormat("###,###");
        return formatter.format(val);
    }
}
