class Mod {
  public static void main(String[] args) {
    ensureAdd(2305843009213693950L, 2305843009213693950L, 2305843009213693951L,
      2305843009213693949L);
    ensureAdd(2305843009213693950L, 1, 2305843009213693951L, 0);
    ensureAdd(2305843009213693950L, 1338, 2305843009213693951L, 1337);
    ensureAdd(123, 456, 7, 5);
    System.out.println("add() passed!");
    
    ensureMul(1, 2, 3, 2);
    ensureMul(5, 10, 25, 0);
    ensureMul(8589933361L, 17178531812L, 4294968633L, 948352967L);
    ensureMul(2305843009213693950L, 2305843009213693950L, 2305843009213693951L,
      1);
    System.out.println("mul() passed!");
    
    ensureExp(2, 3, 5, 3);
    ensureExp(2, 3, 9, 8);
    ensureExp(13, 2305843009213693951L, 1000, 237);
    ensureExp(2305843009213693951L, 2305843009213693951L, 1000, 951);
    ensureExp(2, 11234567890L, 5000000000L, 174836224);
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
    // Incase inputs happen to be bigger than the modulus.
    a = a % modulus;
    b = b % modulus;
    
    long result = 0;
    while (b != 0) {
      // If the least significant bit is set, add the current operand
      if ((b & 1) == 1) {
        result = add(result, a, modulus);
      }
      // Double the operand, halve the multiplier
      a = add(a, a, modulus);
      b /= 2;
    }
    return result;
  }
  
  public static long add(long a, long b, long modulus) {
    // Incase inputs happen to be bigger than the modulus.
    a = a % modulus;
    b = b % modulus;
    
    long diff = modulus - a;
    if (diff > b) {
      return a + b;
    } else {
      return b - diff;
    }
  }
  
  static void ensureAdd(long a, long b, long m, long r) {
    long res = add(a, b, m);
    if (res != r) {
      System.out.println("Expected add(" + a + ", " + b + ", " + m + ") == " +
        r + " but it was " + res);
      System.exit(1);
    }
  }
  
  static void ensureMul(long a, long b, long m, long r) {
    long res = mul(a, b, m);
    if (res != r) {
      System.out.println("Expected mul(" + a + ", " + b + ", " + m + ") == " +
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