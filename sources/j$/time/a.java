package j$.time;

import j$.util.function.BiConsumer;
import j$.util.function.InterfaceC0135l;
import java.util.Map;
import java.util.concurrent.ConcurrentMap;

/* loaded from: classes2.dex */
public abstract /* synthetic */ class a {
    public static void a(ConcurrentMap concurrentMap, BiConsumer biConsumer) {
        biConsumer.getClass();
        for (Map.Entry entry : concurrentMap.entrySet()) {
            try {
                biConsumer.accept(entry.getKey(), entry.getValue());
            } catch (IllegalStateException unused) {
            }
        }
    }

    public static /* synthetic */ void b(InterfaceC0135l interfaceC0135l, InterfaceC0135l interfaceC0135l2, double d8) {
        interfaceC0135l.accept(d8);
        interfaceC0135l2.accept(d8);
    }

    public static /* synthetic */ long c(long j8, long j9) {
        long j10 = j8 + j9;
        if (((j9 ^ j8) < 0) || ((j8 ^ j10) >= 0)) {
            return j10;
        }
        throw new ArithmeticException();
    }

    public static /* synthetic */ long d(long j8, long j9) {
        long j10 = j8 % j9;
        if (j10 == 0) {
            return 0L;
        }
        return (((j8 ^ j9) >> 63) | 1) > 0 ? j10 : j10 + j9;
    }

    public static /* synthetic */ long e(long j8, long j9) {
        int numberOfLeadingZeros = Long.numberOfLeadingZeros(~j9) + Long.numberOfLeadingZeros(j9) + Long.numberOfLeadingZeros(~j8) + Long.numberOfLeadingZeros(j8);
        if (numberOfLeadingZeros > 65) {
            return j8 * j9;
        }
        if (numberOfLeadingZeros >= 64) {
            int i8 = (j8 > 0L ? 1 : (j8 == 0L ? 0 : -1));
            if ((i8 >= 0) | (j9 != Long.MIN_VALUE)) {
                long j10 = j8 * j9;
                if (i8 == 0 || j10 / j8 == j9) {
                    return j10;
                }
            }
        }
        throw new ArithmeticException();
    }

    public static /* synthetic */ long f(long j8, long j9) {
        long j10 = j8 / j9;
        return (j8 - (j9 * j10) != 0 && (((j8 ^ j9) >> 63) | 1) < 0) ? j10 - 1 : j10;
    }

    public static /* synthetic */ long g(long j8, long j9) {
        long j10 = j8 - j9;
        if (((j9 ^ j8) >= 0) || ((j8 ^ j10) >= 0)) {
            return j10;
        }
        throw new ArithmeticException();
    }
}
