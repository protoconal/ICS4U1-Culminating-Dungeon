package Dungeon.Game;

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

  /**
   * Clears the terminal.
   */
  public static void clearTerminal() {
    System.out.println("\033[H\033[2J");
    System.out.flush();
  }

}


