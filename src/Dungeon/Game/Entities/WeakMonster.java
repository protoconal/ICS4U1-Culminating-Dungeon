package Dungeon.Game.Entities;

public abstract class WeakMonster extends Monster {
    public WeakMonster(int maxHP, int minDamage, int maxDamage, String attackText) {
        super(maxHP, minDamage, maxDamage, attackText);
    }
}

class Slime extends WeakMonster {
    private static final String attackText = "";
    public Slime(int maxHP, int minDamage, int maxDamage) {
        super(maxHP, minDamage, maxDamage, attackText);
    }
}

class Spider extends WeakMonster {
    private static final String attackText = "";
    public Spider(int maxHP, int minDamage, int maxDamage) {
        super(maxHP, minDamage, maxDamage, attackText);
    }
}

class Skeleton extends WeakMonster {
    private static final String attackText = "";
    public Skeleton(int maxHP, int minDamage, int maxDamage) {
        super(maxHP, minDamage, maxDamage, attackText);
    }
}


