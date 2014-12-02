import java.math.BigInteger;

class Mod {
  public static void main(String[] args) {
    ensureMul(1, 2, 3, 2);
    ensureMul(5, 10, 25, 0);
    ensureMul(8589933361L, 17178531812L, 4294968633L, 948352967L);
    System.out.println("mul() passed!");
    ensureExp(2, 3, 5, 3);
    ensureExp(2, 3, 9, 8);
    ensureExp(2L, 11234567890L, 5000000000L, 174836224L);
    System.out.println("exp() passed!");
  }
  
  public static long exp(long base, long power, long modulus) {
    // Incase the base is bigger than the modulus
    base = base % modulus;
    
    long result = 1;
    while (power != 0) {
      // If the least significant bit is set, multiply by the current base.
      if ((power & 1) == 1) {
        result = mul(result, base, modulus);
      }
      // Square the base, halve the power.
      base = mul(base, base, modulus);
      power /= 2;
    }
    return result;
  }
  
  public static long mul(long a, long b, long modulus) {
    // TODO: rewrite this without using BigInteger
    BigInteger n1 = BigInteger.valueOf(a);
    BigInteger n2 = BigInteger.valueOf(b);
    BigInteger n3 = BigInteger.valueOf(modulus);
    BigInteger product = n1.multiply(n2);
    BigInteger result = product.mod(n3);
    return result.longValue();
  }
  
  static void ensureMul(long a, long b, long m, long r) {
    long res = mul(a, b, m);
    if (res != r) {
      System.out.println("Expected mod(" + a + ", " + b + ", " + m + ") == " +
        r + " but it was " + res);
      System.exit(1);
    }
  }
  
  static void ensureExp(long a, long b, long m, long r) {
    long res = exp(a, b, m);
    if (res != r) {
      System.out.println("Expected exp(" + a + ", " + b + ", " + m + ") == " +
        r + " but it was " + res);
      System.exit(1);
    }
  }
}