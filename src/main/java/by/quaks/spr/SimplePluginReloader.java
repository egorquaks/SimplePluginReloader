package by.quaks.spr;

import dev.jorel.commandapi.CommandAPI;
import dev.jorel.commandapi.CommandAPICommand;
import dev.jorel.commandapi.arguments.Argument;
import dev.jorel.commandapi.arguments.LiteralArgument;
import org.bukkit.plugin.java.JavaPlugin;
import dev.jorel.commandapi.arguments.StringArgument;

public final class SimplePluginReloader extends JavaPlugin {

    @Override
    public void onEnable() {
        CommandAPI.onEnable(this);
        ReloadCommand.register();
    }

    @Override
    public void onDisable() {
        CommandAPI.onDisable();
        // Plugin shutdown logic
    }
}
