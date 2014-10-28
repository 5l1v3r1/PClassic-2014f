class Vector2 {
  
  public double x;
  public double y;
  
  public Vector2(double _x, double _y) {
    x = _x;
    y = _y;
  }
  
  /**
   * Compute the dot product of two vectors.
   */
  public double dot(Vector2 v) {
    return x * v.x + y * v.y;
  }
  
  /**
   * Compute the magnitude of this vector.
   */
  public double magnitude() {
    return Math.sqrt(dot(this));
  }
  
  /**
   * Return a scaled version of this vector.
   */
  public Vector2 scale(double scaler) {
    return new Vector2(x * scaler, y * scaler);
  }
  
  /**
   * Returns a normalized version of this vector.
   */
  public Vector2 normalize() {
    return scale(1 / magnitude());
  }
  
  /**
   * Project a [point] onto this vector. Returns a scaler multiple of this
   * vector.
   */
  public Vector2 project(Vector2 point) {
    Vector2 normal = normalize();
    return normal.scale(normal.dot(point));
  }
  
  /**
   * Returns the result of subtracting [v] from this vector.
   */
  public Vector2 subtract(Vector2 v) {
    return new Vector2(x - v.x, y - v.y);
  }
  
  /**
   * Returns the result of adding [v] to this vector.
   */
  public Vector2 add(Vector2 v) {
    return new Vector2(x + v.x, y + v.y);
  }
  
  /**
   * Returns a human-readable version of this vector in the format
   * "<x, y>".
   */
  public String toString() {
    return "<" + x + ", " + y + ">";
  }
  
  public static void main(String[] args) {
    // Test dot products
    ensureDot(new Vector2(1, 1), new Vector2(2, 2), 4);
    ensureDot(new Vector2(1, 1), new Vector2(-1, 1), 0);
    ensureDot(new Vector2(3, 4), new Vector2(4, 5), 32);
    // Test magnitudes
    ensureMagnitude(new Vector2(3, 4), 5);
    ensureMagnitude(new Vector2(1, 1), Math.sqrt(2));
    ensureMagnitude(new Vector2(-1, 1), Math.sqrt(2));
    ensureMagnitude(new Vector2(-1, -1), Math.sqrt(2));
    // Test projections
    ensureProjection(new Vector2(1, 1), new Vector2(2, 2), new Vector2(2, 2));
    ensureProjection(new Vector2(1, 1), new Vector2(0, 0), new Vector2(0, 0));
    ensureProjection(new Vector2(1, 1), new Vector2(0, 2), new Vector2(1, 1));
    ensureProjection(new Vector2(1, 1), new Vector2(-1, -1),
        new Vector2(-1, -1));
    ensureProjection(new Vector2(-4, -6), new Vector2(0.5, 4),
        new Vector2(2, 3));
    
    System.out.println("Vector2 passed!");
  }
  
  public static void ensureDot(Vector2 v1, Vector2 v2, double result) {
    double res = v1.dot(v2);
    double diff = (result - res);
    if (diff < -0.0001 || diff > 0.0001) {
      System.out.println(v1 + "*" + v2 + " = " + result + ", but got " + res);
    }
  }
  
  public static void ensureProjection(Vector2 v1, Vector2 v2, Vector2 v3) {
    Vector2 proj = v1.project(v2);
    double diffX = proj.x - v3.x;
    double diffY = proj.y - v3.y;
    if (diffX < -0.0001 || diffX > 0.0001 || diffY < -0.0001 ||
        diffY > 0.0001) {
      System.out.println(v1 + ".project(" + v2 + ") = " + v3 + ", but got " +
          proj);
    }
  }
  
  public static void ensureMagnitude(Vector2 v1, double magnitude) {
    double got = v1.magnitude();
    double diff = magnitude - got;
    if (diff < -0.0001 || diff > 0.0001) {
      System.out.println(v1 + ".magnitude() = " + magnitude + ", but got " + 
          got);
    }
  }
  
}