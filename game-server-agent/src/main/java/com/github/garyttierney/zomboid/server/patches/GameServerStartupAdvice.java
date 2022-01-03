package com.github.garyttierney.zomboid.server.patches;

import com.github.garyttierney.zomboid.server.ZomboidServerStatus;
import com.github.garyttierney.zomboid.server.api.DefaultZomboidApiServerAdapter;
import com.github.garyttierney.zomboid.server.api.ZomboidApiServer;
import net.bytebuddy.asm.Advice;

import javax.management.MBeanServer;
import javax.management.ObjectName;
import java.lang.management.ManagementFactory;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class GameServerStartupAdvice {
    public static final ZomboidApiServer server = new ZomboidApiServer(new DefaultZomboidApiServerAdapter());

    @Advice.OnMethodEnter
    public static void before() {
        server.start();
    }

    @Advice.OnMethodExit
    public static void after() {
        server.stop();
    }
}
