package Dungeon.Game.Entities;

public abstract class StrongMonster extends Monster {
    public StrongMonster(int maxHP, int minDamage, int maxDamage, String attackText) {
        super(maxHP, minDamage, maxDamage, attackText);
    }
}

class Troll extends StrongMonster {
    private static final String attackText = "";
    public Troll(int maxHP, int minDamage, int maxDamage) {
        super(maxHP, minDamage, maxDamage, attackText);
    }
}

class Centaur extends StrongMonster {
    private static final String attackText = "";
    public Centaur(int maxHP, int minDamage, int maxDamage) {
        super(maxHP, minDamage, maxDamage, attackText);
    }
}

class Minotaur extends StrongMonster {
    private static final String attackText = "";
    public Minotaur(int maxHP, int minDamage, int maxDamage) {
        super(maxHP, minDamage, maxDamage, attackText);
    }
}
