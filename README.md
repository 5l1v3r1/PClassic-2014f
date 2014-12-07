# Purpose

I am preparing for the 2014 fall [PClassic](http://pclassic.org) competition by implementing some useful math utilities in Java. Some of the stuff I'm implementing would have really come in handy [last year](https://github.com/unixpickle/PClassic-2013f).

**UPDATE**: checkout my [writeup](writeup.md) for this event.

# What's included

So far, I have created APIs for the following:

 * Math
   * GCD (Greatest Common Divisor).
   * LCM (Least Common Multiple).
   * Vector2
     * Dot products; magnitudes; subtraction and addition
     * Vector projection
     * 2x2 systems of equations
   * Factorizor
   * Arithmetic in modular fields without BigInteger
     * Modular addition
     * Modular multiplication
     * Modular exponentiation
   * EEA (Extended Euclidean Algorithm)
     * Linear diophantine equation solver
   * Convex polygon utilities
     * Containment

# TODO:

 * Math
   * Pythagorian triples
   * Polynomial root finder
   * Linear system of equation solver
   * 3D vector utilities
   * Convex polygon utilities
     * Area
     * Perimeter
   * Concave polygon utilities
     * Containment
     * Area
     * Perimeter
   * Probabilistic primality test
   * Discrete logs
   * Fibonacci numbers
   * Gamma function
   * BigInt
     * Numerical base parsing
     * Addition
     * Multiplication
     * Division
     * Subtraction
 * Parsing
   * Roman numerals
   * Polynomials
     * Polynomial long division
   * Time of day & dates
   * Two-dimensional structures
 * Algorithms
   * Breadth-first search
   * Depth-first search
   * Levenshtein distance
   * Knapsack problem
   * Binary search
   * Permutations
     * Permutation parity
     * Cycle breakdown
