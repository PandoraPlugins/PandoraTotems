package dev.minecraftplugin.pandoratotems.totems;

import com.azortis.azortislib.xseries.XMaterial;
import dev.minecraftplugin.pandoratotems.PandoraTotems;
import dev.minecraftplugin.pandoratotems.totems.inventory.info.InfoInventory;
import net.minecraft.server.v1_8_R3.NBTTagCompound;
import org.bukkit.Bukkit;
import org.bukkit.craftbukkit.v1_8_R3.inventory.CraftItemStack;
import org.bukkit.inventory.ItemStack;

public class TotemManager {

    private final InfoInventory infoInventory;

    public TotemManager(PandoraTotems plugin) {
        TotemScheduler scheduler = new TotemScheduler(plugin);
        infoInventory = new InfoInventory();
        for (Totems value : Totems.values()) {
            if (value.getTotem().isListener())
                Bukkit.getPluginManager().registerEvents(value.getTotem(), plugin);
        }

        // Updates all totems every 2 seconds.
        Bukkit.getScheduler().runTaskTimerAsynchronously(plugin, scheduler, 20, 40);
    }

    public static Totems getTotem(ItemStack itemStack) {
        if (itemStack != null && itemStack.hasItemMeta() && itemStack.getType() == XMaterial.PLAYER_HEAD.parseMaterial()) {
            // If it is, then we try and get the totem nbt tag.
            net.minecraft.server.v1_8_R3.ItemStack nmsI = CraftItemStack.asNMSCopy(itemStack);
            if (nmsI.hasTag()) {
                NBTTagCompound compound = nmsI.getTag();
                return Totems.fromKey(compound.getString("pandora_totem"));
            }
        }
        return null;
    }

    public InfoInventory getInfoInventory() {
        return infoInventory;
    }

}
