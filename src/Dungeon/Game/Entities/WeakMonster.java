package Dungeon.Game.Entities;

public abstract class WeakMonster extends Monster {
    public WeakMonster(int maxHP, int minDamage, int maxDamage, String onAttackText, String onAppearText) {
        super(maxHP, minDamage, maxDamage, onAttackText, onAppearText);
    }
}

class Slime extends WeakMonster {
    public Slime() {
        super(0, //maxHP
                0, // minDamage
                0, // maxDamage
                "verbs.", // onAttackText
                "x appears!" // onAppearText
        );
    }
}

class Spider extends WeakMonster {
    public Spider() {
        super(0, //maxHP
                0, // minDamage
                0, // maxDamage
                "verbs.", // onAttackText
                "x appears!" // onAppearText
        );
    }
}

class Skeleton extends WeakMonster {
    public Skeleton() {
        super(0, //maxHP
                0, // minDamage
                0, // maxDamage
                "verbs.", // onAttackText
                "x appears!" // onAppearText
        );
    }
}


