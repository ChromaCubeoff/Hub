package eu.chromacube.hub;

import com.comphenix.protocol.ProtocolLibrary;
import eu.chromacube.api.API;
import eu.chromacube.hub.gui.MenuNetwork;
import eu.chromacube.hub.manager.ClassManager;
import eu.chromacube.hub.test.test;
import org.bukkit.plugin.java.JavaPlugin;

public class Hub extends JavaPlugin {

    private static Hub hub;
    @Override
    public void onEnable() {
        hub = this;
        API.get().registerMenu(new MenuNetwork());
        new ClassManager(this).init();
        ProtocolLibrary.getProtocolManager().addPacketListener(new test(this));
        super.onEnable();
    }

    @Override
    public void onDisable() {
        super.onDisable();
    }

    public static Hub get() { return hub; }
}
