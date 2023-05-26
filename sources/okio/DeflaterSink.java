package okio;

import java.io.IOException;
import java.util.zip.Deflater;
import kotlin.jvm.internal.Intrinsics;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;

/* compiled from: DeflaterSink.kt */
/* loaded from: classes5.dex */
public final class DeflaterSink implements Sink {

    /* renamed from: f  reason: collision with root package name */
    private final BufferedSink f52596f;

    /* renamed from: g  reason: collision with root package name */
    private final Deflater f52597g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f52598h;

    public DeflaterSink(BufferedSink sink, Deflater deflater) {
        Intrinsics.f(sink, "sink");
        Intrinsics.f(deflater, "deflater");
        this.f52596f = sink;
        this.f52597g = deflater;
    }

    @IgnoreJRERequirement
    private final void a(boolean z7) {
        Segment I0;
        int deflate;
        Buffer b8 = this.f52596f.b();
        while (true) {
            I0 = b8.I0(1);
            if (z7) {
                Deflater deflater = this.f52597g;
                byte[] bArr = I0.f52631a;
                int i8 = I0.f52633c;
                deflate = deflater.deflate(bArr, i8, 8192 - i8, 2);
            } else {
                Deflater deflater2 = this.f52597g;
                byte[] bArr2 = I0.f52631a;
                int i9 = I0.f52633c;
                deflate = deflater2.deflate(bArr2, i9, 8192 - i9);
            }
            if (deflate > 0) {
                I0.f52633c += deflate;
                b8.C0(b8.size() + deflate);
                this.f52596f.H();
            } else if (this.f52597g.needsInput()) {
                break;
            }
        }
        if (I0.f52632b == I0.f52633c) {
            b8.f52580f = I0.b();
            SegmentPool.b(I0);
        }
    }

    public final void c() {
        this.f52597g.finish();
        a(false);
    }

    @Override // okio.Sink, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.f52598h) {
            return;
        }
        Throwable th = null;
        try {
            c();
        } catch (Throwable th2) {
            th = th2;
        }
        try {
            this.f52597g.end();
        } catch (Throwable th3) {
            if (th == null) {
                th = th3;
            }
        }
        try {
            this.f52596f.close();
        } catch (Throwable th4) {
            if (th == null) {
                th = th4;
            }
        }
        this.f52598h = true;
        if (th == null) {
            return;
        }
        throw th;
    }

    @Override // okio.Sink, java.io.Flushable
    public void flush() throws IOException {
        a(true);
        this.f52596f.flush();
    }

    @Override // okio.Sink
    public Timeout timeout() {
        return this.f52596f.timeout();
    }

    public String toString() {
        return "DeflaterSink(" + this.f52596f + ')';
    }

    @Override // okio.Sink
    public void write(Buffer source, long j8) throws IOException {
        Intrinsics.f(source, "source");
        _UtilKt.b(source.size(), 0L, j8);
        while (j8 > 0) {
            Segment segment = source.f52580f;
            Intrinsics.c(segment);
            int min = (int) Math.min(j8, segment.f52633c - segment.f52632b);
            this.f52597g.setInput(segment.f52631a, segment.f52632b, min);
            a(false);
            long j9 = min;
            source.C0(source.size() - j9);
            int i8 = segment.f52632b + min;
            segment.f52632b = i8;
            if (i8 == segment.f52633c) {
                source.f52580f = segment.b();
                SegmentPool.b(segment);
            }
            j8 -= j9;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DeflaterSink(Sink sink, Deflater deflater) {
        this(Okio.c(sink), deflater);
        Intrinsics.f(sink, "sink");
        Intrinsics.f(deflater, "deflater");
    }
}
