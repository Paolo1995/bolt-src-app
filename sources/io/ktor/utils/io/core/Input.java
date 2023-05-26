package io.ktor.utils.io.core;

import com.google.android.gms.common.api.Api;
import io.ktor.utils.io.core.internal.ChunkBuffer;
import io.ktor.utils.io.core.internal.MalformedUTF8InputException;
import io.ktor.utils.io.core.internal.UnsafeKt;
import io.ktor.utils.io.pool.ObjectPool;
import java.io.Closeable;
import java.io.EOFException;
import java.nio.ByteBuffer;
import kotlin.KotlinNothingValueException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;

/* compiled from: Input.kt */
/* loaded from: classes5.dex */
public abstract class Input implements Closeable {

    /* renamed from: m  reason: collision with root package name */
    public static final Companion f47383m = new Companion(null);

    /* renamed from: f  reason: collision with root package name */
    private final ObjectPool<ChunkBuffer> f47384f;

    /* renamed from: g  reason: collision with root package name */
    private ChunkBuffer f47385g;

    /* renamed from: h  reason: collision with root package name */
    private ByteBuffer f47386h;

    /* renamed from: i  reason: collision with root package name */
    private int f47387i;

    /* renamed from: j  reason: collision with root package name */
    private int f47388j;

    /* renamed from: k  reason: collision with root package name */
    private long f47389k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f47390l;

    /* compiled from: Input.kt */
    /* loaded from: classes5.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public Input() {
        this(null, 0L, null, 7, null);
    }

    public Input(ChunkBuffer head, long j8, ObjectPool<ChunkBuffer> pool) {
        Intrinsics.f(head, "head");
        Intrinsics.f(pool, "pool");
        this.f47384f = pool;
        this.f47385g = head;
        this.f47386h = head.h();
        this.f47387i = head.i();
        int k8 = head.k();
        this.f47388j = k8;
        this.f47389k = j8 - (k8 - this.f47387i);
    }

    private final ChunkBuffer F(ChunkBuffer chunkBuffer, ChunkBuffer chunkBuffer2) {
        boolean z7;
        while (chunkBuffer != chunkBuffer2) {
            ChunkBuffer z8 = chunkBuffer.z();
            chunkBuffer.E(this.f47384f);
            if (z8 == null) {
                l1(chunkBuffer2);
                h1(0L);
                chunkBuffer = chunkBuffer2;
            } else {
                if (z8.k() > z8.i()) {
                    z7 = true;
                } else {
                    z7 = false;
                }
                if (z7) {
                    l1(z8);
                    h1(this.f47389k - (z8.k() - z8.i()));
                    return z8;
                }
                chunkBuffer = z8;
            }
        }
        return w();
    }

    private final Void G0(int i8, int i9) {
        throw new IllegalArgumentException("min should be less or equal to max but min = " + i8 + ", max = " + i9);
    }

    private final Void I0(int i8) {
        throw new IllegalStateException("minSize of " + i8 + " is too big (should be less than 8)");
    }

    private final Void K0(int i8, int i9) {
        throw new MalformedUTF8InputException("Premature end of stream: expected at least " + i8 + " chars but had only " + i9);
    }

    private final ChunkBuffer S0(int i8, ChunkBuffer chunkBuffer) {
        boolean z7;
        while (true) {
            int f02 = f0() - s0();
            if (f02 >= i8) {
                return chunkBuffer;
            }
            ChunkBuffer B = chunkBuffer.B();
            if (B == null && (B = w()) == null) {
                return null;
            }
            if (f02 == 0) {
                if (chunkBuffer != ChunkBuffer.f47400j.a()) {
                    c1(chunkBuffer);
                }
                chunkBuffer = B;
            } else {
                int a8 = BufferAppendKt.a(chunkBuffer, B, i8 - f02);
                this.f47388j = chunkBuffer.k();
                h1(this.f47389k - a8);
                if (B.k() > B.i()) {
                    z7 = true;
                } else {
                    z7 = false;
                }
                if (!z7) {
                    chunkBuffer.G(null);
                    chunkBuffer.G(B.z());
                    B.E(this.f47384f);
                } else {
                    B.q(a8);
                }
                if (chunkBuffer.k() - chunkBuffer.i() >= i8) {
                    return chunkBuffer;
                }
                if (i8 > 8) {
                    I0(i8);
                    throw new KotlinNothingValueException();
                }
            }
        }
    }

    private final int U0(Appendable appendable, int i8, int i9) {
        int i10;
        boolean z7;
        boolean z8;
        boolean z9;
        boolean z10 = false;
        if (i9 == 0 && i8 == 0) {
            return 0;
        }
        if (c0()) {
            if (i8 == 0) {
                return 0;
            }
            g(i8);
            throw new KotlinNothingValueException();
        } else if (i9 >= i8) {
            ChunkBuffer b8 = UnsafeKt.b(this, 1);
            if (b8 == null) {
                i10 = 0;
            } else {
                i10 = 0;
                boolean z11 = false;
                while (true) {
                    try {
                        ByteBuffer h8 = b8.h();
                        int i11 = b8.i();
                        int k8 = b8.k();
                        for (int i12 = i11; i12 < k8; i12++) {
                            int i13 = h8.get(i12) & 255;
                            if ((i13 & 128) != 128) {
                                char c8 = (char) i13;
                                if (i10 == i9) {
                                    z9 = false;
                                } else {
                                    appendable.append(c8);
                                    i10++;
                                    z9 = true;
                                }
                                if (z9) {
                                }
                            }
                            b8.c(i12 - i11);
                            z7 = false;
                            break;
                        }
                        b8.c(k8 - i11);
                        z7 = true;
                        if (z7) {
                            z8 = true;
                        } else {
                            if (i10 != i9) {
                                z11 = true;
                            }
                            z8 = false;
                        }
                        if (!z8) {
                            z10 = true;
                            break;
                        }
                        try {
                            ChunkBuffer c9 = UnsafeKt.c(this, b8);
                            if (c9 == null) {
                                break;
                            }
                            b8 = c9;
                        } catch (Throwable th) {
                            th = th;
                            if (z10) {
                                UnsafeKt.a(this, b8);
                            }
                            throw th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        z10 = true;
                    }
                }
                if (z10) {
                    UnsafeKt.a(this, b8);
                }
                z10 = z11;
            }
            if (z10) {
                return i10 + b1(appendable, i8 - i10, i9 - i10);
            }
            if (i10 >= i8) {
                return i10;
            }
            K0(i8, i10);
            throw new KotlinNothingValueException();
        } else {
            G0(i8, i9);
            throw new KotlinNothingValueException();
        }
    }

    private final void Y(ChunkBuffer chunkBuffer) {
        if (this.f47390l && chunkBuffer.B() == null) {
            this.f47387i = chunkBuffer.i();
            this.f47388j = chunkBuffer.k();
            h1(0L);
            return;
        }
        int k8 = chunkBuffer.k() - chunkBuffer.i();
        int min = Math.min(k8, 8 - (chunkBuffer.f() - chunkBuffer.g()));
        if (k8 > min) {
            Z(chunkBuffer, k8, min);
        } else {
            ChunkBuffer u02 = this.f47384f.u0();
            u02.p(8);
            u02.G(chunkBuffer.z());
            BufferAppendKt.a(u02, chunkBuffer, k8);
            l1(u02);
        }
        chunkBuffer.E(this.f47384f);
    }

    private final void Z(ChunkBuffer chunkBuffer, int i8, int i9) {
        ChunkBuffer u02 = this.f47384f.u0();
        ChunkBuffer u03 = this.f47384f.u0();
        u02.p(8);
        u03.p(8);
        u02.G(u03);
        u03.G(chunkBuffer.z());
        BufferAppendKt.a(u02, chunkBuffer, i8 - i9);
        BufferAppendKt.a(u03, chunkBuffer, i9);
        l1(u02);
        h1(BuffersKt.e(u03));
    }

    public static /* synthetic */ String Z0(Input input, int i8, int i9, int i10, Object obj) {
        if (obj == null) {
            if ((i10 & 1) != 0) {
                i8 = 0;
            }
            if ((i10 & 2) != 0) {
                i9 = Api.BaseClientBuilder.API_PRIORITY_OTHER;
            }
            return input.W0(i8, i9);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: readText");
    }

    private final void a(ChunkBuffer chunkBuffer) {
        if (chunkBuffer.k() - chunkBuffer.i() == 0) {
            c1(chunkBuffer);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x004e, code lost:
        r15 = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x00d0, code lost:
        r5.c(((r11 - r9) - r14) + 1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x00ea, code lost:
        if (r15 != 0) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x00ec, code lost:
        r7 = 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x00ee, code lost:
        if (r15 <= 0) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x00f0, code lost:
        r7 = r15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x00f2, code lost:
        r7 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x00f3, code lost:
        r9 = r5.k() - r5.i();
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x0130, code lost:
        if (r4 == false) goto L101;
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x0132, code lost:
        io.ktor.utils.io.core.internal.UnsafeKt.a(r16, r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x0135, code lost:
        r6 = r8;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final int b1(java.lang.Appendable r17, int r18, int r19) {
        /*
            Method dump skipped, instructions count: 329
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.core.Input.b1(java.lang.Appendable, int, int):int");
    }

    private final void e(ChunkBuffer chunkBuffer) {
        boolean z7;
        ChunkBuffer c8 = BuffersKt.c(this.f47385g);
        if (c8 == ChunkBuffer.f47400j.a()) {
            l1(chunkBuffer);
            long j8 = 0;
            if (this.f47389k == 0) {
                z7 = true;
            } else {
                z7 = false;
            }
            if (z7) {
                ChunkBuffer B = chunkBuffer.B();
                if (B != null) {
                    j8 = BuffersKt.e(B);
                }
                h1(j8);
                return;
            }
            throw new IllegalStateException("It should be no tail remaining bytes if current tail is EmptyBuffer");
        }
        c8.G(chunkBuffer);
        h1(this.f47389k + BuffersKt.e(chunkBuffer));
    }

    private final Void g(int i8) {
        throw new EOFException("at least " + i8 + " characters required but no bytes available");
    }

    private final void l1(ChunkBuffer chunkBuffer) {
        this.f47385g = chunkBuffer;
        this.f47386h = chunkBuffer.h();
        this.f47387i = chunkBuffer.i();
        this.f47388j = chunkBuffer.k();
    }

    private final int m(int i8, int i9) {
        while (i8 != 0) {
            ChunkBuffer P0 = P0(1);
            if (P0 == null) {
                return i9;
            }
            int min = Math.min(P0.k() - P0.i(), i8);
            P0.c(min);
            this.f47387i += min;
            a(P0);
            i8 -= min;
            i9 += min;
        }
        return i9;
    }

    private final long q(long j8, long j9) {
        while (j8 != 0) {
            ChunkBuffer P0 = P0(1);
            if (P0 == null) {
                return j9;
            }
            int min = (int) Math.min(P0.k() - P0.i(), j8);
            P0.c(min);
            this.f47387i += min;
            a(P0);
            long j10 = min;
            j8 -= j10;
            j9 += j10;
        }
        return j9;
    }

    private final ChunkBuffer w() {
        if (this.f47390l) {
            return null;
        }
        ChunkBuffer N = N();
        if (N == null) {
            this.f47390l = true;
            return null;
        }
        e(N);
        return N;
    }

    public final long C0() {
        return (f0() - s0()) + this.f47389k;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void D0() {
        if (!this.f47390l) {
            this.f47390l = true;
        }
    }

    public final ChunkBuffer I(ChunkBuffer current) {
        Intrinsics.f(current, "current");
        return y(current);
    }

    protected ChunkBuffer N() {
        ChunkBuffer u02 = this.f47384f.u0();
        try {
            u02.p(8);
            int O = O(u02.h(), u02.k(), u02.g() - u02.k());
            if (O == 0) {
                boolean z7 = true;
                this.f47390l = true;
                if (u02.k() <= u02.i()) {
                    z7 = false;
                }
                if (!z7) {
                    u02.E(this.f47384f);
                    return null;
                }
            }
            u02.a(O);
            return u02;
        } catch (Throwable th) {
            u02.E(this.f47384f);
            throw th;
        }
    }

    protected abstract int O(ByteBuffer byteBuffer, int i8, int i9);

    public final ChunkBuffer P0(int i8) {
        ChunkBuffer d02 = d0();
        if (this.f47388j - this.f47387i >= i8) {
            return d02;
        }
        return S0(i8, d02);
    }

    public final ChunkBuffer R0(int i8) {
        return S0(i8, d0());
    }

    public final String W0(int i8, int i9) {
        int d8;
        int g8;
        if (i8 == 0 && (i9 == 0 || c0())) {
            return "";
        }
        long C0 = C0();
        if (C0 > 0 && i9 >= C0) {
            return StringsKt.g(this, (int) C0, null, 2, null);
        }
        d8 = RangesKt___RangesKt.d(i8, 16);
        g8 = RangesKt___RangesKt.g(d8, i9);
        StringBuilder sb = new StringBuilder(g8);
        U0(sb, i8, i9);
        String sb2 = sb.toString();
        Intrinsics.e(sb2, "StringBuilder(capacity).…builderAction).toString()");
        return sb2;
    }

    public final void X(ChunkBuffer current) {
        Intrinsics.f(current, "current");
        ChunkBuffer B = current.B();
        if (B == null) {
            Y(current);
            return;
        }
        int k8 = current.k() - current.i();
        int min = Math.min(k8, 8 - (current.f() - current.g()));
        if (B.j() < min) {
            Y(current);
            return;
        }
        BufferKt.f(B, min);
        if (k8 > min) {
            current.m();
            this.f47388j = current.k();
            h1(this.f47389k + min);
            return;
        }
        l1(B);
        h1(this.f47389k - ((B.k() - B.i()) - min));
        current.z();
        current.E(this.f47384f);
    }

    public final void c(ChunkBuffer chain) {
        Intrinsics.f(chain, "chain");
        ChunkBuffer.Companion companion = ChunkBuffer.f47400j;
        if (chain == companion.a()) {
            return;
        }
        long e8 = BuffersKt.e(chain);
        if (this.f47385g == companion.a()) {
            l1(chain);
            h1(e8 - (f0() - s0()));
            return;
        }
        BuffersKt.c(this.f47385g).G(chain);
        h1(this.f47389k + e8);
    }

    public final boolean c0() {
        if (f0() - s0() == 0 && this.f47389k == 0 && (this.f47390l || w() == null)) {
            return true;
        }
        return false;
    }

    public final ChunkBuffer c1(ChunkBuffer head) {
        Intrinsics.f(head, "head");
        ChunkBuffer z7 = head.z();
        if (z7 == null) {
            z7 = ChunkBuffer.f47400j.a();
        }
        l1(z7);
        h1(this.f47389k - (z7.k() - z7.i()));
        head.E(this.f47384f);
        return z7;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        release();
        if (!this.f47390l) {
            this.f47390l = true;
        }
        j();
    }

    public final ChunkBuffer d0() {
        ChunkBuffer chunkBuffer = this.f47385g;
        chunkBuffer.d(this.f47387i);
        return chunkBuffer;
    }

    public final int f0() {
        return this.f47388j;
    }

    public final void f1(int i8) {
        this.f47387i = i8;
    }

    public final boolean h() {
        if (this.f47387i == this.f47388j && this.f47389k == 0) {
            return false;
        }
        return true;
    }

    public final void h1(long j8) {
        boolean z7;
        if (j8 >= 0) {
            z7 = true;
        } else {
            z7 = false;
        }
        if (z7) {
            this.f47389k = j8;
            return;
        }
        throw new IllegalArgumentException(("tailRemaining shouldn't be negative: " + j8).toString());
    }

    protected abstract void j();

    public final int k(int i8) {
        boolean z7;
        if (i8 >= 0) {
            z7 = true;
        } else {
            z7 = false;
        }
        if (z7) {
            return m(i8, 0);
        }
        throw new IllegalArgumentException(("Negative discard is not allowed: " + i8).toString());
    }

    public final ByteBuffer k0() {
        return this.f47386h;
    }

    public final long l(long j8) {
        if (j8 <= 0) {
            return 0L;
        }
        return q(j8, 0L);
    }

    public final ChunkBuffer m1() {
        ChunkBuffer d02 = d0();
        ChunkBuffer B = d02.B();
        ChunkBuffer a8 = ChunkBuffer.f47400j.a();
        if (d02 == a8) {
            return null;
        }
        if (B == null) {
            l1(a8);
            h1(0L);
        } else {
            l1(B);
            h1(this.f47389k - (B.k() - B.i()));
        }
        d02.G(null);
        return d02;
    }

    public final ChunkBuffer n1() {
        ChunkBuffer d02 = d0();
        ChunkBuffer a8 = ChunkBuffer.f47400j.a();
        if (d02 == a8) {
            return null;
        }
        l1(a8);
        h1(0L);
        return d02;
    }

    public final boolean o1(ChunkBuffer chain) {
        Intrinsics.f(chain, "chain");
        ChunkBuffer c8 = BuffersKt.c(d0());
        int k8 = chain.k() - chain.i();
        if (k8 != 0 && c8.g() - c8.k() >= k8) {
            BufferAppendKt.a(c8, chain, k8);
            if (d0() == c8) {
                this.f47388j = c8.k();
                return true;
            }
            h1(this.f47389k + k8);
            return true;
        }
        return false;
    }

    public final void release() {
        ChunkBuffer d02 = d0();
        ChunkBuffer a8 = ChunkBuffer.f47400j.a();
        if (d02 != a8) {
            l1(a8);
            h1(0L);
            BuffersKt.d(d02, this.f47384f);
        }
    }

    public final int s0() {
        return this.f47387i;
    }

    public final void t(int i8) {
        if (k(i8) == i8) {
            return;
        }
        throw new EOFException("Unable to discard " + i8 + " bytes due to end of packet");
    }

    public final ObjectPool<ChunkBuffer> v0() {
        return this.f47384f;
    }

    public final ChunkBuffer y(ChunkBuffer current) {
        Intrinsics.f(current, "current");
        return F(current, ChunkBuffer.f47400j.a());
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public /* synthetic */ Input(io.ktor.utils.io.core.internal.ChunkBuffer r1, long r2, io.ktor.utils.io.pool.ObjectPool<io.ktor.utils.io.core.internal.ChunkBuffer> r4, int r5, kotlin.jvm.internal.DefaultConstructorMarker r6) {
        /*
            r0 = this;
            r6 = r5 & 1
            if (r6 == 0) goto La
            io.ktor.utils.io.core.internal.ChunkBuffer$Companion r1 = io.ktor.utils.io.core.internal.ChunkBuffer.f47400j
            io.ktor.utils.io.core.internal.ChunkBuffer r1 = r1.a()
        La:
            r6 = r5 & 2
            if (r6 == 0) goto L12
            long r2 = io.ktor.utils.io.core.BuffersKt.e(r1)
        L12:
            r5 = r5 & 4
            if (r5 == 0) goto L1c
            io.ktor.utils.io.core.internal.ChunkBuffer$Companion r4 = io.ktor.utils.io.core.internal.ChunkBuffer.f47400j
            io.ktor.utils.io.pool.ObjectPool r4 = r4.c()
        L1c:
            r0.<init>(r1, r2, r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.core.Input.<init>(io.ktor.utils.io.core.internal.ChunkBuffer, long, io.ktor.utils.io.pool.ObjectPool, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
