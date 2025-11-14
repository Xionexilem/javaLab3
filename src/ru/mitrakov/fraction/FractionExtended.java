package ru.mitrakov.fraction;

public class FractionExtended extends Fraction {
    public FractionExtended(int numerator, int denominator) {
        if (denominator < 0) {
            numerator = -numerator;
            denominator = -denominator;
        }
        super(numerator, denominator);
    }

    public FractionExtended sum(Fraction other) {
        Fraction result = super.sum(other);
        return new FractionExtended(result.numerator, result.denominator);
    }

    public FractionExtended sum(int other) {
        return sum(new FractionExtended(other, 1));
    }

    public FractionExtended sub(Fraction other) {
        Fraction result = super.sub(other);
        return new FractionExtended(result.numerator, result.denominator);
    }

    public FractionExtended sub(int other) {
        return sub(new FractionExtended(other, 1));
    }

    public FractionExtended multi(Fraction other) {
        Fraction result = super.multi(other);
        return new FractionExtended(result.numerator, result.denominator);
    }

    public FractionExtended multi(int other) {
        return multi(new FractionExtended(other, 1));
    }

    public FractionExtended div(Fraction other) {
        Fraction result = super.div(other);
        return new FractionExtended(result.numerator, result.denominator);
    }

    public FractionExtended div(int other) {
        return div(new FractionExtended(other, 1));
    }
}
