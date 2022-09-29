package me.staryybrodyga.spawnplugin;

import me.staryybrodyga.spawnplugin.commands.SetSpawnCMD;
import me.staryybrodyga.spawnplugin.commands.SpawnCMD;
import me.staryybrodyga.spawnplugin.listeners.SpawnListeners;
import org.bukkit.plugin.java.JavaPlugin;

public final class Plugin extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic

        // config.yml
        getConfig().options().copyDefaults();
        saveDefaultConfig();

        SpawnLocation spawnLocation = new SpawnLocation(this);

        getCommand("setspawn").setExecutor(new SetSpawnCMD(spawnLocation));
        getCommand("spawn").setExecutor(new SpawnCMD(spawnLocation));

        getServer().getPluginManager().registerEvents(new SpawnListeners(spawnLocation), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
