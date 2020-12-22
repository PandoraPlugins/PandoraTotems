package dev.minecraftplugin.pandoratotems;

import com.azortis.azortislib.configuration.ConfigManager;
import dev.minecraftplugin.pandoratotems.totems.TotemManager;
import dev.minecraftplugin.pandoratotems.translation.Messages;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;

public final class PandoraTotems extends JavaPlugin {
    private TotemManager totemManager;

    public TotemManager getTotemManager() {
        return totemManager;
    }

    @Override
    public void onEnable() {
        // Plugin startup logic
        ConfigManager manager = new ConfigManager(this);
        initMessages(manager);
        this.totemManager = new TotemManager(this);
    }

    @Override
    public void onDisable() {
    }

    private void initMessages(ConfigManager manager) {
        File f = new File(getDataFolder(), "messages.json");

        try {
            if (!getDataFolder().exists()) {
                getDataFolder().mkdirs();
            }

            if (!f.exists()) {
                f.mkdirs();
                f.createNewFile();

                try {
                    String json = manager.getGson().toJson(Messages.class);
                    Files.write(f.toPath(), json.getBytes(), StandardOpenOption.CREATE, StandardOpenOption.WRITE);
                } catch (IOException var2) {
                    var2.printStackTrace();
                }

            } else {
                manager.getGson().fromJson(new FileReader(f), Messages.class);
            }
        } catch (IOException var6) {
            var6.printStackTrace();
        }
    }
}
