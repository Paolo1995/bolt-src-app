package okio;

import com.google.android.gms.common.api.Api;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt__CharJVMKt;
import okio.internal._BufferKt;

/* compiled from: RealBufferedSource.kt */
/* loaded from: classes5.dex */
public final class RealBufferedSource implements BufferedSource {

    /* renamed from: f  reason: collision with root package name */
    public final Source f52626f;

    /* renamed from: g  reason: collision with root package name */
    public final Buffer f52627g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f52628h;

    public RealBufferedSource(Source source) {
        Intrinsics.f(source, "source");
        this.f52626f = source;
        this.f52627g = new Buffer();
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x002c, code lost:
        if (r9 == 0) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x002f, code lost:
        r1 = kotlin.text.CharsKt__CharJVMKt.a(16);
        r1 = kotlin.text.CharsKt__CharJVMKt.a(r1);
        r1 = java.lang.Integer.toString(r8, r1);
        kotlin.jvm.internal.Intrinsics.e(r1, "java.lang.Integer.toStri…(this, checkRadix(radix))");
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x004d, code lost:
        throw new java.lang.NumberFormatException(kotlin.jvm.internal.Intrinsics.n("Expected a digit or '-' but was 0x", r1));
     */
    @Override // okio.BufferedSource
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public long A0() {
        /*
            r10 = this;
            r0 = 1
            r10.j0(r0)
            r2 = 0
            r4 = r2
        L8:
            long r6 = r4 + r0
            boolean r8 = r10.f(r6)
            if (r8 == 0) goto L4e
            okio.Buffer r8 = r10.f52627g
            byte r8 = r8.m(r4)
            r9 = 48
            byte r9 = (byte) r9
            if (r8 < r9) goto L20
            r9 = 57
            byte r9 = (byte) r9
            if (r8 <= r9) goto L2a
        L20:
            int r9 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r9 != 0) goto L2c
            r4 = 45
            byte r4 = (byte) r4
            if (r8 == r4) goto L2a
            goto L2c
        L2a:
            r4 = r6
            goto L8
        L2c:
            if (r9 == 0) goto L2f
            goto L4e
        L2f:
            java.lang.NumberFormatException r0 = new java.lang.NumberFormatException
            r1 = 16
            int r1 = kotlin.text.CharsKt.a(r1)
            int r1 = kotlin.text.CharsKt.a(r1)
            java.lang.String r1 = java.lang.Integer.toString(r8, r1)
            java.lang.String r2 = "java.lang.Integer.toStri…(this, checkRadix(radix))"
            kotlin.jvm.internal.Intrinsics.e(r1, r2)
            java.lang.String r2 = "Expected a digit or '-' but was 0x"
            java.lang.String r1 = kotlin.jvm.internal.Intrinsics.n(r2, r1)
            r0.<init>(r1)
            throw r0
        L4e:
            okio.Buffer r0 = r10.f52627g
            long r0 = r0.A0()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.RealBufferedSource.A0():long");
    }

    @Override // okio.BufferedSource
    public long B(ByteString bytes) {
        Intrinsics.f(bytes, "bytes");
        return e(bytes, 0L);
    }

    @Override // okio.BufferedSource
    public void E(Buffer sink, long j8) {
        Intrinsics.f(sink, "sink");
        try {
            j0(j8);
            this.f52627g.E(sink, j8);
        } catch (EOFException e8) {
            sink.V(this.f52627g);
            throw e8;
        }
    }

    @Override // okio.BufferedSource
    public long G(ByteString targetBytes) {
        Intrinsics.f(targetBytes, "targetBytes");
        return g(targetBytes, 0L);
    }

    @Override // okio.BufferedSource
    public String J(long j8) {
        boolean z7;
        long j9;
        if (j8 >= 0) {
            z7 = true;
        } else {
            z7 = false;
        }
        if (z7) {
            if (j8 == Long.MAX_VALUE) {
                j9 = Long.MAX_VALUE;
            } else {
                j9 = j8 + 1;
            }
            byte b8 = (byte) 10;
            long c8 = c(b8, 0L, j9);
            if (c8 != -1) {
                return _BufferKt.d(this.f52627g, c8);
            }
            if (j9 < Long.MAX_VALUE && f(j9) && this.f52627g.m(j9 - 1) == ((byte) 13) && f(1 + j9) && this.f52627g.m(j9) == b8) {
                return _BufferKt.d(this.f52627g, j9);
            }
            Buffer buffer = new Buffer();
            Buffer buffer2 = this.f52627g;
            buffer2.j(buffer, 0L, Math.min(32, buffer2.size()));
            throw new EOFException("\\n not found: limit=" + Math.min(this.f52627g.size(), j8) + " content=" + buffer.N0().p() + (char) 8230);
        }
        throw new IllegalArgumentException(Intrinsics.n("limit < 0: ", Long.valueOf(j8)).toString());
    }

    @Override // okio.BufferedSource
    public String L0(Charset charset) {
        Intrinsics.f(charset, "charset");
        this.f52627g.V(this.f52626f);
        return this.f52627g.L0(charset);
    }

    @Override // okio.BufferedSource
    public ByteString N0() {
        this.f52627g.V(this.f52626f);
        return this.f52627g.N0();
    }

    @Override // okio.BufferedSource
    public boolean R(long j8, ByteString bytes) {
        Intrinsics.f(bytes, "bytes");
        return h(j8, bytes, 0, bytes.z());
    }

    public long a(byte b8) {
        return c(b8, 0L, Long.MAX_VALUE);
    }

    @Override // okio.BufferedSource, okio.BufferedSink
    public Buffer b() {
        return this.f52627g;
    }

    @Override // okio.BufferedSource
    public String b0() {
        return J(Long.MAX_VALUE);
    }

    public long c(byte b8, long j8, long j9) {
        boolean z7 = true;
        if (!this.f52628h) {
            if ((0 > j8 || j8 > j9) ? false : false) {
                while (j8 < j9) {
                    long q8 = this.f52627g.q(b8, j8, j9);
                    if (q8 != -1) {
                        return q8;
                    }
                    long size = this.f52627g.size();
                    if (size >= j9 || this.f52626f.read(this.f52627g, 8192L) == -1) {
                        return -1L;
                    }
                    j8 = Math.max(j8, size);
                }
                return -1L;
            }
            throw new IllegalArgumentException(("fromIndex=" + j8 + " toIndex=" + j9).toString());
        }
        throw new IllegalStateException("closed".toString());
    }

    @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (!this.f52628h) {
            this.f52628h = true;
            this.f52626f.close();
            this.f52627g.a();
        }
    }

    public long e(ByteString bytes, long j8) {
        Intrinsics.f(bytes, "bytes");
        if (!(!this.f52628h)) {
            throw new IllegalStateException("closed".toString());
        }
        while (true) {
            long t7 = this.f52627g.t(bytes, j8);
            if (t7 == -1) {
                long size = this.f52627g.size();
                if (this.f52626f.read(this.f52627g, 8192L) == -1) {
                    return -1L;
                }
                j8 = Math.max(j8, (size - bytes.z()) + 1);
            } else {
                return t7;
            }
        }
    }

    @Override // okio.BufferedSource
    public byte[] e0(long j8) {
        j0(j8);
        return this.f52627g.e0(j8);
    }

    @Override // okio.BufferedSource
    public long e1(Sink sink) {
        Intrinsics.f(sink, "sink");
        long j8 = 0;
        while (this.f52626f.read(this.f52627g, 8192L) != -1) {
            long e8 = this.f52627g.e();
            if (e8 > 0) {
                j8 += e8;
                sink.write(this.f52627g, e8);
            }
        }
        if (this.f52627g.size() > 0) {
            long size = j8 + this.f52627g.size();
            Buffer buffer = this.f52627g;
            sink.write(buffer, buffer.size());
            return size;
        }
        return j8;
    }

    @Override // okio.BufferedSource
    public boolean f(long j8) {
        boolean z7;
        if (j8 >= 0) {
            z7 = true;
        } else {
            z7 = false;
        }
        if (z7) {
            if (!this.f52628h) {
                while (this.f52627g.size() < j8) {
                    if (this.f52626f.read(this.f52627g, 8192L) == -1) {
                        return false;
                    }
                }
                return true;
            }
            throw new IllegalStateException("closed".toString());
        }
        throw new IllegalArgumentException(Intrinsics.n("byteCount < 0: ", Long.valueOf(j8)).toString());
    }

    public long g(ByteString targetBytes, long j8) {
        Intrinsics.f(targetBytes, "targetBytes");
        if (!(!this.f52628h)) {
            throw new IllegalStateException("closed".toString());
        }
        while (true) {
            long N = this.f52627g.N(targetBytes, j8);
            if (N == -1) {
                long size = this.f52627g.size();
                if (this.f52626f.read(this.f52627g, 8192L) == -1) {
                    return -1L;
                }
                j8 = Math.max(j8, size);
            } else {
                return N;
            }
        }
    }

    public boolean h(long j8, ByteString bytes, int i8, int i9) {
        Intrinsics.f(bytes, "bytes");
        if (!this.f52628h) {
            if (j8 >= 0 && i8 >= 0 && i9 >= 0 && bytes.z() - i8 >= i9) {
                if (i9 <= 0) {
                    return true;
                }
                int i10 = 0;
                while (true) {
                    int i11 = i10 + 1;
                    long j9 = i10 + j8;
                    if (!f(1 + j9) || this.f52627g.m(j9) != bytes.h(i10 + i8)) {
                        break;
                    } else if (i11 >= i9) {
                        return true;
                    } else {
                        i10 = i11;
                    }
                }
            }
            return false;
        }
        throw new IllegalStateException("closed".toString());
    }

    @Override // okio.BufferedSource
    public long i1() {
        byte m8;
        int a8;
        int a9;
        j0(1L);
        int i8 = 0;
        while (true) {
            int i9 = i8 + 1;
            if (!f(i9)) {
                break;
            }
            m8 = this.f52627g.m(i8);
            if ((m8 < ((byte) 48) || m8 > ((byte) 57)) && ((m8 < ((byte) 97) || m8 > ((byte) 102)) && (m8 < ((byte) 65) || m8 > ((byte) 70)))) {
                break;
            }
            i8 = i9;
        }
        if (i8 == 0) {
            a8 = CharsKt__CharJVMKt.a(16);
            a9 = CharsKt__CharJVMKt.a(a8);
            String num = Integer.toString(m8, a9);
            Intrinsics.e(num, "java.lang.Integer.toStri…(this, checkRadix(radix))");
            throw new NumberFormatException(Intrinsics.n("Expected leading [0-9a-fA-F] character but was 0x", num));
        }
        return this.f52627g.i1();
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return !this.f52628h;
    }

    public int j() {
        j0(4L);
        return this.f52627g.c0();
    }

    @Override // okio.BufferedSource
    public void j0(long j8) {
        if (f(j8)) {
            return;
        }
        throw new EOFException();
    }

    @Override // okio.BufferedSource
    public InputStream j1() {
        return new InputStream() { // from class: okio.RealBufferedSource$inputStream$1
            @Override // java.io.InputStream
            public int available() {
                RealBufferedSource realBufferedSource = RealBufferedSource.this;
                if (!realBufferedSource.f52628h) {
                    return (int) Math.min(realBufferedSource.f52627g.size(), (long) Api.BaseClientBuilder.API_PRIORITY_OTHER);
                }
                throw new IOException("closed");
            }

            @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
            public void close() {
                RealBufferedSource.this.close();
            }

            @Override // java.io.InputStream
            public int read() {
                RealBufferedSource realBufferedSource = RealBufferedSource.this;
                if (!realBufferedSource.f52628h) {
                    if (realBufferedSource.f52627g.size() == 0) {
                        RealBufferedSource realBufferedSource2 = RealBufferedSource.this;
                        if (realBufferedSource2.f52626f.read(realBufferedSource2.f52627g, 8192L) == -1) {
                            return -1;
                        }
                    }
                    return RealBufferedSource.this.f52627g.readByte() & 255;
                }
                throw new IOException("closed");
            }

            public String toString() {
                return RealBufferedSource.this + ".inputStream()";
            }

            @Override // java.io.InputStream
            public int read(byte[] data, int i8, int i9) {
                Intrinsics.f(data, "data");
                if (!RealBufferedSource.this.f52628h) {
                    _UtilKt.b(data.length, i8, i9);
                    if (RealBufferedSource.this.f52627g.size() == 0) {
                        RealBufferedSource realBufferedSource = RealBufferedSource.this;
                        if (realBufferedSource.f52626f.read(realBufferedSource.f52627g, 8192L) == -1) {
                            return -1;
                        }
                    }
                    return RealBufferedSource.this.f52627g.read(data, i8, i9);
                }
                throw new IOException("closed");
            }
        };
    }

    public short k() {
        j0(2L);
        return this.f52627g.d0();
    }

    @Override // okio.BufferedSource
    public int k1(Options options) {
        Intrinsics.f(options, "options");
        if (!this.f52628h) {
            while (true) {
                int e8 = _BufferKt.e(this.f52627g, options, true);
                if (e8 != -2) {
                    if (e8 != -1) {
                        this.f52627g.skip(options.i()[e8].z());
                        return e8;
                    }
                } else if (this.f52626f.read(this.f52627g, 8192L) == -1) {
                    break;
                }
            }
            return -1;
        }
        throw new IllegalStateException("closed".toString());
    }

    @Override // okio.BufferedSource
    public ByteString o0(long j8) {
        j0(j8);
        return this.f52627g.o0(j8);
    }

    @Override // okio.BufferedSource
    public BufferedSource peek() {
        return Okio.d(new PeekSource(this));
    }

    @Override // okio.Source
    public long read(Buffer sink, long j8) {
        Intrinsics.f(sink, "sink");
        if (j8 >= 0) {
            if (true ^ this.f52628h) {
                if (this.f52627g.size() == 0 && this.f52626f.read(this.f52627g, 8192L) == -1) {
                    return -1L;
                }
                return this.f52627g.read(sink, Math.min(j8, this.f52627g.size()));
            }
            throw new IllegalStateException("closed".toString());
        }
        throw new IllegalArgumentException(Intrinsics.n("byteCount < 0: ", Long.valueOf(j8)).toString());
    }

    @Override // okio.BufferedSource
    public byte readByte() {
        j0(1L);
        return this.f52627g.readByte();
    }

    @Override // okio.BufferedSource
    public void readFully(byte[] sink) {
        Intrinsics.f(sink, "sink");
        try {
            j0(sink.length);
            this.f52627g.readFully(sink);
        } catch (EOFException e8) {
            int i8 = 0;
            while (this.f52627g.size() > 0) {
                Buffer buffer = this.f52627g;
                int read = buffer.read(sink, i8, (int) buffer.size());
                if (read != -1) {
                    i8 += read;
                } else {
                    throw new AssertionError();
                }
            }
            throw e8;
        }
    }

    @Override // okio.BufferedSource
    public int readInt() {
        j0(4L);
        return this.f52627g.readInt();
    }

    @Override // okio.BufferedSource
    public long readLong() {
        j0(8L);
        return this.f52627g.readLong();
    }

    @Override // okio.BufferedSource
    public short readShort() {
        j0(2L);
        return this.f52627g.readShort();
    }

    @Override // okio.BufferedSource
    public Buffer s() {
        return this.f52627g;
    }

    @Override // okio.BufferedSource
    public void skip(long j8) {
        if (!this.f52628h) {
            while (j8 > 0) {
                if (this.f52627g.size() == 0 && this.f52626f.read(this.f52627g, 8192L) == -1) {
                    throw new EOFException();
                }
                long min = Math.min(j8, this.f52627g.size());
                this.f52627g.skip(min);
                j8 -= min;
            }
            return;
        }
        throw new IllegalStateException("closed".toString());
    }

    @Override // okio.Source
    public Timeout timeout() {
        return this.f52626f.timeout();
    }

    public String toString() {
        return "buffer(" + this.f52626f + ')';
    }

    @Override // okio.BufferedSource
    public byte[] w0() {
        this.f52627g.V(this.f52626f);
        return this.f52627g.w0();
    }

    @Override // okio.BufferedSource
    public boolean y0() {
        if (!this.f52628h) {
            if (this.f52627g.y0() && this.f52626f.read(this.f52627g, 8192L) == -1) {
                return true;
            }
            return false;
        }
        throw new IllegalStateException("closed".toString());
    }

    @Override // java.nio.channels.ReadableByteChannel
    public int read(ByteBuffer sink) {
        Intrinsics.f(sink, "sink");
        if (this.f52627g.size() == 0 && this.f52626f.read(this.f52627g, 8192L) == -1) {
            return -1;
        }
        return this.f52627g.read(sink);
    }
}
