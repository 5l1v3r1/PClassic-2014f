class GCD {
  
  public static void main(String[] args) {
    ensure(10, 5, 5);
    ensure(5, 10, 5);
    ensure(7, 13, 1);
    ensure(91, 13, 13);
    ensure(13, 91, 13);
    ensure(0, 1, 1);
    ensure(1, 0, 1);
    ensure(14822028, 82091232, 1140156);
    System.out.println("gcd() passed!");
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
  
  public static void ensure(long one, long two, long answer) {
    long got = gcd(one, two);
    if (got != answer) {
      System.out.println("Test failed: gcd(" + one + ", " + two +
          ") = " + answer + ", but got " + got);
      System.exit(1);
    }
  }
  
}