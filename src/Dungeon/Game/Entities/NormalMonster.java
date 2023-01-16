package Dungeon.Game.Entities;

public abstract class NormalMonster extends Monster {
    public NormalMonster(int maxHP, int minDamage, int maxDamage, String onAttackText, String onAppearText) {
        super(maxHP, minDamage, maxDamage, onAttackText, onAppearText);
    }
}
class HauntedArmour extends NormalMonster {
    public HauntedArmour() {
        super(170, //maxHP
                20, // minDamage
                30, // maxDamage
                "Armour clanks.", // onAttackText
                "A ghostly set of armor appears!" // onAppearText
        );
    }
}
  
class Ghoul extends NormalMonster {
    public Ghoul() {
        super(125, //maxHP
                15, // minDamage
                25, // maxDamage
                " verbs.", // onAttackText
                "x appears!" // onAppearText
        );
    }
}

class Cultist extends NormalMonster {
    public Cultist() {
        super(150, //maxHP
                25, // minDamage
                30, // maxDamage
                "verbs.", // onAttackText
                "x appears!" // onAppearText
        );
    }
}
