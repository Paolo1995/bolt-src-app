package kotlin.time;

import i0.a;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.LongRange;
import kotlin.ranges.RangesKt___RangesKt;
import kotlin.text.StringsKt__StringsKt;
import okhttp3.internal.http2.Http2Connection;

/* compiled from: Duration.kt */
/* loaded from: classes5.dex */
public final class Duration implements Comparable<Duration> {

    /* renamed from: g  reason: collision with root package name */
    public static final Companion f51176g = new Companion(null);

    /* renamed from: h  reason: collision with root package name */
    private static final long f51177h = l(0);

    /* renamed from: i  reason: collision with root package name */
    private static final long f51178i;

    /* renamed from: j  reason: collision with root package name */
    private static final long f51179j;

    /* renamed from: f  reason: collision with root package name */
    private final long f51180f;

    /* compiled from: Duration.kt */
    /* loaded from: classes5.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final long a() {
            return Duration.f51178i;
        }

        public final long b() {
            return Duration.f51177h;
        }

        public final long c(String value) {
            long p8;
            Intrinsics.f(value, "value");
            try {
                p8 = DurationKt.p(value, true);
                return p8;
            } catch (IllegalArgumentException e8) {
                throw new IllegalArgumentException("Invalid ISO duration string format: '" + value + "'.", e8);
            }
        }
    }

    static {
        long j8;
        long j9;
        j8 = DurationKt.j(4611686018427387903L);
        f51178i = j8;
        j9 = DurationKt.j(-4611686018427387903L);
        f51179j = j9;
    }

    private /* synthetic */ Duration(long j8) {
        this.f51180f = j8;
    }

    private static final long A(long j8) {
        return j8 >> 1;
    }

    public static int B(long j8) {
        return a.a(j8);
    }

    public static final boolean C(long j8) {
        return !F(j8);
    }

    private static final boolean D(long j8) {
        return (((int) j8) & 1) == 1;
    }

    private static final boolean E(long j8) {
        return (((int) j8) & 1) == 0;
    }

    public static final boolean F(long j8) {
        if (j8 != f51178i && j8 != f51179j) {
            return false;
        }
        return true;
    }

    public static final boolean G(long j8) {
        return j8 < 0;
    }

    public static final long H(long j8, long j9) {
        long k8;
        long m8;
        if (F(j8)) {
            if (!C(j9) && (j9 ^ j8) < 0) {
                throw new IllegalArgumentException("Summing infinite durations of different signs yields an undefined result.");
            }
            return j8;
        } else if (F(j9)) {
            return j9;
        } else {
            if ((((int) j8) & 1) == (((int) j9) & 1)) {
                long A = A(j8) + A(j9);
                if (E(j8)) {
                    m8 = DurationKt.m(A);
                    return m8;
                }
                k8 = DurationKt.k(A);
                return k8;
            } else if (D(j8)) {
                return e(j8, A(j8), A(j9));
            } else {
                return e(j8, A(j9), A(j8));
            }
        }
    }

    public static final String I(long j8) {
        boolean z7;
        boolean z8;
        StringBuilder sb = new StringBuilder();
        if (G(j8)) {
            sb.append('-');
        }
        sb.append("PT");
        long p8 = p(j8);
        long s7 = s(p8);
        int w7 = w(p8);
        int y7 = y(p8);
        int x7 = x(p8);
        if (F(j8)) {
            s7 = 9999999999999L;
        }
        boolean z9 = true;
        if (s7 != 0) {
            z7 = true;
        } else {
            z7 = false;
        }
        if (y7 == 0 && x7 == 0) {
            z8 = false;
        } else {
            z8 = true;
        }
        if (w7 == 0 && (!z8 || !z7)) {
            z9 = false;
        }
        if (z7) {
            sb.append(s7);
            sb.append('H');
        }
        if (z9) {
            sb.append(w7);
            sb.append('M');
        }
        if (z8 || (!z7 && !z9)) {
            f(j8, sb, y7, x7, 9, "S", true);
        }
        String sb2 = sb.toString();
        Intrinsics.e(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }

    public static final long J(long j8, DurationUnit unit) {
        Intrinsics.f(unit, "unit");
        if (j8 == f51178i) {
            return Long.MAX_VALUE;
        }
        if (j8 == f51179j) {
            return Long.MIN_VALUE;
        }
        return DurationUnitKt__DurationUnitJvmKt.b(A(j8), z(j8), unit);
    }

    public static String K(long j8) {
        boolean z7;
        boolean z8;
        boolean z9;
        boolean z10;
        if (j8 == 0) {
            return "0s";
        }
        if (j8 == f51178i) {
            return "Infinity";
        }
        if (j8 == f51179j) {
            return "-Infinity";
        }
        boolean G = G(j8);
        StringBuilder sb = new StringBuilder();
        if (G) {
            sb.append('-');
        }
        long p8 = p(j8);
        long r7 = r(p8);
        int q8 = q(p8);
        int w7 = w(p8);
        int y7 = y(p8);
        int x7 = x(p8);
        int i8 = 0;
        if (r7 != 0) {
            z7 = true;
        } else {
            z7 = false;
        }
        if (q8 != 0) {
            z8 = true;
        } else {
            z8 = false;
        }
        if (w7 != 0) {
            z9 = true;
        } else {
            z9 = false;
        }
        if (y7 == 0 && x7 == 0) {
            z10 = false;
        } else {
            z10 = true;
        }
        if (z7) {
            sb.append(r7);
            sb.append('d');
            i8 = 1;
        }
        if (z8 || (z7 && (z9 || z10))) {
            int i9 = i8 + 1;
            if (i8 > 0) {
                sb.append(' ');
            }
            sb.append(q8);
            sb.append('h');
            i8 = i9;
        }
        if (z9 || (z10 && (z8 || z7))) {
            int i10 = i8 + 1;
            if (i8 > 0) {
                sb.append(' ');
            }
            sb.append(w7);
            sb.append('m');
            i8 = i10;
        }
        if (z10) {
            int i11 = i8 + 1;
            if (i8 > 0) {
                sb.append(' ');
            }
            if (y7 == 0 && !z7 && !z8 && !z9) {
                if (x7 >= 1000000) {
                    f(j8, sb, x7 / 1000000, x7 % 1000000, 6, "ms", false);
                } else if (x7 >= 1000) {
                    f(j8, sb, x7 / 1000, x7 % 1000, 3, "us", false);
                } else {
                    sb.append(x7);
                    sb.append("ns");
                }
            } else {
                f(j8, sb, y7, x7, 9, "s", false);
            }
            i8 = i11;
        }
        if (G && i8 > 1) {
            sb.insert(1, '(').append(')');
        }
        String sb2 = sb.toString();
        Intrinsics.e(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }

    public static final long L(long j8) {
        long i8;
        i8 = DurationKt.i(-A(j8), ((int) j8) & 1);
        return i8;
    }

    private static final long e(long j8, long j9, long j10) {
        long o8;
        long k8;
        long j11;
        long n8;
        long n9;
        long l8;
        o8 = DurationKt.o(j10);
        long j12 = j9 + o8;
        if (new LongRange(-4611686018426L, 4611686018426L).m(j12)) {
            n8 = DurationKt.n(o8);
            long j13 = j10 - n8;
            n9 = DurationKt.n(j12);
            l8 = DurationKt.l(n9 + j13);
            return l8;
        }
        k8 = RangesKt___RangesKt.k(j12, -4611686018427387903L, 4611686018427387903L);
        j11 = DurationKt.j(k8);
        return j11;
    }

    private static final void f(long j8, StringBuilder sb, int i8, int i9, int i10, String str, boolean z7) {
        String m02;
        boolean z8;
        sb.append(i8);
        if (i9 != 0) {
            sb.append('.');
            m02 = StringsKt__StringsKt.m0(String.valueOf(i9), i10, '0');
            int i11 = -1;
            int length = m02.length() - 1;
            if (length >= 0) {
                while (true) {
                    int i12 = length - 1;
                    if (m02.charAt(length) != '0') {
                        z8 = true;
                    } else {
                        z8 = false;
                    }
                    if (z8) {
                        i11 = length;
                        break;
                    } else if (i12 < 0) {
                        break;
                    } else {
                        length = i12;
                    }
                }
            }
            int i13 = i11 + 1;
            if (!z7 && i13 < 3) {
                sb.append((CharSequence) m02, 0, i13);
                Intrinsics.e(sb, "this.append(value, startIndex, endIndex)");
            } else {
                sb.append((CharSequence) m02, 0, ((i13 + 2) / 3) * 3);
                Intrinsics.e(sb, "this.append(value, startIndex, endIndex)");
            }
        }
        sb.append(str);
    }

    public static final /* synthetic */ Duration h(long j8) {
        return new Duration(j8);
    }

    public static int k(long j8, long j9) {
        long j10 = j8 ^ j9;
        if (j10 >= 0 && (((int) j10) & 1) != 0) {
            int i8 = (((int) j8) & 1) - (((int) j9) & 1);
            if (G(j8)) {
                return -i8;
            }
            return i8;
        }
        return Intrinsics.i(j8, j9);
    }

    public static long l(long j8) {
        if (DurationJvmKt.a()) {
            if (E(j8)) {
                if (!new LongRange(-4611686018426999999L, 4611686018426999999L).m(A(j8))) {
                    throw new AssertionError(A(j8) + " ns is out of nanoseconds range");
                }
            } else if (new LongRange(-4611686018427387903L, 4611686018427387903L).m(A(j8))) {
                if (new LongRange(-4611686018426L, 4611686018426L).m(A(j8))) {
                    throw new AssertionError(A(j8) + " ms is denormalized");
                }
            } else {
                throw new AssertionError(A(j8) + " ms is out of milliseconds range");
            }
        }
        return j8;
    }

    public static boolean m(long j8, Object obj) {
        return (obj instanceof Duration) && j8 == ((Duration) obj).M();
    }

    public static final long p(long j8) {
        if (G(j8)) {
            return L(j8);
        }
        return j8;
    }

    public static final int q(long j8) {
        if (F(j8)) {
            return 0;
        }
        return (int) (s(j8) % 24);
    }

    public static final long r(long j8) {
        return J(j8, DurationUnit.DAYS);
    }

    public static final long s(long j8) {
        return J(j8, DurationUnit.HOURS);
    }

    public static final long t(long j8) {
        if (D(j8) && C(j8)) {
            return A(j8);
        }
        return J(j8, DurationUnit.MILLISECONDS);
    }

    public static final long u(long j8) {
        return J(j8, DurationUnit.MINUTES);
    }

    public static final long v(long j8) {
        return J(j8, DurationUnit.SECONDS);
    }

    public static final int w(long j8) {
        if (F(j8)) {
            return 0;
        }
        return (int) (u(j8) % 60);
    }

    public static final int x(long j8) {
        long A;
        if (F(j8)) {
            return 0;
        }
        if (D(j8)) {
            A = DurationKt.n(A(j8) % 1000);
        } else {
            A = A(j8) % ((long) Http2Connection.DEGRADED_PONG_TIMEOUT_NS);
        }
        return (int) A;
    }

    public static final int y(long j8) {
        if (F(j8)) {
            return 0;
        }
        return (int) (v(j8) % 60);
    }

    private static final DurationUnit z(long j8) {
        if (E(j8)) {
            return DurationUnit.NANOSECONDS;
        }
        return DurationUnit.MILLISECONDS;
    }

    public final /* synthetic */ long M() {
        return this.f51180f;
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(Duration duration) {
        return j(duration.M());
    }

    public boolean equals(Object obj) {
        return m(this.f51180f, obj);
    }

    public int hashCode() {
        return B(this.f51180f);
    }

    public int j(long j8) {
        return k(this.f51180f, j8);
    }

    public String toString() {
        return K(this.f51180f);
    }
}
