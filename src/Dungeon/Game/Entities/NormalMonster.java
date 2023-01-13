package Dungeon.Game.Entities;

public abstract class NormalMonster extends Monster {
    public NormalMonster(int maxHP, int minDamage, int maxDamage, String attackText) {
        super(maxHP, minDamage, maxDamage, attackText);
    }
}
class HauntedArmour extends NormalMonster {
    private static final String attackText = "";
    public HauntedArmour(int maxHP, int minDamage, int maxDamage) {
        super(maxHP, minDamage, maxDamage, attackText);
    }
}

class Ghoul extends NormalMonster {
    private static final String attackText = "";
    public Ghoul(int maxHP, int minDamage, int maxDamage) {
        super(maxHP, minDamage, maxDamage, attackText);
    }
}

class Cultist extends NormalMonster {
    private static final String attackText = "";
    public Cultist(int maxHP, int minDamage, int maxDamage) {
        super(maxHP, minDamage, maxDamage, attackText);
    }
}
