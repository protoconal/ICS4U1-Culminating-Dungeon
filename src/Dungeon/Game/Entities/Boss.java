package Dungeon.Game.Entities;

public abstract class Boss extends Monster {
    public Boss(int maxHP, int minDamage, int maxDamage, String attackText) {
        super(maxHP, minDamage, maxDamage, attackText);
    }
}

class SpiderBroodMother extends Boss {
    private static final String attackText = "";
    public SpiderBroodMother(int maxHP, int minDamage, int maxDamage) {
        super(maxHP, minDamage, maxDamage, attackText);
    }
}

class DarkKnightofTheForgotten extends Boss {
    private static final String attackText = "";
    public DarkKnightofTheForgotten(int maxHP, int minDamage, int maxDamage) {
        super(maxHP, minDamage, maxDamage, attackText);
    }
}

class CorruptedExecutioner extends Boss {
    private static final String attackText = "";
    public CorruptedExecutioner(int maxHP, int minDamage, int maxDamage) {
        super(maxHP, minDamage, maxDamage, attackText);
    }
}

class LichKing extends Boss {
    private static final String attackText = "";
    public LichKing(int maxHP, int minDamage, int maxDamage) {
        super(maxHP, minDamage, maxDamage, attackText);
    }
}

class AldwynTheFallen extends Boss {
    private static final String attackText = "";
    public AldwynTheFallen(int maxHP, int minDamage, int maxDamage) {
        super(maxHP, minDamage, maxDamage, attackText);
    }
}
