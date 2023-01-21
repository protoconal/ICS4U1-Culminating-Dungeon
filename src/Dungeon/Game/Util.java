package Dungeon.Game;

import java.util.ArrayList;

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

      // if it stops, it's at -1
      // we know that this index would be the right spot for it
      data[index + 1] = key;
    }
  }

  public static void insertionSort(ArrayList<String> data) {

    // insertion sort
    int searchIndex;
    String key;

    for (int x = 1; x < data.size(); x++) {
      key = data.get(x);
      searchIndex = x - 1;

      while (searchIndex >= 0 && key.compareTo(data.get(searchIndex)) > 0) {
        // move each element up one
        data.set(searchIndex + 1, data.get(searchIndex));
        searchIndex--;
      }

      data.set(searchIndex + 1, key);
    }

  }

  /**
   * Reverses a String ArrayList from the given indexes.
   *
   * @param arr   stores an arraylist of strings to be reversed
   * @param start stores start index
   * @param end   stores end index
   */

  public static void reverseArrList(ArrayList<String> arr, int start, int end) {
    do {
      String temp = arr.get(end);
      arr.set(end, arr.get(start));
      arr.set(start, temp);
      start++;
      end--;
    } while (start <= end);
  }

  /**
   * Clears the terminal.
   */
  public static void clearTerminal() {
    System.out.println("\033[H\033[2J");
    System.out.flush();
  }

  public static String[] copyArrayFromIndexes(String[] originalArr, int fromIndex, int toIndex) {
    String[] copyArr = new String[toIndex - fromIndex];
    int y = 0;
    for (int x = fromIndex; x < toIndex; x++) {
      copyArr[y] = originalArr[x];
      y++;
    }

    return copyArr;
  }
}


