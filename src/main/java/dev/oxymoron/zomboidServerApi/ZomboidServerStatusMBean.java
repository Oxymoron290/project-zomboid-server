package dev.oxymoron.zomboidServerApi;

public interface ZomboidServerStatusMBean {
    Integer getCurrentPlayers();
    Integer getTotalZombies();
    Integer getLoadedZombies();
    Long getTotalTicks();
}
