import ru.mitrakov.fraction.Fraction;
import ru.mitrakov.fraction.FractionExtended;

public class Main {
  public static void main(String[] args) {
    System.out.println(new FractionExtended(3, 5).div(new Fraction(1, -5)));
  }
}