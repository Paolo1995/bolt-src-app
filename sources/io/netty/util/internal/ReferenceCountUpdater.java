package io.netty.util.internal;

import io.netty.util.IllegalReferenceCountException;
import io.netty.util.ReferenceCounted;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/* loaded from: classes5.dex */
public abstract class ReferenceCountUpdater<T extends ReferenceCounted> {
    public static long getUnsafeOffset(Class<? extends ReferenceCounted> cls, String str) {
        try {
            if (PlatformDependent.hasUnsafe()) {
                return PlatformDependent.objectFieldOffset(cls.getDeclaredField(str));
            }
            return -1L;
        } catch (Throwable unused) {
            return -1L;
        }
    }

    private boolean nonFinalRelease0(T t7, int i8, int i9, int i10) {
        if (i8 < i10 && updater().compareAndSet(t7, i9, i9 - (i8 << 1))) {
            return false;
        }
        return retryRelease0(t7, i8);
    }

    private int nonVolatileRawCnt(T t7) {
        long unsafeOffset = unsafeOffset();
        if (unsafeOffset != -1) {
            return PlatformDependent.getInt(t7, unsafeOffset);
        }
        return updater().get(t7);
    }

    private static int realRefCnt(int i8) {
        if (i8 == 2 || i8 == 4 || (i8 & 1) == 0) {
            return i8 >>> 1;
        }
        return 0;
    }

    private T retain0(T t7, int i8, int i9) {
        int andAdd = updater().getAndAdd(t7, i9);
        if (andAdd != 2 && andAdd != 4 && (andAdd & 1) != 0) {
            throw new IllegalReferenceCountException(0, i8);
        }
        if ((andAdd <= 0 && andAdd + i9 >= 0) || (andAdd >= 0 && andAdd + i9 < andAdd)) {
            updater().getAndAdd(t7, -i9);
            throw new IllegalReferenceCountException(realRefCnt(andAdd), i8);
        }
        return t7;
    }

    private boolean retryRelease0(T t7, int i8) {
        while (true) {
            int i9 = updater().get(t7);
            int liveRealRefCnt = toLiveRealRefCnt(i9, i8);
            if (i8 == liveRealRefCnt) {
                if (tryFinalRelease0(t7, i9)) {
                    return true;
                }
            } else if (i8 < liveRealRefCnt) {
                if (updater().compareAndSet(t7, i9, i9 - (i8 << 1))) {
                    return false;
                }
            } else {
                throw new IllegalReferenceCountException(liveRealRefCnt, -i8);
            }
            Thread.yield();
        }
    }

    private static int toLiveRealRefCnt(int i8, int i9) {
        if (i8 != 2 && i8 != 4 && (i8 & 1) != 0) {
            throw new IllegalReferenceCountException(0, -i9);
        }
        return i8 >>> 1;
    }

    private boolean tryFinalRelease0(T t7, int i8) {
        return updater().compareAndSet(t7, i8, 1);
    }

    public final int initialValue() {
        return 2;
    }

    public final boolean isLiveNonVolatile(T t7) {
        int i8;
        long unsafeOffset = unsafeOffset();
        if (unsafeOffset != -1) {
            i8 = PlatformDependent.getInt(t7, unsafeOffset);
        } else {
            i8 = updater().get(t7);
        }
        if (i8 == 2 || i8 == 4 || i8 == 6 || i8 == 8 || (i8 & 1) == 0) {
            return true;
        }
        return false;
    }

    public final int refCnt(T t7) {
        return realRefCnt(updater().get(t7));
    }

    public final boolean release(T t7) {
        int nonVolatileRawCnt = nonVolatileRawCnt(t7);
        if (nonVolatileRawCnt == 2) {
            return tryFinalRelease0(t7, 2) || retryRelease0(t7, 1);
        }
        return nonFinalRelease0(t7, 1, nonVolatileRawCnt, toLiveRealRefCnt(nonVolatileRawCnt, 1));
    }

    public final void resetRefCnt(T t7) {
        updater().set(t7, initialValue());
    }

    public final T retain(T t7) {
        return retain0(t7, 1, 2);
    }

    protected abstract long unsafeOffset();

    protected abstract AtomicIntegerFieldUpdater<T> updater();

    public final boolean release(T t7, int i8) {
        int nonVolatileRawCnt = nonVolatileRawCnt(t7);
        int liveRealRefCnt = toLiveRealRefCnt(nonVolatileRawCnt, ObjectUtil.checkPositive(i8, "decrement"));
        if (i8 == liveRealRefCnt) {
            return tryFinalRelease0(t7, nonVolatileRawCnt) || retryRelease0(t7, i8);
        }
        return nonFinalRelease0(t7, i8, nonVolatileRawCnt, liveRealRefCnt);
    }
}
