package okio;

import java.io.IOException;
import java.io.InputStream;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: JvmOkio.kt */
/* loaded from: classes5.dex */
public class InputStreamSource implements Source {

    /* renamed from: f  reason: collision with root package name */
    private final InputStream f52609f;

    /* renamed from: g  reason: collision with root package name */
    private final Timeout f52610g;

    public InputStreamSource(InputStream input, Timeout timeout) {
        Intrinsics.f(input, "input");
        Intrinsics.f(timeout, "timeout");
        this.f52609f = input;
        this.f52610g = timeout;
    }

    @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f52609f.close();
    }

    @Override // okio.Source
    public long read(Buffer sink, long j8) {
        boolean z7;
        Intrinsics.f(sink, "sink");
        int i8 = (j8 > 0L ? 1 : (j8 == 0L ? 0 : -1));
        if (i8 == 0) {
            return 0L;
        }
        if (i8 >= 0) {
            z7 = true;
        } else {
            z7 = false;
        }
        if (z7) {
            try {
                this.f52610g.throwIfReached();
                Segment I0 = sink.I0(1);
                int read = this.f52609f.read(I0.f52631a, I0.f52633c, (int) Math.min(j8, 8192 - I0.f52633c));
                if (read == -1) {
                    if (I0.f52632b == I0.f52633c) {
                        sink.f52580f = I0.b();
                        SegmentPool.b(I0);
                        return -1L;
                    }
                    return -1L;
                }
                I0.f52633c += read;
                long j9 = read;
                sink.C0(sink.size() + j9);
                return j9;
            } catch (AssertionError e8) {
                if (Okio.e(e8)) {
                    throw new IOException(e8);
                }
                throw e8;
            }
        }
        throw new IllegalArgumentException(Intrinsics.n("byteCount < 0: ", Long.valueOf(j8)).toString());
    }

    @Override // okio.Source
    public Timeout timeout() {
        return this.f52610g;
    }

    public String toString() {
        return "source(" + this.f52609f + ')';
    }
}
