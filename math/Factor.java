import java.util.ArrayList;

class Factor {
  public static void main(String[] args) {
    ensureFactor(1337, 7);
    ensureFactor(191, 191);
    ensureFactor(191, 191);
    ensureFactor(123819729312313L, 257);
    ensureFactor(481788830009L, 481788830009L);
    ensureFactor(104729L * 104729L, 104729L);
    System.out.println("smallestPrimeFactor() passed!");
    ensureFactors(1337, new long[] {7, 191});
    ensureFactors(1337, new long[] {7, 191});
    ensureFactors(104729L * 104729L, new long[] {104729L, 104729L});
    ensureFactors(25116328125L, new long[] {3, 3, 3, 3, 3, 3, 3, 3,
      5, 5, 5, 5, 5, 5, 5, 7, 7});
    System.out.println("factorize() passed!");
  }

  /**
   * Finds the smallest prime factor of a number.
   *
   * If the number is prime, it will be returned.
   */
  public static long smallestPrimeFactor(long num) {
    long squareRoot = (long)Math.ceil(Math.sqrt((double)num));
    for (long i = 2; i <= squareRoot; ++i) {
      if (num % i == 0) {
        return i;
      }
    }
    return num;
  }

  /**
   * Returns a list of a number's factors.
   *
   * The result is sorted in ascending order.
   */
  public static long[] factorize(long num) {
    ArrayList<Long> nums = new ArrayList<Long>();
    while (true) {
      long res = smallestPrimeFactor(num);
      nums.add(new Long(res));
      if (res == num) {
        break;
      }
      num /= res;
    }
    long[] list = new long[nums.size()];
    for (int i = 0; i < nums.size(); ++i) {
      list[i] = nums.get(i).longValue();
    }
    return list;
  }

  static void ensureFactor(long num, long factor) {
    long res = smallestPrimeFactor(num);
    if (res != factor) {
      System.out.println("expected smallestPrimeFactor(" + num + ") to be " +
        factor + " got " + res);
      System.exit(1);
    }
  }

  static void ensureFactors(long num, long[] factors) {
    long[] res = factorize(num);
    if (res.length != factors.length) {
      System.out.println("expected factorize(" + num + ") to be " +
        factors + " but got " + res);
      System.exit(1);
    }
    for (int i = 0; i < res.length; ++i) {
      if (res[i] != factors[i]) {
        System.out.println("expected factorize(" + num + ") to be " +
          factors + " but got " + res);
        System.exit(1);
      }
    }
  }
}

