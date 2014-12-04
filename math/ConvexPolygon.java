class ConvexPolygon {
  public static class Point {
    public double x;
    public double y;
    
    Point(double x, double y) {
      this.x = x;
      this.y = y;
    }
    
    Point sub(Point p) {
      return new Point(x - p.x, y - p.y);
    }
  }
  
  public Point[] points = null;
  
  ConvexPolygon() {
  }
  
  ConvexPolygon(double[] coords) {
    points = new Point[coords.length / 2];
    for (int i = 0; i < coords.length / 2; ++i) {
      points[i] = new Point(coords[i * 2], coords[i * 2 + 1]);
    }
  }
  
  public boolean contains(Point p) {
    if (points.length < 3) {
      return false;
    } else if (points.length == 3) {
      // If the point lies within two different parallelograms that can be drawn
      // around this triangle, then the point lies within this triangle.
      
      // Use points[0] as an anchor.
      Point p1 = points[1].sub(points[0]);
      Point p2 = points[2].sub(points[0]);
      Point theP = p.sub(points[0]);
      if (!inParallelogram(p1, p2, theP)) {
        return false;
      }
      
      // Use points[1] as an anchor.
      p1 = points[0].sub(points[1]);
      p2 = points[2].sub(points[1]);
      theP = p.sub(points[1]);
      return inParallelogram(p1, p2, theP);
    } else {
      ConvexPolygon triangle = new ConvexPolygon();
      triangle.points = new Point[3];
      // Loop over every triangle in the polygon. This could be simplified if
      // the points were sorted around the perimeter, but they're not.
      for (int i = 0; i < points.length - 2; ++i) {
        for (int j = i + 1; j < points.length - 1; ++j) {
          for (int k = j + 1; k < points.length; ++k) {
            triangle.points[0] = points[i];
            triangle.points[1] = points[j];
            triangle.points[2] = points[k];
            if (triangle.contains(p)) {
              return true;
            }
          }
        }
      }
      return false;
    }
  }
  
  /**
   * Take the parallelogram which is anchored at the origin and formed by two
   * vectors, p1 and p2, and return whether or not it contains a point p.
   */
  public static boolean inParallelogram(Point p1, Point p2, Point p) {
    double det = p1.x * p2.y - p2.x * p1.y;
    if (det == 0.0) {
      return false;
    }
    double c1 = (p.x * p2.y - p.y * p2.x) / det;
    double c2 = (-p.x * p1.y + p.y * p1.x) / det;
    return c1 >= 0.0 && c1 <= 1.0 && c2 >= 0.0 && c2 <= 1.0;
  }
  
  public static void main(String[] args) {
    testInParallelogram();
    testContains();
  }
  
  static void testInParallelogram() {
    Point p1 = new Point(1, 2);
    Point p2 = new Point(2, 1);
    ensureInParallelogram(p1, p2, new Point(1.5, 1.5), true);
    ensureInParallelogram(p1, p2, new Point(2.9, 2.9), true);
    ensureInParallelogram(p1, p2, new Point(-1, -1), false);
    ensureInParallelogram(p1, p2, new Point(-2.9, -2.9), false);
    ensureInParallelogram(p1, p2, new Point(1, 2.1), false);
    ensureInParallelogram(p1, p2, new Point(2.1, 1), false);
    p1 = new Point(-1.3, 3.7);
    p2 = new Point(7.9, 2.9);
    ensureInParallelogram(p1, p2, new Point(1, 2), true);
    ensureInParallelogram(p1, p2, new Point(5, 2), true);
    ensureInParallelogram(p1, p2, new Point(6, 3), true);
    ensureInParallelogram(p1, p2, new Point(6, 2), false);
    ensureInParallelogram(p1, p2, new Point(7, 2), false);
    ensureInParallelogram(p1, p2, new Point(10, 2), false);
    System.out.println("inParallelogram() passed");
  }
  
  static void ensureInParallelogram(Point p1, Point p2, Point p, boolean res) {
    if (inParallelogram(p1, p2, p) != res) {
      System.out.println("ensureInParallelogram(" + p1 + "," + p2 + "," +
        p + ") should be " + res + " but got " + !res);
      System.exit(1);
    }
  }
  
  static void testContains() {
    // Shape 1
    ConvexPolygon shape = new ConvexPolygon(new double[] {
      4, 3, -1, -1, 1, -1, 2, 3, -2, 2, 3, 0
    });
    ensureOutside(shape, new double[] {
      0, 3, 1, 3, -1, 3, 3, 4, 4, 4, 4, 1, 4, 2, 3, -1,
      2, -2, 0, -2, -2, 0, -1, -2
    });
    ensureInside(shape, new double[] {
      1, 1, 2, 2, -1, 1, -0.5, -0.5, -1, 2, 3, 2, 3, 1, 1, 2,
      0, 0, 0, -1, 0, 1, 1, -1
    });
    // Shape 2
    shape = new ConvexPolygon(new double[] {
      1, 1, 2, 3, 3, 3, 5, 5, 5, 4, 6, 0, 6, 2, 2, 5, 0, 3
    });
    ensureOutside(shape, new double[] {
      0, 0, 0, 1, 0, 4, 1, 0, 1, 5, 2, 0, 2, 6, 3, 0, 3, 6, 4, 0, 4, 6,
      5, 0, 5, 6, 6, -1, 6, 3, 7, 0, 5.5, 0, -1, 0
    });
    ensureInside(shape, new double[] {
      1, 2, 1, 3, 2, 1, 2, 2, 2, 3, 2, 4, 3, 1, 3, 2, 3, 3, 3, 4, 4, 1,
      4, 2, 4, 3, 4, 4, 5, 1, 5, 2, 5, 3, 5, 4, 5.5, 0.5
    });
    System.out.println("contains() passed!");
  }
  
  static void ensureOutside(ConvexPolygon shape, double[] coords) {
    for (int i = 0; i < coords.length / 2; ++i) {
      Point p = new Point(coords[i * 2], coords[i * 2 + 1]);
      if (shape.contains(p)) {
        System.out.println("Shape contains (" + p.x + ", " + p.y + ")");
        System.exit(1);
      }
    }
  }
  
  static void ensureInside(ConvexPolygon shape, double[] coords) {
    for (int i = 0; i < coords.length / 2; ++i) {
      Point p = new Point(coords[i * 2], coords[i * 2 + 1]);
      if (!shape.contains(p)) {
        System.out.println("Shape does not contain (" + p.x + ", " + p.y + ")");
        System.exit(1);
      }
    }
  }
}