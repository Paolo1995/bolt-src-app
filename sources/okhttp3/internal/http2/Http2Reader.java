package okhttp3.internal.http2;

import com.google.android.gms.common.api.Api;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntProgression;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt___RangesKt;
import okhttp3.internal.Util;
import okhttp3.internal.http2.Hpack;
import okio.Buffer;
import okio.BufferedSource;
import okio.ByteString;
import okio.Source;
import okio.Timeout;

/* compiled from: Http2Reader.kt */
/* loaded from: classes5.dex */
public final class Http2Reader implements Closeable {
    public static final Companion Companion = new Companion(null);
    private static final Logger logger;
    private final boolean client;
    private final ContinuationSource continuation;
    private final Hpack.Reader hpackReader;
    private final BufferedSource source;

    /* compiled from: Http2Reader.kt */
    /* loaded from: classes5.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Logger getLogger() {
            return Http2Reader.logger;
        }

        public final int lengthWithoutPadding(int i8, int i9, int i10) throws IOException {
            if ((i9 & 8) != 0) {
                i8--;
            }
            if (i10 <= i8) {
                return i8 - i10;
            }
            throw new IOException("PROTOCOL_ERROR padding " + i10 + " > remaining length " + i8);
        }
    }

    /* compiled from: Http2Reader.kt */
    /* loaded from: classes5.dex */
    public static final class ContinuationSource implements Source {
        private int flags;
        private int left;
        private int length;
        private int padding;
        private final BufferedSource source;
        private int streamId;

        public ContinuationSource(BufferedSource source) {
            Intrinsics.f(source, "source");
            this.source = source;
        }

        private final void readContinuationHeader() throws IOException {
            int i8 = this.streamId;
            int readMedium = Util.readMedium(this.source);
            this.left = readMedium;
            this.length = readMedium;
            int and = Util.and(this.source.readByte(), 255);
            this.flags = Util.and(this.source.readByte(), 255);
            Companion companion = Http2Reader.Companion;
            if (companion.getLogger().isLoggable(Level.FINE)) {
                companion.getLogger().fine(Http2.INSTANCE.frameLog(true, this.streamId, this.length, and, this.flags));
            }
            int readInt = this.source.readInt() & Api.BaseClientBuilder.API_PRIORITY_OTHER;
            this.streamId = readInt;
            if (and == 9) {
                if (readInt == i8) {
                    return;
                }
                throw new IOException("TYPE_CONTINUATION streamId changed");
            }
            throw new IOException(and + " != TYPE_CONTINUATION");
        }

        @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
        }

        public final int getFlags() {
            return this.flags;
        }

        public final int getLeft() {
            return this.left;
        }

        public final int getLength() {
            return this.length;
        }

        public final int getPadding() {
            return this.padding;
        }

        public final int getStreamId() {
            return this.streamId;
        }

        @Override // okio.Source
        public long read(Buffer sink, long j8) throws IOException {
            Intrinsics.f(sink, "sink");
            while (true) {
                int i8 = this.left;
                if (i8 == 0) {
                    this.source.skip(this.padding);
                    this.padding = 0;
                    if ((this.flags & 4) != 0) {
                        return -1L;
                    }
                    readContinuationHeader();
                } else {
                    long read = this.source.read(sink, Math.min(j8, i8));
                    if (read == -1) {
                        return -1L;
                    }
                    this.left -= (int) read;
                    return read;
                }
            }
        }

        public final void setFlags(int i8) {
            this.flags = i8;
        }

        public final void setLeft(int i8) {
            this.left = i8;
        }

        public final void setLength(int i8) {
            this.length = i8;
        }

        public final void setPadding(int i8) {
            this.padding = i8;
        }

        public final void setStreamId(int i8) {
            this.streamId = i8;
        }

        @Override // okio.Source
        public Timeout timeout() {
            return this.source.timeout();
        }
    }

    /* compiled from: Http2Reader.kt */
    /* loaded from: classes5.dex */
    public interface Handler {
        void ackSettings();

        void alternateService(int i8, String str, ByteString byteString, String str2, int i9, long j8);

        void data(boolean z7, int i8, BufferedSource bufferedSource, int i9) throws IOException;

        void goAway(int i8, ErrorCode errorCode, ByteString byteString);

        void headers(boolean z7, int i8, int i9, List<Header> list);

        void ping(boolean z7, int i8, int i9);

        void priority(int i8, int i9, int i10, boolean z7);

        void pushPromise(int i8, int i9, List<Header> list) throws IOException;

        void rstStream(int i8, ErrorCode errorCode);

        void settings(boolean z7, Settings settings);

        void windowUpdate(int i8, long j8);
    }

    static {
        Logger logger2 = Logger.getLogger(Http2.class.getName());
        Intrinsics.e(logger2, "getLogger(Http2::class.java.name)");
        logger = logger2;
    }

    public Http2Reader(BufferedSource source, boolean z7) {
        Intrinsics.f(source, "source");
        this.source = source;
        this.client = z7;
        ContinuationSource continuationSource = new ContinuationSource(source);
        this.continuation = continuationSource;
        this.hpackReader = new Hpack.Reader(continuationSource, 4096, 0, 4, null);
    }

    private final void readData(Handler handler, int i8, int i9, int i10) throws IOException {
        boolean z7;
        if (i10 != 0) {
            int i11 = 0;
            boolean z8 = true;
            if ((i9 & 1) != 0) {
                z7 = true;
            } else {
                z7 = false;
            }
            if ((i9 & 32) == 0) {
                z8 = false;
            }
            if (!z8) {
                if ((i9 & 8) != 0) {
                    i11 = Util.and(this.source.readByte(), 255);
                }
                handler.data(z7, i10, this.source, Companion.lengthWithoutPadding(i8, i9, i11));
                this.source.skip(i11);
                return;
            }
            throw new IOException("PROTOCOL_ERROR: FLAG_COMPRESSED without SETTINGS_COMPRESS_DATA");
        }
        throw new IOException("PROTOCOL_ERROR: TYPE_DATA streamId == 0");
    }

    private final void readGoAway(Handler handler, int i8, int i9, int i10) throws IOException {
        if (i8 >= 8) {
            if (i10 == 0) {
                int readInt = this.source.readInt();
                int readInt2 = this.source.readInt();
                int i11 = i8 - 8;
                ErrorCode fromHttp2 = ErrorCode.Companion.fromHttp2(readInt2);
                if (fromHttp2 != null) {
                    ByteString byteString = ByteString.f52592j;
                    if (i11 > 0) {
                        byteString = this.source.o0(i11);
                    }
                    handler.goAway(readInt, fromHttp2, byteString);
                    return;
                }
                throw new IOException(Intrinsics.n("TYPE_GOAWAY unexpected error code: ", Integer.valueOf(readInt2)));
            }
            throw new IOException("TYPE_GOAWAY streamId != 0");
        }
        throw new IOException(Intrinsics.n("TYPE_GOAWAY length < 8: ", Integer.valueOf(i8)));
    }

    private final List<Header> readHeaderBlock(int i8, int i9, int i10, int i11) throws IOException {
        this.continuation.setLeft(i8);
        ContinuationSource continuationSource = this.continuation;
        continuationSource.setLength(continuationSource.getLeft());
        this.continuation.setPadding(i9);
        this.continuation.setFlags(i10);
        this.continuation.setStreamId(i11);
        this.hpackReader.readHeaders();
        return this.hpackReader.getAndResetHeaderList();
    }

    private final void readHeaders(Handler handler, int i8, int i9, int i10) throws IOException {
        boolean z7;
        if (i10 != 0) {
            int i11 = 0;
            if ((i9 & 1) != 0) {
                z7 = true;
            } else {
                z7 = false;
            }
            if ((i9 & 8) != 0) {
                i11 = Util.and(this.source.readByte(), 255);
            }
            if ((i9 & 32) != 0) {
                readPriority(handler, i10);
                i8 -= 5;
            }
            handler.headers(z7, i10, -1, readHeaderBlock(Companion.lengthWithoutPadding(i8, i9, i11), i11, i9, i10));
            return;
        }
        throw new IOException("PROTOCOL_ERROR: TYPE_HEADERS streamId == 0");
    }

    private final void readPing(Handler handler, int i8, int i9, int i10) throws IOException {
        if (i8 == 8) {
            if (i10 == 0) {
                int readInt = this.source.readInt();
                int readInt2 = this.source.readInt();
                boolean z7 = true;
                if ((i9 & 1) == 0) {
                    z7 = false;
                }
                handler.ping(z7, readInt, readInt2);
                return;
            }
            throw new IOException("TYPE_PING streamId != 0");
        }
        throw new IOException(Intrinsics.n("TYPE_PING length != 8: ", Integer.valueOf(i8)));
    }

    private final void readPriority(Handler handler, int i8, int i9, int i10) throws IOException {
        if (i8 == 5) {
            if (i10 != 0) {
                readPriority(handler, i10);
                return;
            }
            throw new IOException("TYPE_PRIORITY streamId == 0");
        }
        throw new IOException("TYPE_PRIORITY length: " + i8 + " != 5");
    }

    private final void readPushPromise(Handler handler, int i8, int i9, int i10) throws IOException {
        int i11;
        if (i10 != 0) {
            if ((i9 & 8) != 0) {
                i11 = Util.and(this.source.readByte(), 255);
            } else {
                i11 = 0;
            }
            handler.pushPromise(i10, this.source.readInt() & Api.BaseClientBuilder.API_PRIORITY_OTHER, readHeaderBlock(Companion.lengthWithoutPadding(i8 - 4, i9, i11), i11, i9, i10));
            return;
        }
        throw new IOException("PROTOCOL_ERROR: TYPE_PUSH_PROMISE streamId == 0");
    }

    private final void readRstStream(Handler handler, int i8, int i9, int i10) throws IOException {
        if (i8 == 4) {
            if (i10 != 0) {
                int readInt = this.source.readInt();
                ErrorCode fromHttp2 = ErrorCode.Companion.fromHttp2(readInt);
                if (fromHttp2 != null) {
                    handler.rstStream(i10, fromHttp2);
                    return;
                }
                throw new IOException(Intrinsics.n("TYPE_RST_STREAM unexpected error code: ", Integer.valueOf(readInt)));
            }
            throw new IOException("TYPE_RST_STREAM streamId == 0");
        }
        throw new IOException("TYPE_RST_STREAM length: " + i8 + " != 4");
    }

    private final void readSettings(Handler handler, int i8, int i9, int i10) throws IOException {
        IntRange o8;
        IntProgression n8;
        int readInt;
        if (i10 == 0) {
            if ((i9 & 1) != 0) {
                if (i8 == 0) {
                    handler.ackSettings();
                    return;
                }
                throw new IOException("FRAME_SIZE_ERROR ack frame should be empty!");
            } else if (i8 % 6 == 0) {
                Settings settings = new Settings();
                o8 = RangesKt___RangesKt.o(0, i8);
                n8 = RangesKt___RangesKt.n(o8, 6);
                int g8 = n8.g();
                int i11 = n8.i();
                int k8 = n8.k();
                if ((k8 > 0 && g8 <= i11) || (k8 < 0 && i11 <= g8)) {
                    while (true) {
                        int i12 = g8 + k8;
                        int and = Util.and(this.source.readShort(), (int) Settings.DEFAULT_INITIAL_WINDOW_SIZE);
                        readInt = this.source.readInt();
                        if (and != 2) {
                            if (and != 3) {
                                if (and != 4) {
                                    if (and == 5 && (readInt < 16384 || readInt > 16777215)) {
                                        break;
                                    }
                                } else {
                                    and = 7;
                                    if (readInt < 0) {
                                        throw new IOException("PROTOCOL_ERROR SETTINGS_INITIAL_WINDOW_SIZE > 2^31 - 1");
                                    }
                                }
                            } else {
                                and = 4;
                            }
                        } else if (readInt != 0 && readInt != 1) {
                            throw new IOException("PROTOCOL_ERROR SETTINGS_ENABLE_PUSH != 0 or 1");
                        }
                        settings.set(and, readInt);
                        if (g8 == i11) {
                            break;
                        }
                        g8 = i12;
                    }
                    throw new IOException(Intrinsics.n("PROTOCOL_ERROR SETTINGS_MAX_FRAME_SIZE: ", Integer.valueOf(readInt)));
                }
                handler.settings(false, settings);
                return;
            } else {
                throw new IOException(Intrinsics.n("TYPE_SETTINGS length % 6 != 0: ", Integer.valueOf(i8)));
            }
        }
        throw new IOException("TYPE_SETTINGS streamId != 0");
    }

    private final void readWindowUpdate(Handler handler, int i8, int i9, int i10) throws IOException {
        if (i8 == 4) {
            long and = Util.and(this.source.readInt(), 2147483647L);
            if (and != 0) {
                handler.windowUpdate(i10, and);
                return;
            }
            throw new IOException("windowSizeIncrement was 0");
        }
        throw new IOException(Intrinsics.n("TYPE_WINDOW_UPDATE length !=4: ", Integer.valueOf(i8)));
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.source.close();
    }

    public final boolean nextFrame(boolean z7, Handler handler) throws IOException {
        Intrinsics.f(handler, "handler");
        try {
            this.source.j0(9L);
            int readMedium = Util.readMedium(this.source);
            if (readMedium <= 16384) {
                int and = Util.and(this.source.readByte(), 255);
                int and2 = Util.and(this.source.readByte(), 255);
                int readInt = this.source.readInt() & Api.BaseClientBuilder.API_PRIORITY_OTHER;
                Logger logger2 = logger;
                if (logger2.isLoggable(Level.FINE)) {
                    logger2.fine(Http2.INSTANCE.frameLog(true, readInt, readMedium, and, and2));
                }
                if (z7 && and != 4) {
                    throw new IOException(Intrinsics.n("Expected a SETTINGS frame but was ", Http2.INSTANCE.formattedType$okhttp(and)));
                }
                switch (and) {
                    case 0:
                        readData(handler, readMedium, and2, readInt);
                        return true;
                    case 1:
                        readHeaders(handler, readMedium, and2, readInt);
                        return true;
                    case 2:
                        readPriority(handler, readMedium, and2, readInt);
                        return true;
                    case 3:
                        readRstStream(handler, readMedium, and2, readInt);
                        return true;
                    case 4:
                        readSettings(handler, readMedium, and2, readInt);
                        return true;
                    case 5:
                        readPushPromise(handler, readMedium, and2, readInt);
                        return true;
                    case 6:
                        readPing(handler, readMedium, and2, readInt);
                        return true;
                    case 7:
                        readGoAway(handler, readMedium, and2, readInt);
                        return true;
                    case 8:
                        readWindowUpdate(handler, readMedium, and2, readInt);
                        return true;
                    default:
                        this.source.skip(readMedium);
                        return true;
                }
            }
            throw new IOException(Intrinsics.n("FRAME_SIZE_ERROR: ", Integer.valueOf(readMedium)));
        } catch (EOFException unused) {
            return false;
        }
    }

    public final void readConnectionPreface(Handler handler) throws IOException {
        Intrinsics.f(handler, "handler");
        if (this.client) {
            if (!nextFrame(true, handler)) {
                throw new IOException("Required SETTINGS preface not received");
            }
            return;
        }
        BufferedSource bufferedSource = this.source;
        ByteString byteString = Http2.CONNECTION_PREFACE;
        ByteString o02 = bufferedSource.o0(byteString.z());
        Logger logger2 = logger;
        if (logger2.isLoggable(Level.FINE)) {
            logger2.fine(Util.format(Intrinsics.n("<< CONNECTION ", o02.p()), new Object[0]));
        }
        if (Intrinsics.a(byteString, o02)) {
            return;
        }
        throw new IOException(Intrinsics.n("Expected a connection header but was ", o02.D()));
    }

    private final void readPriority(Handler handler, int i8) throws IOException {
        int readInt = this.source.readInt();
        handler.priority(i8, readInt & Api.BaseClientBuilder.API_PRIORITY_OTHER, Util.and(this.source.readByte(), 255) + 1, (Integer.MIN_VALUE & readInt) != 0);
    }
}
