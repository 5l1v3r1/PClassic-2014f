class Polygon {
  public double[] coordinates;
  
  public int pointCount() {
    return coordinates.length / 2;
  }
  
  public boolean containsPoint(double x, double y) {
    if (pointCount() < 3) {
      return false
    } else if (pointCount() == 3) {
      // Use the first point as an anchor
      double x1 = coordinates[2] - coordinates[0];
      double y1 = coordinates[3] - coordinates[1];
      // TODO: the rest of this
    } else {
      // TODO: Check each triangle in the polygon.
    }
  }
  
  /**
   * Take the parallelogram which is anchored at the origin and formed by two
   * vectors, (x1, y1) and (x2, y2). This returns true if (px, py) is contained
   * in that parallelogram or touches its edges.
   */
  public static boolean parallelogramContains(double x1, double y1, double x2,
                                              double y2, double px, double py) {
    double det = x1 * y2 - x2 * y1;
    double c1 = (px * y2 - py * x2) / det;
    double c2 = (-px * y1 + py * x1) / det;
    return c1 >= 0.0 && c1 <= 1.0 && c2 >= 0.0 && c2 <= 1.0
  }
}