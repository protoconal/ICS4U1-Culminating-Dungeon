package Dungeon.Game.Entities;

public abstract class Monster extends Entity {
    private final int MIN_DAMAGE;
    private final int MAX_DAMAGE;
    private final String attackText;
    public int randomDamage() {
        int damageRange = MAX_DAMAGE - MIN_DAMAGE;
        return (int) (MIN_DAMAGE + Math.random() * damageRange);
    }

    public Monster(int maxHP, int minDamage, int maxDamage, String attackText) {
        super(maxHP);
        this.MIN_DAMAGE = minDamage;
        this.MAX_DAMAGE = maxDamage;
        this.attackText = attackText;
    }

    public String getAttackText() {
        return attackText;
    }
}
