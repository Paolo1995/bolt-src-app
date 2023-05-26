package kotlin.random.jdk8;

import j$.util.concurrent.ThreadLocalRandom;
import java.util.Random;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.AbstractPlatformRandom;

/* compiled from: PlatformThreadLocalRandom.kt */
/* loaded from: classes5.dex */
public final class PlatformThreadLocalRandom extends AbstractPlatformRandom {
    @Override // kotlin.random.Random
    public int f(int i8, int i9) {
        return ThreadLocalRandom.current().nextInt(i8, i9);
    }

    @Override // kotlin.random.Random
    public long h(long j8, long j9) {
        return ThreadLocalRandom.current().nextLong(j8, j9);
    }

    @Override // kotlin.random.AbstractPlatformRandom
    public Random i() {
        ThreadLocalRandom current = ThreadLocalRandom.current();
        Intrinsics.e(current, "current()");
        return current;
    }
}
