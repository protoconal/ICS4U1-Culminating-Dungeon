package Dungeon.Game.DungeonMap;

import Dungeon.Game.Util;
import java.util.Random;

public class WeightedRandom {


    // https://stackoverflow.com/a/4463613
    final Random rand = new Random();
    private final double[] CDF;
    private double[] ScaleFactors;
    private final double[] BaseProbabilities;
    private double SUM;
    public WeightedRandom(double[] probabilities) {
        this.BaseProbabilities = probabilities;
        this.CDF = new double[probabilities.length];
        this.ScaleFactors = new double[probabilities.length];
        for (int x = 0; x <= probabilities.length; x++) {
            this.ScaleFactors[x] = 1;
        }
        updateCDF();
    }

    public WeightedRandom(double[] probabilities, double[] scalarFactors) {
        this.BaseProbabilities = probabilities;
        this.CDF = new double[probabilities.length];
        this.ScaleFactors = scalarFactors;
        updateCDF();
    }

    private void updateCDF() {
        double runningTotal = 0;
        for (int x = 0; x < this.CDF.length; x++) {
            runningTotal += this.BaseProbabilities[x];
            this.CDF[x] = runningTotal;

            // multiply by scaling
            this.CDF[x] *= this.ScaleFactors[x];
        }
        this.SUM = this.CDF[this.CDF.length - 1];

        Util.insertionSort(this.CDF);
    }

    public int generateChoice() {
        double randomChoice = rand.nextDouble(this.SUM);
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

    public void setScaleFactors(double[] ScaleFactors) {
        this.ScaleFactors = ScaleFactors;
    }


    /** double[] chanceTables = {
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
