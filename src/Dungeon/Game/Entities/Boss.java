package Dungeon.Game.Entities;

public abstract class Boss extends Monster {
    public Boss(int maxHP, int minDamage, int maxDamage, String onAttackText, String onAppearText) {
        super(maxHP, minDamage, maxDamage, onAttackText, onAppearText);
    }
}

class SpiderBroodMother extends Boss {
    public SpiderBroodMother() {
        super(500, //maxHP
                30, // minDamage
                70, // maxDamage
                "verbs.", // onAttackText
                "x appears!" // onAppearText
        );
    }
}

class DarkKnightofTheForgotten extends Boss {
    public DarkKnightofTheForgotten() {
        super(650, //maxHP
                60, // minDamage
                80, // maxDamage
                "verbs.", // onAttackText
                "x appears!" // onAppearText
        );
    }
}

class CorruptedExecutioner extends Boss {
    public CorruptedExecutioner() {
        super(750, //maxHP
                70, // minDamage
                90, // maxDamage
                "verbs.", // onAttackText
                "x appears!" // onAppearText
        );
    }
}

class LichKing extends Boss {
    public LichKing() {
        super(900, //maxHP
                75, // minDamage
                90, // maxDamage
                "verbs.", // onAttackText
                "x appears!" // onAppearText
        );
    }
}

class AldwynTheFallen extends Boss {
    public AldwynTheFallen() {
        super(1000, //maxHP
                80, // minDamage
                100, // maxDamage
                "verbs.", // onAttackText
                "x appears!" // onAppearText
        );
    }
}
