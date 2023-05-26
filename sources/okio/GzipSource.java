package okio;

import java.io.EOFException;
import java.io.IOException;
import java.util.Arrays;
import java.util.zip.CRC32;
import java.util.zip.Inflater;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: GzipSource.kt */
/* loaded from: classes5.dex */
public final class GzipSource implements Source {

    /* renamed from: f  reason: collision with root package name */
    private byte f52600f;

    /* renamed from: g  reason: collision with root package name */
    private final RealBufferedSource f52601g;

    /* renamed from: h  reason: collision with root package name */
    private final Inflater f52602h;

    /* renamed from: i  reason: collision with root package name */
    private final InflaterSource f52603i;

    /* renamed from: j  reason: collision with root package name */
    private final CRC32 f52604j;

    public GzipSource(Source source) {
        Intrinsics.f(source, "source");
        RealBufferedSource realBufferedSource = new RealBufferedSource(source);
        this.f52601g = realBufferedSource;
        Inflater inflater = new Inflater(true);
        this.f52602h = inflater;
        this.f52603i = new InflaterSource((BufferedSource) realBufferedSource, inflater);
        this.f52604j = new CRC32();
    }

    private final void a(String str, int i8, int i9) {
        if (i9 == i8) {
            return;
        }
        String format = String.format("%s: actual 0x%08x != expected 0x%08x", Arrays.copyOf(new Object[]{str, Integer.valueOf(i9), Integer.valueOf(i8)}, 3));
        Intrinsics.e(format, "java.lang.String.format(this, *args)");
        throw new IOException(format);
    }

    private final void c() throws IOException {
        boolean z7;
        boolean z8;
        boolean z9;
        this.f52601g.j0(10L);
        byte m8 = this.f52601g.f52627g.m(3L);
        boolean z10 = true;
        if (((m8 >> 1) & 1) == 1) {
            z7 = true;
        } else {
            z7 = false;
        }
        if (z7) {
            g(this.f52601g.f52627g, 0L, 10L);
        }
        a("ID1ID2", 8075, this.f52601g.readShort());
        this.f52601g.skip(8L);
        if (((m8 >> 2) & 1) == 1) {
            z8 = true;
        } else {
            z8 = false;
        }
        if (z8) {
            this.f52601g.j0(2L);
            if (z7) {
                g(this.f52601g.f52627g, 0L, 2L);
            }
            long d02 = this.f52601g.f52627g.d0();
            this.f52601g.j0(d02);
            if (z7) {
                g(this.f52601g.f52627g, 0L, d02);
            }
            this.f52601g.skip(d02);
        }
        if (((m8 >> 3) & 1) == 1) {
            z9 = true;
        } else {
            z9 = false;
        }
        if (z9) {
            long a8 = this.f52601g.a((byte) 0);
            if (a8 != -1) {
                if (z7) {
                    g(this.f52601g.f52627g, 0L, a8 + 1);
                }
                this.f52601g.skip(a8 + 1);
            } else {
                throw new EOFException();
            }
        }
        if (((m8 >> 4) & 1) != 1) {
            z10 = false;
        }
        if (z10) {
            long a9 = this.f52601g.a((byte) 0);
            if (a9 != -1) {
                if (z7) {
                    g(this.f52601g.f52627g, 0L, a9 + 1);
                }
                this.f52601g.skip(a9 + 1);
            } else {
                throw new EOFException();
            }
        }
        if (z7) {
            a("FHCRC", this.f52601g.k(), (short) this.f52604j.getValue());
            this.f52604j.reset();
        }
    }

    private final void e() throws IOException {
        a("CRC", this.f52601g.j(), (int) this.f52604j.getValue());
        a("ISIZE", this.f52601g.j(), (int) this.f52602h.getBytesWritten());
    }

    private final void g(Buffer buffer, long j8, long j9) {
        int i8;
        Segment segment = buffer.f52580f;
        Intrinsics.c(segment);
        while (true) {
            int i9 = segment.f52633c;
            int i10 = segment.f52632b;
            if (j8 < i9 - i10) {
                break;
            }
            j8 -= i9 - i10;
            segment = segment.f52636f;
            Intrinsics.c(segment);
        }
        while (j9 > 0) {
            int min = (int) Math.min(segment.f52633c - i8, j9);
            this.f52604j.update(segment.f52631a, (int) (segment.f52632b + j8), min);
            j9 -= min;
            segment = segment.f52636f;
            Intrinsics.c(segment);
            j8 = 0;
        }
    }

    @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f52603i.close();
    }

    @Override // okio.Source
    public long read(Buffer sink, long j8) throws IOException {
        boolean z7;
        Intrinsics.f(sink, "sink");
        int i8 = (j8 > 0L ? 1 : (j8 == 0L ? 0 : -1));
        if (i8 >= 0) {
            z7 = true;
        } else {
            z7 = false;
        }
        if (z7) {
            if (i8 == 0) {
                return 0L;
            }
            if (this.f52600f == 0) {
                c();
                this.f52600f = (byte) 1;
            }
            if (this.f52600f == 1) {
                long size = sink.size();
                long read = this.f52603i.read(sink, j8);
                if (read != -1) {
                    g(sink, size, read);
                    return read;
                }
                this.f52600f = (byte) 2;
            }
            if (this.f52600f == 2) {
                e();
                this.f52600f = (byte) 3;
                if (!this.f52601g.y0()) {
                    throw new IOException("gzip finished without exhausting source");
                }
            }
            return -1L;
        }
        throw new IllegalArgumentException(Intrinsics.n("byteCount < 0: ", Long.valueOf(j8)).toString());
    }

    @Override // okio.Source
    public Timeout timeout() {
        return this.f52601g.timeout();
    }
}
