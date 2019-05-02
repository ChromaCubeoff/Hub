package eu.chromacube.hub;

import org.bukkit.plugin.java.JavaPlugin;

public class Hub extends JavaPlugin {

    private static Hub hub;
    @Override
    public void onEnable() {
        hub = this;
        super.onEnable();
    }

    @Override
    public void onDisable() {
        super.onDisable();
    }

    public static Hub get() { return hub; }
}
