package me.staryybrodyga.spawnplugin.commands;

import me.staryybrodyga.spawnplugin.Plugin;
import me.staryybrodyga.spawnplugin.SpawnLocation;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SetSpawnCMD implements CommandExecutor {

    private final SpawnLocation spawnLocation;

    public SetSpawnCMD(SpawnLocation spawnLocation) {
        this.spawnLocation = spawnLocation;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player) {
            Player player = (Player) sender;

            //1. Save each value of the location, x, y, z, worldname etc
            spawnLocation.setSpawnLocation2(player);

            //2. Save the location object directly
            //plugin.getConfig().set("spawn", location);

            player.sendMessage("Spawn location set!");

        } else {
            System.out.println("Bruh get yo ass on the server.");
        }

        return true;
    }
}
