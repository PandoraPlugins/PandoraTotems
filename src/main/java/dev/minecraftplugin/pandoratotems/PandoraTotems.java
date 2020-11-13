package dev.minecraftplugin.pandoratotems;

import com.azortis.azortislib.experimental.translation.Translation;
import com.azortis.azortislib.experimental.translation.TranslationManager;
import com.azortis.azortislib.experimental.translation.impl.YAMLTranslation;
import dev.minecraftplugin.pandoratotems.totems.TotemManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class PandoraTotems extends JavaPlugin {
    private Translation translation;
    private TotemManager manager;

    public Translation getTranslation() {
        return translation;
    }

    public TotemManager getManager() {
        return manager;
    }

    @Override
    public void onEnable() {
        // Plugin startup logic

        // Load in messages/translated messages.
        translation = TranslationManager.loadTranslation("messages", new YAMLTranslation(), this);
        manager = new TotemManager(this);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic

        // Saves any changes to our translation messages.
        translation.save();
    }
}
