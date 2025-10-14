package org.security.soa;

import java.util.Locale;
import java.util.Scanner;

public class testir1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("a*x^2 + b*x + c = 0");
            System.out.println("Введите коэффициенты (или 'q' для выхода)");

            double a = readCoefficient(sc, "a");
            if (Double.isNaN(a)) break;

            double b = readCoefficient(sc, "b");
            if (Double.isNaN(b)) break;

            double c = readCoefficient(sc, "c");
            if (Double.isNaN(c)) break;

            String result = solveEquation(a, b, c);
            System.out.println(result);
            System.out.println();
        }

        System.out.println("Программа завершена.");
    }


    public static double getDiscriminant(double a, double b, double c) {
        return b * b - 4 * a * c;
    }


    private static double readCoefficient(Scanner sc, String name) {
        while (true) {
            System.out.print("Введите " + name + ": ");
            String input = sc.next();
            if (input.equalsIgnoreCase("q")) return Double.NaN;

            try {
                double value = Double.parseDouble(input);

                if (Math.abs(value) > 20000) {
                    System.out.println("Ошибка: число должно быть в пределах [-20000, 20000]. Попробуйте снова.");
                    continue;
                }

                return value;
            } catch (NumberFormatException e) {
                System.out.println("Ошибка: введите корректное число.");
            }
        }
    }

    public static String solveEquation(double a, double b, double c) {
        if (a == 0 && b == 0 && c == 0) {
            return "Бесконечно много решений";
        }
        if (a == 0 && b == 0) {
            return "Нет решений";
        }
        if (a == 0) {
            double x = -c / b;
            return String.format(Locale.US,
                    "Дискриминант не вычисляется (линейное уравнение)%nОдин корень: x = %.4f", x);
        }

        double D = getDiscriminant(a, b, c);
        StringBuilder sb = new StringBuilder();
        sb.append(String.format(Locale.US, "Дискриминант: D = %.4f%n", D));

        if (D > 0) {
            double x1 = (-b + Math.sqrt(D)) / (2 * a);
            double x2 = (-b - Math.sqrt(D)) / (2 * a);
            sb.append(String.format(Locale.US, "Два корня: x1 = %.4f, x2 = %.4f", x1, x2));
        } else if (D == 0) {
            double x = -b / (2 * a);
            sb.append(String.format(Locale.US, "Один корень: x = %.4f", x));
        } else {
            sb.append("Нет вещественных корней");
        }

        return sb.toString();
    }
}
