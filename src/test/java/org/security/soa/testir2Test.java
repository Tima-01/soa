package org.security.soa;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class testir2Test {

    @Test
    public void testBaseCases() {
        System.out.println("Тест базовых случаев:");
        System.out.println("Ввод = 0 | Ожидаемый результат = 0 | Фактический результат = " + testir2.getFibonacci(0));
        System.out.println("Ввод = 1 | Ожидаемый результат = 1 | Фактический результат = " + testir2.getFibonacci(1));

        assertEquals(0, testir2.getFibonacci(0));
        assertEquals(1, testir2.getFibonacci(1));
    }

    @Test
    public void testSmallNumbers() {
        System.out.println("Тест маленьких чисел:");
        System.out.println("Ввод = 2 | Ожидаемый результат = 1 | Фактический результат = " + testir2.getFibonacci(2));
        System.out.println("Ввод = 5 | Ожидаемый результат = 5 | Фактический результат = " + testir2.getFibonacci(5));
        System.out.println("Ввод = 10 | Ожидаемый результат = 55 | Фактический результат = " + testir2.getFibonacci(10));

        assertEquals(1, testir2.getFibonacci(2));
        assertEquals(5, testir2.getFibonacci(5));
        assertEquals(55, testir2.getFibonacci(10));
    }

    @Test
    public void testLargerNumber() {
        System.out.println("Тест большого числа:");
        System.out.println("Ввод = 20 | Ожидаемый результат = 6765 | Фактический результат = " + testir2.getFibonacci(20));

        assertEquals(6765, testir2.getFibonacci(20));
    }

    @Test
    public void testMaxValidInput() {
        System.out.println("Тест максимального допустимого n:");
        System.out.println("Ввод = 92 | Ожидаемый результат = 7540113804746346429 | Фактический результат = " + testir2.getFibonacci(92));

        assertEquals(7540113804746346429L, testir2.getFibonacci(92));
    }

    @Test
    public void testNegativeInput() {
        System.out.println("Тест отрицательного n:");
        try {
            testir2.getFibonacci(-3);
            System.out.println("Ввод = -3 | Ожидаемый результат = Номер числа не может быть отрицательным | Фактический результат = НЕ сработала ошибка!");
        } catch (IllegalArgumentException e) {
            System.out.println("Ввод = -3 | Ожидаемый результат = Номер числа не может быть отрицательным | Фактический результат = Ошибка поймана: " + e.getMessage());
        }

        assertThrows(IllegalArgumentException.class,
                () -> testir2.getFibonacci(-3),
                "Ожидается ошибка при отрицательном n");
    }

    @Test
    public void testTooLargeInput() {
        System.out.println("Тест слишком большого n:");
        try {
            testir2.getFibonacci(93);
            System.out.println("Ввод = 93 | Ожидаемый результат = Слишком большое n, используйте n ≤ 92 | Фактический результат = НЕ сработала ошибка!");
        } catch (IllegalArgumentException e) {
            System.out.println("Ввод = 93 | Ожидаемый результат = Слишком большое n, используйте n ≤ 92 | Фактический результат = Ошибка поймана: " + e.getMessage());
        }

        assertThrows(IllegalArgumentException.class,
                () -> testir2.getFibonacci(93),
                "Ожидается ошибка при слишком большом n");
    }
}
