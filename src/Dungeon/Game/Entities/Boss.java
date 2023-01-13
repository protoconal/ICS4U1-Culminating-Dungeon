package Dungeon.Game.Entities;

public abstract class Boss extends Monster {
    public Boss(int maxHP, int minDamage, int maxDamage, String onAttackText, String onAppearText) {
        super(maxHP, minDamage, maxDamage, onAttackText, onAppearText);
    }
}

class SpiderBroodMother extends Boss {
    public SpiderBroodMother() {
        super(0, //maxHP
                0, // minDamage
                0, // maxDamage
                "verbs.", // onAttackText
                "x appears!" // onAppearText
        );
    }
}

class DarkKnightofTheForgotten extends Boss {
    public DarkKnightofTheForgotten() {
        super(0, //maxHP
                0, // minDamage
                0, // maxDamage
                "verbs.", // onAttackText
                "x appears!" // onAppearText
        );
    }
}

class CorruptedExecutioner extends Boss {
    public CorruptedExecutioner() {
        super(0, //maxHP
                0, // minDamage
                0, // maxDamage
                "verbs.", // onAttackText
                "x appears!" // onAppearText
        );
    }
}

class LichKing extends Boss {
    public LichKing() {
        super(0, //maxHP
                0, // minDamage
                0, // maxDamage
                "verbs.", // onAttackText
                "x appears!" // onAppearText
        );
    }
}

class AldwynTheFallen extends Boss {
    public AldwynTheFallen() {
        super(0, //maxHP
                0, // minDamage
                0, // maxDamage
                "verbs.", // onAttackText
                "x appears!" // onAppearText
        );
    }
}
