package Dungeon.Game;

import java.util.Random;

/**
 * This GameWeightedRandoms class provides WeightedRandom generation with optional Scaling.
 *
 * @author <a href="https://stackoverflow.com/a/4463613">Sven Marnach</a> + Tony Guo
 * @version 1.0
 * @since 1.0
 */

public class GameWeightedRandoms {


  // https://stackoverflow.com/a/4463613
  private final Random RAND = new Random();
  private final double[] CDF;
  private final double[] BASE_PROBABILITIES;
  private double[] scaleFactors;
  private double sum;
  private int radius = -1;

  /**
   * Constructor for the GameWeightedRandoms class.
   */
  public GameWeightedRandoms(double[] probabilities) {
    this.BASE_PROBABILITIES = probabilities;
    this.CDF = new double[probabilities.length];

    // create new scale factors and set them to zero
    this.scaleFactors = new double[probabilities.length];
    for (int x = 0; x < probabilities.length; x++) {
      this.scaleFactors[x] = 1;
    }
    updateCDF();
  }

  /**
   * Calculates the probability of each element.
   */
  private void updateCDF() {
    double runningTotal = 0;
    for (int x = 0; x < this.CDF.length; x++) {
      // multiply by scaling
      runningTotal += this.BASE_PROBABILITIES[x] * this.scaleFactors[x];
      this.CDF[x] = runningTotal;
    }
    this.sum = runningTotal;

    Util.insertionSort(this.CDF);
  }

  /**
   * Calculate a choice by randomly generating a number and finding the first greater element within the array.
   *
   * @return the choice.
   */
  public int generateChoice() {
    double randomChoice = RAND.nextDouble(this.sum);
    // binary search
    int min = 0;
    int max = this.CDF.length - 1;
    while (min < max) {
      int middle = (min + max) / 2;
      if (randomChoice > this.CDF[middle]) {
        min = middle + 1;
      } else {
        max = middle;
      }
    }
    return min;
  }

  /**
   * Sets the scale factors and radius.
   *
   * @param radius       stores the radius
   * @param scaleFactors stores the probability scaling factors in a double array
   */
  public void setScaleFactors(int radius, double[] scaleFactors) {
    this.scaleFactors = scaleFactors;
    this.radius = radius;
    updateCDF();
  }

  /**
   * @return the radius
   */
  public int getRadius() {
    return this.radius;
  }

}
