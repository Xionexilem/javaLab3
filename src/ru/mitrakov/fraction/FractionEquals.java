package ru.mitrakov.fraction;

public class FractionEquals extends FractionNumber {
    public FractionEquals(int numerator, int denominator) {
        super(numerator, denominator);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return this.numerator == ((FractionEquals) obj).numerator
                && this.denominator == ((FractionEquals) obj).denominator;
    }
}
