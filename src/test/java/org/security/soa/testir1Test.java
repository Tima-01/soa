package org.security.soa;

import org.junit.jupiter.api.Test;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

public class testir1Test {

    // ====== 1. ТЕСТЫ ИЗ ЛАБОРАТОРНОЙ ======
    @Test
    void test1_TwoRealRoots() {
        double a = 1.5, b = -3.7, c = 2.2;
        String result = testir1.solveEquation(a, b, c);
        System.out.println("=== test1_TwoRealRoots ===");
        System.out.println("Ввод: a=1.5, b=-3.7, c=2.2");
        System.out.println("Ожидается: два корня x1 ≈ 1.4667, x2 ≈ 1.0000");
        System.out.println("Результат: " + result + "\n");

        assertTrue(result.contains("Дискриминант"));
        assertTrue(result.contains("Два корня: x1 = 1.4667, x2 = 1.0000"));
    }

    @Test
    void test2_OneRoot() {
        double a = 0.5, b = 1.5, c = 1.125;
        String result = testir1.solveEquation(a, b, c);
        System.out.println("=== test2_OneRoot ===");
        System.out.println("Ввод: a=0.5, b=1.5, c=1.125");
        System.out.println("Ожидается: один корень x = -1.5000");
        System.out.println("Результат: " + result + "\n");

        assertTrue(result.contains("Дискриминант"));
        assertTrue(result.contains("Один корень: x = -1.5000"));
    }

    @Test
    void test3_NoRealRoots() {
        double a = 1.0, b = 1.0, c = 1.0;
        String result = testir1.solveEquation(a, b, c);
        System.out.println("=== test3_NoRealRoots ===");
        System.out.println("Ввод: a=1, b=1, c=1");
        System.out.println("Ожидается: нет вещественных корней");
        System.out.println("Результат: " + result + "\n");

        assertTrue(result.contains("Дискриминант"));
        assertTrue(result.contains("Нет вещественных корней"));
    }

    @Test
    void test4_LinearEquation() {
        double a = 0.0, b = 2.5, c = -5.75;
        String result = testir1.solveEquation(a, b, c);
        System.out.println("=== test4_LinearEquation ===");
        System.out.println("Ввод: a=0, b=2.5, c=-5.75");
        System.out.println("Ожидается: линейное уравнение, x = 2.3000");
        System.out.println("Результат: " + result + "\n");

        assertTrue(result.toLowerCase().contains("линейное уравнение"));
        assertTrue(result.contains("Один корень: x = 2.3000"));
    }

    @Test
    void test5_InfiniteSolutions() {
        double a = 0.0, b = 0.0, c = 0.0;
        String result = testir1.solveEquation(a, b, c);
        System.out.println("=== test5_InfiniteSolutions ===");
        System.out.println("Ввод: a=0, b=0, c=0");
        System.out.println("Ожидается: бесконечно много решений");
        System.out.println("Результат: " + result + "\n");

        assertEquals("Бесконечно много решений", result);
    }

    @Test
    void test6_NoSolutions() {
        double a = 0.0, b = 0.0, c = 4.2;
        String result = testir1.solveEquation(a, b, c);
        System.out.println("=== test6_NoSolutions ===");
        System.out.println("Ввод: a=0, b=0, c=4.2");
        System.out.println("Ожидается: нет решений");
        System.out.println("Результат: " + result + "\n");

        assertEquals("Нет решений", result);
    }

    @Test
    void test7_VerySmallNumbers() {
        double a = 1e-9, b = 2e-9, c = 1e-9;
        String result = testir1.solveEquation(a, b, c);
        System.out.println("=== test7_VerySmallNumbers ===");
        System.out.println("Ввод: очень малые числа");
        System.out.println("Ожидается: дискриминант ≈ 0, один корень x ≈ -1");
        System.out.println("Результат: " + result + "\n");

        assertTrue(result.contains("Дискриминант"));
        assertTrue(result.contains("Один корень: x = -1.0000"));
    }

    @Test
    void test8_AccuracyCheck() {
        double a = 1.25, b = -3.5, c = 0.75;
        String result = testir1.solveEquation(a, b, c);
        System.out.println("=== test8_AccuracyCheck ===");
        System.out.println("Ввод: a=1.25, b=-3.5, c=0.75");
        System.out.println("Ожидается: x1 ≈ 2.5662, x2 ≈ 0.2338");
        System.out.println("Результат: " + result + "\n");

        assertTrue(result.contains("Дискриминант"));
        assertTrue(result.contains("Два корня: x1 = 2.5662, x2 = 0.2338"));
    }

    // ====== 2. ТЕСТЫ НА ОСНОВЕ CollectionAssert ======
    @Test
    void test_Collections_EquivalentAndUnique() {
        List<String> list1 = Arrays.asList("alpha", "beta", "gamma");
        List<String> list2 = Arrays.asList("gamma", "beta", "alpha");
        List<String> list3 = new ArrayList<>(Arrays.asList("beta", "gamma", "delta"));

        System.out.println("=== test_Collections_EquivalentAndUnique ===");
        System.out.println("list1: " + list1);
        System.out.println("list2: " + list2);
        System.out.println("list3: " + list3 + "\n");

        assertTrue(list1.containsAll(list2) && list2.containsAll(list1),
                "list1 и list2 должны содержать одинаковые элементы");
        assertFalse(list3.contains("alpha"), "list3 не должен содержать элемент 'alpha'");

        Set<String> unique = new HashSet<>(list3);
        assertEquals(list3.size(), unique.size(), "Все элементы list3 должны быть уникальны");
    }

    // ====== 3. ТЕСТЫ ДЛЯ РАСЧЁТА ДИСКРИМИНАНТА ======
    @Test
    void test_Discriminant_Positive() {
        double a = 1, b = -5, c = 6;
        double expected = 1;
        double actual = testir1.getDiscriminant(a, b, c);

        System.out.println("=== test_Discriminant_Positive ===");
        System.out.println("Ввод: a=1, b=-5, c=6");
        System.out.println("Ожидаемый D = 1");
        System.out.println("Фактический D = " + actual + "\n");

        assertEquals(expected, actual, 0.0001);
    }

    @Test
    void test_Discriminant_Zero() {
        double a = 1, b = 2, c = 1;
        double expected = 0;
        double actual = testir1.getDiscriminant(a, b, c);

        System.out.println("=== test_Discriminant_Zero ===");
        System.out.println("Ввод: a=1, b=2, c=1");
        System.out.println("Ожидаемый D = 0");
        System.out.println("Фактический D = " + actual + "\n");

        assertEquals(expected, actual, 0.0001);
    }

    @Test
    void test_Discriminant_Negative() {
        double a = 1, b = 1, c = 5;
        double expected = -19;
        double actual = testir1.getDiscriminant(a, b, c);

        System.out.println("=== test_Discriminant_Negative ===");
        System.out.println("Ввод: a=1, b=1, c=5");
        System.out.println("Ожидаемый D = -19");
        System.out.println("Фактический D = " + actual + "\n");

        assertEquals(expected, actual, 0.0001);
    }

    @Test
    void test_Discriminant_SmallNumbers() {
        double a = 0.00001, b = 0.00002, c = 0.00001;
        double expected = 0.0;
        double actual = testir1.getDiscriminant(a, b, c);

        System.out.println("=== test_Discriminant_SmallNumbers ===");
        System.out.println("Ввод: очень малые значения");
        System.out.println("Ожидаемый D ≈ 0");
        System.out.println("Фактический D = " + actual + "\n");

        assertEquals(expected, actual, 1e-9);
    }
}
