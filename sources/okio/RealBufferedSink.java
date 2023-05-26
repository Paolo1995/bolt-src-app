package okio;

import java.nio.ByteBuffer;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: RealBufferedSink.kt */
/* loaded from: classes5.dex */
public final class RealBufferedSink implements BufferedSink {

    /* renamed from: f  reason: collision with root package name */
    public final Sink f52623f;

    /* renamed from: g  reason: collision with root package name */
    public final Buffer f52624g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f52625h;

    public RealBufferedSink(Sink sink) {
        Intrinsics.f(sink, "sink");
        this.f52623f = sink;
        this.f52624g = new Buffer();
    }

    @Override // okio.BufferedSink
    public BufferedSink H() {
        if (!this.f52625h) {
            long e8 = this.f52624g.e();
            if (e8 > 0) {
                this.f52623f.write(this.f52624g, e8);
            }
            return this;
        }
        throw new IllegalStateException("closed".toString());
    }

    @Override // okio.BufferedSink
    public BufferedSink M0(long j8) {
        if (!this.f52625h) {
            this.f52624g.M0(j8);
            return H();
        }
        throw new IllegalStateException("closed".toString());
    }

    @Override // okio.BufferedSink
    public BufferedSink Q(String string) {
        Intrinsics.f(string, "string");
        if (!this.f52625h) {
            this.f52624g.Q(string);
            return H();
        }
        throw new IllegalStateException("closed".toString());
    }

    @Override // okio.BufferedSink
    public BufferedSink U(String string, int i8, int i9) {
        Intrinsics.f(string, "string");
        if (!this.f52625h) {
            this.f52624g.U(string, i8, i9);
            return H();
        }
        throw new IllegalStateException("closed".toString());
    }

    @Override // okio.BufferedSink
    public long V(Source source) {
        Intrinsics.f(source, "source");
        long j8 = 0;
        while (true) {
            long read = source.read(this.f52624g, 8192L);
            if (read == -1) {
                return j8;
            }
            j8 += read;
            H();
        }
    }

    @Override // okio.BufferedSink
    public BufferedSink a1(ByteString byteString) {
        Intrinsics.f(byteString, "byteString");
        if (!this.f52625h) {
            this.f52624g.a1(byteString);
            return H();
        }
        throw new IllegalStateException("closed".toString());
    }

    @Override // okio.BufferedSink
    public Buffer b() {
        return this.f52624g;
    }

    @Override // okio.Sink, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (!this.f52625h) {
            Throwable th = null;
            try {
                if (this.f52624g.size() > 0) {
                    Sink sink = this.f52623f;
                    Buffer buffer = this.f52624g;
                    sink.write(buffer, buffer.size());
                }
            } catch (Throwable th2) {
                th = th2;
            }
            try {
                this.f52623f.close();
            } catch (Throwable th3) {
                if (th == null) {
                    th = th3;
                }
            }
            this.f52625h = true;
            if (th == null) {
                return;
            }
            throw th;
        }
    }

    @Override // okio.BufferedSink, okio.Sink, java.io.Flushable
    public void flush() {
        if (!this.f52625h) {
            if (this.f52624g.size() > 0) {
                Sink sink = this.f52623f;
                Buffer buffer = this.f52624g;
                sink.write(buffer, buffer.size());
            }
            this.f52623f.flush();
            return;
        }
        throw new IllegalStateException("closed".toString());
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return !this.f52625h;
    }

    @Override // okio.BufferedSink
    public BufferedSink l0(long j8) {
        if (!this.f52625h) {
            this.f52624g.l0(j8);
            return H();
        }
        throw new IllegalStateException("closed".toString());
    }

    @Override // okio.Sink
    public Timeout timeout() {
        return this.f52623f.timeout();
    }

    public String toString() {
        return "buffer(" + this.f52623f + ')';
    }

    @Override // okio.BufferedSink
    public BufferedSink v() {
        if (!this.f52625h) {
            long size = this.f52624g.size();
            if (size > 0) {
                this.f52623f.write(this.f52624g, size);
            }
            return this;
        }
        throw new IllegalStateException("closed".toString());
    }

    @Override // java.nio.channels.WritableByteChannel
    public int write(ByteBuffer source) {
        Intrinsics.f(source, "source");
        if (!this.f52625h) {
            int write = this.f52624g.write(source);
            H();
            return write;
        }
        throw new IllegalStateException("closed".toString());
    }

    @Override // okio.BufferedSink
    public BufferedSink writeByte(int i8) {
        if (!this.f52625h) {
            this.f52624g.writeByte(i8);
            return H();
        }
        throw new IllegalStateException("closed".toString());
    }

    @Override // okio.BufferedSink
    public BufferedSink writeInt(int i8) {
        if (!this.f52625h) {
            this.f52624g.writeInt(i8);
            return H();
        }
        throw new IllegalStateException("closed".toString());
    }

    @Override // okio.BufferedSink
    public BufferedSink writeShort(int i8) {
        if (!this.f52625h) {
            this.f52624g.writeShort(i8);
            return H();
        }
        throw new IllegalStateException("closed".toString());
    }

    @Override // okio.Sink
    public void write(Buffer source, long j8) {
        Intrinsics.f(source, "source");
        if (!this.f52625h) {
            this.f52624g.write(source, j8);
            H();
            return;
        }
        throw new IllegalStateException("closed".toString());
    }

    @Override // okio.BufferedSink
    public BufferedSink write(byte[] source) {
        Intrinsics.f(source, "source");
        if (!this.f52625h) {
            this.f52624g.write(source);
            return H();
        }
        throw new IllegalStateException("closed".toString());
    }

    @Override // okio.BufferedSink
    public BufferedSink write(byte[] source, int i8, int i9) {
        Intrinsics.f(source, "source");
        if (!this.f52625h) {
            this.f52624g.write(source, i8, i9);
            return H();
        }
        throw new IllegalStateException("closed".toString());
    }
}
