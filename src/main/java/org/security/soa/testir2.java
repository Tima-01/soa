package org.security.soa;

import java.util.Scanner;

public class testir2 {
    public static long getFibonacci(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Номер числа не может быть отрицательным");
        }
        if (n > 92) {
            throw new IllegalArgumentException("Слишком большое n, используйте n ≤ 92");
        }
        if (n == 0) return 0;
        if (n == 1) return 1;

        long a = 0, b = 1;
        for (int i = 2; i <= n; i++) {
            long temp = a + b;
            a = b;
            b = temp;
        }
        return b;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Программа вычисления чисел Фибоначчи.");
        System.out.println("Введите номер числа (n) или напишите 'exit' для выхода.");

        while (true) {
            System.out.print("n = ");
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("exit")) {
                System.out.println("Выход из программы...");
                break;
            }

            try {
                int n = Integer.parseInt(input);
                long result = getFibonacci(n);
                System.out.println("F(" + n + ") = " + result);
            } catch (NumberFormatException e) {
                System.out.println("Ошибка: введите целое число или 'exit'.");
            } catch (IllegalArgumentException e) {
                System.out.println("Ошибка: " + e.getMessage());
            }
        }
    }
}
