public class LCM {
  public static void main(String[] args) {
    ensure(21, 6, 42);
    ensure(48, 180, 720);
    ensure(2, 3, 6);
    ensure(50, 51, 50*51);
    System.out.println("Tests passed");
  }

  /**
   * Compute the greatest common denominator between two non-negative integers.
   */
  public static long gcd(long one, long two) {
    if (one < two) {
      return gcd(two, one);
    } else if (two == 0) {
      return one;
    } else {
      one = one % two;
      return gcd(two, one);
    }
  }

  /**
   * Creates the least common multiple of two longs.
   */
  public static long lcm(long one, long two) {
    return (one * two) / gcd(one, two);
  }


  public static void ensure(long one, long two, long answer) {
    long got = lcm(one, two);
    if (got != answer) {
      System.out.println("Test failed: lcm(" + one + ", " + two +
          ") = " + answer + ", but got " + got);
      System.exit(1);
    }
  }

}
