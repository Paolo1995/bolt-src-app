package okhttp3.internal.http2;

import com.google.android.gms.common.api.Api;
import java.io.Closeable;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.Util;
import okhttp3.internal.http2.Hpack;
import okio.Buffer;
import okio.BufferedSink;

/* compiled from: Http2Writer.kt */
/* loaded from: classes5.dex */
public final class Http2Writer implements Closeable {
    public static final Companion Companion = new Companion(null);
    private static final Logger logger = Logger.getLogger(Http2.class.getName());
    private final boolean client;
    private boolean closed;
    private final Buffer hpackBuffer;
    private final Hpack.Writer hpackWriter;
    private int maxFrameSize;
    private final BufferedSink sink;

    /* compiled from: Http2Writer.kt */
    /* loaded from: classes5.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public Http2Writer(BufferedSink sink, boolean z7) {
        Intrinsics.f(sink, "sink");
        this.sink = sink;
        this.client = z7;
        Buffer buffer = new Buffer();
        this.hpackBuffer = buffer;
        this.maxFrameSize = 16384;
        this.hpackWriter = new Hpack.Writer(0, false, buffer, 3, null);
    }

    private final void writeContinuationFrames(int i8, long j8) throws IOException {
        int i9;
        while (j8 > 0) {
            long min = Math.min(this.maxFrameSize, j8);
            j8 -= min;
            int i10 = (int) min;
            if (j8 == 0) {
                i9 = 4;
            } else {
                i9 = 0;
            }
            frameHeader(i8, i10, 9, i9);
            this.sink.write(this.hpackBuffer, min);
        }
    }

    public final synchronized void applyAndAckSettings(Settings peerSettings) throws IOException {
        Intrinsics.f(peerSettings, "peerSettings");
        if (!this.closed) {
            this.maxFrameSize = peerSettings.getMaxFrameSize(this.maxFrameSize);
            if (peerSettings.getHeaderTableSize() != -1) {
                this.hpackWriter.resizeHeaderTable(peerSettings.getHeaderTableSize());
            }
            frameHeader(0, 0, 4, 1);
            this.sink.flush();
        } else {
            throw new IOException("closed");
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() throws IOException {
        this.closed = true;
        this.sink.close();
    }

    public final synchronized void connectionPreface() throws IOException {
        if (!this.closed) {
            if (!this.client) {
                return;
            }
            Logger logger2 = logger;
            if (logger2.isLoggable(Level.FINE)) {
                logger2.fine(Util.format(Intrinsics.n(">> CONNECTION ", Http2.CONNECTION_PREFACE.p()), new Object[0]));
            }
            this.sink.a1(Http2.CONNECTION_PREFACE);
            this.sink.flush();
            return;
        }
        throw new IOException("closed");
    }

    public final synchronized void data(boolean z7, int i8, Buffer buffer, int i9) throws IOException {
        if (!this.closed) {
            dataFrame(i8, z7 ? 1 : 0, buffer, i9);
        } else {
            throw new IOException("closed");
        }
    }

    public final void dataFrame(int i8, int i9, Buffer buffer, int i10) throws IOException {
        frameHeader(i8, i10, 0, i9);
        if (i10 > 0) {
            BufferedSink bufferedSink = this.sink;
            Intrinsics.c(buffer);
            bufferedSink.write(buffer, i10);
        }
    }

    public final synchronized void flush() throws IOException {
        if (!this.closed) {
            this.sink.flush();
        } else {
            throw new IOException("closed");
        }
    }

    public final void frameHeader(int i8, int i9, int i10, int i11) throws IOException {
        boolean z7;
        Logger logger2 = logger;
        if (logger2.isLoggable(Level.FINE)) {
            logger2.fine(Http2.INSTANCE.frameLog(false, i8, i9, i10, i11));
        }
        boolean z8 = true;
        if (i9 <= this.maxFrameSize) {
            z7 = true;
        } else {
            z7 = false;
        }
        if (z7) {
            if ((Integer.MIN_VALUE & i8) != 0) {
                z8 = false;
            }
            if (z8) {
                Util.writeMedium(this.sink, i9);
                this.sink.writeByte(i10 & 255);
                this.sink.writeByte(i11 & 255);
                this.sink.writeInt(i8 & Api.BaseClientBuilder.API_PRIORITY_OTHER);
                return;
            }
            throw new IllegalArgumentException(Intrinsics.n("reserved bit set: ", Integer.valueOf(i8)).toString());
        }
        throw new IllegalArgumentException(("FRAME_SIZE_ERROR length > " + this.maxFrameSize + ": " + i9).toString());
    }

    public final Hpack.Writer getHpackWriter() {
        return this.hpackWriter;
    }

    public final synchronized void goAway(int i8, ErrorCode errorCode, byte[] debugData) throws IOException {
        boolean z7;
        Intrinsics.f(errorCode, "errorCode");
        Intrinsics.f(debugData, "debugData");
        if (!this.closed) {
            boolean z8 = false;
            if (errorCode.getHttpCode() != -1) {
                z7 = true;
            } else {
                z7 = false;
            }
            if (z7) {
                frameHeader(0, debugData.length + 8, 7, 0);
                this.sink.writeInt(i8);
                this.sink.writeInt(errorCode.getHttpCode());
                if (debugData.length == 0) {
                    z8 = true;
                }
                if (!z8) {
                    this.sink.write(debugData);
                }
                this.sink.flush();
            } else {
                throw new IllegalArgumentException("errorCode.httpCode == -1".toString());
            }
        } else {
            throw new IOException("closed");
        }
    }

    public final synchronized void headers(boolean z7, int i8, List<Header> headerBlock) throws IOException {
        int i9;
        Intrinsics.f(headerBlock, "headerBlock");
        if (!this.closed) {
            this.hpackWriter.writeHeaders(headerBlock);
            long size = this.hpackBuffer.size();
            long min = Math.min(this.maxFrameSize, size);
            int i10 = (size > min ? 1 : (size == min ? 0 : -1));
            if (i10 == 0) {
                i9 = 4;
            } else {
                i9 = 0;
            }
            if (z7) {
                i9 |= 1;
            }
            frameHeader(i8, (int) min, 1, i9);
            this.sink.write(this.hpackBuffer, min);
            if (i10 > 0) {
                writeContinuationFrames(i8, size - min);
            }
        } else {
            throw new IOException("closed");
        }
    }

    public final int maxDataLength() {
        return this.maxFrameSize;
    }

    public final synchronized void ping(boolean z7, int i8, int i9) throws IOException {
        int i10;
        if (!this.closed) {
            if (z7) {
                i10 = 1;
            } else {
                i10 = 0;
            }
            frameHeader(0, 8, 6, i10);
            this.sink.writeInt(i8);
            this.sink.writeInt(i9);
            this.sink.flush();
        } else {
            throw new IOException("closed");
        }
    }

    public final synchronized void pushPromise(int i8, int i9, List<Header> requestHeaders) throws IOException {
        int i10;
        Intrinsics.f(requestHeaders, "requestHeaders");
        if (!this.closed) {
            this.hpackWriter.writeHeaders(requestHeaders);
            long size = this.hpackBuffer.size();
            int min = (int) Math.min(this.maxFrameSize - 4, size);
            int i11 = min + 4;
            long j8 = min;
            int i12 = (size > j8 ? 1 : (size == j8 ? 0 : -1));
            if (i12 == 0) {
                i10 = 4;
            } else {
                i10 = 0;
            }
            frameHeader(i8, i11, 5, i10);
            this.sink.writeInt(i9 & Api.BaseClientBuilder.API_PRIORITY_OTHER);
            this.sink.write(this.hpackBuffer, j8);
            if (i12 > 0) {
                writeContinuationFrames(i8, size - j8);
            }
        } else {
            throw new IOException("closed");
        }
    }

    public final synchronized void rstStream(int i8, ErrorCode errorCode) throws IOException {
        boolean z7;
        Intrinsics.f(errorCode, "errorCode");
        if (!this.closed) {
            if (errorCode.getHttpCode() != -1) {
                z7 = true;
            } else {
                z7 = false;
            }
            if (z7) {
                frameHeader(i8, 4, 3, 0);
                this.sink.writeInt(errorCode.getHttpCode());
                this.sink.flush();
            } else {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
        } else {
            throw new IOException("closed");
        }
    }

    public final synchronized void settings(Settings settings) throws IOException {
        int i8;
        Intrinsics.f(settings, "settings");
        if (!this.closed) {
            int i9 = 0;
            frameHeader(0, settings.size() * 6, 4, 0);
            while (i9 < 10) {
                int i10 = i9 + 1;
                if (settings.isSet(i9)) {
                    if (i9 != 4) {
                        if (i9 != 7) {
                            i8 = i9;
                        } else {
                            i8 = 4;
                        }
                    } else {
                        i8 = 3;
                    }
                    this.sink.writeShort(i8);
                    this.sink.writeInt(settings.get(i9));
                }
                i9 = i10;
            }
            this.sink.flush();
        } else {
            throw new IOException("closed");
        }
    }

    public final synchronized void windowUpdate(int i8, long j8) throws IOException {
        boolean z7;
        if (!this.closed) {
            if (j8 != 0 && j8 <= 2147483647L) {
                z7 = true;
            } else {
                z7 = false;
            }
            if (z7) {
                frameHeader(i8, 4, 8, 0);
                this.sink.writeInt((int) j8);
                this.sink.flush();
            } else {
                throw new IllegalArgumentException(Intrinsics.n("windowSizeIncrement == 0 || windowSizeIncrement > 0x7fffffffL: ", Long.valueOf(j8)).toString());
            }
        } else {
            throw new IOException("closed");
        }
    }
}
