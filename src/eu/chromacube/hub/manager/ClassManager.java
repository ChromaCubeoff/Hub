package eu.chromacube.hub.manager;

import eu.chromacube.hub.Hub;
import eu.chromacube.hub.listeners.PlayerJoin;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;

public class ClassManager {

    private Hub hub;

    public ClassManager(Hub hub) {
        this.hub = hub;
    }

    public void init(){
        PluginManager pm = Bukkit.getPluginManager();
        pm.registerEvents(new PlayerJoin(), hub);
    }
}
