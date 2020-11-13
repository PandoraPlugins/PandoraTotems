package dev.minecraftplugin.pandoratotems.totems.items;

import com.azortis.azortislib.experimental.inventory.item.Item;
import com.azortis.azortislib.xseries.XMaterial;
import dev.minecraftplugin.pandoratotems.totems.Totem;
import dev.minecraftplugin.pandoratotems.totems.TotemManager;
import dev.minecraftplugin.pandoratotems.totems.TotemTier;
import dev.minecraftplugin.pandoratotems.totems.Totems;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.inventory.ItemStack;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiConsumer;

public class FireResistanceTotem implements Totem {


    @Override
    public String getItemName(int level) {
        return "&cTotem of Fire Resistance &8[&e&l&n" + level + "&8]";
    }

    @Override
    public String getShopName() {
        return "&cTotem of Fire Resistance";
    }

    @Override
    public int[] getLevels() {
        return new int[]{1};
    }

    @Override
    public int getLowestLevel() {
        return 1;
    }

    @Override
    public int getHighestLevel() {
        return 1;
    }

    @Override
    public int getXpCost(int level) {
        return 0;
    }

    @Override
    public boolean isActiveLevel(int level) {
        return false;
    }

    @Override
    public List<String> getShopDescription() {
        StringBuilder levels = new StringBuilder("&bLevels &7[&e&l&n");
        for (int i = getLowestLevel(); i <= getHighestLevel(); i++) {
            if (i == getLowestLevel()) levels.append(i);
            else levels.append(", ").append(i);
        }
        levels.append("&7]");

        return Arrays.asList("",
                levels.toString(),
                "",
                "&ePASSIVE",
                "&b&oUsers take no fire/lava damage when the totem is",
                "&b&owithin your inventory or totem pouch.",
                getType().getColor() + "&o" + getType().getName());
    }

    @Override
    public List<String> getItemDescription(int level) {
        return Arrays.asList("&bLevel &e&l&n" + level,
                "",
                "&b&oUsers take no fire/lava damage when the totem is",
                "&b&owithin your inventory or totem pouch.",
                getType().getColor() + "&o" + getType().getName());
    }

    @Override
    public boolean isListener() {
        return true;
    }

    @Override
    public Item getItem(int level) {
        Item item = new Item(XMaterial.PLAYER_HEAD);
        item.skull("b82ee289b91ff39a97d39b9ac5fb9a8e4348404f27643af2495859027b344503");
        item.name(getItemName(1));
        item.lore(getItemDescription(1));
        return item;
    }

    @Override
    public Item getShopItem() {
        return null; // todo: do this
    }

    @EventHandler
    public void onPlayerFire(EntityDamageEvent event) {
        // Check if is player
        if (event.getEntityType() == EntityType.PLAYER) {
            // Check if it's a fire/lava damage.
            if (event.getCause() == EntityDamageEvent.DamageCause.FIRE ||
                    event.getCause() == EntityDamageEvent.DamageCause.FIRE_TICK ||
                    event.getCause() == EntityDamageEvent.DamageCause.LAVA) {
                Player p = (Player) event.getEntity();
                for (ItemStack itemStack : p.getInventory()) {
                    Totems totems = TotemManager.getTotem(itemStack);
                    if (totems == Totems.FIRE_RESISTANCE_TOTEM) {
                        p.setFireTicks(0);
                        event.setCancelled(true);
                        break;
                    }
                }
            }
        }
    }

    @Override
    public BiConsumer<Player, ItemStack> updateConsumer() {
        return null;
    }

    @Override
    public TotemTier getType() {
        return TotemTier.COMMON;
    }
}
