package Dungeon.Game.DungeonMap;

import Dungeon.Game.Util;
import java.util.Random;

public class WeightedRandom {
    // https://stackoverflow.com/a/4463613

    final Random rand = new Random();
    private final double[] CDF;
    private final double SUM;
    public WeightedRandom(double[] probabilities) {
        this.CDF = new double[probabilities.length];

        double runningTotal = 0;
        for (int x = 0; x < probabilities.length; x++) {
            runningTotal += probabilities[x];
            this.CDF[x] = runningTotal;
        }
        this.SUM = this.CDF[probabilities.length - 1];

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
