package Dungeon.Game.Entities;

import Dungeon.Game.NormalWeightedRandoms;

public class WeakMonsterDefinitions {
  private final NormalWeightedRandoms RANDOM;
  private final Monster[] MONSTERS = new Monster[]{
      new Skeleton(),
      new Slime(),
      new Spider(),
  };

  public WeakMonsterDefinitions() {
    double[] spawnChances = new double[]{
        1, // Skeleton
        2, // Slime
        3, // Spider
    };
    this.RANDOM = new NormalWeightedRandoms(spawnChances);
  }

  public Monster generateMonster() {
    return MONSTERS[RANDOM.generateChoice()];
  }

  public abstract static class WeakMonster extends Monster {
    public WeakMonster(String name, int maxHP, int minDamage, int maxDamage, String onAttackText, String onAppearText) {
      super(name, maxHP, minDamage, maxDamage, onAttackText, onAppearText);
    }
  }
}

class Skeleton extends WeakMonsterDefinitions.WeakMonster {
  public Skeleton() {
    super("Fallen Warrior",
            75, //maxHP
        10, // minDamage
        20, // maxDamage
        "verbs.", // onAttackText
        "x appears!" // onAppearText
    );
  }
}

class Slime extends WeakMonsterDefinitions.WeakMonster {
  public Slime() {
    super("Blobby",
            25, //maxHP
        1, // minDamage
        10, // maxDamage
        "verbs.", // onAttackText
        "x appears!" // onAppearText
    );
  }
}

class Spider extends WeakMonsterDefinitions.WeakMonster {
  public Spider() {
    super("Tiffany the Spider",
            45, //maxHP
        5, // minDamage
        15, // maxDamage
        "verbs.", // onAttackText
        "A creepy crawler appears!" // onAppearText
    );
  }
}
