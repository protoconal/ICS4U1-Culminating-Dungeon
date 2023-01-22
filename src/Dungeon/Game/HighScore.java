package Dungeon.Game;

import java.io.*;
import java.util.ArrayList;

/**
 * HighScore.
 * Appropriated from Nim.
 *
 * @author Tony Guo
 * @version 1.0
 * @since 1.0
 */
public class HighScore {

  private final ArrayList<String> HIGH_SCORES = new ArrayList<>();

  /** Constructor for HighScore class */
  public HighScore() {
    try {
      this.loadHighScore();
    } catch (IOException err) {
      System.out.println("Something terrible has happened. : " + err);
    }
  }

  /**
   * It takes the high scores from the array list and puts them into a string builder, then returns the
   * string builder as a string
   *
   * @return a string of the high scores.
   */
  public String returnHighScoreText() {
    StringBuilder outString = new StringBuilder();
    for (int x = 0; x < HIGH_SCORES.size(); x++) {
      outString.append("    ")
          .append(HIGH_SCORES.get(x))
          .append("\n");
    }

    if (outString.length() == 0) {
      return ":( Currently None";
    }
    return outString.toString();
  }

  /**
   * Loads the High Score from a text file. The formatting of each score is the
   * same as it is stored, allowing for "lazy storing/loading." The integer
   * maximum is 10 digits long. Therefore, let us store it like... "0000000000 -
   * NAME".
   * Sorts the scores before returning.
   */
  private void loadHighScore() throws IOException {
    BufferedReader read = null;

    try {
      read = new BufferedReader(new FileReader("highscore.txt"));
      String line;
      while ((line = read.readLine()) != null) { // does not read newline characters
        this.HIGH_SCORES.add(line);
      }
    } catch (IOException e) {
      // file probably doesn't exist so create it.
      // scores don't exist either
      writeHighScore();
    } finally {
      if (read != null) {
        read.close();
      }
    }
    sortHighScore();
  }

  /**
   * Sorts the high score list using insertion sort.
   */
  private void sortHighScore() {

    if (this.HIGH_SCORES.size() == 0) {
      return;
    }

    Util.insertionSort(this.HIGH_SCORES);

    // implement sort score by alphabetical
    // the list should be sorted, we only need to reverse the indexes

    String currentElement = this.HIGH_SCORES.get(0).substring(0, 11);
    int max = 0;
    int min = 0;
    // length is one less than size
    int arrayLength = this.HIGH_SCORES.size() - 1;

    for (int x = 0; x < this.HIGH_SCORES.size(); x++) {

      // not equal
      if (!this.HIGH_SCORES.get(x).substring(0, 11).equals(currentElement) ||
          x == arrayLength) {
        currentElement = this.HIGH_SCORES.get(x).substring(0, 11);

        if (x == arrayLength) {
          Util.reverseArrList(this.HIGH_SCORES, min, max);
        } else {
          Util.reverseArrList(this.HIGH_SCORES, min, max - 1);
        }
        min = x;
      }
      max++;
    }
  }

  /**
   * Processes updates to the high score list by grabbing the name and adding one
   * to their score.
   *
   * @param name a string to store the name to update
   */
  public void updateHighScore(String name, int currentScore) {
    name = name.strip();
    // search for name -- linear search
    int index = -1;
    for (int x = 0; x < this.HIGH_SCORES.size(); x++) {
      // "0000000001 - U1", start of name is past character 13
      String currentName = " ";
      try {
        currentName = this.HIGH_SCORES.get(x).substring(13).strip();
      } catch (StringIndexOutOfBoundsException error) {
        // do nothing
      }
      if (currentName.equals(name)) {
        index = x;
        x = this.HIGH_SCORES.size();
      }
    }

    int newScore = currentScore;
    // if the score exists, check if higher
    if (index != -1) {
      String currentScoreString = this.HIGH_SCORES.remove(index);
      // first ten digits are the score
      int score = Integer.parseInt(currentScoreString.substring(0, 10));
      newScore = Math.max(currentScore, score);
    }
    // since it is now an integer, we must convert it back to a string
    // representation (SCORE - NAME)
    // and replace the spaces created with (%10s) to zeros
    this.HIGH_SCORES.add(String.format("%10s", newScore).replace(' ', '0') + " - " + name);

    // finally sort it
    sortHighScore();
  }

  /**
   * Saves the new scores to disk.
   */
  public void writeHighScore() throws IOException {
    sortHighScore();
    BufferedWriter read = null;

    try {
      read = new BufferedWriter(new FileWriter("highscore.txt"));
      read.write(String.join("\n", this.HIGH_SCORES));
    } catch (IOException e) {
      System.out.println("Failed to save high scores.");
    } finally {
      if (read != null) {
        read.close();
      }
    }
  }

}