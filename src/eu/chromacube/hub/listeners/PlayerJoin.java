package eu.chromacube.hub.listeners;

import eu.chromacube.hub.manager.PlayerAddItem;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoin implements Listener {

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();

        player.sendMessage("Ceci est un test !");
        player.setFoodLevel(20);
        player.setHealth(20);
        player.setLevel(0);
        player.setGameMode(GameMode.ADVENTURE);
        player.getInventory().clear();
        player.setExp(0);

        new PlayerAddItem().onJoinPlayer(player);
    }
}
