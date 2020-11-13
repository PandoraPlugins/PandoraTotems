package dev.minecraftplugin.pandoratotems.totems;

import dev.minecraftplugin.pandoratotems.PandoraTotems;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.concurrent.Callable;

public class TotemScheduler implements Runnable {
    private final PandoraTotems plugin;

    public TotemScheduler(PandoraTotems plugin) {
        this.plugin = plugin;
    }

    /**
     * When an object implementing interface <code>Runnable</code> is used
     * to create a thread, starting the thread causes the object's
     * <code>run</code> method to be called in that separately executing
     * thread.
     * <p>
     * The general contract of the method <code>run</code> is that it may
     * take any action whatsoever.
     *
     * @see Thread#run()
     */
    @Override
    public void run() {
        // Get all online players
        for (Player onlinePlayer : Bukkit.getOnlinePlayers()) {
            // Get their inventory
            for (ItemStack itemStack : onlinePlayer.getInventory()) {
                // Go through each item, and check if it's a player head and has item meta.
                Totems totems = TotemManager.getTotem(itemStack);
                if (totems != null) {
                    if (totems.getTotem().updateConsumer() != null)
                        runTaskSync(() -> {
                            totems.getTotem().updateConsumer().accept(onlinePlayer, itemStack);
                            // It wants us to return something so we just return nothing.
                            return null;
                        });
                }


            }
        }
    }


    private <T> void runTaskSync(Callable<T> callable) {
        Bukkit.getScheduler().callSyncMethod(plugin, callable);
    }
}
