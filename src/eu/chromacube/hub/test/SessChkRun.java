package eu.chromacube.hub.test;

import eu.chromacube.hub.Hub;

public class SessChkRun implements Runnable {

    private Hub plugin;
    private String name;
    private String serverId;
    public SessChkRun(Hub plugin, String name, String serverId) {
        this.plugin = plugin;
        this.name = name;
        this.serverId = serverId;
    }
    @Override
    public void run() {
        new test(plugin).checkSession(name, serverId);
    }

}
