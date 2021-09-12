package com.company;


public class Calc {

    public static int calc(int a, int b, String operation) {

        int result = 0;
        switch (operation) {
            case "+" -> result = a + b;
            case "-" -> result = a - b;
            case "/" -> result = a / b;
            case "*" -> result = a * b;
            default -> throw new IllegalArgumentException("Не верный знак операции");
        }

        return result;
    }
}