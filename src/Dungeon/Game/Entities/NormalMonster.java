package Dungeon.Game.Entities;

public abstract class NormalMonster extends Monster {
    public NormalMonster(int maxHP, int minDamage, int maxDamage, String onAttackText, String onAppearText) {
        super(maxHP, minDamage, maxDamage, onAttackText, onAppearText);
    }
}
class HauntedArmour extends NormalMonster {
    public HauntedArmour() {
        super(0, //maxHP
                0, // minDamage
                0, // maxDamage
                "Armour clanks.", // onAttackText
                "A ghostly set of armor appears!" // onAppearText
        );
    }
}

class Ghoul extends NormalMonster {
    public Ghoul() {
        super(0, //maxHP
                0, // minDamage
                0, // maxDamage
                " verbs.", // onAttackText
                "x appears!" // onAppearText
        );
    }
}

class Cultist extends NormalMonster {
    public Cultist() {
        super(0, //maxHP
                0, // minDamage
                0, // maxDamage
                "verbs.", // onAttackText
                "x appears!" // onAppearText
        );
    }
}
