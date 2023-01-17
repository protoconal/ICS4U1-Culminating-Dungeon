package Dungeon.Game.Entities;

import Dungeon.Game.WeightedRandoms;

public class BossMonsterDefinitions {

    private final WeightedRandoms rand;
    private final Monster[] monsters = new Monster[]{
            new SpiderBroodMother(),
            new DarkKnightofTheForgotten(),
            new CorruptedExecutioner(),
            new LichKing(),
            new AldwynTheFallen(),
    };

    public BossMonsterDefinitions() {
        double[] spawnChances = new double[]{
                0.40, // SpiderBroodMother
                0.30, // DarkKnightofTheForgotten
                0.20, // CorruptedExecutioner
                0.10, // LichKing
                0.05, // AldwynTheFallen
        };
        this.rand = new WeightedRandoms(spawnChances);
    }

    public Monster generateMonster() {
        return monsters[rand.generateChoice()];
    }

    public abstract static class BossMonster extends Monster {
        public BossMonster(int maxHP, int minDamage, int maxDamage, String onAttackText, String onAppearText) {
            super(maxHP, minDamage, maxDamage, onAttackText, onAppearText);
        }
    }
}

class SpiderBroodMother extends BossMonsterDefinitions.BossMonster {
    public SpiderBroodMother() {
        super(500, //maxHP
                30, // minDamage
                70, // maxDamage
                "verbs.", // onAttackText
                "x appears!" // onAppearText
        );
    }
}

class DarkKnightofTheForgotten extends BossMonsterDefinitions.BossMonster {
    public DarkKnightofTheForgotten() {
        super(650, //maxHP
                60, // minDamage
                80, // maxDamage
                "verbs.", // onAttackText
                "x appears!" // onAppearText
        );
    }
}

class CorruptedExecutioner extends BossMonsterDefinitions.BossMonster {
    public CorruptedExecutioner() {
        super(750, //maxHP
                70, // minDamage
                90, // maxDamage
                "verbs.", // onAttackText
                "x appears!" // onAppearText
        );
    }
}

class LichKing extends BossMonsterDefinitions.BossMonster {
    public LichKing() {
        super(900, //maxHP
                75, // minDamage
                90, // maxDamage
                "verbs.", // onAttackText
                "x appears!" // onAppearText
        );
    }
}

class AldwynTheFallen extends BossMonsterDefinitions.BossMonster {
    public AldwynTheFallen() {
        super(1000, //maxHP
                80, // minDamage
                100, // maxDamage
                "verbs.", // onAttackText
                "x appears!" // onAppearText
        );
    }
}
