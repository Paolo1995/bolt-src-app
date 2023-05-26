package okio;

import com.google.android.gms.common.api.Api;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.charset.Charset;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import okhttp3.internal.connection.RealConnection;
import okio.internal._BufferKt;

/* compiled from: Buffer.kt */
/* loaded from: classes5.dex */
public final class Buffer implements BufferedSource, BufferedSink, Cloneable, ByteChannel {

    /* renamed from: f  reason: collision with root package name */
    public Segment f52580f;

    /* renamed from: g  reason: collision with root package name */
    private long f52581g;

    /* compiled from: Buffer.kt */
    /* loaded from: classes5.dex */
    public static final class UnsafeCursor implements Closeable {

        /* renamed from: f  reason: collision with root package name */
        public Buffer f52582f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f52583g;

        /* renamed from: h  reason: collision with root package name */
        private Segment f52584h;

        /* renamed from: j  reason: collision with root package name */
        public byte[] f52586j;

        /* renamed from: i  reason: collision with root package name */
        public long f52585i = -1;

        /* renamed from: k  reason: collision with root package name */
        public int f52587k = -1;

        /* renamed from: l  reason: collision with root package name */
        public int f52588l = -1;

        public final Segment a() {
            return this.f52584h;
        }

        public final int c() {
            boolean z7;
            long j8;
            long j9 = this.f52585i;
            Buffer buffer = this.f52582f;
            Intrinsics.c(buffer);
            if (j9 != buffer.size()) {
                z7 = true;
            } else {
                z7 = false;
            }
            if (z7) {
                long j10 = this.f52585i;
                if (j10 == -1) {
                    j8 = 0;
                } else {
                    j8 = j10 + (this.f52588l - this.f52587k);
                }
                return g(j8);
            }
            throw new IllegalStateException("no more bytes".toString());
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            boolean z7;
            if (this.f52582f != null) {
                z7 = true;
            } else {
                z7 = false;
            }
            if (z7) {
                this.f52582f = null;
                h(null);
                this.f52585i = -1L;
                this.f52586j = null;
                this.f52587k = -1;
                this.f52588l = -1;
                return;
            }
            throw new IllegalStateException("not attached to a buffer".toString());
        }

        public final long e(long j8) {
            boolean z7;
            Buffer buffer = this.f52582f;
            if (buffer != null) {
                if (this.f52583g) {
                    long size = buffer.size();
                    int i8 = 1;
                    int i9 = (j8 > size ? 1 : (j8 == size ? 0 : -1));
                    if (i9 <= 0) {
                        if (j8 >= 0) {
                            z7 = true;
                        } else {
                            z7 = false;
                        }
                        if (z7) {
                            long j9 = size - j8;
                            while (true) {
                                if (j9 <= 0) {
                                    break;
                                }
                                Segment segment = buffer.f52580f;
                                Intrinsics.c(segment);
                                Segment segment2 = segment.f52637g;
                                Intrinsics.c(segment2);
                                int i10 = segment2.f52633c;
                                long j10 = i10 - segment2.f52632b;
                                if (j10 <= j9) {
                                    buffer.f52580f = segment2.b();
                                    SegmentPool.b(segment2);
                                    j9 -= j10;
                                } else {
                                    segment2.f52633c = i10 - ((int) j9);
                                    break;
                                }
                            }
                            h(null);
                            this.f52585i = j8;
                            this.f52586j = null;
                            this.f52587k = -1;
                            this.f52588l = -1;
                        } else {
                            throw new IllegalArgumentException(Intrinsics.n("newSize < 0: ", Long.valueOf(j8)).toString());
                        }
                    } else if (i9 > 0) {
                        long j11 = j8 - size;
                        boolean z8 = true;
                        while (j11 > 0) {
                            Segment I0 = buffer.I0(i8);
                            int min = (int) Math.min(j11, 8192 - I0.f52633c);
                            I0.f52633c += min;
                            j11 -= min;
                            if (z8) {
                                h(I0);
                                this.f52585i = size;
                                this.f52586j = I0.f52631a;
                                int i11 = I0.f52633c;
                                this.f52587k = i11 - min;
                                this.f52588l = i11;
                                i8 = 1;
                                z8 = false;
                            } else {
                                i8 = 1;
                            }
                        }
                    }
                    buffer.C0(j8);
                    return size;
                }
                throw new IllegalStateException("resizeBuffer() only permitted for read/write buffers".toString());
            }
            throw new IllegalStateException("not attached to a buffer".toString());
        }

        public final int g(long j8) {
            Segment segment;
            Buffer buffer = this.f52582f;
            if (buffer != null) {
                int i8 = (j8 > (-1L) ? 1 : (j8 == (-1L) ? 0 : -1));
                if (i8 >= 0 && j8 <= buffer.size()) {
                    if (i8 != 0 && j8 != buffer.size()) {
                        long j9 = 0;
                        long size = buffer.size();
                        Segment segment2 = buffer.f52580f;
                        if (a() != null) {
                            long j10 = this.f52585i;
                            int i9 = this.f52587k;
                            Segment a8 = a();
                            Intrinsics.c(a8);
                            long j11 = j10 - (i9 - a8.f52632b);
                            if (j11 > j8) {
                                segment2 = a();
                                size = j11;
                                segment = segment2;
                            } else {
                                segment = a();
                                j9 = j11;
                            }
                        } else {
                            segment = segment2;
                        }
                        if (size - j8 > j8 - j9) {
                            while (true) {
                                Intrinsics.c(segment);
                                int i10 = segment.f52633c;
                                int i11 = segment.f52632b;
                                if (j8 < (i10 - i11) + j9) {
                                    break;
                                }
                                j9 += i10 - i11;
                                segment = segment.f52636f;
                            }
                        } else {
                            while (size > j8) {
                                Intrinsics.c(segment2);
                                segment2 = segment2.f52637g;
                                Intrinsics.c(segment2);
                                size -= segment2.f52633c - segment2.f52632b;
                            }
                            j9 = size;
                            segment = segment2;
                        }
                        if (this.f52583g) {
                            Intrinsics.c(segment);
                            if (segment.f52634d) {
                                Segment f8 = segment.f();
                                if (buffer.f52580f == segment) {
                                    buffer.f52580f = f8;
                                }
                                segment = segment.c(f8);
                                Segment segment3 = segment.f52637g;
                                Intrinsics.c(segment3);
                                segment3.b();
                            }
                        }
                        h(segment);
                        this.f52585i = j8;
                        Intrinsics.c(segment);
                        this.f52586j = segment.f52631a;
                        int i12 = segment.f52632b + ((int) (j8 - j9));
                        this.f52587k = i12;
                        int i13 = segment.f52633c;
                        this.f52588l = i13;
                        return i13 - i12;
                    }
                    h(null);
                    this.f52585i = j8;
                    this.f52586j = null;
                    this.f52587k = -1;
                    this.f52588l = -1;
                    return -1;
                }
                throw new ArrayIndexOutOfBoundsException("offset=" + j8 + " > size=" + buffer.size());
            }
            throw new IllegalStateException("not attached to a buffer".toString());
        }

        public final void h(Segment segment) {
            this.f52584h = segment;
        }
    }

    public static /* synthetic */ UnsafeCursor Z(Buffer buffer, UnsafeCursor unsafeCursor, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            unsafeCursor = _UtilKt.c();
        }
        return buffer.Y(unsafeCursor);
    }

    /* JADX WARN: Code restructure failed: missing block: B:37:0x0091, code lost:
        C0(size() - r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x009a, code lost:
        if (r6 == false) goto L57;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x009c, code lost:
        r14 = 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x009e, code lost:
        r14 = 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x009f, code lost:
        if (r5 >= r14) goto L53;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x00a9, code lost:
        if (size() == 0) goto L51;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00ab, code lost:
        if (r6 == false) goto L50;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x00ad, code lost:
        r1 = "Expected a digit";
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x00b0, code lost:
        r1 = "Expected a digit or '-'";
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x00d5, code lost:
        throw new java.lang.NumberFormatException(r1 + " but was 0x" + okio._UtilKt.h(m(0)));
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x00db, code lost:
        throw new java.io.EOFException();
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x00dc, code lost:
        if (r6 == false) goto L54;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x00e0, code lost:
        return -r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:?, code lost:
        return r8;
     */
    @Override // okio.BufferedSource
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public long A0() throws java.io.EOFException {
        /*
            Method dump skipped, instructions count: 231
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.Buffer.A0():long");
    }

    @Override // okio.BufferedSource
    public long B(ByteString bytes) throws IOException {
        Intrinsics.f(bytes, "bytes");
        return t(bytes, 0L);
    }

    public final void C0(long j8) {
        this.f52581g = j8;
    }

    public final ByteString D0() {
        boolean z7;
        if (size() <= 2147483647L) {
            z7 = true;
        } else {
            z7 = false;
        }
        if (z7) {
            return G0((int) size());
        }
        throw new IllegalStateException(Intrinsics.n("size > Int.MAX_VALUE: ", Long.valueOf(size())).toString());
    }

    @Override // okio.BufferedSource
    public void E(Buffer sink, long j8) throws EOFException {
        Intrinsics.f(sink, "sink");
        if (size() >= j8) {
            sink.write(this, j8);
        } else {
            sink.write(this, size());
            throw new EOFException();
        }
    }

    @Override // okio.BufferedSource
    public long G(ByteString targetBytes) {
        Intrinsics.f(targetBytes, "targetBytes");
        return N(targetBytes, 0L);
    }

    public final ByteString G0(int i8) {
        if (i8 == 0) {
            return ByteString.f52592j;
        }
        _UtilKt.b(size(), 0L, i8);
        Segment segment = this.f52580f;
        int i9 = 0;
        int i10 = 0;
        int i11 = 0;
        while (i10 < i8) {
            Intrinsics.c(segment);
            int i12 = segment.f52633c;
            int i13 = segment.f52632b;
            if (i12 != i13) {
                i10 += i12 - i13;
                i11++;
                segment = segment.f52636f;
            } else {
                throw new AssertionError("s.limit == s.pos");
            }
        }
        byte[][] bArr = new byte[i11];
        int[] iArr = new int[i11 * 2];
        Segment segment2 = this.f52580f;
        int i14 = 0;
        while (i9 < i8) {
            Intrinsics.c(segment2);
            bArr[i14] = segment2.f52631a;
            i9 += segment2.f52633c - segment2.f52632b;
            iArr[i14] = Math.min(i9, i8);
            iArr[i14 + i11] = segment2.f52632b;
            segment2.f52634d = true;
            i14++;
            segment2 = segment2.f52636f;
        }
        return new SegmentedByteString(bArr, iArr);
    }

    public final Segment I0(int i8) {
        boolean z7 = true;
        if ((i8 < 1 || i8 > 8192) ? false : false) {
            Segment segment = this.f52580f;
            if (segment == null) {
                Segment c8 = SegmentPool.c();
                this.f52580f = c8;
                c8.f52637g = c8;
                c8.f52636f = c8;
                return c8;
            }
            Intrinsics.c(segment);
            Segment segment2 = segment.f52637g;
            Intrinsics.c(segment2);
            if (segment2.f52633c + i8 <= 8192 && segment2.f52635e) {
                return segment2;
            }
            return segment2.c(SegmentPool.c());
        }
        throw new IllegalArgumentException("unexpected capacity".toString());
    }

    @Override // okio.BufferedSource
    public String J(long j8) throws EOFException {
        boolean z7;
        if (j8 >= 0) {
            z7 = true;
        } else {
            z7 = false;
        }
        if (z7) {
            long j9 = Long.MAX_VALUE;
            if (j8 != Long.MAX_VALUE) {
                j9 = j8 + 1;
            }
            byte b8 = (byte) 10;
            long q8 = q(b8, 0L, j9);
            if (q8 != -1) {
                return _BufferKt.d(this, q8);
            }
            if (j9 < size() && m(j9 - 1) == ((byte) 13) && m(j9) == b8) {
                return _BufferKt.d(this, j9);
            }
            Buffer buffer = new Buffer();
            j(buffer, 0L, Math.min(32, size()));
            throw new EOFException("\\n not found: limit=" + Math.min(size(), j8) + " content=" + buffer.N0().p() + (char) 8230);
        }
        throw new IllegalArgumentException(Intrinsics.n("limit < 0: ", Long.valueOf(j8)).toString());
    }

    @Override // okio.BufferedSink
    /* renamed from: K0 */
    public Buffer a1(ByteString byteString) {
        Intrinsics.f(byteString, "byteString");
        byteString.E(this, 0, byteString.z());
        return this;
    }

    @Override // okio.BufferedSource
    public String L0(Charset charset) {
        Intrinsics.f(charset, "charset");
        return f0(this.f52581g, charset);
    }

    public long N(ByteString targetBytes, long j8) {
        boolean z7;
        int i8;
        int i9;
        Intrinsics.f(targetBytes, "targetBytes");
        long j9 = 0;
        if (j8 >= 0) {
            z7 = true;
        } else {
            z7 = false;
        }
        if (z7) {
            Segment segment = this.f52580f;
            if (segment == null) {
                return -1L;
            }
            if (size() - j8 < j8) {
                j9 = size();
                while (j9 > j8) {
                    segment = segment.f52637g;
                    Intrinsics.c(segment);
                    j9 -= segment.f52633c - segment.f52632b;
                }
                if (targetBytes.z() == 2) {
                    byte h8 = targetBytes.h(0);
                    byte h9 = targetBytes.h(1);
                    while (j9 < size()) {
                        byte[] bArr = segment.f52631a;
                        i8 = (int) ((segment.f52632b + j8) - j9);
                        int i10 = segment.f52633c;
                        while (i8 < i10) {
                            byte b8 = bArr[i8];
                            if (b8 != h8 && b8 != h9) {
                                i8++;
                            }
                            i9 = segment.f52632b;
                        }
                        j9 += segment.f52633c - segment.f52632b;
                        segment = segment.f52636f;
                        Intrinsics.c(segment);
                        j8 = j9;
                    }
                    return -1L;
                }
                byte[] q8 = targetBytes.q();
                while (j9 < size()) {
                    byte[] bArr2 = segment.f52631a;
                    i8 = (int) ((segment.f52632b + j8) - j9);
                    int i11 = segment.f52633c;
                    while (i8 < i11) {
                        byte b9 = bArr2[i8];
                        int length = q8.length;
                        int i12 = 0;
                        while (i12 < length) {
                            byte b10 = q8[i12];
                            i12++;
                            if (b9 == b10) {
                                i9 = segment.f52632b;
                            }
                        }
                        i8++;
                    }
                    j9 += segment.f52633c - segment.f52632b;
                    segment = segment.f52636f;
                    Intrinsics.c(segment);
                    j8 = j9;
                }
                return -1L;
            }
            while (true) {
                long j10 = (segment.f52633c - segment.f52632b) + j9;
                if (j10 > j8) {
                    break;
                }
                segment = segment.f52636f;
                Intrinsics.c(segment);
                j9 = j10;
            }
            if (targetBytes.z() == 2) {
                byte h10 = targetBytes.h(0);
                byte h11 = targetBytes.h(1);
                while (j9 < size()) {
                    byte[] bArr3 = segment.f52631a;
                    i8 = (int) ((segment.f52632b + j8) - j9);
                    int i13 = segment.f52633c;
                    while (i8 < i13) {
                        byte b11 = bArr3[i8];
                        if (b11 != h10 && b11 != h11) {
                            i8++;
                        }
                        i9 = segment.f52632b;
                    }
                    j9 += segment.f52633c - segment.f52632b;
                    segment = segment.f52636f;
                    Intrinsics.c(segment);
                    j8 = j9;
                }
                return -1L;
            }
            byte[] q9 = targetBytes.q();
            while (j9 < size()) {
                byte[] bArr4 = segment.f52631a;
                i8 = (int) ((segment.f52632b + j8) - j9);
                int i14 = segment.f52633c;
                while (i8 < i14) {
                    byte b12 = bArr4[i8];
                    int length2 = q9.length;
                    int i15 = 0;
                    while (i15 < length2) {
                        byte b13 = q9[i15];
                        i15++;
                        if (b12 == b13) {
                            i9 = segment.f52632b;
                        }
                    }
                    i8++;
                }
                j9 += segment.f52633c - segment.f52632b;
                segment = segment.f52636f;
                Intrinsics.c(segment);
                j8 = j9;
            }
            return -1L;
            return (i8 - i9) + j9;
        }
        throw new IllegalArgumentException(Intrinsics.n("fromIndex < 0: ", Long.valueOf(j8)).toString());
    }

    @Override // okio.BufferedSource
    public ByteString N0() {
        return o0(size());
    }

    public OutputStream O() {
        return new OutputStream() { // from class: okio.Buffer$outputStream$1
            @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
            public void close() {
            }

            @Override // java.io.OutputStream, java.io.Flushable
            public void flush() {
            }

            public String toString() {
                return Buffer.this + ".outputStream()";
            }

            @Override // java.io.OutputStream
            public void write(int i8) {
                Buffer.this.writeByte(i8);
            }

            @Override // java.io.OutputStream
            public void write(byte[] data, int i8, int i9) {
                Intrinsics.f(data, "data");
                Buffer.this.write(data, i8, i9);
            }
        };
    }

    public Buffer P0(Source source, long j8) throws IOException {
        Intrinsics.f(source, "source");
        while (j8 > 0) {
            long read = source.read(this, j8);
            if (read != -1) {
                j8 -= read;
            } else {
                throw new EOFException();
            }
        }
        return this;
    }

    @Override // okio.BufferedSource
    public boolean R(long j8, ByteString bytes) {
        Intrinsics.f(bytes, "bytes");
        return X(j8, bytes, 0, bytes.z());
    }

    @Override // okio.BufferedSink
    /* renamed from: R0 */
    public Buffer write(byte[] source) {
        Intrinsics.f(source, "source");
        return write(source, 0, source.length);
    }

    @Override // okio.BufferedSink
    /* renamed from: S0 */
    public Buffer write(byte[] source, int i8, int i9) {
        Intrinsics.f(source, "source");
        long j8 = i9;
        _UtilKt.b(source.length, i8, j8);
        int i10 = i9 + i8;
        while (i8 < i10) {
            Segment I0 = I0(1);
            int min = Math.min(i10 - i8, 8192 - I0.f52633c);
            int i11 = i8 + min;
            ArraysKt.f(source, I0.f52631a, I0.f52633c, i8, i11);
            I0.f52633c += min;
            i8 = i11;
        }
        C0(size() + j8);
        return this;
    }

    @Override // okio.BufferedSink
    /* renamed from: U0 */
    public Buffer writeByte(int i8) {
        Segment I0 = I0(1);
        byte[] bArr = I0.f52631a;
        int i9 = I0.f52633c;
        I0.f52633c = i9 + 1;
        bArr[i9] = (byte) i8;
        C0(size() + 1);
        return this;
    }

    @Override // okio.BufferedSink
    public long V(Source source) throws IOException {
        Intrinsics.f(source, "source");
        long j8 = 0;
        while (true) {
            long read = source.read(this, 8192L);
            if (read == -1) {
                return j8;
            }
            j8 += read;
        }
    }

    @Override // okio.BufferedSink
    /* renamed from: W0 */
    public Buffer l0(long j8) {
        int i8 = (j8 > 0L ? 1 : (j8 == 0L ? 0 : -1));
        if (i8 == 0) {
            return writeByte(48);
        }
        boolean z7 = false;
        int i9 = 1;
        if (i8 < 0) {
            j8 = -j8;
            if (j8 < 0) {
                return Q("-9223372036854775808");
            }
            z7 = true;
        }
        if (j8 < 100000000) {
            if (j8 < 10000) {
                if (j8 < 100) {
                    if (j8 >= 10) {
                        i9 = 2;
                    }
                } else if (j8 < 1000) {
                    i9 = 3;
                } else {
                    i9 = 4;
                }
            } else if (j8 < 1000000) {
                if (j8 < 100000) {
                    i9 = 5;
                } else {
                    i9 = 6;
                }
            } else if (j8 < 10000000) {
                i9 = 7;
            } else {
                i9 = 8;
            }
        } else if (j8 < 1000000000000L) {
            if (j8 < RealConnection.IDLE_CONNECTION_HEALTHY_NS) {
                if (j8 < 1000000000) {
                    i9 = 9;
                } else {
                    i9 = 10;
                }
            } else if (j8 < 100000000000L) {
                i9 = 11;
            } else {
                i9 = 12;
            }
        } else if (j8 < 1000000000000000L) {
            if (j8 < 10000000000000L) {
                i9 = 13;
            } else if (j8 < 100000000000000L) {
                i9 = 14;
            } else {
                i9 = 15;
            }
        } else if (j8 < 100000000000000000L) {
            if (j8 < 10000000000000000L) {
                i9 = 16;
            } else {
                i9 = 17;
            }
        } else if (j8 < 1000000000000000000L) {
            i9 = 18;
        } else {
            i9 = 19;
        }
        if (z7) {
            i9++;
        }
        Segment I0 = I0(i9);
        byte[] bArr = I0.f52631a;
        int i10 = I0.f52633c + i9;
        while (j8 != 0) {
            long j9 = 10;
            i10--;
            bArr[i10] = _BufferKt.b()[(int) (j8 % j9)];
            j8 /= j9;
        }
        if (z7) {
            bArr[i10 - 1] = (byte) 45;
        }
        I0.f52633c += i9;
        C0(size() + i9);
        return this;
    }

    public boolean X(long j8, ByteString bytes, int i8, int i9) {
        Intrinsics.f(bytes, "bytes");
        if (j8 < 0 || i8 < 0 || i9 < 0 || size() - j8 < i9 || bytes.z() - i8 < i9) {
            return false;
        }
        if (i9 > 0) {
            int i10 = 0;
            while (true) {
                int i11 = i10 + 1;
                if (m(i10 + j8) != bytes.h(i10 + i8)) {
                    return false;
                }
                if (i11 >= i9) {
                    break;
                }
                i10 = i11;
            }
        }
        return true;
    }

    public final UnsafeCursor Y(UnsafeCursor unsafeCursor) {
        Intrinsics.f(unsafeCursor, "unsafeCursor");
        return _BufferKt.a(this, unsafeCursor);
    }

    @Override // okio.BufferedSink
    /* renamed from: Z0 */
    public Buffer M0(long j8) {
        if (j8 == 0) {
            return writeByte(48);
        }
        long j9 = (j8 >>> 1) | j8;
        long j10 = j9 | (j9 >>> 2);
        long j11 = j10 | (j10 >>> 4);
        long j12 = j11 | (j11 >>> 8);
        long j13 = j12 | (j12 >>> 16);
        long j14 = j13 | (j13 >>> 32);
        long j15 = j14 - ((j14 >>> 1) & 6148914691236517205L);
        long j16 = ((j15 >>> 2) & 3689348814741910323L) + (j15 & 3689348814741910323L);
        long j17 = ((j16 >>> 4) + j16) & 1085102592571150095L;
        long j18 = j17 + (j17 >>> 8);
        long j19 = j18 + (j18 >>> 16);
        int i8 = (int) ((((j19 & 63) + ((j19 >>> 32) & 63)) + 3) / 4);
        Segment I0 = I0(i8);
        byte[] bArr = I0.f52631a;
        int i9 = I0.f52633c;
        for (int i10 = (i9 + i8) - 1; i10 >= i9; i10--) {
            bArr[i10] = _BufferKt.b()[(int) (15 & j8)];
            j8 >>>= 4;
        }
        I0.f52633c += i8;
        C0(size() + i8);
        return this;
    }

    public final void a() {
        skip(size());
    }

    @Override // okio.BufferedSource, okio.BufferedSink
    public Buffer b() {
        return this;
    }

    @Override // okio.BufferedSource
    public String b0() throws EOFException {
        return J(Long.MAX_VALUE);
    }

    @Override // okio.BufferedSink
    /* renamed from: b1 */
    public Buffer writeInt(int i8) {
        Segment I0 = I0(4);
        byte[] bArr = I0.f52631a;
        int i9 = I0.f52633c;
        int i10 = i9 + 1;
        bArr[i9] = (byte) ((i8 >>> 24) & 255);
        int i11 = i10 + 1;
        bArr[i10] = (byte) ((i8 >>> 16) & 255);
        int i12 = i11 + 1;
        bArr[i11] = (byte) ((i8 >>> 8) & 255);
        bArr[i12] = (byte) (i8 & 255);
        I0.f52633c = i12 + 1;
        C0(size() + 4);
        return this;
    }

    /* renamed from: c */
    public Buffer clone() {
        return h();
    }

    public int c0() throws EOFException {
        return _UtilKt.f(readInt());
    }

    public Buffer c1(long j8) {
        Segment I0 = I0(8);
        byte[] bArr = I0.f52631a;
        int i8 = I0.f52633c;
        int i9 = i8 + 1;
        bArr[i8] = (byte) ((j8 >>> 56) & 255);
        int i10 = i9 + 1;
        bArr[i9] = (byte) ((j8 >>> 48) & 255);
        int i11 = i10 + 1;
        bArr[i10] = (byte) ((j8 >>> 40) & 255);
        int i12 = i11 + 1;
        bArr[i11] = (byte) ((j8 >>> 32) & 255);
        int i13 = i12 + 1;
        bArr[i12] = (byte) ((j8 >>> 24) & 255);
        int i14 = i13 + 1;
        bArr[i13] = (byte) ((j8 >>> 16) & 255);
        int i15 = i14 + 1;
        bArr[i14] = (byte) ((j8 >>> 8) & 255);
        bArr[i15] = (byte) (j8 & 255);
        I0.f52633c = i15 + 1;
        C0(size() + 8);
        return this;
    }

    @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    public short d0() throws EOFException {
        return _UtilKt.g(readShort());
    }

    public final long e() {
        long size = size();
        if (size == 0) {
            return 0L;
        }
        Segment segment = this.f52580f;
        Intrinsics.c(segment);
        Segment segment2 = segment.f52637g;
        Intrinsics.c(segment2);
        int i8 = segment2.f52633c;
        if (i8 < 8192 && segment2.f52635e) {
            size -= i8 - segment2.f52632b;
        }
        return size;
    }

    @Override // okio.BufferedSource
    public byte[] e0(long j8) throws EOFException {
        boolean z7;
        if (j8 >= 0 && j8 <= 2147483647L) {
            z7 = true;
        } else {
            z7 = false;
        }
        if (z7) {
            if (size() >= j8) {
                byte[] bArr = new byte[(int) j8];
                readFully(bArr);
                return bArr;
            }
            throw new EOFException();
        }
        throw new IllegalArgumentException(Intrinsics.n("byteCount: ", Long.valueOf(j8)).toString());
    }

    @Override // okio.BufferedSource
    public long e1(Sink sink) throws IOException {
        Intrinsics.f(sink, "sink");
        long size = size();
        if (size > 0) {
            sink.write(this, size);
        }
        return size;
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (!(obj instanceof Buffer)) {
                return false;
            }
            Buffer buffer = (Buffer) obj;
            if (size() != buffer.size()) {
                return false;
            }
            if (size() != 0) {
                Segment segment = this.f52580f;
                Intrinsics.c(segment);
                Segment segment2 = buffer.f52580f;
                Intrinsics.c(segment2);
                int i8 = segment.f52632b;
                int i9 = segment2.f52632b;
                long j8 = 0;
                while (j8 < size()) {
                    long min = Math.min(segment.f52633c - i8, segment2.f52633c - i9);
                    if (0 < min) {
                        long j9 = 0;
                        while (true) {
                            j9++;
                            int i10 = i8 + 1;
                            int i11 = i9 + 1;
                            if (segment.f52631a[i8] != segment2.f52631a[i9]) {
                                return false;
                            }
                            if (j9 >= min) {
                                i8 = i10;
                                i9 = i11;
                                break;
                            }
                            i8 = i10;
                            i9 = i11;
                        }
                    }
                    if (i8 == segment.f52633c) {
                        segment = segment.f52636f;
                        Intrinsics.c(segment);
                        i8 = segment.f52632b;
                    }
                    if (i9 == segment2.f52633c) {
                        segment2 = segment2.f52636f;
                        Intrinsics.c(segment2);
                        i9 = segment2.f52632b;
                    }
                    j8 += min;
                }
            }
        }
        return true;
    }

    @Override // okio.BufferedSource
    public boolean f(long j8) {
        if (this.f52581g >= j8) {
            return true;
        }
        return false;
    }

    public String f0(long j8, Charset charset) throws EOFException {
        boolean z7;
        Intrinsics.f(charset, "charset");
        int i8 = (j8 > 0L ? 1 : (j8 == 0L ? 0 : -1));
        if (i8 >= 0 && j8 <= 2147483647L) {
            z7 = true;
        } else {
            z7 = false;
        }
        if (z7) {
            if (this.f52581g >= j8) {
                if (i8 == 0) {
                    return "";
                }
                Segment segment = this.f52580f;
                Intrinsics.c(segment);
                int i9 = segment.f52632b;
                if (i9 + j8 > segment.f52633c) {
                    return new String(e0(j8), charset);
                }
                int i10 = (int) j8;
                String str = new String(segment.f52631a, i9, i10, charset);
                int i11 = segment.f52632b + i10;
                segment.f52632b = i11;
                this.f52581g -= j8;
                if (i11 == segment.f52633c) {
                    this.f52580f = segment.b();
                    SegmentPool.b(segment);
                }
                return str;
            }
            throw new EOFException();
        }
        throw new IllegalArgumentException(Intrinsics.n("byteCount: ", Long.valueOf(j8)).toString());
    }

    @Override // okio.BufferedSink
    /* renamed from: f1 */
    public Buffer writeShort(int i8) {
        Segment I0 = I0(2);
        byte[] bArr = I0.f52631a;
        int i9 = I0.f52633c;
        int i10 = i9 + 1;
        bArr[i9] = (byte) ((i8 >>> 8) & 255);
        bArr[i10] = (byte) (i8 & 255);
        I0.f52633c = i10 + 1;
        C0(size() + 2);
        return this;
    }

    @Override // okio.BufferedSink, okio.Sink, java.io.Flushable
    public void flush() {
    }

    public final Buffer h() {
        Buffer buffer = new Buffer();
        if (size() != 0) {
            Segment segment = this.f52580f;
            Intrinsics.c(segment);
            Segment d8 = segment.d();
            buffer.f52580f = d8;
            d8.f52637g = d8;
            d8.f52636f = d8;
            for (Segment segment2 = segment.f52636f; segment2 != segment; segment2 = segment2.f52636f) {
                Segment segment3 = d8.f52637g;
                Intrinsics.c(segment3);
                Intrinsics.c(segment2);
                segment3.c(segment2.d());
            }
            buffer.C0(size());
        }
        return buffer;
    }

    public Buffer h1(String string, int i8, int i9, Charset charset) {
        boolean z7;
        boolean z8;
        Intrinsics.f(string, "string");
        Intrinsics.f(charset, "charset");
        boolean z9 = true;
        if (i8 >= 0) {
            z7 = true;
        } else {
            z7 = false;
        }
        if (z7) {
            if (i9 >= i8) {
                z8 = true;
            } else {
                z8 = false;
            }
            if (z8) {
                if (i9 > string.length()) {
                    z9 = false;
                }
                if (z9) {
                    if (Intrinsics.a(charset, Charsets.f51135b)) {
                        return U(string, i8, i9);
                    }
                    String substring = string.substring(i8, i9);
                    Intrinsics.e(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                    if (substring != null) {
                        byte[] bytes = substring.getBytes(charset);
                        Intrinsics.e(bytes, "(this as java.lang.String).getBytes(charset)");
                        return write(bytes, 0, bytes.length);
                    }
                    throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                }
                throw new IllegalArgumentException(("endIndex > string.length: " + i9 + " > " + string.length()).toString());
            }
            throw new IllegalArgumentException(("endIndex < beginIndex: " + i9 + " < " + i8).toString());
        }
        throw new IllegalArgumentException(Intrinsics.n("beginIndex < 0: ", Integer.valueOf(i8)).toString());
    }

    public int hashCode() {
        Segment segment = this.f52580f;
        if (segment == null) {
            return 0;
        }
        int i8 = 1;
        do {
            int i9 = segment.f52633c;
            for (int i10 = segment.f52632b; i10 < i9; i10++) {
                i8 = (i8 * 31) + segment.f52631a[i10];
            }
            segment = segment.f52636f;
            Intrinsics.c(segment);
        } while (segment != this.f52580f);
        return i8;
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0098 A[EDGE_INSN: B:42:0x0098->B:37:0x0098 ?: BREAK  , SYNTHETIC] */
    @Override // okio.BufferedSource
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public long i1() throws java.io.EOFException {
        /*
            r15 = this;
            long r0 = r15.size()
            r2 = 0
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 == 0) goto La2
            r0 = 0
            r4 = r2
            r1 = 0
        Ld:
            okio.Segment r6 = r15.f52580f
            kotlin.jvm.internal.Intrinsics.c(r6)
            byte[] r7 = r6.f52631a
            int r8 = r6.f52632b
            int r9 = r6.f52633c
        L18:
            if (r8 >= r9) goto L84
            r10 = r7[r8]
            r11 = 48
            byte r11 = (byte) r11
            if (r10 < r11) goto L29
            r12 = 57
            byte r12 = (byte) r12
            if (r10 > r12) goto L29
            int r11 = r10 - r11
            goto L43
        L29:
            r11 = 97
            byte r11 = (byte) r11
            if (r10 < r11) goto L38
            r12 = 102(0x66, float:1.43E-43)
            byte r12 = (byte) r12
            if (r10 > r12) goto L38
        L33:
            int r11 = r10 - r11
            int r11 = r11 + 10
            goto L43
        L38:
            r11 = 65
            byte r11 = (byte) r11
            if (r10 < r11) goto L70
            r12 = 70
            byte r12 = (byte) r12
            if (r10 > r12) goto L70
            goto L33
        L43:
            r12 = -1152921504606846976(0xf000000000000000, double:-3.105036184601418E231)
            long r12 = r12 & r4
            int r14 = (r12 > r2 ? 1 : (r12 == r2 ? 0 : -1))
            if (r14 != 0) goto L53
            r10 = 4
            long r4 = r4 << r10
            long r10 = (long) r11
            long r4 = r4 | r10
            int r8 = r8 + 1
            int r0 = r0 + 1
            goto L18
        L53:
            okio.Buffer r0 = new okio.Buffer
            r0.<init>()
            okio.Buffer r0 = r0.M0(r4)
            okio.Buffer r0 = r0.writeByte(r10)
            java.lang.NumberFormatException r1 = new java.lang.NumberFormatException
            java.lang.String r0 = r0.k0()
            java.lang.String r2 = "Number too large: "
            java.lang.String r0 = kotlin.jvm.internal.Intrinsics.n(r2, r0)
            r1.<init>(r0)
            throw r1
        L70:
            if (r0 == 0) goto L74
            r1 = 1
            goto L84
        L74:
            java.lang.NumberFormatException r0 = new java.lang.NumberFormatException
            java.lang.String r1 = okio._UtilKt.h(r10)
            java.lang.String r2 = "Expected leading [0-9a-fA-F] character but was 0x"
            java.lang.String r1 = kotlin.jvm.internal.Intrinsics.n(r2, r1)
            r0.<init>(r1)
            throw r0
        L84:
            if (r8 != r9) goto L90
            okio.Segment r7 = r6.b()
            r15.f52580f = r7
            okio.SegmentPool.b(r6)
            goto L92
        L90:
            r6.f52632b = r8
        L92:
            if (r1 != 0) goto L98
            okio.Segment r6 = r15.f52580f
            if (r6 != 0) goto Ld
        L98:
            long r1 = r15.size()
            long r6 = (long) r0
            long r1 = r1 - r6
            r15.C0(r1)
            return r4
        La2:
            java.io.EOFException r0 = new java.io.EOFException
            r0.<init>()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.Buffer.i1():long");
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return true;
    }

    public final Buffer j(Buffer out, long j8, long j9) {
        Intrinsics.f(out, "out");
        _UtilKt.b(size(), j8, j9);
        if (j9 != 0) {
            out.C0(out.size() + j9);
            Segment segment = this.f52580f;
            while (true) {
                Intrinsics.c(segment);
                int i8 = segment.f52633c;
                int i9 = segment.f52632b;
                if (j8 < i8 - i9) {
                    break;
                }
                j8 -= i8 - i9;
                segment = segment.f52636f;
            }
            while (j9 > 0) {
                Intrinsics.c(segment);
                Segment d8 = segment.d();
                int i10 = d8.f52632b + ((int) j8);
                d8.f52632b = i10;
                d8.f52633c = Math.min(i10 + ((int) j9), d8.f52633c);
                Segment segment2 = out.f52580f;
                if (segment2 == null) {
                    d8.f52637g = d8;
                    d8.f52636f = d8;
                    out.f52580f = d8;
                } else {
                    Intrinsics.c(segment2);
                    Segment segment3 = segment2.f52637g;
                    Intrinsics.c(segment3);
                    segment3.c(d8);
                }
                j9 -= d8.f52633c - d8.f52632b;
                segment = segment.f52636f;
                j8 = 0;
            }
        }
        return this;
    }

    @Override // okio.BufferedSource
    public void j0(long j8) throws EOFException {
        if (this.f52581g >= j8) {
            return;
        }
        throw new EOFException();
    }

    @Override // okio.BufferedSource
    public InputStream j1() {
        return new InputStream() { // from class: okio.Buffer$inputStream$1
            @Override // java.io.InputStream
            public int available() {
                return (int) Math.min(Buffer.this.size(), (long) Api.BaseClientBuilder.API_PRIORITY_OTHER);
            }

            @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
            public void close() {
            }

            @Override // java.io.InputStream
            public int read() {
                if (Buffer.this.size() > 0) {
                    return Buffer.this.readByte() & 255;
                }
                return -1;
            }

            public String toString() {
                return Buffer.this + ".inputStream()";
            }

            @Override // java.io.InputStream
            public int read(byte[] sink, int i8, int i9) {
                Intrinsics.f(sink, "sink");
                return Buffer.this.read(sink, i8, i9);
            }
        };
    }

    @Override // okio.BufferedSink
    /* renamed from: k */
    public Buffer v() {
        return this;
    }

    public String k0() {
        return f0(this.f52581g, Charsets.f51135b);
    }

    @Override // okio.BufferedSource
    public int k1(Options options) {
        Intrinsics.f(options, "options");
        int f8 = _BufferKt.f(this, options, false, 2, null);
        if (f8 == -1) {
            return -1;
        }
        skip(options.i()[f8].z());
        return f8;
    }

    @Override // okio.BufferedSink
    /* renamed from: l */
    public Buffer H() {
        return this;
    }

    public Buffer l1(String string, Charset charset) {
        Intrinsics.f(string, "string");
        Intrinsics.f(charset, "charset");
        return h1(string, 0, string.length(), charset);
    }

    public final byte m(long j8) {
        _UtilKt.b(size(), j8, 1L);
        Segment segment = this.f52580f;
        if (segment != null) {
            if (size() - j8 < j8) {
                long size = size();
                while (size > j8) {
                    segment = segment.f52637g;
                    Intrinsics.c(segment);
                    size -= segment.f52633c - segment.f52632b;
                }
                Intrinsics.c(segment);
                return segment.f52631a[(int) ((segment.f52632b + j8) - size)];
            }
            long j9 = 0;
            while (true) {
                long j10 = (segment.f52633c - segment.f52632b) + j9;
                if (j10 > j8) {
                    Intrinsics.c(segment);
                    return segment.f52631a[(int) ((segment.f52632b + j8) - j9)];
                }
                segment = segment.f52636f;
                Intrinsics.c(segment);
                j9 = j10;
            }
        } else {
            Intrinsics.c(null);
            throw null;
        }
    }

    @Override // okio.BufferedSink
    /* renamed from: m1 */
    public Buffer Q(String string) {
        Intrinsics.f(string, "string");
        return U(string, 0, string.length());
    }

    @Override // okio.BufferedSink
    /* renamed from: n1 */
    public Buffer U(String string, int i8, int i9) {
        boolean z7;
        boolean z8;
        boolean z9;
        char charAt;
        char c8;
        boolean z10;
        Intrinsics.f(string, "string");
        if (i8 >= 0) {
            z7 = true;
        } else {
            z7 = false;
        }
        if (z7) {
            if (i9 >= i8) {
                z8 = true;
            } else {
                z8 = false;
            }
            if (z8) {
                if (i9 <= string.length()) {
                    z9 = true;
                } else {
                    z9 = false;
                }
                if (z9) {
                    while (i8 < i9) {
                        char charAt2 = string.charAt(i8);
                        if (charAt2 < 128) {
                            Segment I0 = I0(1);
                            byte[] bArr = I0.f52631a;
                            int i10 = I0.f52633c - i8;
                            int min = Math.min(i9, 8192 - i10);
                            int i11 = i8 + 1;
                            bArr[i8 + i10] = (byte) charAt2;
                            while (true) {
                                i8 = i11;
                                if (i8 >= min || (charAt = string.charAt(i8)) >= 128) {
                                    break;
                                }
                                i11 = i8 + 1;
                                bArr[i8 + i10] = (byte) charAt;
                            }
                            int i12 = I0.f52633c;
                            int i13 = (i10 + i8) - i12;
                            I0.f52633c = i12 + i13;
                            C0(size() + i13);
                        } else {
                            if (charAt2 < 2048) {
                                Segment I02 = I0(2);
                                byte[] bArr2 = I02.f52631a;
                                int i14 = I02.f52633c;
                                bArr2[i14] = (byte) ((charAt2 >> 6) | 192);
                                bArr2[i14 + 1] = (byte) ((charAt2 & '?') | 128);
                                I02.f52633c = i14 + 2;
                                C0(size() + 2);
                            } else if (charAt2 >= 55296 && charAt2 <= 57343) {
                                int i15 = i8 + 1;
                                if (i15 < i9) {
                                    c8 = string.charAt(i15);
                                } else {
                                    c8 = 0;
                                }
                                if (charAt2 <= 56319) {
                                    if (56320 <= c8 && c8 <= 57343) {
                                        z10 = true;
                                    } else {
                                        z10 = false;
                                    }
                                    if (z10) {
                                        int i16 = (((charAt2 & 1023) << 10) | (c8 & 1023)) + 65536;
                                        Segment I03 = I0(4);
                                        byte[] bArr3 = I03.f52631a;
                                        int i17 = I03.f52633c;
                                        bArr3[i17] = (byte) ((i16 >> 18) | 240);
                                        bArr3[i17 + 1] = (byte) (((i16 >> 12) & 63) | 128);
                                        bArr3[i17 + 2] = (byte) (((i16 >> 6) & 63) | 128);
                                        bArr3[i17 + 3] = (byte) ((i16 & 63) | 128);
                                        I03.f52633c = i17 + 4;
                                        C0(size() + 4);
                                        i8 += 2;
                                    }
                                }
                                writeByte(63);
                                i8 = i15;
                            } else {
                                Segment I04 = I0(3);
                                byte[] bArr4 = I04.f52631a;
                                int i18 = I04.f52633c;
                                bArr4[i18] = (byte) ((charAt2 >> '\f') | 224);
                                bArr4[i18 + 1] = (byte) ((63 & (charAt2 >> 6)) | 128);
                                bArr4[i18 + 2] = (byte) ((charAt2 & '?') | 128);
                                I04.f52633c = i18 + 3;
                                C0(size() + 3);
                            }
                            i8++;
                        }
                    }
                    return this;
                }
                throw new IllegalArgumentException(("endIndex > string.length: " + i9 + " > " + string.length()).toString());
            }
            throw new IllegalArgumentException(("endIndex < beginIndex: " + i9 + " < " + i8).toString());
        }
        throw new IllegalArgumentException(Intrinsics.n("beginIndex < 0: ", Integer.valueOf(i8)).toString());
    }

    @Override // okio.BufferedSource
    public ByteString o0(long j8) throws EOFException {
        boolean z7;
        if (j8 >= 0 && j8 <= 2147483647L) {
            z7 = true;
        } else {
            z7 = false;
        }
        if (z7) {
            if (size() >= j8) {
                if (j8 >= 4096) {
                    ByteString G0 = G0((int) j8);
                    skip(j8);
                    return G0;
                }
                return new ByteString(e0(j8));
            }
            throw new EOFException();
        }
        throw new IllegalArgumentException(Intrinsics.n("byteCount: ", Long.valueOf(j8)).toString());
    }

    public Buffer o1(int i8) {
        if (i8 < 128) {
            writeByte(i8);
        } else if (i8 < 2048) {
            Segment I0 = I0(2);
            byte[] bArr = I0.f52631a;
            int i9 = I0.f52633c;
            bArr[i9] = (byte) ((i8 >> 6) | 192);
            bArr[i9 + 1] = (byte) ((i8 & 63) | 128);
            I0.f52633c = i9 + 2;
            C0(size() + 2);
        } else {
            boolean z7 = false;
            if (55296 <= i8 && i8 <= 57343) {
                z7 = true;
            }
            if (z7) {
                writeByte(63);
            } else if (i8 < 65536) {
                Segment I02 = I0(3);
                byte[] bArr2 = I02.f52631a;
                int i10 = I02.f52633c;
                bArr2[i10] = (byte) ((i8 >> 12) | 224);
                bArr2[i10 + 1] = (byte) (((i8 >> 6) & 63) | 128);
                bArr2[i10 + 2] = (byte) ((i8 & 63) | 128);
                I02.f52633c = i10 + 3;
                C0(size() + 3);
            } else if (i8 <= 1114111) {
                Segment I03 = I0(4);
                byte[] bArr3 = I03.f52631a;
                int i11 = I03.f52633c;
                bArr3[i11] = (byte) ((i8 >> 18) | 240);
                bArr3[i11 + 1] = (byte) (((i8 >> 12) & 63) | 128);
                bArr3[i11 + 2] = (byte) (((i8 >> 6) & 63) | 128);
                bArr3[i11 + 3] = (byte) ((i8 & 63) | 128);
                I03.f52633c = i11 + 4;
                C0(size() + 4);
            } else {
                throw new IllegalArgumentException(Intrinsics.n("Unexpected code point: 0x", _UtilKt.i(i8)));
            }
        }
        return this;
    }

    @Override // okio.BufferedSource
    public BufferedSource peek() {
        return Okio.d(new PeekSource(this));
    }

    public long q(byte b8, long j8, long j9) {
        Segment segment;
        int i8;
        long j10 = j8;
        long j11 = j9;
        boolean z7 = false;
        long j12 = 0;
        if (0 <= j10 && j10 <= j11) {
            z7 = true;
        }
        if (z7) {
            if (j11 > size()) {
                j11 = size();
            }
            long j13 = j11;
            if (j10 == j13 || (segment = this.f52580f) == null) {
                return -1L;
            }
            if (size() - j10 < j10) {
                j12 = size();
                while (j12 > j10) {
                    segment = segment.f52637g;
                    Intrinsics.c(segment);
                    j12 -= segment.f52633c - segment.f52632b;
                }
                while (j12 < j13) {
                    byte[] bArr = segment.f52631a;
                    int min = (int) Math.min(segment.f52633c, (segment.f52632b + j13) - j12);
                    i8 = (int) ((segment.f52632b + j10) - j12);
                    while (i8 < min) {
                        if (bArr[i8] != b8) {
                            i8++;
                        }
                    }
                    j12 += segment.f52633c - segment.f52632b;
                    segment = segment.f52636f;
                    Intrinsics.c(segment);
                    j10 = j12;
                }
                return -1L;
            }
            while (true) {
                long j14 = (segment.f52633c - segment.f52632b) + j12;
                if (j14 > j10) {
                    break;
                }
                segment = segment.f52636f;
                Intrinsics.c(segment);
                j12 = j14;
            }
            while (j12 < j13) {
                byte[] bArr2 = segment.f52631a;
                int min2 = (int) Math.min(segment.f52633c, (segment.f52632b + j13) - j12);
                i8 = (int) ((segment.f52632b + j10) - j12);
                while (i8 < min2) {
                    if (bArr2[i8] != b8) {
                        i8++;
                    }
                }
                j12 += segment.f52633c - segment.f52632b;
                segment = segment.f52636f;
                Intrinsics.c(segment);
                j10 = j12;
            }
            return -1L;
            return (i8 - segment.f52632b) + j12;
        }
        throw new IllegalArgumentException(("size=" + size() + " fromIndex=" + j10 + " toIndex=" + j11).toString());
    }

    @Override // java.nio.channels.ReadableByteChannel
    public int read(ByteBuffer sink) throws IOException {
        Intrinsics.f(sink, "sink");
        Segment segment = this.f52580f;
        if (segment == null) {
            return -1;
        }
        int min = Math.min(sink.remaining(), segment.f52633c - segment.f52632b);
        sink.put(segment.f52631a, segment.f52632b, min);
        int i8 = segment.f52632b + min;
        segment.f52632b = i8;
        this.f52581g -= min;
        if (i8 == segment.f52633c) {
            this.f52580f = segment.b();
            SegmentPool.b(segment);
        }
        return min;
    }

    @Override // okio.BufferedSource
    public byte readByte() throws EOFException {
        if (size() != 0) {
            Segment segment = this.f52580f;
            Intrinsics.c(segment);
            int i8 = segment.f52632b;
            int i9 = segment.f52633c;
            int i10 = i8 + 1;
            byte b8 = segment.f52631a[i8];
            C0(size() - 1);
            if (i10 == i9) {
                this.f52580f = segment.b();
                SegmentPool.b(segment);
            } else {
                segment.f52632b = i10;
            }
            return b8;
        }
        throw new EOFException();
    }

    @Override // okio.BufferedSource
    public void readFully(byte[] sink) throws EOFException {
        Intrinsics.f(sink, "sink");
        int i8 = 0;
        while (i8 < sink.length) {
            int read = read(sink, i8, sink.length - i8);
            if (read != -1) {
                i8 += read;
            } else {
                throw new EOFException();
            }
        }
    }

    @Override // okio.BufferedSource
    public int readInt() throws EOFException {
        if (size() >= 4) {
            Segment segment = this.f52580f;
            Intrinsics.c(segment);
            int i8 = segment.f52632b;
            int i9 = segment.f52633c;
            if (i9 - i8 < 4) {
                return ((readByte() & 255) << 24) | ((readByte() & 255) << 16) | ((readByte() & 255) << 8) | (readByte() & 255);
            }
            byte[] bArr = segment.f52631a;
            int i10 = i8 + 1;
            int i11 = i10 + 1;
            int i12 = ((bArr[i8] & 255) << 24) | ((bArr[i10] & 255) << 16);
            int i13 = i11 + 1;
            int i14 = i12 | ((bArr[i11] & 255) << 8);
            int i15 = i13 + 1;
            int i16 = i14 | (bArr[i13] & 255);
            C0(size() - 4);
            if (i15 == i9) {
                this.f52580f = segment.b();
                SegmentPool.b(segment);
            } else {
                segment.f52632b = i15;
            }
            return i16;
        }
        throw new EOFException();
    }

    @Override // okio.BufferedSource
    public long readLong() throws EOFException {
        if (size() >= 8) {
            Segment segment = this.f52580f;
            Intrinsics.c(segment);
            int i8 = segment.f52632b;
            int i9 = segment.f52633c;
            if (i9 - i8 < 8) {
                return ((readInt() & 4294967295L) << 32) | (4294967295L & readInt());
            }
            byte[] bArr = segment.f52631a;
            int i10 = i8 + 1;
            int i11 = i10 + 1;
            int i12 = i11 + 1;
            long j8 = ((bArr[i8] & 255) << 56) | ((bArr[i10] & 255) << 48) | ((bArr[i11] & 255) << 40);
            int i13 = i12 + 1;
            long j9 = ((bArr[i12] & 255) << 32) | j8;
            int i14 = i13 + 1;
            int i15 = i14 + 1;
            long j10 = j9 | ((bArr[i13] & 255) << 24) | ((bArr[i14] & 255) << 16);
            int i16 = i15 + 1;
            int i17 = i16 + 1;
            long j11 = j10 | ((bArr[i15] & 255) << 8) | (bArr[i16] & 255);
            C0(size() - 8);
            if (i17 == i9) {
                this.f52580f = segment.b();
                SegmentPool.b(segment);
            } else {
                segment.f52632b = i17;
            }
            return j11;
        }
        throw new EOFException();
    }

    @Override // okio.BufferedSource
    public short readShort() throws EOFException {
        if (size() >= 2) {
            Segment segment = this.f52580f;
            Intrinsics.c(segment);
            int i8 = segment.f52632b;
            int i9 = segment.f52633c;
            if (i9 - i8 < 2) {
                return (short) (((readByte() & 255) << 8) | (readByte() & 255));
            }
            byte[] bArr = segment.f52631a;
            int i10 = i8 + 1;
            int i11 = i10 + 1;
            int i12 = ((bArr[i8] & 255) << 8) | (bArr[i10] & 255);
            C0(size() - 2);
            if (i11 == i9) {
                this.f52580f = segment.b();
                SegmentPool.b(segment);
            } else {
                segment.f52632b = i11;
            }
            return (short) i12;
        }
        throw new EOFException();
    }

    @Override // okio.BufferedSource
    public Buffer s() {
        return this;
    }

    public String s0(long j8) throws EOFException {
        return f0(j8, Charsets.f51135b);
    }

    public final long size() {
        return this.f52581g;
    }

    @Override // okio.BufferedSource
    public void skip(long j8) throws EOFException {
        while (j8 > 0) {
            Segment segment = this.f52580f;
            if (segment != null) {
                int min = (int) Math.min(j8, segment.f52633c - segment.f52632b);
                long j9 = min;
                C0(size() - j9);
                j8 -= j9;
                int i8 = segment.f52632b + min;
                segment.f52632b = i8;
                if (i8 == segment.f52633c) {
                    this.f52580f = segment.b();
                    SegmentPool.b(segment);
                }
            } else {
                throw new EOFException();
            }
        }
    }

    public long t(ByteString bytes, long j8) throws IOException {
        boolean z7;
        boolean z8;
        Intrinsics.f(bytes, "bytes");
        if (bytes.z() > 0) {
            z7 = true;
        } else {
            z7 = false;
        }
        if (z7) {
            long j9 = 0;
            if (j8 >= 0) {
                z8 = true;
            } else {
                z8 = false;
            }
            if (z8) {
                Segment segment = this.f52580f;
                if (segment != null) {
                    if (size() - j8 < j8) {
                        long size = size();
                        while (size > j8) {
                            segment = segment.f52637g;
                            Intrinsics.c(segment);
                            size -= segment.f52633c - segment.f52632b;
                        }
                        byte[] q8 = bytes.q();
                        byte b8 = q8[0];
                        int z9 = bytes.z();
                        long size2 = (size() - z9) + 1;
                        Segment segment2 = segment;
                        long j10 = size;
                        long j11 = j8;
                        while (j10 < size2) {
                            byte[] bArr = segment2.f52631a;
                            long j12 = j11;
                            int min = (int) Math.min(segment2.f52633c, (segment2.f52632b + size2) - j10);
                            int i8 = (int) ((segment2.f52632b + j12) - j10);
                            if (i8 < min) {
                                while (true) {
                                    int i9 = i8 + 1;
                                    if (bArr[i8] == b8 && _BufferKt.c(segment2, i9, q8, 1, z9)) {
                                        return (i8 - segment2.f52632b) + j10;
                                    }
                                    if (i9 >= min) {
                                        break;
                                    }
                                    i8 = i9;
                                }
                            }
                            j10 += segment2.f52633c - segment2.f52632b;
                            segment2 = segment2.f52636f;
                            Intrinsics.c(segment2);
                            j11 = j10;
                        }
                    } else {
                        while (true) {
                            long j13 = (segment.f52633c - segment.f52632b) + j9;
                            if (j13 > j8) {
                                break;
                            }
                            segment = segment.f52636f;
                            Intrinsics.c(segment);
                            j9 = j13;
                        }
                        byte[] q9 = bytes.q();
                        byte b9 = q9[0];
                        int z10 = bytes.z();
                        long size3 = (size() - z10) + 1;
                        long j14 = j9;
                        long j15 = j8;
                        while (j14 < size3) {
                            byte[] bArr2 = segment.f52631a;
                            long j16 = size3;
                            int min2 = (int) Math.min(segment.f52633c, (segment.f52632b + size3) - j14);
                            int i10 = (int) ((segment.f52632b + j15) - j14);
                            if (i10 < min2) {
                                while (true) {
                                    int i11 = i10 + 1;
                                    if (bArr2[i10] == b9 && _BufferKt.c(segment, i11, q9, 1, z10)) {
                                        return (i10 - segment.f52632b) + j14;
                                    }
                                    if (i11 >= min2) {
                                        break;
                                    }
                                    i10 = i11;
                                }
                            }
                            j14 += segment.f52633c - segment.f52632b;
                            segment = segment.f52636f;
                            Intrinsics.c(segment);
                            j15 = j14;
                            size3 = j16;
                        }
                    }
                }
                return -1L;
            }
            throw new IllegalArgumentException(Intrinsics.n("fromIndex < 0: ", Long.valueOf(j8)).toString());
        }
        throw new IllegalArgumentException("bytes is empty".toString());
    }

    @Override // okio.Source
    public Timeout timeout() {
        return Timeout.NONE;
    }

    public String toString() {
        return D0().toString();
    }

    public int v0() throws EOFException {
        int i8;
        int i9;
        int i10;
        if (size() != 0) {
            byte m8 = m(0L);
            boolean z7 = false;
            if ((m8 & 128) == 0) {
                i8 = m8 & Byte.MAX_VALUE;
                i9 = 1;
                i10 = 0;
            } else if ((m8 & 224) == 192) {
                i8 = m8 & 31;
                i9 = 2;
                i10 = 128;
            } else if ((m8 & 240) == 224) {
                i8 = m8 & 15;
                i9 = 3;
                i10 = 2048;
            } else if ((m8 & 248) == 240) {
                i8 = m8 & 7;
                i9 = 4;
                i10 = 65536;
            } else {
                skip(1L);
                return 65533;
            }
            long j8 = i9;
            if (size() >= j8) {
                if (1 < i9) {
                    int i11 = 1;
                    while (true) {
                        int i12 = i11 + 1;
                        long j9 = i11;
                        byte m9 = m(j9);
                        if ((m9 & 192) == 128) {
                            i8 = (i8 << 6) | (m9 & 63);
                            if (i12 >= i9) {
                                break;
                            }
                            i11 = i12;
                        } else {
                            skip(j9);
                            return 65533;
                        }
                    }
                }
                skip(j8);
                if (i8 > 1114111) {
                    return 65533;
                }
                if (55296 <= i8 && i8 <= 57343) {
                    z7 = true;
                }
                if (z7 || i8 < i10) {
                    return 65533;
                }
                return i8;
            }
            throw new EOFException("size < " + i9 + ": " + size() + " (to read code point prefixed 0x" + _UtilKt.h(m8) + ')');
        }
        throw new EOFException();
    }

    @Override // okio.BufferedSource
    public byte[] w0() {
        return e0(size());
    }

    @Override // okio.BufferedSource
    public boolean y0() {
        if (this.f52581g == 0) {
            return true;
        }
        return false;
    }

    @Override // java.nio.channels.WritableByteChannel
    public int write(ByteBuffer source) throws IOException {
        Intrinsics.f(source, "source");
        int remaining = source.remaining();
        int i8 = remaining;
        while (i8 > 0) {
            Segment I0 = I0(1);
            int min = Math.min(i8, 8192 - I0.f52633c);
            source.get(I0.f52631a, I0.f52633c, min);
            i8 -= min;
            I0.f52633c += min;
        }
        this.f52581g += remaining;
        return remaining;
    }

    public int read(byte[] sink, int i8, int i9) {
        Intrinsics.f(sink, "sink");
        _UtilKt.b(sink.length, i8, i9);
        Segment segment = this.f52580f;
        if (segment == null) {
            return -1;
        }
        int min = Math.min(i9, segment.f52633c - segment.f52632b);
        byte[] bArr = segment.f52631a;
        int i10 = segment.f52632b;
        ArraysKt.f(bArr, sink, i8, i10, i10 + min);
        segment.f52632b += min;
        C0(size() - min);
        if (segment.f52632b == segment.f52633c) {
            this.f52580f = segment.b();
            SegmentPool.b(segment);
        }
        return min;
    }

    @Override // okio.Sink
    public void write(Buffer source, long j8) {
        Segment segment;
        Segment segment2;
        Intrinsics.f(source, "source");
        if (source != this) {
            _UtilKt.b(source.size(), 0L, j8);
            while (j8 > 0) {
                Segment segment3 = source.f52580f;
                Intrinsics.c(segment3);
                int i8 = segment3.f52633c;
                Intrinsics.c(source.f52580f);
                if (j8 < i8 - segment.f52632b) {
                    Segment segment4 = this.f52580f;
                    if (segment4 != null) {
                        Intrinsics.c(segment4);
                        segment2 = segment4.f52637g;
                    } else {
                        segment2 = null;
                    }
                    if (segment2 != null && segment2.f52635e) {
                        if ((segment2.f52633c + j8) - (segment2.f52634d ? 0 : segment2.f52632b) <= 8192) {
                            Segment segment5 = source.f52580f;
                            Intrinsics.c(segment5);
                            segment5.g(segment2, (int) j8);
                            source.C0(source.size() - j8);
                            C0(size() + j8);
                            return;
                        }
                    }
                    Segment segment6 = source.f52580f;
                    Intrinsics.c(segment6);
                    source.f52580f = segment6.e((int) j8);
                }
                Segment segment7 = source.f52580f;
                Intrinsics.c(segment7);
                long j9 = segment7.f52633c - segment7.f52632b;
                source.f52580f = segment7.b();
                Segment segment8 = this.f52580f;
                if (segment8 == null) {
                    this.f52580f = segment7;
                    segment7.f52637g = segment7;
                    segment7.f52636f = segment7;
                } else {
                    Intrinsics.c(segment8);
                    Segment segment9 = segment8.f52637g;
                    Intrinsics.c(segment9);
                    segment9.c(segment7).a();
                }
                source.C0(source.size() - j9);
                C0(size() + j9);
                j8 -= j9;
            }
            return;
        }
        throw new IllegalArgumentException("source == this".toString());
    }

    @Override // okio.Source
    public long read(Buffer sink, long j8) {
        Intrinsics.f(sink, "sink");
        if (j8 >= 0) {
            if (size() == 0) {
                return -1L;
            }
            if (j8 > size()) {
                j8 = size();
            }
            sink.write(this, j8);
            return j8;
        }
        throw new IllegalArgumentException(Intrinsics.n("byteCount < 0: ", Long.valueOf(j8)).toString());
    }
}
