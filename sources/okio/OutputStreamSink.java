package okio;

import java.io.OutputStream;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: JvmOkio.kt */
/* loaded from: classes5.dex */
public final class OutputStreamSink implements Sink {

    /* renamed from: f  reason: collision with root package name */
    private final OutputStream f52615f;

    /* renamed from: g  reason: collision with root package name */
    private final Timeout f52616g;

    public OutputStreamSink(OutputStream out, Timeout timeout) {
        Intrinsics.f(out, "out");
        Intrinsics.f(timeout, "timeout");
        this.f52615f = out;
        this.f52616g = timeout;
    }

    @Override // okio.Sink, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f52615f.close();
    }

    @Override // okio.Sink, java.io.Flushable
    public void flush() {
        this.f52615f.flush();
    }

    @Override // okio.Sink
    public Timeout timeout() {
        return this.f52616g;
    }

    public String toString() {
        return "sink(" + this.f52615f + ')';
    }

    @Override // okio.Sink
    public void write(Buffer source, long j8) {
        Intrinsics.f(source, "source");
        _UtilKt.b(source.size(), 0L, j8);
        while (j8 > 0) {
            this.f52616g.throwIfReached();
            Segment segment = source.f52580f;
            Intrinsics.c(segment);
            int min = (int) Math.min(j8, segment.f52633c - segment.f52632b);
            this.f52615f.write(segment.f52631a, segment.f52632b, min);
            segment.f52632b += min;
            long j9 = min;
            j8 -= j9;
            source.C0(source.size() - j9);
            if (segment.f52632b == segment.f52633c) {
                source.f52580f = segment.b();
                SegmentPool.b(segment);
            }
        }
    }
}
