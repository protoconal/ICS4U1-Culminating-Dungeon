package Dungeon.Game;

import java.util.ArrayList;

/**
 * Utility Class.
 * Some functions appropriated from Nim.
 *
 * @author Tony Guo
 * @version 1.0
 * @since 1.0
 */
public class Util {

  /**
   * Find the searchTerm within an Array using Linear Search
   * <p></p>
   * If not found, return -1;
   *
   * @param array      the array to search
   * @param searchTerm The term you're searching for.
   * @return The index of the search term in the array.
   */
  public static int index(String[] array, String searchTerm) {
    // linear search
    for (int x = 0; x < array.length; x++) {
      if (array[x].equals(searchTerm)) {
        return x;
      }
    }
    return -1;
  }

  /**
   * It takes an array, a starting index, and an ending index, and returns a new array that contains
   * the values from the original array that are between the starting and ending indexes
   *
   * @param originalArr The original array to copy from
   * @param fromIndex   The index of the first element to copy.
   * @param toIndex     The index of the last element to copy.
   * @return The method is returning a copy of the original array.
   */
  public static double[] copyArrayFromIndexes(double[] originalArr, int fromIndex, int toIndex) {
    double[] copyArr = new double[toIndex - fromIndex];
    int y = 0;
    for (int x = fromIndex; x < toIndex; x++) {
      copyArr[y] = originalArr[x];
      y++;
    }

    return copyArr;
  }

  /**
   * We start at the second element in the array, and compare it to the first element. If it's smaller,
   * we move the first element to the right, and then compare the second element to the new first
   * element. We keep doing this until we find an element that's smaller than the second element, or we
   * reach the end of the array. Then we move the second element to the right of the element we found
   *
   * @param data the array to be sorted
   */
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

  /**
   * The function takes an ArrayList of Strings as a parameter and sorts the ArrayList using the
   * insertion sort algorithm
   *
   * @param data the ArrayList to be sorted
   */
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

  /**
   * It takes an array, a starting index, and an ending index, and returns a new array that contains
   * the elements of the original array from the starting index to the ending index
   *
   * @param originalArr The original array to copy from.
   * @param fromIndex   The index of the first element to copy.
   * @param toIndex     The index of the last element to copy.
   * @return A copy of the original array from the specified indexes.
   */
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


