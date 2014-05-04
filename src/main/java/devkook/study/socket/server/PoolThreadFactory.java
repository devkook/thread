package devkook.study.socket.server;

import java.util.concurrent.ThreadFactory;

/**
 * Created by diginori on 2014. 5. 4..
 */
public class PoolThreadFactory implements ThreadFactory {
    private final String name;

    public PoolThreadFactory(String name) {
        this.name = name;
    }

    @Override
    public Thread newThread(final Runnable r) {
        final PoolAppThread poolAppThread = new PoolAppThread(r, name);
        PoolAppThread.setDebug(true);
        return poolAppThread;
    }
}
