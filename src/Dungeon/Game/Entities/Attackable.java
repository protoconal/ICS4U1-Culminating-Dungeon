package Dungeon.Game.Entities;

import Dungeon.Game.Items.HealthItem;
import Dungeon.Game.Items.WeaponItem;

public interface Attackable {
    void heal(HealthItem health);
    boolean revive(HealthItem health);
    boolean damage(WeaponItem weapon);
}
