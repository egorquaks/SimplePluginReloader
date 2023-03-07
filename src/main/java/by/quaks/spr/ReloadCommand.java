package by.quaks.spr;

import dev.jorel.commandapi.CommandAPICommand;
import dev.jorel.commandapi.arguments.Argument;
import dev.jorel.commandapi.arguments.MultiLiteralArgument;
import dev.jorel.commandapi.arguments.TextArgument;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.Plugin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReloadCommand{

    public static void register() {
        Plugin[] plugins = Bukkit.getPluginManager().getPlugins();
        List<String> pluginNamesList = new ArrayList<>(Arrays.asList(
                Arrays.stream(plugins)
                        .map(Plugin::getName)
                        .toArray(String[]::new)
        ));
        pluginNamesList.remove("SimplePluginReloader");
        String[] pluginNames = pluginNamesList.toArray(new String[0]);
        new CommandAPICommand("reloadplugin")
                .withArguments(new MultiLiteralArgument(pluginNames))
                .executes((sender, args) -> {
                    String pluginName = (String) args[0];
                    Plugin plugin = Bukkit.getPluginManager().getPlugin(pluginName);
                    if(plugin != null) {
                        Bukkit.getPluginManager().disablePlugin(plugin);
                        Bukkit.getPluginManager().enablePlugin(plugin);
                        sender.sendMessage("Reloaded plugin " + pluginName);
                    } else {
                        sender.sendMessage("Plugin " + pluginName + " not found");
                    }
                })
                .register();
    }
}
