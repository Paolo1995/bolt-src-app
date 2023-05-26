package kotlin.random;

import java.io.Serializable;
import kotlin.internal.PlatformImplementationsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: Random.kt */
/* loaded from: classes5.dex */
public abstract class Random {

    /* renamed from: f  reason: collision with root package name */
    public static final Default f51030f = new Default(null);

    /* renamed from: g  reason: collision with root package name */
    private static final Random f51031g = PlatformImplementationsKt.f50939a.b();

    /* compiled from: Random.kt */
    /* loaded from: classes5.dex */
    public static final class Default extends Random implements Serializable {
        private Default() {
        }

        public /* synthetic */ Default(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Override // kotlin.random.Random
        public int b(int i8) {
            return Random.f51031g.b(i8);
        }

        @Override // kotlin.random.Random
        public float c() {
            return Random.f51031g.c();
        }

        @Override // kotlin.random.Random
        public int d() {
            return Random.f51031g.d();
        }

        @Override // kotlin.random.Random
        public int e(int i8) {
            return Random.f51031g.e(i8);
        }

        @Override // kotlin.random.Random
        public int f(int i8, int i9) {
            return Random.f51031g.f(i8, i9);
        }

        @Override // kotlin.random.Random
        public long g() {
            return Random.f51031g.g();
        }

        @Override // kotlin.random.Random
        public long h(long j8, long j9) {
            return Random.f51031g.h(j8, j9);
        }
    }

    public abstract int b(int i8);

    public float c() {
        return b(24) / 1.6777216E7f;
    }

    public int d() {
        return b(32);
    }

    public int e(int i8) {
        return f(0, i8);
    }

    public int f(int i8, int i9) {
        int d8;
        int i10;
        int i11;
        int d9;
        boolean z7;
        RandomKt.c(i8, i9);
        int i12 = i9 - i8;
        if (i12 <= 0 && i12 != Integer.MIN_VALUE) {
            do {
                d9 = d();
                z7 = false;
                if (i8 <= d9 && d9 < i9) {
                    z7 = true;
                    continue;
                }
            } while (!z7);
            return d9;
        }
        if (((-i12) & i12) == i12) {
            i11 = b(RandomKt.e(i12));
        } else {
            do {
                d8 = d() >>> 1;
                i10 = d8 % i12;
            } while ((d8 - i10) + (i12 - 1) < 0);
            i11 = i10;
        }
        return i8 + i11;
    }

    public long g() {
        return (d() << 32) + d();
    }

    public long h(long j8, long j9) {
        long g8;
        boolean z7;
        long g9;
        long j10;
        long j11;
        int d8;
        RandomKt.d(j8, j9);
        long j12 = j9 - j8;
        if (j12 > 0) {
            if (((-j12) & j12) == j12) {
                int i8 = (int) j12;
                int i9 = (int) (j12 >>> 32);
                if (i8 != 0) {
                    d8 = b(RandomKt.e(i8));
                } else if (i9 == 1) {
                    d8 = d();
                } else {
                    j11 = (b(RandomKt.e(i9)) << 32) + (d() & 4294967295L);
                }
                j11 = d8 & 4294967295L;
            } else {
                do {
                    g9 = g() >>> 1;
                    j10 = g9 % j12;
                } while ((g9 - j10) + (j12 - 1) < 0);
                j11 = j10;
            }
            return j8 + j11;
        }
        do {
            g8 = g();
            z7 = false;
            if (j8 <= g8 && g8 < j9) {
                z7 = true;
                continue;
            }
        } while (!z7);
        return g8;
    }
}
