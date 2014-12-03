class EEA {
  public static void main(String[] args) {
    ensureEEA(1, 2, 1);
    ensureEEA(240, 46, 2);
    ensureEEA(123123123, 456456456, 3003003);
    ensureEEA(123123123, 456456457, 1);
    System.out.println("eea() passed!");
    ensureLinDio(1, 2, 123, true);
    ensureLinDio(240, 46, 2, true);
    ensureLinDio(240, 46, 38, true);
    ensureLinDio(240, 46, 37, false);
    ensureLinDio(123123123, 456456456, 3003003, true);
    ensureLinDio(123123123, 456456456, 6006006, true);
    ensureLinDio(123123123, 456456456, 6006007, false);
    ensureLinDio(123123123, 456456457, 1, true);
    ensureLinDio(123123123, 456456457, 1337, true);
    System.out.println("linDio() passed!");
  }
  
  /**
   * For integers x and y, this returns an array [a, b, gcd(x, y)] such that
   * ax + by = gcd(x, y).
   */
  public static long[] eea(long x, long y) {
    if (x > y) {
      long[] res = eea(y, x);
      long temp = res[0];
      res[0] = res[1];
      res[1] = temp;
      return res;
    }
    
    long a = 1;
    long u = 0; // u is the old a
    
    long b = 0;
    long v = 1; // v is the old b
    
    while (x > 0) {
      // Perform another step
      long quot = y / x;
      
      // Modify the remainder
      long temp = x;
      x = y % x;
      y = temp;
      
      // Modify the x coefficient
      temp = u - quot * a;
      u = a;
      a = temp;
      
      // Modify the y coefficient
      temp = v - quot * b;
      v = b;
      b = temp;
    }
    return new long[] {u, v, y};
  }
  
  /**
   * Finds a solution to the linear diophantine equation: ax + by = z.
   *
   * Returns one possible [a, b] on success, or null if no solution exists.
   */
  public static long[] linDio(long x, long y, long z) {
    long[] res = eea(x, y);
    if (z % res[2] != 0) {
      return null;
    }
    long factor = z / res[2];
    return new long[] {res[0] * factor, res[1] * factor};
  }
  
  static void ensureEEA(long x, long y, long gcd) {
    long[] res = eea(x, y);
    if (res[2] != gcd) {
      System.out.println("Expected eea(" + x + ", " + y + ") to yield GCD=" +
        gcd + " but got GCD=" + res[2]);
      System.exit(1);
    }
    if (res[0] * x + res[1] * y != gcd) {
      System.out.println(res[0] + "*" + x + " + " + res[1] + "*" + y + " != " +
        gcd);
      System.exit(1);
    }
  }
  
  static void ensureLinDio(long x, long y, long z, boolean hasSolution) {
    long[] res = linDio(x, y, z);
    if (!hasSolution) {
      if (res != null) {
        System.out.println("Expected no solution for " + x + "," + y + "," + z);
        System.exit(1);
      }
      return;
    }
    if (res == null) {
      System.out.println("Expected solution for " + x + "," + y + "," + z);
      System.exit(1);
    }
    if (res[0] * x + res[1] * y != z) {
      System.out.println(res[0] + "*" + x + " + " + res[1] + "*" + y + " != " +
        z);
      System.exit(1);
    }
  }
}