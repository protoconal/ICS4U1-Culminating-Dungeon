package Dungeon.Game;

import java.util.Random;

public class WeightedRandoms {

    // https://stackoverflow.com/a/4463613
    private final Random RAND = new Random();
    private final double[] CDF;
    private final double[] BASE_PROBABILITIES;
    private double sum;
  
    public WeightedRandoms(double[] probabilities) {
        this.BASE_PROBABILITIES = probabilities;
        this.CDF = new double[probabilities.length];
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
            runningTotal += this.BASE_PROBABILITIES[x];
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
}
