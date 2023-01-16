package Dungeon.Game.Entities;

public abstract class NormalMonster extends Monster {
    public NormalMonster(int maxHP, int minDamage, int maxDamage, String onAttackText, String onAppearText) {
        super(maxHP, minDamage, maxDamage, onAttackText, onAppearText);
    }
}
class HauntedArmour extends NormalMonster {
    public HauntedArmour() {
        super(256, //maxHP
                15, // minDamage
                25, // maxDamage
                "Armour clanks.", // onAttackText
                "A ghostly set of armor appears!" // onAppearText
        );
    }
}

class Ghoul extends NormalMonster {
    public Ghoul() {
        super(1024, //maxHP
                30, // minDamage
                35, // maxDamage
                " verbs.", // onAttackText
                "x appears!" // onAppearText
        );
    }
}

class Cultist extends NormalMonster {
    public Cultist() {
        super(4096, //maxHP
                40, // minDamage
                45, // maxDamage
                "verbs.", // onAttackText
                "x appears!" // onAppearText
        );
    }
}
