package eu.chromacube.hub.manager;

import eu.chromacube.api.tools.CreativeInventory;
import eu.chromacube.api.tools.CreativeItem;
import eu.chromacube.hub.gui.MenuNetwork;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;

public class PlayerAddItem {

    public void onJoinPlayer(Player player) {
        player.getInventory().setItem(4, new CreativeItem(Material.COMPASS).setName(ChatColor.GOLD + "Menu Network").setAction(event -> {
            new CreativeInventory().open(event.getPlayer(), MenuNetwork.class);
        }).toItemStack());
    }
}
