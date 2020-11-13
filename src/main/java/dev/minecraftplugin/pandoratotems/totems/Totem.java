package dev.minecraftplugin.pandoratotems.totems;

import com.azortis.azortislib.experimental.inventory.item.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;

import java.util.List;
import java.util.function.BiConsumer;

public interface Totem extends Listener {
    String getItemName(int level);

    String getShopName();

    int[] getLevels();

    int getLowestLevel();

    int getHighestLevel();

    int getXpCost(int level);

    boolean isActiveLevel(int level);

    List<String> getShopDescription();

    List<String> getItemDescription(int level);

    boolean isListener();

    Item getItem(int level);

    Item getShopItem();

    BiConsumer<Player, ItemStack> updateConsumer();

    TotemTier getType();
}
