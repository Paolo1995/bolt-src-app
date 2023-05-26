package io.netty.util.concurrent;

import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.StringUtil;
import java.util.Locale;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes5.dex */
public class DefaultThreadFactory implements ThreadFactory {
    private static final AtomicInteger poolId = new AtomicInteger();
    private final boolean daemon;
    private final AtomicInteger nextId;
    private final String prefix;
    private final int priority;
    protected final ThreadGroup threadGroup;

    public DefaultThreadFactory(Class<?> cls) {
        this(cls, false, 5);
    }

    public static String toPoolName(Class<?> cls) {
        ObjectUtil.checkNotNull(cls, "poolType");
        String simpleClassName = StringUtil.simpleClassName(cls);
        int length = simpleClassName.length();
        if (length != 0) {
            if (length != 1) {
                if (Character.isUpperCase(simpleClassName.charAt(0)) && Character.isLowerCase(simpleClassName.charAt(1))) {
                    return Character.toLowerCase(simpleClassName.charAt(0)) + simpleClassName.substring(1);
                }
                return simpleClassName;
            }
            return simpleClassName.toLowerCase(Locale.US);
        }
        return "unknown";
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        Runnable wrap = FastThreadLocalRunnable.wrap(runnable);
        Thread newThread = newThread(wrap, this.prefix + this.nextId.incrementAndGet());
        try {
            boolean isDaemon = newThread.isDaemon();
            boolean z7 = this.daemon;
            if (isDaemon != z7) {
                newThread.setDaemon(z7);
            }
            int priority = newThread.getPriority();
            int i8 = this.priority;
            if (priority != i8) {
                newThread.setPriority(i8);
            }
        } catch (Exception unused) {
        }
        return newThread;
    }

    public DefaultThreadFactory(Class<?> cls, int i8) {
        this(cls, false, i8);
    }

    public DefaultThreadFactory(String str, int i8) {
        this(str, false, i8);
    }

    public DefaultThreadFactory(Class<?> cls, boolean z7, int i8) {
        this(toPoolName(cls), z7, i8);
    }

    public DefaultThreadFactory(String str, boolean z7, int i8, ThreadGroup threadGroup) {
        this.nextId = new AtomicInteger();
        ObjectUtil.checkNotNull(str, "poolName");
        if (i8 >= 1 && i8 <= 10) {
            this.prefix = str + '-' + poolId.incrementAndGet() + '-';
            this.daemon = z7;
            this.priority = i8;
            this.threadGroup = threadGroup;
            return;
        }
        throw new IllegalArgumentException("priority: " + i8 + " (expected: Thread.MIN_PRIORITY <= priority <= Thread.MAX_PRIORITY)");
    }

    protected Thread newThread(Runnable runnable, String str) {
        return new FastThreadLocalThread(this.threadGroup, runnable, str);
    }

    public DefaultThreadFactory(String str, boolean z7, int i8) {
        this(str, z7, i8, System.getSecurityManager() == null ? Thread.currentThread().getThreadGroup() : System.getSecurityManager().getThreadGroup());
    }
}
