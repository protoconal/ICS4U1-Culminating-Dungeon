package Dungeon.Game;

import Dungeon.Game.Entities.Hero;
import Dungeon.Game.Items.PlayerInventory;

/**
 * The Player class is a subclass of the Hero class, and it has an inventory, a score, and a death
 * reason
 */
public class Player extends Hero {
  public final PlayerInventory INVENTORY = new PlayerInventory();
  private int score = 0;
  private String deathReason;

  public Player() {
    super();
  }

  /**
   * The toString() method returns a string representation of the object
   * 
   * @return The player's current HP, the average damage of the equipped weapon, and the player's
   * score.
   */
  @Override
  public String toString() {
    return "Player - HP: " + this.getCurrentHP() +
        " - AVG DMG: " +
        INVENTORY.getEquippedWeapon().getAvgDamage() +
        " - SCORE: " +
        this.getScore();
  }

  
  /**
   * // Java
   * public int getScore() {
   *     return score;
   *   }
   * 
   * @return The score of the player.
   */
  public int getScore() {
    return score;
  }

  /**
   * This function adds the score parameter to the score variable
   * 
   * @param score The score to add to the current score.
   */
  public void addScore(int score) {
    this.score += score;
  }

  /**
   * // Java
   * public void removeScore(int score) {
   *     this.score -= score;
   *   }
   * 
   * @param score The score to be added to the player's score.
   */
  public void removeScore(int score) {
    this.score -= score;
  }


  /**
   * This function resets the score and HP of the player to 0 and 100 respectively, and resets the
   * inventory
   */
  public void reset() {
    this.score = 0;
    this.resetHP();
    INVENTORY.reset();
  }

  /**
   * It returns the player's inventory
   * 
   * @return The PlayerInventory object.
   */
  public PlayerInventory getInventory() {
    return INVENTORY;
  }

  /**
   * This function returns the death reason of the player
   * 
   * @return The deathReason variable is being returned.
   */
  public String getDeathReason() {
    return deathReason;
  }

  /**
   * This function sets the death reason of the player
   * 
   * @param deathReason The reason the player died.
   */
  public void setDeathReason(String deathReason) {
    this.deathReason = deathReason;
  }
}
