package dev.oxymoron.zomboidServerApi.patches;

import dev.oxymoron.zomboidServerApi.ZomboidServerStatus;
import dev.oxymoron.zomboidServerApi.api.DefaultZomboidApiServerAdapter;
import dev.oxymoron.zomboidServerApi.api.ZomboidApiServer;
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
