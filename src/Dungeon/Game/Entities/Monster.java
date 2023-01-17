package Dungeon.Game.Entities;

public abstract class Monster extends Entity {
    private final int MIN_DAMAGE;
    private final int MAX_DAMAGE;
    private final String onAttackText; // x verbs you.
    private final String onAppearText; // a blobby creature appears.

    public Monster() {
        super(0);
        this.MIN_DAMAGE = 0;
        this.MAX_DAMAGE = 0;
        this.onAttackText = "";
        this.onAppearText = "";
    }

    public int generateDamage() {
        int damageRange = MAX_DAMAGE - MIN_DAMAGE;
        return (int) (MIN_DAMAGE + Math.random() * damageRange);
    }

    public Monster(int maxHP, int minDamage, int maxDamage, String onAttackText, String onAppearText) {
        super(maxHP);
        this.MIN_DAMAGE = minDamage;
        this.MAX_DAMAGE = maxDamage;
        this.onAttackText = onAttackText;
        this.onAppearText = onAppearText;
    }

    public String getAttackText() {
        return onAttackText;
    }

    public String getAppearText() {
        return onAppearText;
    }
}
