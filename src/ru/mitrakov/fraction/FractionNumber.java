package ru.mitrakov.fraction;

public class FractionNumber extends Number {
    protected final int numerator;
    protected final int denominator;

    public FractionNumber(int numerator, int denominator) {
        if (denominator == 0) {
            throw new IllegalArgumentException("The denominator cannot be equal to zero.");
        }
        if (denominator < 0) {
            numerator = -numerator;
            denominator = -denominator;
        }
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public FractionNumber sum(FractionNumber other) {
        int newNumerator;
        int newDenominator;

        if (this.denominator == other.denominator) {
            newNumerator = this.numerator + other.numerator;
            newDenominator = this.denominator;
        } else {
            newNumerator = this.numerator * other.denominator + other.numerator * this.denominator;
            newDenominator = this.denominator * other.denominator;
        }
        FractionNumber result = simplify(new FractionNumber(newNumerator, newDenominator));
        System.out.println(this + " + " + other + " = " + result);
        return result;
    }

    public FractionNumber sum(int other) {
        return sum(new FractionNumber(other, 1));
    }

    public FractionNumber sub(FractionNumber other) {
        int newNumerator;
        int newDenominator;

        if (this.denominator == other.denominator) {
            newNumerator = this.numerator - other.numerator;
            newDenominator = this.denominator;
        } else {
            newNumerator = this.numerator * other.denominator - other.numerator * this.denominator;
            newDenominator = this.denominator * other.denominator;
        }

        FractionNumber result = simplify(new FractionNumber(newNumerator, newDenominator));
        System.out.println(this + " - " + other + " = " + result);
        return result;
    }

    public FractionNumber sub(int other) {
        return sub(new FractionNumber(other, 1));
    }

    public FractionNumber multi(FractionNumber other) {
        FractionNumber result = simplify(new FractionNumber(this.numerator * other.numerator, this.denominator * other.denominator));
        System.out.println(this + " * " + other + " = " + result);
        return result;
    }

    public FractionNumber multi(int other) {
        return multi(new FractionNumber(other, 1));
    }

    public FractionNumber div(FractionNumber other) {
        FractionNumber result = simplify(new FractionNumber(this.numerator * other.denominator, this.denominator * other.numerator));
        System.out.println(this + " / " + other + " = " + result);
        return result;
    }

    public FractionNumber div(int other) {
        if (other == 0) {
            throw new IllegalArgumentException("Division by 0 is impossible");
        } else {
            return div(new FractionNumber(other, 1));
        }
    }

    private FractionNumber simplify(FractionNumber fraction) {
        int gcd = findGCD(Math.abs(fraction.numerator), Math.abs(fraction.denominator));
        int simplifiedNumerator = fraction.numerator / gcd;
        int simplifiedDenominator = fraction.denominator / gcd;

        if (simplifiedDenominator < 0) {
            simplifiedNumerator = -simplifiedNumerator;
            simplifiedDenominator = -simplifiedDenominator;
        }

        return new FractionNumber(simplifiedNumerator, simplifiedDenominator);
    }

    private int findGCD(int a, int b) {
        while (b != 0) {
            int tmp = b;
            b = a %b;
            a = tmp;
        }
        return a;
    }

    @Override
    public String toString() {
        return numerator + "/" + denominator;
    }

    @Override
    public int intValue() {
        return numerator / denominator;
    }

    @Override
    public long longValue() {
        return (long) numerator / denominator;
    }

    @Override
    public float floatValue() {
        return (float) numerator / denominator;
    }

    @Override
    public double doubleValue() {
        return (double) numerator / denominator;
    }
}
