package okio;

import java.io.EOFException;
import java.io.IOException;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: InflaterSource.kt */
/* loaded from: classes5.dex */
public final class InflaterSource implements Source {

    /* renamed from: f  reason: collision with root package name */
    private final BufferedSource f52605f;

    /* renamed from: g  reason: collision with root package name */
    private final Inflater f52606g;

    /* renamed from: h  reason: collision with root package name */
    private int f52607h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f52608i;

    public InflaterSource(BufferedSource source, Inflater inflater) {
        Intrinsics.f(source, "source");
        Intrinsics.f(inflater, "inflater");
        this.f52605f = source;
        this.f52606g = inflater;
    }

    private final void e() {
        int i8 = this.f52607h;
        if (i8 == 0) {
            return;
        }
        int remaining = i8 - this.f52606g.getRemaining();
        this.f52607h -= remaining;
        this.f52605f.skip(remaining);
    }

    public final long a(Buffer sink, long j8) throws IOException {
        boolean z7;
        Intrinsics.f(sink, "sink");
        int i8 = (j8 > 0L ? 1 : (j8 == 0L ? 0 : -1));
        if (i8 >= 0) {
            z7 = true;
        } else {
            z7 = false;
        }
        if (z7) {
            if (!this.f52608i) {
                if (i8 == 0) {
                    return 0L;
                }
                try {
                    Segment I0 = sink.I0(1);
                    int min = (int) Math.min(j8, 8192 - I0.f52633c);
                    c();
                    int inflate = this.f52606g.inflate(I0.f52631a, I0.f52633c, min);
                    e();
                    if (inflate > 0) {
                        I0.f52633c += inflate;
                        long j9 = inflate;
                        sink.C0(sink.size() + j9);
                        return j9;
                    }
                    if (I0.f52632b == I0.f52633c) {
                        sink.f52580f = I0.b();
                        SegmentPool.b(I0);
                    }
                    return 0L;
                } catch (DataFormatException e8) {
                    throw new IOException(e8);
                }
            }
            throw new IllegalStateException("closed".toString());
        }
        throw new IllegalArgumentException(Intrinsics.n("byteCount < 0: ", Long.valueOf(j8)).toString());
    }

    public final boolean c() throws IOException {
        if (!this.f52606g.needsInput()) {
            return false;
        }
        if (this.f52605f.y0()) {
            return true;
        }
        Segment segment = this.f52605f.b().f52580f;
        Intrinsics.c(segment);
        int i8 = segment.f52633c;
        int i9 = segment.f52632b;
        int i10 = i8 - i9;
        this.f52607h = i10;
        this.f52606g.setInput(segment.f52631a, i9, i10);
        return false;
    }

    @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.f52608i) {
            return;
        }
        this.f52606g.end();
        this.f52608i = true;
        this.f52605f.close();
    }

    @Override // okio.Source
    public long read(Buffer sink, long j8) throws IOException {
        Intrinsics.f(sink, "sink");
        do {
            long a8 = a(sink, j8);
            if (a8 > 0) {
                return a8;
            }
            if (this.f52606g.finished() || this.f52606g.needsDictionary()) {
                return -1L;
            }
        } while (!this.f52605f.y0());
        throw new EOFException("source exhausted prematurely");
    }

    @Override // okio.Source
    public Timeout timeout() {
        return this.f52605f.timeout();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public InflaterSource(Source source, Inflater inflater) {
        this(Okio.d(source), inflater);
        Intrinsics.f(source, "source");
        Intrinsics.f(inflater, "inflater");
    }
}
