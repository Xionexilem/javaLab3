package ru.mitrakov.fraction;

public class Fraction {
  protected final int numerator;
  protected final int denominator;

  public Fraction(int numerator, int denominator) {
    if (denominator == 0) {
      throw new IllegalArgumentException("The denominator cannot be equal to zero.");
    }
    this.numerator = numerator;
    this.denominator = denominator;
  }

  public Fraction sum(Fraction other) {
    int newNumerator;
    int newDenominator;
    
    if (this.denominator == other.denominator) {
      newNumerator = this.numerator + other.numerator;
      newDenominator = this.denominator;
    } else {
      newNumerator = this.numerator * other.denominator + other.numerator * this.denominator;
      newDenominator = this.denominator * other.denominator;
    }
    Fraction result = simplify(new Fraction(newNumerator, newDenominator));
    System.out.println(this + " + " + other + " = " + result);
    return result;
  }
  
  public Fraction sum(int other) {
    return sum(new Fraction(other, 1));
  }

  public Fraction sub(Fraction other) {
    int newNumerator;
    int newDenominator;

    if (this.denominator == other.denominator) {
      newNumerator = this.numerator - other.numerator;
      newDenominator = this.denominator;
    } else {
      newNumerator = this.numerator * other.denominator - other.numerator * this.denominator;
      newDenominator = this.denominator * other.denominator;
    }

    Fraction result = simplify(new Fraction(newNumerator, newDenominator));
    System.out.println(this + " - " + other + " = " + result);
    return result;
  }

  public Fraction sub(int other) {
    return sub(new Fraction(other, 1));
  }
  
  public Fraction multi(Fraction other) {
    Fraction result = simplify(new Fraction(this.numerator * other.numerator, this.denominator * other.denominator));
    System.out.println(this + " * " + other + " = " + result);
    return result;
  }
  
  public Fraction multi(int other) {
    return multi(new Fraction(other, 1));
  }
  
  public Fraction div(Fraction other) {
    Fraction result = simplify(new Fraction(this.numerator * other.denominator, this.denominator * other.numerator));
    System.out.println(this + " / " + other + " = " + result);
    return result;
  }
  
  public Fraction div(int other) {
    if (other == 0) {
      throw new IllegalArgumentException("Division by 0 is impossible");
    } else {
      return div(new Fraction(other, 1));
    }
  }
  
  private Fraction simplify(Fraction fraction) {
    int gcd = findGCD(Math.abs(fraction.numerator), Math.abs(fraction.denominator));
    int simplifiedNumerator = fraction.numerator / gcd;
    int simplifiedDenominator = fraction.denominator / gcd;
    
    if (simplifiedDenominator < 0) {
      simplifiedNumerator = -simplifiedNumerator;
      simplifiedDenominator = -simplifiedDenominator;
    }
    
    return new Fraction(simplifiedNumerator, simplifiedDenominator);
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
}
