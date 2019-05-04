package eu.chromacube.hub;

import eu.chromacube.api.tools.CreativeInventory;
import eu.chromacube.hub.gui.MenuNetwork;
import eu.chromacube.hub.manager.ClassManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Hub extends JavaPlugin {

    private static Hub hub;
    @Override
    public void onEnable() {
        hub = this;
        new ClassManager(this).init();
        CreativeInventory creativeInventory = new CreativeInventory();
        creativeInventory.registerMenu(new MenuNetwork());
        super.onEnable();
    }

    @Override
    public void onDisable() {
        super.onDisable();
    }

    public static Hub get() { return hub; }
}
