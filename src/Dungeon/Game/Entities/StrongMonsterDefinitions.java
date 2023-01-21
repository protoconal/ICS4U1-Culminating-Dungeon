package Dungeon.Game.Entities;

import Dungeon.Game.NormalWeightedRandoms;

public class StrongMonsterDefinitions {
  private final NormalWeightedRandoms RANDOM;
  private final Monster[] MONSTERS = new Monster[]{
      new Troll(),
      new Centaur(),
      new Minotaur(),
  };

  public StrongMonsterDefinitions() {
    double[] spawnChances = new double[]{
        1, // Troll
        2, // Centaur
        3, // Minotaur
    };
    this.RANDOM = new NormalWeightedRandoms(spawnChances);
  }

  public Monster generateMonster() {
    return MONSTERS[RANDOM.generateChoice()].returnCopy();
  }

  public abstract static class StrongMonster extends Monster {
    public StrongMonster(String name, int maxHP, int minDamage, int maxDamage, String onAttackText, String onAppearText) {
      super(name, maxHP, minDamage, maxDamage, onAttackText, onAppearText);
    }
  }
}

class Troll extends StrongMonsterDefinitions.StrongMonster {
  public Troll() {
    super("Miles the Troll",
        200, //maxHP
        40, // minDamage
        60, // maxDamage
        "verbs.", // onAttackText
        "x appears!" // onAppearText
    );
  }

  @Override
  public Monster returnCopy() {
    return new Troll();
  }
}

class Centaur extends StrongMonsterDefinitions.StrongMonster {
  public Centaur() {
    super("Fiona the Centaur",
        180, //maxHP
        40, // minDamage
        55, // maxDamage
        "verbs.", // onAttackText
        "x appears!" // onAppearText
    );
  }

  @Override
  public Monster returnCopy() {
    return new Centaur();
  }
}

class Minotaur extends StrongMonsterDefinitions.StrongMonster {
  public Minotaur() {
    super("Klara the Minotaur",
        240, //maxHP
        50, // minDamage
        65, // maxDamage
        "verbs.", // onAttackText
        "x appears!" // onAppearText
    );
  }

  @Override
  public Monster returnCopy() {
    return new Minotaur();
  }
}
