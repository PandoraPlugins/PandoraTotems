package dev.minecraftplugin.pandoratotems.totems;

import com.azortis.azortislib.experimental.inventory.item.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

public abstract class Totem implements Listener {
    protected final String name;
    protected final int identifier;
    protected final Rarity rarity;
    protected final String[] description;
    protected final boolean isPassive;
    protected final String head;
    protected final int[] cost;

    public String getName() {
        return name;
    }

    public int getIdentifier() {
        return identifier;
    }

    public Rarity getRarity() {
        return rarity;
    }

    public String[] getDescription() {
        return description;
    }

    public abstract void doEffect(Player player, Item item);

    public Totem(String name, int identifier, Rarity rarity, String[] description, boolean isPassive, String head, int[] cost) {
        this.name = name;
        this.identifier = identifier;
        this.rarity = rarity;
        this.description = description;
        this.isPassive = isPassive;
        this.head = head;
        this.cost = cost;
    }
}
