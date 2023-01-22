package Dungeon.Game;

import Dungeon.Game.Entities.Entity;
import Dungeon.Game.Items.ArmourItem;
import Dungeon.Game.Items.ItemInventory;
import Dungeon.Game.Items.PlayerInventory;

/**
 * This Player class represents the player.
 * <p></p>
 * They have an inventory, a score, and a death reason.
 *
 * @author Tony Guo, Emily Ta, Chris Yang, Ilelemwanta Nomaren
 * @version 1.0
 * @since 1.0
 */
public class Player extends Entity {
  private final PlayerInventory INVENTORY = new PlayerInventory();
  private String name;
  private int score = 0;
  private String deathReason;

  public Player() {
    super(100);
    ArmourItem item = (ArmourItem) ItemInventory.returnItemFromId("RustyArmour");
    INVENTORY.setArmour(item);
    this.updateHealth(item);
    INVENTORY.setEquippedWeapon("DullSword");
  }

  /**
   * @return the player's inventory.
   */
  public PlayerInventory getInventory() {
    return INVENTORY;
  }

  /**
   * @return the name our the hero.
   */
  public String getName() {
    return name;
  }

  /**
   * Sets the name of the hero.
   *
   * @param name the name of our player
   */
  public void setName(String name) {
    this.name = name;
  }


  /**
   * @return the score of the player.
   */
  public int getScore() {
    return score;
  }

  /**
   * Adds the given score to our player's score.
   *
   * @param score stores the score to add.
   */
  public void addScore(int score) {
    this.score += score;
  }

  /**
   * Removes the given score from our player's score.
   *
   * @param score stores the score to remove.
   */
  public void removeScore(int score) {
    this.score -= score;
  }

  /**
   * @return the monster's name who killed player.
   */
  public String getDeathReason() {
    return deathReason;
  }

  /**
   * Sets the death reason of the player
   *
   * @param deathReason the monster's name who killed player.
   */
  public void setDeathReason(String deathReason) {
    this.deathReason = deathReason;
  }


  /**
   * Resets the score, HP and inventory to defaults.
   */
  public void reset() {
    this.score = 0;
    this.resetHP();
    INVENTORY.reset();
  }

  /**
   * @return a string representation of the player's current HP, the average damage of the equipped weapon, and the player's score.
   */
  @Override
  public String toString() {
    return "\"" + this.getName() + "\"" +
        " - HP: " + this.getCurrentHP() +
        " - MaxHP: " + this.getMaxHP() +
        " - AVG DMG: " + INVENTORY.getEquippedWeapon().getAvgDamage() +
        " - SCORE: " +
        this.getScore();
  }

  public void updateHealth(ArmourItem armour) {
    super.setArmour(armour);
  }
}
