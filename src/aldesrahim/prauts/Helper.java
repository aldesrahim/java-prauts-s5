package aldesrahim.prauts;

import java.text.DecimalFormat;
import java.util.Scanner;

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

    public static String ask(String format, Object... args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.printf(format, args);
            String answer = scanner.nextLine();
            if (answer.isEmpty()) {
                continue;
            }
            return answer;
        }
    }

    public static Integer askInt(String question) {
        Scanner scanner = new Scanner(System.in);
        try {
            while (true) {
                System.out.print(question);
                String answer = scanner.nextLine();
                if (answer.isEmpty()) {
                    continue;
                }
                return Integer.parseInt(answer);
            }
        } catch (NumberFormatException nfe) {
            System.out.println("Input wajib berupa angka");
            return Helper.askInt(question);
        }
    }

    public static String numberFormat(Object val) {
        DecimalFormat formatter = new DecimalFormat("###,###");
        return formatter.format(val);
    }
}
