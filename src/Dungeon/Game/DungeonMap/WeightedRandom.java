package Dungeon.Game.DungeonMap;

import Dungeon.Game.Util;
import java.util.Random;

public class WeightedRandom {


    // https://stackoverflow.com/a/4463613
    private final Random RAND = new Random();
    private final double[] CDF;
    private final double[] BASE_PROBABILITIES;
    private double[] scaleFactors;
    private double sum;
    private int radius = -1;
  
    public WeightedRandom(double[] probabilities) {
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

    public int generateChoice() {
        double randomChoice = RAND.nextDouble(this.sum);
        // binary search
        int min = 0;
        int max = this.CDF.length - 1;
        while (min < max) {
            int middle = (min + max) / 2;
            if (randomChoice > this.CDF[middle]) {
                min = middle + 1;
            }
            else {
                max = middle;
            }
        }
        return min;
    }

    public void setScaleFactors(int radius, double[] scaleFactors) {
        this.scaleFactors = scaleFactors;
        this.radius = radius;
        updateCDF();
    }

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
