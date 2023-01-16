package Dungeon.Game.Entities;

public abstract class WeakMonster extends Monster {
    public WeakMonster(int maxHP, int minDamage, int maxDamage, String onAttackText, String onAppearText) {
        super(maxHP, minDamage, maxDamage, onAttackText, onAppearText);
    }
}

class Slime extends WeakMonster {
    public Slime() {
        super(25, //maxHP
                1, // minDamage
                10, // maxDamage
                "verbs.", // onAttackText
                "x appears!" // onAppearText
        );
    }
}

class Spider extends WeakMonster {
    public Spider() {
        super(45, //maxHP
                5, // minDamage
                15, // maxDamage
                "verbs.", // onAttackText
                "x appears!" // onAppearText
        );
    }
}

class Skeleton extends WeakMonster {
    public Skeleton() {
        super(75, //maxHP
                10, // minDamage
                20, // maxDamage
                "verbs.", // onAttackText
                "x appears!" // onAppearText
        );
    }
}
