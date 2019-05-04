package eu.chromacube.hub.gui;

import eu.chromacube.api.tools.CreativeInventory;
import eu.chromacube.api.tools.CreativeItem;
import org.bukkit.ChatColor;
import org.bukkit.Material;

public class MenuNetwork implements CreativeInventory.ICreativeInventory {


    @Override
    public String name() {
        return ChatColor.GOLD + "Menu Network";
    }

    @Override
    public int size() {
        return 6*9;
    }

    @Override
    public void contents(CreativeInventory inv) {
        inv.setItem(0, new CreativeItem(Material.RED_STAINED_GLASS).toItemStack());
    }
}
