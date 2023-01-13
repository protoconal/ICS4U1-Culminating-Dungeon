package Dungeon.Game;

import java.util.Random;

/**
 * Utility Class
 */
public class Util {

    public static int index(String[] array, String searchTerm) {
        // linear search
        for (int x = 0; x < array.length; x++) {
            if (array[x].equals(searchTerm)) {
                return x;
            }
        }
        return -1;
    }

    public static double[] copyArrayFromIndexes(double[] originalArr, int fromIndex, int toIndex) {
        double[] copyArr = new double[toIndex - fromIndex];
        int y = 0;
        for (int x = fromIndex; x < toIndex; x++) {
            copyArr[y] = originalArr[x];
            y++;
        }

        return copyArr;
    }

    public static void insertionSort(double[] data) {
        // insertion sort
        int index;
        double key; // value we are comparing with

        // the first element will always be considered sorted, as it has nothing else to compare with
        for (int i = 1; i < data.length; i++) {
            key = data[i];
            index = i - 1;

            // check through each element from the index to the bottom of the list
            while (index >= 0 && key < data[index]) {
                data[index + 1] = data[index]; // move that value right one
                index--;
            }

            // if it stops, its at -1
            // we know that this index would be the right spot for it
            data[index + 1] = key;
        }
    }
    public static void selectionSort(String[] words) {
        //Selection Sort
        int smallestIndex;

        for (int i = 0; i < words.length; i++) { //this is reducing the unsorted portion of the array
            smallestIndex = i; //setting smallestIndex to the first element of the UNSORTED portion of the array
            for (int j = i + 1; j < words.length; j++) {//these are the elements we compared TO
                // smallestIndex to the current element of the array
                if (words[j].compareTo(words[smallestIndex]) < 0) {
                    smallestIndex = j;
                }
            }
            // Swap the smallestIndex to the beginning of the unsorted portion of the array
            String tempVar = words[smallestIndex];
            words[smallestIndex] = words[i];
            words[i] = tempVar;
        }
    }

    public static void selectionSort(String[] words) {
        //Selection Sort
        int smallestIndex;

        for (int i = 0; i < words.length; i++) { //this is reducing the unsorted portion of the array
            smallestIndex = i; //setting smallestIndex to the first element of the UNSORTED portion of the array
            for (int j = i + 1; j < words.length; j++) {//these are the elements we compared TO
                // smallestIndex to the current element of the array
                if (words[j].compareTo(words[smallestIndex]) < 0) {
                    smallestIndex = j;
                }
            }
            // Swap the smallestIndex to the beginning of the unsorted portion of the array
            String tempVar = words[smallestIndex];
            words[smallestIndex] = words[i];
            words[i] = tempVar;
        }
    }

  


    /**
     * Clears the terminal.
     */
    public static void clearTerminal() {
        System.out.println("\033[H\033[2J");
        System.out.flush();
    }

}


