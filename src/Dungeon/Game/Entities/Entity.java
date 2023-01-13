package Dungeon.Game.Entities;

import Dungeon.Game.Items.HealthItem;
import Dungeon.Game.Items.WeaponItem;

public abstract class Entity implements Attackable {
    private final int MAX_HP;
    private int currentHP;
    private boolean isDead;

    public Entity(int maximumHP) {
        this.MAX_HP = maximumHP;
        this.currentHP = maximumHP;
        this.isDead = false;
    }

    @Override
    public void heal(HealthItem health) {
        int newHealth = this.currentHP + health.getRestoreHP();
        if (newHealth > MAX_HP) {
            this.currentHP = MAX_HP;
            return;
        }
        this.currentHP = newHealth;
    }

    @Override
    public boolean revive(HealthItem health) {
        this.isDead = true;
        return true;
    }

    @Override
    public boolean damage(WeaponItem weapon) {
        int newHealth = this.currentHP - weapon.randomDamage();
        if (newHealth < 0) {
            this.currentHP = 0;
            this.isDead = true;
            return true;
        }
        this.currentHP = newHealth;
        return false;
    }

    public boolean isDead() {
        return isDead;
    }
}
