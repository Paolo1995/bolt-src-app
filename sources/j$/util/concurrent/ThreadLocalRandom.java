package j$.util.concurrent;

import com.google.android.gms.common.api.Api;
import j$.util.stream.AbstractC0254w0;
import j$.util.stream.C0215m0;
import j$.util.stream.F;
import j$.util.stream.IntStream;
import java.io.ObjectStreamField;
import java.security.AccessController;
import java.security.SecureRandom;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

/* loaded from: classes2.dex */
public class ThreadLocalRandom extends Random {

    /* renamed from: d  reason: collision with root package name */
    private static final AtomicInteger f50203d = new AtomicInteger();

    /* renamed from: e  reason: collision with root package name */
    private static final AtomicLong f50204e;

    /* renamed from: f  reason: collision with root package name */
    private static final ThreadLocal f50205f;

    /* renamed from: g  reason: collision with root package name */
    private static final ThreadLocal f50206g;

    /* renamed from: a  reason: collision with root package name */
    long f50207a;

    /* renamed from: b  reason: collision with root package name */
    int f50208b;

    /* renamed from: c  reason: collision with root package name */
    boolean f50209c = true;

    static {
        long h8;
        if (((Boolean) AccessController.doPrivileged(new x())).booleanValue()) {
            byte[] seed = SecureRandom.getSeed(8);
            h8 = seed[0] & 255;
            for (int i8 = 1; i8 < 8; i8++) {
                h8 = (h8 << 8) | (seed[i8] & 255);
            }
        } else {
            h8 = h(System.nanoTime()) ^ h(System.currentTimeMillis());
        }
        f50204e = new AtomicLong(h8);
        f50205f = new ThreadLocal();
        f50206g = new y();
        new ObjectStreamField("rnd", Long.TYPE);
        new ObjectStreamField("initialized", Boolean.TYPE);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final int a(int i8) {
        int i9 = i8 ^ (i8 << 13);
        int i10 = i9 ^ (i9 >>> 17);
        int i11 = i10 ^ (i10 << 5);
        ((ThreadLocalRandom) f50206g.get()).f50208b = i11;
        return i11;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final int b() {
        return ((ThreadLocalRandom) f50206g.get()).f50208b;
    }

    public static ThreadLocalRandom current() {
        ThreadLocalRandom threadLocalRandom = (ThreadLocalRandom) f50206g.get();
        if (threadLocalRandom.f50208b == 0) {
            f();
        }
        return threadLocalRandom;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void f() {
        int addAndGet = f50203d.addAndGet(-1640531527);
        if (addAndGet == 0) {
            addAndGet = 1;
        }
        long h8 = h(f50204e.getAndAdd(-4942790177534073029L));
        ThreadLocalRandom threadLocalRandom = (ThreadLocalRandom) f50206g.get();
        threadLocalRandom.f50207a = h8;
        threadLocalRandom.f50208b = addAndGet;
    }

    private static int g(long j8) {
        long j9 = (j8 ^ (j8 >>> 33)) * (-49064778989728563L);
        return (int) (((j9 ^ (j9 >>> 33)) * (-4265267296055464877L)) >>> 32);
    }

    private static long h(long j8) {
        long j9 = (j8 ^ (j8 >>> 33)) * (-49064778989728563L);
        long j10 = (j9 ^ (j9 >>> 33)) * (-4265267296055464877L);
        return j10 ^ (j10 >>> 33);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final double c(double d8, double d9) {
        double nextLong = (nextLong() >>> 11) * 1.1102230246251565E-16d;
        if (d8 < d9) {
            double d10 = ((d9 - d8) * nextLong) + d8;
            return d10 >= d9 ? Double.longBitsToDouble(Double.doubleToLongBits(d9) - 1) : d10;
        }
        return nextLong;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int d(int i8, int i9) {
        int i10;
        int g8 = g(i());
        if (i8 < i9) {
            int i11 = i9 - i8;
            int i12 = i11 - 1;
            if ((i11 & i12) == 0) {
                i10 = g8 & i12;
            } else if (i11 > 0) {
                int i13 = g8 >>> 1;
                while (true) {
                    int i14 = i13 + i12;
                    i10 = i13 % i11;
                    if (i14 - i10 >= 0) {
                        break;
                    }
                    i13 = g(i()) >>> 1;
                }
            } else {
                while (true) {
                    if (g8 >= i8 && g8 < i9) {
                        return g8;
                    }
                    g8 = g(i());
                }
            }
            return i10 + i8;
        }
        return g8;
    }

    @Override // java.util.Random
    public final DoubleStream doubles() {
        return F.y(AbstractC0254w0.X0(new z(0L, Long.MAX_VALUE, Double.MAX_VALUE, 0.0d)));
    }

    @Override // java.util.Random
    public final DoubleStream doubles(double d8, double d9) {
        if (d8 < d9) {
            return F.y(AbstractC0254w0.X0(new z(0L, Long.MAX_VALUE, d8, d9)));
        }
        throw new IllegalArgumentException("bound must be greater than origin");
    }

    @Override // java.util.Random
    public final DoubleStream doubles(long j8) {
        if (j8 >= 0) {
            return F.y(AbstractC0254w0.X0(new z(0L, j8, Double.MAX_VALUE, 0.0d)));
        }
        throw new IllegalArgumentException("size must be non-negative");
    }

    @Override // java.util.Random
    public final DoubleStream doubles(long j8, double d8, double d9) {
        if (j8 >= 0) {
            if (d8 < d9) {
                return F.y(AbstractC0254w0.X0(new z(0L, j8, d8, d9)));
            }
            throw new IllegalArgumentException("bound must be greater than origin");
        }
        throw new IllegalArgumentException("size must be non-negative");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final long e(long j8, long j9) {
        long h8 = h(i());
        if (j8 >= j9) {
            return h8;
        }
        long j10 = j9 - j8;
        long j11 = j10 - 1;
        if ((j10 & j11) == 0) {
            return (h8 & j11) + j8;
        }
        if (j10 > 0) {
            while (true) {
                long j12 = h8 >>> 1;
                long j13 = j12 + j11;
                long j14 = j12 % j10;
                if (j13 - j14 >= 0) {
                    return j14 + j8;
                }
                h8 = h(i());
            }
        } else {
            while (true) {
                if (h8 >= j8 && h8 < j9) {
                    return h8;
                }
                h8 = h(i());
            }
        }
    }

    final long i() {
        long j8 = this.f50207a - 7046029254386353131L;
        this.f50207a = j8;
        return j8;
    }

    @Override // java.util.Random
    public final IntStream ints() {
        return IntStream.Wrapper.convert(AbstractC0254w0.h1(new A(0L, Long.MAX_VALUE, Api.BaseClientBuilder.API_PRIORITY_OTHER, 0)));
    }

    @Override // java.util.Random
    public final java.util.stream.IntStream ints(int i8, int i9) {
        if (i8 < i9) {
            return IntStream.Wrapper.convert(AbstractC0254w0.h1(new A(0L, Long.MAX_VALUE, i8, i9)));
        }
        throw new IllegalArgumentException("bound must be greater than origin");
    }

    @Override // java.util.Random
    public final java.util.stream.IntStream ints(long j8) {
        if (j8 >= 0) {
            return IntStream.Wrapper.convert(AbstractC0254w0.h1(new A(0L, j8, Api.BaseClientBuilder.API_PRIORITY_OTHER, 0)));
        }
        throw new IllegalArgumentException("size must be non-negative");
    }

    @Override // java.util.Random
    public final java.util.stream.IntStream ints(long j8, int i8, int i9) {
        if (j8 >= 0) {
            if (i8 < i9) {
                return IntStream.Wrapper.convert(AbstractC0254w0.h1(new A(0L, j8, i8, i9)));
            }
            throw new IllegalArgumentException("bound must be greater than origin");
        }
        throw new IllegalArgumentException("size must be non-negative");
    }

    @Override // java.util.Random
    public final LongStream longs() {
        return C0215m0.y(AbstractC0254w0.j1(new B(0L, Long.MAX_VALUE, Long.MAX_VALUE, 0L)));
    }

    @Override // java.util.Random
    public final LongStream longs(long j8) {
        if (j8 >= 0) {
            return C0215m0.y(AbstractC0254w0.j1(new B(0L, j8, Long.MAX_VALUE, 0L)));
        }
        throw new IllegalArgumentException("size must be non-negative");
    }

    @Override // java.util.Random
    public final LongStream longs(long j8, long j9) {
        if (j8 < j9) {
            return C0215m0.y(AbstractC0254w0.j1(new B(0L, Long.MAX_VALUE, j8, j9)));
        }
        throw new IllegalArgumentException("bound must be greater than origin");
    }

    @Override // java.util.Random
    public final LongStream longs(long j8, long j9, long j10) {
        if (j8 >= 0) {
            if (j9 < j10) {
                return C0215m0.y(AbstractC0254w0.j1(new B(0L, j8, j9, j10)));
            }
            throw new IllegalArgumentException("bound must be greater than origin");
        }
        throw new IllegalArgumentException("size must be non-negative");
    }

    @Override // java.util.Random
    protected final int next(int i8) {
        return (int) (h(i()) >>> (64 - i8));
    }

    @Override // java.util.Random
    public final boolean nextBoolean() {
        return g(i()) < 0;
    }

    @Override // java.util.Random
    public final double nextDouble() {
        return (h(i()) >>> 11) * 1.1102230246251565E-16d;
    }

    @Override // java.util.Random
    public final float nextFloat() {
        return (g(i()) >>> 8) * 5.9604645E-8f;
    }

    @Override // java.util.Random
    public final double nextGaussian() {
        ThreadLocal threadLocal = f50205f;
        Double d8 = (Double) threadLocal.get();
        if (d8 != null) {
            threadLocal.set(null);
            return d8.doubleValue();
        }
        while (true) {
            double nextDouble = (nextDouble() * 2.0d) - 1.0d;
            double nextDouble2 = (nextDouble() * 2.0d) - 1.0d;
            double d9 = (nextDouble2 * nextDouble2) + (nextDouble * nextDouble);
            if (d9 < 1.0d && d9 != 0.0d) {
                double sqrt = StrictMath.sqrt((StrictMath.log(d9) * (-2.0d)) / d9);
                f50205f.set(new Double(nextDouble2 * sqrt));
                return nextDouble * sqrt;
            }
        }
    }

    @Override // java.util.Random
    public final int nextInt() {
        return g(i());
    }

    @Override // java.util.Random
    public final int nextInt(int i8) {
        if (i8 <= 0) {
            throw new IllegalArgumentException("bound must be positive");
        }
        int g8 = g(i());
        int i9 = i8 - 1;
        if ((i8 & i9) == 0) {
            return g8 & i9;
        }
        while (true) {
            int i10 = g8 >>> 1;
            int i11 = i10 + i9;
            int i12 = i10 % i8;
            if (i11 - i12 >= 0) {
                return i12;
            }
            g8 = g(i());
        }
    }

    public int nextInt(int i8, int i9) {
        if (i8 < i9) {
            return d(i8, i9);
        }
        throw new IllegalArgumentException("bound must be greater than origin");
    }

    @Override // java.util.Random
    public final long nextLong() {
        return h(i());
    }

    public long nextLong(long j8, long j9) {
        if (j8 < j9) {
            return e(j8, j9);
        }
        throw new IllegalArgumentException("bound must be greater than origin");
    }

    @Override // java.util.Random
    public final void setSeed(long j8) {
        if (this.f50209c) {
            throw new UnsupportedOperationException();
        }
    }
}
