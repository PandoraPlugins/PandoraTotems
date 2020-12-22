package dev.minecraftplugin.pandoratotems.totems.types;

import com.azortis.azortislib.experimental.inventory.item.Item;
import dev.minecraftplugin.pandoratotems.totems.Rarity;
import dev.minecraftplugin.pandoratotems.totems.Totem;
import org.bukkit.entity.Player;

public class BlazingTotem extends Totem {
    public BlazingTotem() {
        super("&6&lBlazing Totem",
                1,
                Rarity.COMMON,
                new String[]{
                        "&7Grants you the &6Fire Resistance&7 effect",
                        "&7while &aActive &7and in your inventory.",
                },
                true,
                "",
                new int[]{10});

    }

    @Override
    public void doEffect(Player player, Item item) {

    }
}
