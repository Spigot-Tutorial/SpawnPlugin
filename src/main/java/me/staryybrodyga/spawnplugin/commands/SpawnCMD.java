package me.staryybrodyga.spawnplugin.commands;

import me.staryybrodyga.spawnplugin.SpawnLocation;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandException;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SpawnCMD implements CommandExecutor {

    private final SpawnLocation spawnLocation;

    public SpawnCMD(SpawnLocation spawnLocation) {
        this.spawnLocation = spawnLocation;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player) {

            Player player = (Player) sender;

            try {
                Location location = spawnLocation.getSpawnLocation2();
                player.teleport(location);
                player.sendMessage("You have been teleported to the spawn point.");
            } catch (CommandException e) {
                player.sendMessage("There is not spawn point set. Use /setspawn to set it.");
                e.printStackTrace();
            }

        }

        return true;
    }
}
