package Dungeon.Game.Entities;

public abstract class StrongMonster extends Monster {
    public StrongMonster(int maxHP, int minDamage, int maxDamage, String onAttackText, String onAppearText) {
        super(maxHP, minDamage, maxDamage, onAttackText, onAppearText);
    }
}

class Troll extends StrongMonster {
    public Troll() {
        super(0, //maxHP
                0, // minDamage
                0, // maxDamage
                "verbs.", // onAttackText
                "x appears!" // onAppearText
        );
    }
}

class Centaur extends StrongMonster {
    public Centaur() {
        super(0, //maxHP
                0, // minDamage
                0, // maxDamage
                "verbs.", // onAttackText
                "x appears!" // onAppearText
        );
    }
}

class Minotaur extends StrongMonster {
    public Minotaur() {
        super(0, //maxHP
                0, // minDamage
                0, // maxDamage
                "verbs.", // onAttackText
                "x appears!" // onAppearText
        );
    }
}
