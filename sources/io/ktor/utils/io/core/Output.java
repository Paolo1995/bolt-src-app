package io.ktor.utils.io.core;

import io.ktor.utils.io.bits.Memory;
import io.ktor.utils.io.core.internal.ChunkBuffer;
import io.ktor.utils.io.core.internal.ChunkBufferKt;
import io.ktor.utils.io.core.internal.NumbersKt;
import io.ktor.utils.io.core.internal.UTF8Kt;
import io.ktor.utils.io.pool.ObjectPool;
import java.io.Closeable;
import java.io.EOFException;
import java.nio.ByteBuffer;
import kotlin.KotlinNothingValueException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

/* compiled from: Output.kt */
/* loaded from: classes5.dex */
public abstract class Output implements Appendable, Closeable {

    /* renamed from: f  reason: collision with root package name */
    private final ObjectPool<ChunkBuffer> f47391f;

    /* renamed from: g  reason: collision with root package name */
    private ChunkBuffer f47392g;

    /* renamed from: h  reason: collision with root package name */
    private ChunkBuffer f47393h;

    /* renamed from: i  reason: collision with root package name */
    private ByteBuffer f47394i;

    /* renamed from: j  reason: collision with root package name */
    private int f47395j;

    /* renamed from: k  reason: collision with root package name */
    private int f47396k;

    /* renamed from: l  reason: collision with root package name */
    private int f47397l;

    /* renamed from: m  reason: collision with root package name */
    private int f47398m;

    public Output(ObjectPool<ChunkBuffer> pool) {
        Intrinsics.f(pool, "pool");
        this.f47391f = pool;
        this.f47394i = Memory.f47364a.a();
    }

    private final void C0(ChunkBuffer chunkBuffer, ChunkBuffer chunkBuffer2) {
        BufferAppendKt.c(chunkBuffer, chunkBuffer2);
        ChunkBuffer chunkBuffer3 = this.f47392g;
        if (chunkBuffer3 != null) {
            if (chunkBuffer3 == chunkBuffer2) {
                this.f47392g = chunkBuffer;
            } else {
                while (true) {
                    ChunkBuffer B = chunkBuffer3.B();
                    Intrinsics.c(B);
                    if (B == chunkBuffer2) {
                        break;
                    }
                    chunkBuffer3 = B;
                }
                chunkBuffer3.G(chunkBuffer);
            }
            chunkBuffer2.E(this.f47391f);
            this.f47393h = BuffersKt.c(chunkBuffer);
            return;
        }
        throw new IllegalStateException("head should't be null since it is already handled in the fast-path".toString());
    }

    private final void k(ChunkBuffer chunkBuffer, ChunkBuffer chunkBuffer2, int i8) {
        ChunkBuffer chunkBuffer3 = this.f47393h;
        if (chunkBuffer3 == null) {
            this.f47392g = chunkBuffer;
            this.f47398m = 0;
        } else {
            chunkBuffer3.G(chunkBuffer);
            int i9 = this.f47395j;
            chunkBuffer3.b(i9);
            this.f47398m += i9 - this.f47397l;
        }
        this.f47393h = chunkBuffer2;
        this.f47398m += i8;
        this.f47394i = chunkBuffer2.h();
        this.f47395j = chunkBuffer2.k();
        this.f47397l = chunkBuffer2.i();
        this.f47396k = chunkBuffer2.g();
    }

    private final void l(char c8) {
        boolean z7;
        boolean z8;
        boolean z9;
        boolean z10;
        int i8 = 3;
        ChunkBuffer Z = Z(3);
        try {
            ByteBuffer h8 = Z.h();
            int k8 = Z.k();
            boolean z11 = true;
            if (c8 >= 0 && c8 < 128) {
                z7 = true;
            } else {
                z7 = false;
            }
            if (z7) {
                h8.put(k8, (byte) c8);
                i8 = 1;
            } else {
                if (128 <= c8 && c8 < 2048) {
                    z8 = true;
                } else {
                    z8 = false;
                }
                if (z8) {
                    h8.put(k8, (byte) (((c8 >> 6) & 31) | 192));
                    h8.put(k8 + 1, (byte) ((c8 & '?') | 128));
                    i8 = 2;
                } else {
                    if (2048 <= c8 && c8 < 0) {
                        z9 = true;
                    } else {
                        z9 = false;
                    }
                    if (z9) {
                        h8.put(k8, (byte) (((c8 >> '\f') & 15) | 224));
                        h8.put(k8 + 1, (byte) (((c8 >> 6) & 63) | 128));
                        h8.put(k8 + 2, (byte) ((c8 & '?') | 128));
                    } else {
                        if (0 <= c8 && c8 < 0) {
                            z10 = true;
                        } else {
                            z10 = false;
                        }
                        if (z10) {
                            h8.put(k8, (byte) (((c8 >> 18) & 7) | 240));
                            h8.put(k8 + 1, (byte) (((c8 >> '\f') & 63) | 128));
                            h8.put(k8 + 2, (byte) (((c8 >> 6) & 63) | 128));
                            h8.put(k8 + 3, (byte) ((c8 & '?') | 128));
                            i8 = 4;
                        } else {
                            UTF8Kt.j(c8);
                            throw new KotlinNothingValueException();
                        }
                    }
                }
            }
            Z.a(i8);
            if (i8 < 0) {
                z11 = false;
            }
            if (z11) {
                return;
            }
            throw new IllegalStateException("The returned value shouldn't be negative".toString());
        } finally {
            c();
        }
    }

    private final ChunkBuffer m() {
        ChunkBuffer u02 = this.f47391f.u0();
        u02.p(8);
        q(u02);
        return u02;
    }

    private final void v0(ChunkBuffer chunkBuffer, ChunkBuffer chunkBuffer2, ObjectPool<ChunkBuffer> objectPool) {
        chunkBuffer.b(this.f47395j);
        int k8 = chunkBuffer.k() - chunkBuffer.i();
        int k9 = chunkBuffer2.k() - chunkBuffer2.i();
        int a8 = PacketJVMKt.a();
        k9 = (k9 >= a8 || k9 > (chunkBuffer.f() - chunkBuffer.g()) + (chunkBuffer.g() - chunkBuffer.k())) ? -1 : -1;
        k8 = (k8 >= a8 || k8 > chunkBuffer2.j() || !ChunkBufferKt.a(chunkBuffer2)) ? -1 : -1;
        if (k9 == -1 && k8 == -1) {
            j(chunkBuffer2);
        } else if (k8 != -1 && k9 > k8) {
            if (k9 != -1 && k8 >= k9) {
                throw new IllegalStateException("prep = " + k8 + ", app = " + k9);
            }
            C0(chunkBuffer2, chunkBuffer);
        } else {
            BufferAppendKt.a(chunkBuffer, chunkBuffer2, (chunkBuffer.g() - chunkBuffer.k()) + (chunkBuffer.f() - chunkBuffer.g()));
            c();
            ChunkBuffer z7 = chunkBuffer2.z();
            if (z7 != null) {
                j(z7);
            }
            chunkBuffer2.E(objectPool);
        }
    }

    private final void y() {
        ChunkBuffer d02 = d0();
        if (d02 == null) {
            return;
        }
        ChunkBuffer chunkBuffer = d02;
        do {
            try {
                w(chunkBuffer.h(), chunkBuffer.i(), chunkBuffer.k() - chunkBuffer.i());
                chunkBuffer = chunkBuffer.B();
            } finally {
                BuffersKt.d(d02, this.f47391f);
            }
        } while (chunkBuffer != null);
    }

    public final ChunkBuffer F() {
        ChunkBuffer chunkBuffer = this.f47392g;
        if (chunkBuffer == null) {
            return ChunkBuffer.f47400j.a();
        }
        return chunkBuffer;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final ObjectPool<ChunkBuffer> I() {
        return this.f47391f;
    }

    public final int N() {
        return this.f47396k;
    }

    public final ByteBuffer O() {
        return this.f47394i;
    }

    public final int X() {
        return this.f47395j;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final int Y() {
        return this.f47398m + (this.f47395j - this.f47397l);
    }

    public final ChunkBuffer Z(int i8) {
        ChunkBuffer chunkBuffer;
        if (N() - X() >= i8 && (chunkBuffer = this.f47393h) != null) {
            chunkBuffer.b(this.f47395j);
            return chunkBuffer;
        }
        return m();
    }

    public final void a() {
        boolean z7;
        ChunkBuffer F = F();
        if (F != ChunkBuffer.f47400j.a()) {
            if (F.B() == null) {
                z7 = true;
            } else {
                z7 = false;
            }
            if (z7) {
                F.s();
                F.p(8);
                int k8 = F.k();
                this.f47395j = k8;
                this.f47397l = k8;
                this.f47396k = F.g();
                return;
            }
            throw new IllegalStateException("Check failed.".toString());
        }
    }

    public final void c() {
        ChunkBuffer chunkBuffer = this.f47393h;
        if (chunkBuffer != null) {
            this.f47395j = chunkBuffer.k();
        }
    }

    public final void c0(int i8) {
        this.f47395j = i8;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        try {
            flush();
        } finally {
            t();
        }
    }

    public final ChunkBuffer d0() {
        ChunkBuffer chunkBuffer = this.f47392g;
        if (chunkBuffer == null) {
            return null;
        }
        ChunkBuffer chunkBuffer2 = this.f47393h;
        if (chunkBuffer2 != null) {
            chunkBuffer2.b(this.f47395j);
        }
        this.f47392g = null;
        this.f47393h = null;
        this.f47395j = 0;
        this.f47396k = 0;
        this.f47397l = 0;
        this.f47398m = 0;
        this.f47394i = Memory.f47364a.a();
        return chunkBuffer;
    }

    @Override // java.lang.Appendable
    /* renamed from: e */
    public Output append(char c8) {
        boolean z7;
        boolean z8;
        boolean z9;
        int i8 = this.f47395j;
        int i9 = 3;
        if (this.f47396k - i8 >= 3) {
            ByteBuffer byteBuffer = this.f47394i;
            boolean z10 = true;
            if (c8 >= 0 && c8 < 128) {
                z7 = true;
            } else {
                z7 = false;
            }
            if (z7) {
                byteBuffer.put(i8, (byte) c8);
                i9 = 1;
            } else {
                if (128 <= c8 && c8 < 2048) {
                    z8 = true;
                } else {
                    z8 = false;
                }
                if (z8) {
                    byteBuffer.put(i8, (byte) (((c8 >> 6) & 31) | 192));
                    byteBuffer.put(i8 + 1, (byte) ((c8 & '?') | 128));
                    i9 = 2;
                } else {
                    if (2048 <= c8 && c8 < 0) {
                        z9 = true;
                    } else {
                        z9 = false;
                    }
                    if (z9) {
                        byteBuffer.put(i8, (byte) (((c8 >> '\f') & 15) | 224));
                        byteBuffer.put(i8 + 1, (byte) (((c8 >> 6) & 63) | 128));
                        byteBuffer.put(i8 + 2, (byte) ((c8 & '?') | 128));
                    } else {
                        if ((0 > c8 || c8 >= 0) ? false : false) {
                            byteBuffer.put(i8, (byte) (((c8 >> 18) & 7) | 240));
                            byteBuffer.put(i8 + 1, (byte) (((c8 >> '\f') & 63) | 128));
                            byteBuffer.put(i8 + 2, (byte) (((c8 >> 6) & 63) | 128));
                            byteBuffer.put(i8 + 3, (byte) ((c8 & '?') | 128));
                            i9 = 4;
                        } else {
                            UTF8Kt.j(c8);
                            throw new KotlinNothingValueException();
                        }
                    }
                }
            }
            this.f47395j = i8 + i9;
            return this;
        }
        l(c8);
        return this;
    }

    public final void f0(ChunkBuffer chunkBuffer) {
        Intrinsics.f(chunkBuffer, "chunkBuffer");
        ChunkBuffer chunkBuffer2 = this.f47393h;
        if (chunkBuffer2 == null) {
            j(chunkBuffer);
        } else {
            v0(chunkBuffer2, chunkBuffer, this.f47391f);
        }
    }

    public final void flush() {
        y();
    }

    @Override // java.lang.Appendable
    /* renamed from: g */
    public Output append(CharSequence charSequence) {
        if (charSequence == null) {
            append("null", 0, 4);
        } else {
            append(charSequence, 0, charSequence.length());
        }
        return this;
    }

    @Override // java.lang.Appendable
    /* renamed from: h */
    public Output append(CharSequence charSequence, int i8, int i9) {
        if (charSequence == null) {
            return append("null", i8, i9);
        }
        StringsKt.h(this, charSequence, i8, i9, Charsets.f51135b);
        return this;
    }

    public final void j(ChunkBuffer head) {
        Intrinsics.f(head, "head");
        ChunkBuffer c8 = BuffersKt.c(head);
        long e8 = BuffersKt.e(head) - (c8.k() - c8.i());
        if (e8 < 2147483647L) {
            k(head, c8, (int) e8);
        } else {
            NumbersKt.a(e8, "total size increase");
            throw new KotlinNothingValueException();
        }
    }

    public final void k0(ByteReadPacket packet) {
        Intrinsics.f(packet, "packet");
        ChunkBuffer n12 = packet.n1();
        if (n12 == null) {
            packet.release();
            return;
        }
        ChunkBuffer chunkBuffer = this.f47393h;
        if (chunkBuffer == null) {
            j(n12);
        } else {
            v0(chunkBuffer, n12, packet.v0());
        }
    }

    public final void q(ChunkBuffer buffer) {
        boolean z7;
        Intrinsics.f(buffer, "buffer");
        if (buffer.B() == null) {
            z7 = true;
        } else {
            z7 = false;
        }
        if (z7) {
            k(buffer, buffer, 0);
            return;
        }
        throw new IllegalStateException("It should be a single buffer chunk.".toString());
    }

    public final void release() {
        close();
    }

    public final void s0(ByteReadPacket p8, long j8) {
        Intrinsics.f(p8, "p");
        while (j8 > 0) {
            long f02 = p8.f0() - p8.s0();
            if (f02 <= j8) {
                j8 -= f02;
                ChunkBuffer m12 = p8.m1();
                if (m12 != null) {
                    q(m12);
                } else {
                    throw new EOFException("Unexpected end of packet");
                }
            } else {
                ChunkBuffer P0 = p8.P0(1);
                if (P0 != null) {
                    int i8 = P0.i();
                    try {
                        OutputKt.a(this, P0, (int) j8);
                        int i9 = P0.i();
                        if (i9 >= i8) {
                            if (i9 == P0.k()) {
                                p8.y(P0);
                                return;
                            } else {
                                p8.f1(i9);
                                return;
                            }
                        }
                        throw new IllegalStateException("Buffer's position shouldn't be rewinded");
                    } catch (Throwable th) {
                        int i10 = P0.i();
                        if (i10 >= i8) {
                            if (i10 == P0.k()) {
                                p8.y(P0);
                            } else {
                                p8.f1(i10);
                            }
                            throw th;
                        }
                        throw new IllegalStateException("Buffer's position shouldn't be rewinded");
                    }
                }
                StringsKt.a(1);
                throw new KotlinNothingValueException();
            }
        }
    }

    protected abstract void t();

    protected abstract void w(ByteBuffer byteBuffer, int i8, int i9);

    public Output() {
        this(ChunkBuffer.f47400j.c());
    }
}
