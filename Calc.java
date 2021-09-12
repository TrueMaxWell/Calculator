package com.company;


public class Calc {

    public static int calc(int a, int b, String operation) {

        int result = 0;
        switch (operation) {
            case "+" -> result = a + b;
            case "-" -> result = a - b;
            case "/" -> result = a / b;
            case "*" -> result = a * b;
            default -> System.out.println("Ошибка! Программа работает только с одним из операторов (+, -, *, /) Перезапустите программу");
        }
        return result;
    }
}