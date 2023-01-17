package Dungeon.Game.Entities;

public abstract class StrongMonster extends Monster {
    public StrongMonster(int maxHP, int minDamage, int maxDamage, String onAttackText, String onAppearText) {
        super(maxHP, minDamage, maxDamage, onAttackText, onAppearText);
    }
}

class Troll extends StrongMonster {
    public Troll() {
        super(200, //maxHP
                30, // minDamage
                60, // maxDamage
                "verbs.", // onAttackText
                "x appears!" // onAppearText
        );
    }
}

class Centaur extends StrongMonster {
    public Centaur() {
        super(180, //maxHP
                40, // minDamage
                55, // maxDamage
                "verbs.", // onAttackText
                "x appears!" // onAppearText
        );
    }
}

class Minotaur extends StrongMonster {
    public Minotaur() {
        super(240, //maxHP
                50, // minDamage
                60, // maxDamage
                "verbs.", // onAttackText
                "x appears!" // onAppearText
        );
    }
}
