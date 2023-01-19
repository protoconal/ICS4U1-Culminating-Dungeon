package Dungeon.Game;

import java.io.*;
import java.util.ArrayList;
// import java.util.Scanner;

public class Highscore {

  private final ArrayList<String> HIGHSCORES = new ArrayList<>();

  public String[] returnHighScores() {
    String[] highscoreStrings = { ":( Currently None" };
    // replace array with scores if they exist
    if (this.HIGHSCORES.size() != 0) {
      highscoreStrings = this.HIGHSCORES.toArray(new String[0]);
    }
    return highscoreStrings;
  }

  /**
   * Loads the High Score from a text file. The formatting of each score is the
   * same as it is stored, allowing for "lazy storing/loading." The integer
   * maximum is 10 digits long. Therefore, let us store it like... "0000000000 -
   * NAME".
   * Sorts the scores before returning.
   */
  public void loadHighScore() throws IOException {
    BufferedReader read = null;

    try {
      read = new BufferedReader(new FileReader("highscore.txt"));
      String line;
      while ((line = read.readLine()) != null) { // does not read newline characters
        this.HIGHSCORES.add(line);
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
   * Sorts the highscore list using insertion sort.
   */
  private void sortHighScore() {

    if (this.HIGHSCORES.size() == 0) {
      return;
    }

    Util.insertionSort(this.HIGHSCORES);

    // implement sort score by alphabetical
    // the list should be sorted, we only need to reverse the indexes

    String currentElement = this.HIGHSCORES.get(0).substring(0, 11);
    int max = 0;
    int min = 0;
    // length is oneless than size
    int arrayLength = this.HIGHSCORES.size() - 1;

    for (int x = 0; x < this.HIGHSCORES.size(); x++) {

      // not equal
      if (!this.HIGHSCORES.get(x).substring(0, 11).equals(currentElement) ||
          x == arrayLength) {
        currentElement = this.HIGHSCORES.get(x).substring(0, 11);

        if (x == arrayLength) {
          Util.reverseArrList(this.HIGHSCORES, min, max);
        } else {
          Util.reverseArrList(this.HIGHSCORES, min, max - 1);
        }
        min = x;
      }
      max++;
    }
  }

  /**
   * Processes updates to the highscore list by grabbing the name and adding one
   * to their score.
   *
   * @param name a string to store the name to update
   */
  public void updateHighScore(String name, int currentScore) {
    name = name.strip();
    // search for name -- linear search
    int index = -1;
    for (int x = 0; x < this.HIGHSCORES.size(); x++) {
      // "0000000001 - U1", start of name is past character 13
      String currentName = this.HIGHSCORES.get(x).substring(13).strip();
      if (currentName.equals(name)) {
        index = x;
        x = this.HIGHSCORES.size();
      }
    }

    int newScore = 1;
    // if the score exists, check if higher
    if (index != -1) {
      String currentScoreString = this.HIGHSCORES.remove(index);
      // first ten digits are the score
      int score = Integer.parseInt(currentScoreString.substring(0, 10));
      if (currentScore > score) {
        newScore = currentScore;
      }
      else {
        newScore = score;
      }
    }
    // since it is now an integer, we must convert it back to a string
    // representation (SCORE - NAME)
    // and replace the spaces created with (%10s) to zeros
    this.HIGHSCORES.add(String.format("%10s", newScore).replace(' ', '0') + " - " + name);

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
      read.write(String.join("\n", this.HIGHSCORES));
    } catch (IOException e) {
      System.out.println("Failed to save high scores.");
    } finally {
      if (read != null) {
        read.close();
      }
    }
  }

}