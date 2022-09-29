package me.staryybrodyga.spawnplugin.listeners;

import me.staryybrodyga.spawnplugin.SpawnLocation;
import org.bukkit.Location;
import org.bukkit.command.CommandException;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerRespawnEvent;

public class SpawnListeners implements Listener {

    private final SpawnLocation spawnLocation;

    public SpawnListeners(SpawnLocation spawnLocation) {
        this.spawnLocation = spawnLocation;
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {

        Player player = event.getPlayer();

        if (!player.hasPlayedBefore()) {

            try {
                Location location = spawnLocation.getSpawnLocation2();
                player.teleport(location);
            } catch (CommandException e) {
                e.printStackTrace();
            }
        }
    }

    @EventHandler
    public void onPlayerRespawn(PlayerRespawnEvent event) {

        // when a player dies, respawn them at the spawn location if its set
        try {
            Location location = spawnLocation.getSpawnLocation2();
            event.setRespawnLocation(location);
        } catch (CommandException e) {
            e.printStackTrace();
        }
    }
}
