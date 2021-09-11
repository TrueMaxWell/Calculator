package com.company;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        System.out.println("Калькулятор");
        System.out.println("Введите пример");
        System.out.println("(Цифры и операторы через пробел)");
        Scanner console = new Scanner(System.in);
        if (console.hasNextInt())
        {
            int a = console.nextInt();
            String c = console.next();
            int b = console.nextInt();
            String d;
            String e;
            double de;

            if (a > 0 & b > 0 & a < 101 & b < 101)
            {

                switch (c) {
                    case "+" -> System.out.println("Решение: " + (a + b)); //тут честно говоря сама среда разработки предложила мне изменить
                    case "-" -> System.out.println("Решение: " + (a - b)); // изначально у меня был вид - if -> else if -> else if и т.д.
                    case "/" -> {
                        d = ("" + a);                               // а тут хз, решил преобразовать int в string а потом в double чтобы получить результат при делении с остатком
                        double D = Double.parseDouble(d);           // уверен есть способ проще, но пока что так)
                        e = ("" + b);
                        double E = Double.parseDouble(e);
                        de = (D/E);
                            System.out.println("Решение: " + (de));
                    }
                    case "*" -> System.out.println("Решение: " + (a * b));
                    default -> System.out.println("Ошибка! Программа работает только с одним из операторов (+, -, *, /) Перезапустите программу");
                }
                console.close();

            }
            else System.out.println("Ошибка! Допускаются числа в диапазоне 1-100 включительно. Перезапустите программу");
        }
         else if (console.hasNextLine()) {

            enum RomanNumeral {                                                     // сам алгоритм преобразования взял из лекции которую нашел, убрал то что посчитал лишним
                I(1), IV(4), V(5), IX(9), X(10),
                XL(40), L(50), XC(90), C(100),
                CD(400), D(500), CM(900), M(1000);

                private int value;

                RomanNumeral(int value) {
                    this.value = value;
                }

                public int getValue() {
                    return value;
                }

                public static List<RomanNumeral> getReverseSortedValues() {
                    return Arrays.stream(values())
                            .sorted(Comparator.comparing((RomanNumeral e) -> e.value).reversed())
                            .collect(Collectors.toList());
                }

                public static int romanToArabic(String input) {
                    String romanNumeral = input.toUpperCase();
                    int result = 0;

                    List<RomanNumeral> romanNumerals = RomanNumeral.getReverseSortedValues();

                    int i = 0;

                    while ((romanNumeral.length() > 0) && (i < romanNumerals.size())) {
                        RomanNumeral symbol = romanNumerals.get(i);
                        if (romanNumeral.startsWith(symbol.name())) {
                            result += symbol.getValue();
                            romanNumeral = romanNumeral.substring(symbol.name().length());
                        } else {
                            i++;
                        }
                    }

                    return result;
                }
                public static String arabicToRoman(int number) {

                    List<RomanNumeral> romanNumerals = RomanNumeral.getReverseSortedValues();

                    int i = 0;
                    StringBuilder sb = new StringBuilder();

                    while ((number > 0) && (i < romanNumerals.size())) {
                        RomanNumeral currentSymbol = romanNumerals.get(i);
                        if (currentSymbol.getValue() <= number) {
                            sb.append(currentSymbol.name());
                            number -= currentSymbol.getValue();
                        } else {
                            i++;
                        }
                    }

                    return sb.toString();
                }
            }

                String a = console.next();
                String c = console.next();
                String b = console.next();

                int A = RomanNumeral.romanToArabic(a);
                int B = RomanNumeral.romanToArabic(b);

                if (A > 0 & B > 0 & A < 101 & B < 101) {

                    switch (c) {
                        case "+" -> {
                            int d = (A + B);
                            String result = RomanNumeral.arabicToRoman(d);
                            System.out.println(result);
                        }
                        case "-" -> {
                            int d = (A - B);
                            String result = RomanNumeral.arabicToRoman(d);
                            System.out.println(result);
                        }
                        case "/" -> {
                            int d = (A / B);
                            String result = RomanNumeral.arabicToRoman(d);
                            System.out.println(result);
                        }
                        case "*" -> {
                            int d = (A * B);
                            String result = RomanNumeral.arabicToRoman(d);
                            System.out.println(result);
                        }
                        default -> System.out.println("Ошибка! Программа работает только с одним из операторов (+, -, *, /) Перезапустите программу");
                    }
                    console.close();
                }
                else System.out.println("Ошибка!");







        }








    }
}
