package ru.mitrakov.fraction;

public class FractionCloneable extends FractionEquals implements Cloneable {

    public FractionCloneable(int numerator, int denominator) {
        super(numerator, denominator);
    }

    @Override
    public FractionCloneable clone() {
        return new FractionCloneable(numerator, denominator);
    }
}
