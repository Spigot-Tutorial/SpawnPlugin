package me.staryybrodyga.spawnplugin;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;

public class SpawnLocation {

    private final Plugin plugin;

    public SpawnLocation(Plugin plugin) {
        this.plugin = plugin;
    }

    public void setSpawnLocation1(Player player) {
        Location location = player.getLocation();

        //1. Save each value of the location, x, y, z, worldname etc
        plugin.getConfig().set("spawn.x", location.getX());
        plugin.getConfig().set("spawn.y", location.getY());
        plugin.getConfig().set("spawn.z", location.getZ());
        plugin.getConfig().set("spawn.worldName", location.getWorld().getName());
        plugin.getConfig().set("spawn.yaw", location.getYaw());
        plugin.getConfig().set("spawn.pitch", location.getPitch());

        plugin.saveConfig();
    }

    public Location getSpawnLocation1() {
        double x = plugin.getConfig().getDouble("spawn.x");
        double y = plugin.getConfig().getDouble("spawn.y");
        double z = plugin.getConfig().getDouble("spawn.z");
        double yaw = plugin.getConfig().getDouble("spawn.yaw");
        double pitch = plugin.getConfig().getDouble("spawn.pitch");
        String worldName = plugin.getConfig().getString("spawn.worldName");
        World world = plugin.getServer().getWorld(worldName);
        return new Location(world, x, y, z, (float) yaw, (float) pitch);
    }

    public void setSpawnLocation2(Player player) {
        Location location = player.getLocation();
        plugin.getConfig().set("spawn", location);
        plugin.saveConfig();
    }

    public Location getSpawnLocation2() {
        return plugin.getConfig().getLocation("spawn");
    }
}
