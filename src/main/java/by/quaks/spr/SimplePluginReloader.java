package by.quaks.spr;

import dev.jorel.commandapi.CommandAPI;
import org.bukkit.plugin.java.JavaPlugin;

public final class SimplePluginReloader extends JavaPlugin {

    @Override
    public void onEnable() {
        CommandAPI.onEnable(this);
        ReloadCommand.register();
    }

    @Override
    public void onDisable() {
        CommandAPI.onDisable();
    }
}
