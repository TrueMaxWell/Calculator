package com.company;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {

        System.out.println("Калькулятор");
        System.out.println("Введите пример");
        System.out.println("(Числа и операторы через пробел)");
        Scanner console = new Scanner(System.in);
        if (console.hasNextInt()) {

            int a = console.nextInt();
            String c = console.next();
            int b = console.nextInt();

            if (a > 0 & b > 0 & a < 101 & b < 101) {
                System.out.println(Calc.calc(a, b, c));
                console.close();
            }
         else throw new InputMismatchException("Ошибка! Допускаются числа в диапазоне 1-100 включительно. Перезапустите программу");
    }
         else if (console.hasNextLine()) {

             String a = console.next();
             String c = console.next();
             String b = console.next();

             int A = Roman.RomanNumeral.romanToArabic(a);
             int B = Roman.RomanNumeral.romanToArabic(b);

             if (A > 0 & B > 0 & A < 101 & B < 101) {
                    int d = (Calc.calc(A, B, c));
                    String result = Roman.RomanNumeral.arabicToRoman(d);
                    System.out.println(result);
                    console.close();
             }
             else throw new InputMismatchException("Ошибка! Допускаются числа в диапазоне 1-100 включительно. Перезапустите программу");
        }
    }
}
