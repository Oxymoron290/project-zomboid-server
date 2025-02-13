package dev.oxymoron.zomboidServerApi;

import zombie.MovingObjectUpdateScheduler;
import zombie.iso.IsoWorld;
import zombie.network.GameServer;
import zombie.network.MPStatistics;
import zombie.network.ServerMap;
import zombie.network.ServerOptions;

public class ZomboidServerStatus implements ZomboidServerStatusMBean {

    private int currentPlayers = 0;
    private int zombies = 0;
    private int loadedZombies = 0;
    private long totalTicks = 0;

    @Override
    public Integer getCurrentPlayers() {
        return currentPlayers;
    }

    @Override
    public Integer getTotalZombies() {
        return zombies;
    }

    @Override
    public Integer getLoadedZombies() {
        return loadedZombies;
    }

    @Override
    public Long getTotalTicks() {
        return totalTicks;
    }

    public void update() {
        currentPlayers = GameServer.getPlayerCount();
        zombies = ServerMap.instance.ZombieMap.size();
        loadedZombies = IsoWorld.instance.getCell().getZombieList().size();
        totalTicks = MovingObjectUpdateScheduler.instance.getFrameCounter();

        MPStatistics.requested();
    }
}
