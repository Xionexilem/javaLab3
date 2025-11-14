package ru.mitrakov.summator;

public class SumNumbers {
    public static double sum(Number... numbers) {
        double result = 0.0;
        for (Number number : numbers) {
            result += number.doubleValue();
        }
        return result;
    }
}
