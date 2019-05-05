package eu.chromacube.hub;

import com.comphenix.protocol.ProtocolLibrary;
import com.comphenix.protocol.events.PacketAdapter;
import com.comphenix.protocol.events.PacketEvent;
import eu.chromacube.api.API;
import eu.chromacube.hub.gui.MenuNetwork;
import eu.chromacube.hub.manager.ClassManager;
import eu.chromacube.hub.test.SessChkRun;
import eu.chromacube.hub.test.test;
import net.minecraft.server.v1_13_R1.PacketLoginInEncryptionBegin;
import org.bukkit.craftbukkit.v1_13_R1.CraftServer;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Level;

public class Hub extends JavaPlugin {

    private static Hub hub;
    private API api;
    @Override
    public void onEnable() {
        hub = this;
        this.api = API.get();
        API.get().registerMenu(new MenuNetwork());
        api.log(Level.SEVERE, "Loading API");
        System.out.println(ProtocolLibrary.getPlugin());
        new ClassManager(this).init();
        ProtocolLibrary.getProtocolManager().addPacketListener(new PacketAdapter(null) {
            @Override
            public void onPacketSending(PacketEvent event) {
                this.plugin.getLogger().info("Received LoginInEncryptionBegin from " + event.getPlayer().getName() + " [" + event.getPlayer().getUniqueId().toString() + "]");
                String serverId = new test(hub).getServerId((PacketLoginInEncryptionBegin) event.getPacket().getHandle(), ((CraftServer) this.plugin.getServer()).getServer());
                this.plugin.getLogger().info("Decrypted his sent server ID (\"" + serverId + "\") and requesting mojang check.");
                this.plugin.getServer().getScheduler().runTaskAsynchronously(this.plugin, new SessChkRun((Hub) this.plugin, event.getPlayer().getName(), serverId));
            }
        });
        super.onEnable();
    }

    @Override
    public void onDisable() {
        super.onDisable();
    }

    public static Hub get() { return hub; }
}
