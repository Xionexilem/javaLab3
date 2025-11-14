public class FractionExtended extends Fraction {
  public FractionExtended(int numerator, int denominator) {
    if (denominator < 0) {
      numerator *= -1;
      denominator *= -1;
    }
    super(numerator, denominator);
  }
}
