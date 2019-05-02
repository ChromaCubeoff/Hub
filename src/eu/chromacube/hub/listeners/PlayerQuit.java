package eu.chromacube.hub.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerQuit implements Listener {

     @EventHandler
    public void onquit(PlayerQuitEvent event){
         Player player = event.getPlayer();
         
     }

}
