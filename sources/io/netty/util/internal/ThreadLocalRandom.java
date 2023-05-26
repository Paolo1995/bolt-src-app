package io.netty.util.internal;

import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.lang.Thread;
import java.security.SecureRandom;
import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: classes5.dex */
public final class ThreadLocalRandom extends Random {
    private static volatile long initialSeedUniquifier;
    private static volatile long seedGeneratorEndTime;
    private static final long seedGeneratorStartTime;
    private static final Thread seedGeneratorThread;
    private static final BlockingQueue<Long> seedQueue;
    boolean initialized;
    private long rnd;
    private static final InternalLogger logger = InternalLoggerFactory.getInstance(ThreadLocalRandom.class);
    private static final AtomicLong seedUniquifier = new AtomicLong();

    static {
        initialSeedUniquifier = SystemPropertyUtil.getLong("io.netty.initialSeedUniquifier", 0L);
        if (initialSeedUniquifier == 0) {
            if (SystemPropertyUtil.getBoolean("java.util.secureRandomSeed", false)) {
                seedQueue = new LinkedBlockingQueue();
                seedGeneratorStartTime = System.nanoTime();
                Thread thread = new Thread("initialSeedUniquifierGenerator") { // from class: io.netty.util.internal.ThreadLocalRandom.1
                    @Override // java.lang.Thread, java.lang.Runnable
                    public void run() {
                        byte[] generateSeed = new SecureRandom().generateSeed(8);
                        long unused = ThreadLocalRandom.seedGeneratorEndTime = System.nanoTime();
                        ThreadLocalRandom.seedQueue.add(Long.valueOf(((generateSeed[0] & 255) << 56) | ((generateSeed[1] & 255) << 48) | ((generateSeed[2] & 255) << 40) | ((generateSeed[3] & 255) << 32) | ((generateSeed[4] & 255) << 24) | ((generateSeed[5] & 255) << 16) | ((generateSeed[6] & 255) << 8) | (generateSeed[7] & 255)));
                    }
                };
                seedGeneratorThread = thread;
                thread.setDaemon(true);
                thread.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() { // from class: io.netty.util.internal.ThreadLocalRandom.2
                    @Override // java.lang.Thread.UncaughtExceptionHandler
                    public void uncaughtException(Thread thread2, Throwable th) {
                        ThreadLocalRandom.logger.debug("An exception has been raised by {}", thread2.getName(), th);
                    }
                });
                thread.start();
                return;
            }
            initialSeedUniquifier = mix64(System.currentTimeMillis()) ^ mix64(System.nanoTime());
            seedGeneratorThread = null;
            seedQueue = null;
            seedGeneratorStartTime = 0L;
            return;
        }
        seedGeneratorThread = null;
        seedQueue = null;
        seedGeneratorStartTime = 0L;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ThreadLocalRandom() {
        super(newSeed());
        this.initialized = true;
    }

    public static ThreadLocalRandom current() {
        return InternalThreadLocalMap.get().random();
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x003f, code lost:
        r4 = r10.longValue();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static long getInitialSeedUniquifier() {
        /*
            long r0 = io.netty.util.internal.ThreadLocalRandom.initialSeedUniquifier
            r2 = 0
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 == 0) goto L9
            return r0
        L9:
            java.lang.Class<io.netty.util.internal.ThreadLocalRandom> r0 = io.netty.util.internal.ThreadLocalRandom.class
            monitor-enter(r0)
            long r4 = io.netty.util.internal.ThreadLocalRandom.initialSeedUniquifier     // Catch: java.lang.Throwable -> L8c
            int r1 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r1 == 0) goto L14
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L8c
            return r4
        L14:
            long r6 = io.netty.util.internal.ThreadLocalRandom.seedGeneratorStartTime     // Catch: java.lang.Throwable -> L8c
            java.util.concurrent.TimeUnit r1 = java.util.concurrent.TimeUnit.SECONDS     // Catch: java.lang.Throwable -> L8c
            r8 = 3
            long r10 = r1.toNanos(r8)     // Catch: java.lang.Throwable -> L8c
            long r6 = r6 + r10
            r1 = 0
        L20:
            long r10 = java.lang.System.nanoTime()     // Catch: java.lang.Throwable -> L8c
            long r10 = r6 - r10
            int r12 = (r10 > r2 ? 1 : (r10 == r2 ? 0 : -1))
            if (r12 > 0) goto L33
            java.util.concurrent.BlockingQueue<java.lang.Long> r10 = io.netty.util.internal.ThreadLocalRandom.seedQueue     // Catch: java.lang.InterruptedException -> L57 java.lang.Throwable -> L8c
            java.lang.Object r10 = r10.poll()     // Catch: java.lang.InterruptedException -> L57 java.lang.Throwable -> L8c
            java.lang.Long r10 = (java.lang.Long) r10     // Catch: java.lang.InterruptedException -> L57 java.lang.Throwable -> L8c
            goto L3d
        L33:
            java.util.concurrent.BlockingQueue<java.lang.Long> r13 = io.netty.util.internal.ThreadLocalRandom.seedQueue     // Catch: java.lang.InterruptedException -> L57 java.lang.Throwable -> L8c
            java.util.concurrent.TimeUnit r14 = java.util.concurrent.TimeUnit.NANOSECONDS     // Catch: java.lang.InterruptedException -> L57 java.lang.Throwable -> L8c
            java.lang.Object r10 = r13.poll(r10, r14)     // Catch: java.lang.InterruptedException -> L57 java.lang.Throwable -> L8c
            java.lang.Long r10 = (java.lang.Long) r10     // Catch: java.lang.InterruptedException -> L57 java.lang.Throwable -> L8c
        L3d:
            if (r10 == 0) goto L44
            long r4 = r10.longValue()     // Catch: java.lang.InterruptedException -> L57 java.lang.Throwable -> L8c
            goto L5f
        L44:
            if (r12 > 0) goto L20
            java.lang.Thread r6 = io.netty.util.internal.ThreadLocalRandom.seedGeneratorThread     // Catch: java.lang.Throwable -> L8c
            r6.interrupt()     // Catch: java.lang.Throwable -> L8c
            io.netty.util.internal.logging.InternalLogger r6 = io.netty.util.internal.ThreadLocalRandom.logger     // Catch: java.lang.Throwable -> L8c
            java.lang.String r7 = "Failed to generate a seed from SecureRandom within {} seconds. Not enough entropy?"
            java.lang.Long r8 = java.lang.Long.valueOf(r8)     // Catch: java.lang.Throwable -> L8c
            r6.warn(r7, r8)     // Catch: java.lang.Throwable -> L8c
            goto L5f
        L57:
            r1 = 1
            io.netty.util.internal.logging.InternalLogger r6 = io.netty.util.internal.ThreadLocalRandom.logger     // Catch: java.lang.Throwable -> L8c
            java.lang.String r7 = "Failed to generate a seed from SecureRandom due to an InterruptedException."
            r6.warn(r7)     // Catch: java.lang.Throwable -> L8c
        L5f:
            r6 = 3627065505421648153(0x3255ecdc33bae119, double:3.253008663204319E-66)
            long r4 = r4 ^ r6
            long r6 = java.lang.System.nanoTime()     // Catch: java.lang.Throwable -> L8c
            long r6 = java.lang.Long.reverse(r6)     // Catch: java.lang.Throwable -> L8c
            long r4 = r4 ^ r6
            io.netty.util.internal.ThreadLocalRandom.initialSeedUniquifier = r4     // Catch: java.lang.Throwable -> L8c
            if (r1 == 0) goto L7e
            java.lang.Thread r1 = java.lang.Thread.currentThread()     // Catch: java.lang.Throwable -> L8c
            r1.interrupt()     // Catch: java.lang.Throwable -> L8c
            java.lang.Thread r1 = io.netty.util.internal.ThreadLocalRandom.seedGeneratorThread     // Catch: java.lang.Throwable -> L8c
            r1.interrupt()     // Catch: java.lang.Throwable -> L8c
        L7e:
            long r6 = io.netty.util.internal.ThreadLocalRandom.seedGeneratorEndTime     // Catch: java.lang.Throwable -> L8c
            int r1 = (r6 > r2 ? 1 : (r6 == r2 ? 0 : -1))
            if (r1 != 0) goto L8a
            long r1 = java.lang.System.nanoTime()     // Catch: java.lang.Throwable -> L8c
            io.netty.util.internal.ThreadLocalRandom.seedGeneratorEndTime = r1     // Catch: java.lang.Throwable -> L8c
        L8a:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L8c
            return r4
        L8c:
            r1 = move-exception
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L8c
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.util.internal.ThreadLocalRandom.getInitialSeedUniquifier():long");
    }

    private static long mix64(long j8) {
        long j9 = (j8 ^ (j8 >>> 33)) * (-49064778989728563L);
        long j10 = (j9 ^ (j9 >>> 33)) * (-4265267296055464877L);
        return j10 ^ (j10 >>> 33);
    }

    private static long newSeed() {
        AtomicLong atomicLong;
        long j8;
        int i8;
        long initialSeedUniquifier2;
        long j9;
        do {
            atomicLong = seedUniquifier;
            j8 = atomicLong.get();
            i8 = (j8 > 0L ? 1 : (j8 == 0L ? 0 : -1));
            if (i8 != 0) {
                initialSeedUniquifier2 = j8;
            } else {
                initialSeedUniquifier2 = getInitialSeedUniquifier();
            }
            j9 = 181783497276652981L * initialSeedUniquifier2;
        } while (!atomicLong.compareAndSet(j8, j9));
        if (i8 == 0) {
            InternalLogger internalLogger = logger;
            if (internalLogger.isDebugEnabled()) {
                if (seedGeneratorEndTime != 0) {
                    internalLogger.debug(String.format("-Dio.netty.initialSeedUniquifier: 0x%016x (took %d ms)", Long.valueOf(initialSeedUniquifier2), Long.valueOf(TimeUnit.NANOSECONDS.toMillis(seedGeneratorEndTime - seedGeneratorStartTime))));
                } else {
                    internalLogger.debug(String.format("-Dio.netty.initialSeedUniquifier: 0x%016x", Long.valueOf(initialSeedUniquifier2)));
                }
            }
        }
        return System.nanoTime() ^ j9;
    }

    @Override // java.util.Random
    protected int next(int i8) {
        long j8 = ((this.rnd * 25214903917L) + 11) & 281474976710655L;
        this.rnd = j8;
        return (int) (j8 >>> (48 - i8));
    }

    @Override // java.util.Random
    public void setSeed(long j8) {
        if (!this.initialized) {
            this.rnd = (j8 ^ 25214903917L) & 281474976710655L;
            return;
        }
        throw new UnsupportedOperationException();
    }
}
