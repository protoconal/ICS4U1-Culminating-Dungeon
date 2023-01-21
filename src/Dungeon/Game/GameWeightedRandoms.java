package Dungeon.Game;

import java.util.Random;

/**
 * It generates a random number between 0 and 1, and then it uses a binary search to find the index of
 * the first element in the CDF array that is greater than the random number
 */
public class GameWeightedRandoms {


  // https://stackoverflow.com/a/4463613
  private final Random RAND = new Random();
  private final double[] CDF;
  private final double[] BASE_PROBABILITIES;
  private double[] scaleFactors;
  private double sum;
  private int radius = -1;

  public GameWeightedRandoms(double[] probabilities) {
    this.BASE_PROBABILITIES = probabilities;
    this.CDF = new double[probabilities.length];
    this.scaleFactors = new double[probabilities.length];
    for (int x = 0; x < probabilities.length; x++) {
      this.scaleFactors[x] = 1;
    }
    updateCDF();
  }

// --Commented out by Inspection START (1/12/2023 11:21 PM):
//    public WeightedRandom(double[] probabilities, double[] scalarFactors) {
//        this.BASE_PROBABILITIES = probabilities;
//        this.CDF = new double[probabilities.length];
//        this.scaleFactors = scalarFactors;
//        updateCDF();
//    }
// --Commented out by Inspection STOP (1/12/2023 11:21 PM)

  /**
   * The function updates the CDF array by multiplying each element of the BASE_PROBABILITIES array by
   * the corresponding element of the scaleFactors array, and then adding the result to the
   * runningTotal variable
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
   * We generate a random number between 0 and 1, and then we use a binary search to find the index of
   * the first element in the CDF array that is greater than the random number
   * 
   * @return The index of the choice.
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
   * This function sets the scale factors and radius of the filter
   * 
   * @param radius The radius of the circle.
   * @param scaleFactors The scale factors for each of the Gaussian kernels.
   */
  public void setScaleFactors(int radius, double[] scaleFactors) {
    this.scaleFactors = scaleFactors;
    this.radius = radius;
    updateCDF();
  }

  /**
   * This function returns the radius of the circle
   * 
   * @return The radius of the circle.
   */
  public int getRadius() {
    return this.radius;
  }


    /* double[] chanceTables = {
                0.05, // RegularTile
                0.05, // RegularTile
                0.15,  // WallTile
                0.25, // RegularTile
                0.50  // WallTile
        };
        WeightedRandom weights = new WeightedRandom(chanceTables);
        int[] newWeights = new int[5];
        while (true) {
            int index = weights.generateChoice();
            newWeights[index] += 1;
            if (newWeights[0] % 2000 == 0) {
                double sum = 0;
                for (int newWeight : newWeights) {
                    sum += newWeight;
                }
                System.out.println(newWeights[0] / sum + "\n" +
                        newWeights[1] / sum + "\n" +
                        newWeights[2] / sum + "\n" +
                        newWeights[3] / sum + "\n" +
                        newWeights[4] / sum + "\n");
            }
        }
     */

}
