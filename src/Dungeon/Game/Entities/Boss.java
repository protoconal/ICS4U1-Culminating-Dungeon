package Dungeon.Game.Entities;

public abstract class Boss extends Monster {
    public Boss(int maxHP, int minDamage, int maxDamage, String onAttackText, String onAppearText) {
        super(maxHP, minDamage, maxDamage, onAttackText, onAppearText);
    }
}

class SpiderBroodMother extends Boss {
    public SpiderBroodMother() {
        super(500, //maxHP
                10, // minDamage
                20, // maxDamage
                "verbs.", // onAttackText
                "x appears!" // onAppearText
        );
    }
}

class DarkKnightofTheForgotten extends Boss {
    public DarkKnightofTheForgotten() {
        super(650, //maxHP
                15, // minDamage
                25, // maxDamage
                "verbs.", // onAttackText
                "x appears!" // onAppearText
        );
    }
}

class CorruptedExecutioner extends Boss {
    public CorruptedExecutioner() {
        super(750, //maxHP
                30, // minDamage
                40, // maxDamage
                "verbs.", // onAttackText
                "x appears!" // onAppearText
        );
    }
}

class LichKing extends Boss {
    public LichKing() {
        super(900, //maxHP
                35, // minDamage
                45, // maxDamage
                "verbs.", // onAttackText
                "x appears!" // onAppearText
        );
    }
}

class AldwynTheFallen extends Boss {
    public AldwynTheFallen() {
        super(1000, //maxHP
                50, // minDamage
                60, // maxDamage
                "verbs.", // onAttackText
                "x appears!" // onAppearText
        );
    }
}
