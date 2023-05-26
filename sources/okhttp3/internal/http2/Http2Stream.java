package okhttp3.internal.http2;

import java.io.EOFException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.SocketTimeoutException;
import java.util.ArrayDeque;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Headers;
import okhttp3.internal.Util;
import okio.AsyncTimeout;
import okio.Buffer;
import okio.BufferedSource;
import okio.Sink;
import okio.Source;
import okio.Timeout;

/* compiled from: Http2Stream.kt */
/* loaded from: classes5.dex */
public final class Http2Stream {
    public static final Companion Companion = new Companion(null);
    public static final long EMIT_BUFFER_SIZE = 16384;
    private final Http2Connection connection;
    private ErrorCode errorCode;
    private IOException errorException;
    private boolean hasResponseHeaders;
    private final ArrayDeque<Headers> headersQueue;
    private final int id;
    private long readBytesAcknowledged;
    private long readBytesTotal;
    private final StreamTimeout readTimeout;
    private final FramingSink sink;
    private final FramingSource source;
    private long writeBytesMaximum;
    private long writeBytesTotal;
    private final StreamTimeout writeTimeout;

    /* compiled from: Http2Stream.kt */
    /* loaded from: classes5.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: Http2Stream.kt */
    /* loaded from: classes5.dex */
    public final class FramingSource implements Source {
        private boolean closed;
        private boolean finished;
        private final long maxByteCount;
        private final Buffer readBuffer;
        private final Buffer receiveBuffer;
        final /* synthetic */ Http2Stream this$0;
        private Headers trailers;

        public FramingSource(Http2Stream this$0, long j8, boolean z7) {
            Intrinsics.f(this$0, "this$0");
            this.this$0 = this$0;
            this.maxByteCount = j8;
            this.finished = z7;
            this.receiveBuffer = new Buffer();
            this.readBuffer = new Buffer();
        }

        private final void updateConnectionFlowControl(long j8) {
            Http2Stream http2Stream = this.this$0;
            if (Util.assertionsEnabled && Thread.holdsLock(http2Stream)) {
                throw new AssertionError("Thread " + ((Object) Thread.currentThread().getName()) + " MUST NOT hold lock on " + http2Stream);
            }
            this.this$0.getConnection().updateConnectionFlowControl$okhttp(j8);
        }

        @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            long size;
            Http2Stream http2Stream = this.this$0;
            synchronized (http2Stream) {
                setClosed$okhttp(true);
                size = getReadBuffer().size();
                getReadBuffer().a();
                http2Stream.notifyAll();
                Unit unit = Unit.f50853a;
            }
            if (size > 0) {
                updateConnectionFlowControl(size);
            }
            this.this$0.cancelStreamIfNecessary$okhttp();
        }

        public final boolean getClosed$okhttp() {
            return this.closed;
        }

        public final boolean getFinished$okhttp() {
            return this.finished;
        }

        public final Buffer getReadBuffer() {
            return this.readBuffer;
        }

        public final Buffer getReceiveBuffer() {
            return this.receiveBuffer;
        }

        public final Headers getTrailers() {
            return this.trailers;
        }

        /* JADX WARN: Code restructure failed: missing block: B:43:0x00ce, code lost:
            throw new java.io.IOException("stream closed");
         */
        @Override // okio.Source
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public long read(okio.Buffer r19, long r20) throws java.io.IOException {
            /*
                r18 = this;
                r1 = r18
                r0 = r19
                r2 = r20
                java.lang.String r4 = "sink"
                kotlin.jvm.internal.Intrinsics.f(r0, r4)
                r6 = 0
                int r8 = (r2 > r6 ? 1 : (r2 == r6 ? 0 : -1))
                if (r8 < 0) goto L13
                r8 = 1
                goto L14
            L13:
                r8 = 0
            L14:
                if (r8 == 0) goto Ldb
            L16:
                r8 = 0
                okhttp3.internal.http2.Http2Stream r9 = r1.this$0
                monitor-enter(r9)
                okhttp3.internal.http2.Http2Stream$StreamTimeout r10 = r9.getReadTimeout$okhttp()     // Catch: java.lang.Throwable -> Ld8
                r10.enter()     // Catch: java.lang.Throwable -> Ld8
                okhttp3.internal.http2.ErrorCode r10 = r9.getErrorCode$okhttp()     // Catch: java.lang.Throwable -> Lcf
                if (r10 == 0) goto L39
                java.io.IOException r8 = r9.getErrorException$okhttp()     // Catch: java.lang.Throwable -> Lcf
                if (r8 != 0) goto L39
                okhttp3.internal.http2.StreamResetException r8 = new okhttp3.internal.http2.StreamResetException     // Catch: java.lang.Throwable -> Lcf
                okhttp3.internal.http2.ErrorCode r10 = r9.getErrorCode$okhttp()     // Catch: java.lang.Throwable -> Lcf
                kotlin.jvm.internal.Intrinsics.c(r10)     // Catch: java.lang.Throwable -> Lcf
                r8.<init>(r10)     // Catch: java.lang.Throwable -> Lcf
            L39:
                boolean r10 = r18.getClosed$okhttp()     // Catch: java.lang.Throwable -> Lcf
                if (r10 != 0) goto Lc7
                okio.Buffer r10 = r18.getReadBuffer()     // Catch: java.lang.Throwable -> Lcf
                long r10 = r10.size()     // Catch: java.lang.Throwable -> Lcf
                r12 = -1
                int r14 = (r10 > r6 ? 1 : (r10 == r6 ? 0 : -1))
                if (r14 <= 0) goto L9b
                okio.Buffer r10 = r18.getReadBuffer()     // Catch: java.lang.Throwable -> Lcf
                okio.Buffer r11 = r18.getReadBuffer()     // Catch: java.lang.Throwable -> Lcf
                long r14 = r11.size()     // Catch: java.lang.Throwable -> Lcf
                long r14 = java.lang.Math.min(r2, r14)     // Catch: java.lang.Throwable -> Lcf
                long r10 = r10.read(r0, r14)     // Catch: java.lang.Throwable -> Lcf
                long r14 = r9.getReadBytesTotal()     // Catch: java.lang.Throwable -> Lcf
                long r14 = r14 + r10
                r9.setReadBytesTotal$okhttp(r14)     // Catch: java.lang.Throwable -> Lcf
                long r14 = r9.getReadBytesTotal()     // Catch: java.lang.Throwable -> Lcf
                long r16 = r9.getReadBytesAcknowledged()     // Catch: java.lang.Throwable -> Lcf
                long r14 = r14 - r16
                if (r8 != 0) goto Laa
                okhttp3.internal.http2.Http2Connection r16 = r9.getConnection()     // Catch: java.lang.Throwable -> Lcf
                okhttp3.internal.http2.Settings r16 = r16.getOkHttpSettings()     // Catch: java.lang.Throwable -> Lcf
                int r16 = r16.getInitialWindowSize()     // Catch: java.lang.Throwable -> Lcf
                int r4 = r16 / 2
                long r5 = (long) r4     // Catch: java.lang.Throwable -> Lcf
                int r4 = (r14 > r5 ? 1 : (r14 == r5 ? 0 : -1))
                if (r4 < 0) goto Laa
                okhttp3.internal.http2.Http2Connection r4 = r9.getConnection()     // Catch: java.lang.Throwable -> Lcf
                int r5 = r9.getId()     // Catch: java.lang.Throwable -> Lcf
                r4.writeWindowUpdateLater$okhttp(r5, r14)     // Catch: java.lang.Throwable -> Lcf
                long r4 = r9.getReadBytesTotal()     // Catch: java.lang.Throwable -> Lcf
                r9.setReadBytesAcknowledged$okhttp(r4)     // Catch: java.lang.Throwable -> Lcf
                goto Laa
            L9b:
                boolean r4 = r18.getFinished$okhttp()     // Catch: java.lang.Throwable -> Lcf
                if (r4 != 0) goto La9
                if (r8 != 0) goto La9
                r9.waitForIo$okhttp()     // Catch: java.lang.Throwable -> Lcf
                r10 = r12
                r4 = 1
                goto Lab
            La9:
                r10 = r12
            Laa:
                r4 = 0
            Lab:
                okhttp3.internal.http2.Http2Stream$StreamTimeout r5 = r9.getReadTimeout$okhttp()     // Catch: java.lang.Throwable -> Ld8
                r5.exitAndThrowIfTimedOut()     // Catch: java.lang.Throwable -> Ld8
                kotlin.Unit r5 = kotlin.Unit.f50853a     // Catch: java.lang.Throwable -> Ld8
                monitor-exit(r9)
                if (r4 == 0) goto Lbb
                r6 = 0
                goto L16
            Lbb:
                int r0 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
                if (r0 == 0) goto Lc3
                r1.updateConnectionFlowControl(r10)
                return r10
            Lc3:
                if (r8 != 0) goto Lc6
                return r12
            Lc6:
                throw r8
            Lc7:
                java.io.IOException r0 = new java.io.IOException     // Catch: java.lang.Throwable -> Lcf
                java.lang.String r2 = "stream closed"
                r0.<init>(r2)     // Catch: java.lang.Throwable -> Lcf
                throw r0     // Catch: java.lang.Throwable -> Lcf
            Lcf:
                r0 = move-exception
                okhttp3.internal.http2.Http2Stream$StreamTimeout r2 = r9.getReadTimeout$okhttp()     // Catch: java.lang.Throwable -> Ld8
                r2.exitAndThrowIfTimedOut()     // Catch: java.lang.Throwable -> Ld8
                throw r0     // Catch: java.lang.Throwable -> Ld8
            Ld8:
                r0 = move-exception
                monitor-exit(r9)
                throw r0
            Ldb:
                java.lang.String r0 = "byteCount < 0: "
                java.lang.Long r2 = java.lang.Long.valueOf(r20)
                java.lang.String r0 = kotlin.jvm.internal.Intrinsics.n(r0, r2)
                java.lang.IllegalArgumentException r2 = new java.lang.IllegalArgumentException
                java.lang.String r0 = r0.toString()
                r2.<init>(r0)
                throw r2
            */
            throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.http2.Http2Stream.FramingSource.read(okio.Buffer, long):long");
        }

        public final void receive$okhttp(BufferedSource source, long j8) throws IOException {
            boolean finished$okhttp;
            boolean z7;
            boolean z8;
            long j9;
            Intrinsics.f(source, "source");
            Http2Stream http2Stream = this.this$0;
            if (Util.assertionsEnabled && Thread.holdsLock(http2Stream)) {
                throw new AssertionError("Thread " + ((Object) Thread.currentThread().getName()) + " MUST NOT hold lock on " + http2Stream);
            }
            while (j8 > 0) {
                synchronized (this.this$0) {
                    finished$okhttp = getFinished$okhttp();
                    z7 = true;
                    if (getReadBuffer().size() + j8 > this.maxByteCount) {
                        z8 = true;
                    } else {
                        z8 = false;
                    }
                    Unit unit = Unit.f50853a;
                }
                if (z8) {
                    source.skip(j8);
                    this.this$0.closeLater(ErrorCode.FLOW_CONTROL_ERROR);
                    return;
                } else if (finished$okhttp) {
                    source.skip(j8);
                    return;
                } else {
                    long read = source.read(this.receiveBuffer, j8);
                    if (read != -1) {
                        j8 -= read;
                        Http2Stream http2Stream2 = this.this$0;
                        synchronized (http2Stream2) {
                            if (getClosed$okhttp()) {
                                j9 = getReceiveBuffer().size();
                                getReceiveBuffer().a();
                            } else {
                                if (getReadBuffer().size() != 0) {
                                    z7 = false;
                                }
                                getReadBuffer().V(getReceiveBuffer());
                                if (z7) {
                                    http2Stream2.notifyAll();
                                }
                                j9 = 0;
                            }
                        }
                        if (j9 > 0) {
                            updateConnectionFlowControl(j9);
                        }
                    } else {
                        throw new EOFException();
                    }
                }
            }
        }

        public final void setClosed$okhttp(boolean z7) {
            this.closed = z7;
        }

        public final void setFinished$okhttp(boolean z7) {
            this.finished = z7;
        }

        public final void setTrailers(Headers headers) {
            this.trailers = headers;
        }

        @Override // okio.Source
        public Timeout timeout() {
            return this.this$0.getReadTimeout$okhttp();
        }
    }

    /* compiled from: Http2Stream.kt */
    /* loaded from: classes5.dex */
    public final class StreamTimeout extends AsyncTimeout {
        final /* synthetic */ Http2Stream this$0;

        public StreamTimeout(Http2Stream this$0) {
            Intrinsics.f(this$0, "this$0");
            this.this$0 = this$0;
        }

        public final void exitAndThrowIfTimedOut() throws IOException {
            if (!exit()) {
                return;
            }
            throw newTimeoutException(null);
        }

        @Override // okio.AsyncTimeout
        protected IOException newTimeoutException(IOException iOException) {
            SocketTimeoutException socketTimeoutException = new SocketTimeoutException("timeout");
            if (iOException != null) {
                socketTimeoutException.initCause(iOException);
            }
            return socketTimeoutException;
        }

        @Override // okio.AsyncTimeout
        protected void timedOut() {
            this.this$0.closeLater(ErrorCode.CANCEL);
            this.this$0.getConnection().sendDegradedPingLater$okhttp();
        }
    }

    public Http2Stream(int i8, Http2Connection connection, boolean z7, boolean z8, Headers headers) {
        Intrinsics.f(connection, "connection");
        this.id = i8;
        this.connection = connection;
        this.writeBytesMaximum = connection.getPeerSettings().getInitialWindowSize();
        ArrayDeque<Headers> arrayDeque = new ArrayDeque<>();
        this.headersQueue = arrayDeque;
        this.source = new FramingSource(this, connection.getOkHttpSettings().getInitialWindowSize(), z8);
        this.sink = new FramingSink(this, z7);
        this.readTimeout = new StreamTimeout(this);
        this.writeTimeout = new StreamTimeout(this);
        if (headers != null) {
            if (!isLocallyInitiated()) {
                arrayDeque.add(headers);
                return;
            }
            throw new IllegalStateException("locally-initiated streams shouldn't have headers yet".toString());
        } else if (isLocallyInitiated()) {
        } else {
            throw new IllegalStateException("remotely-initiated streams should have headers".toString());
        }
    }

    private final boolean closeInternal(ErrorCode errorCode, IOException iOException) {
        if (Util.assertionsEnabled && Thread.holdsLock(this)) {
            throw new AssertionError("Thread " + ((Object) Thread.currentThread().getName()) + " MUST NOT hold lock on " + this);
        }
        synchronized (this) {
            if (getErrorCode$okhttp() != null) {
                return false;
            }
            if (getSource$okhttp().getFinished$okhttp() && getSink$okhttp().getFinished()) {
                return false;
            }
            setErrorCode$okhttp(errorCode);
            setErrorException$okhttp(iOException);
            notifyAll();
            Unit unit = Unit.f50853a;
            this.connection.removeStream$okhttp(this.id);
            return true;
        }
    }

    public final void addBytesToWriteWindow(long j8) {
        this.writeBytesMaximum += j8;
        if (j8 > 0) {
            notifyAll();
        }
    }

    public final void cancelStreamIfNecessary$okhttp() throws IOException {
        boolean z7;
        boolean isOpen;
        if (Util.assertionsEnabled && Thread.holdsLock(this)) {
            throw new AssertionError("Thread " + ((Object) Thread.currentThread().getName()) + " MUST NOT hold lock on " + this);
        }
        synchronized (this) {
            if (!getSource$okhttp().getFinished$okhttp() && getSource$okhttp().getClosed$okhttp() && (getSink$okhttp().getFinished() || getSink$okhttp().getClosed())) {
                z7 = true;
            } else {
                z7 = false;
            }
            isOpen = isOpen();
            Unit unit = Unit.f50853a;
        }
        if (z7) {
            close(ErrorCode.CANCEL, null);
        } else if (!isOpen) {
            this.connection.removeStream$okhttp(this.id);
        }
    }

    public final void checkOutNotClosed$okhttp() throws IOException {
        if (!this.sink.getClosed()) {
            if (!this.sink.getFinished()) {
                if (this.errorCode != null) {
                    IOException iOException = this.errorException;
                    if (iOException == null) {
                        ErrorCode errorCode = this.errorCode;
                        Intrinsics.c(errorCode);
                        throw new StreamResetException(errorCode);
                    }
                    throw iOException;
                }
                return;
            }
            throw new IOException("stream finished");
        }
        throw new IOException("stream closed");
    }

    public final void close(ErrorCode rstStatusCode, IOException iOException) throws IOException {
        Intrinsics.f(rstStatusCode, "rstStatusCode");
        if (!closeInternal(rstStatusCode, iOException)) {
            return;
        }
        this.connection.writeSynReset$okhttp(this.id, rstStatusCode);
    }

    public final void closeLater(ErrorCode errorCode) {
        Intrinsics.f(errorCode, "errorCode");
        if (!closeInternal(errorCode, null)) {
            return;
        }
        this.connection.writeSynResetLater$okhttp(this.id, errorCode);
    }

    public final void enqueueTrailers(Headers trailers) {
        Intrinsics.f(trailers, "trailers");
        synchronized (this) {
            boolean z7 = true;
            if (!getSink$okhttp().getFinished()) {
                if (trailers.size() == 0) {
                    z7 = false;
                }
                if (z7) {
                    getSink$okhttp().setTrailers(trailers);
                    Unit unit = Unit.f50853a;
                } else {
                    throw new IllegalArgumentException("trailers.size() == 0".toString());
                }
            } else {
                throw new IllegalStateException("already finished".toString());
            }
        }
    }

    public final Http2Connection getConnection() {
        return this.connection;
    }

    public final synchronized ErrorCode getErrorCode$okhttp() {
        return this.errorCode;
    }

    public final IOException getErrorException$okhttp() {
        return this.errorException;
    }

    public final int getId() {
        return this.id;
    }

    public final long getReadBytesAcknowledged() {
        return this.readBytesAcknowledged;
    }

    public final long getReadBytesTotal() {
        return this.readBytesTotal;
    }

    public final StreamTimeout getReadTimeout$okhttp() {
        return this.readTimeout;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0011 A[Catch: all -> 0x0023, TRY_LEAVE, TryCatch #0 {, blocks: (B:3:0x0001, B:5:0x0005, B:11:0x0011, B:15:0x0017, B:16:0x0022), top: B:20:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0017 A[Catch: all -> 0x0023, TRY_ENTER, TryCatch #0 {, blocks: (B:3:0x0001, B:5:0x0005, B:11:0x0011, B:15:0x0017, B:16:0x0022), top: B:20:0x0001 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final okio.Sink getSink() {
        /*
            r2 = this;
            monitor-enter(r2)
            boolean r0 = r2.hasResponseHeaders     // Catch: java.lang.Throwable -> L23
            if (r0 != 0) goto Le
            boolean r0 = r2.isLocallyInitiated()     // Catch: java.lang.Throwable -> L23
            if (r0 == 0) goto Lc
            goto Le
        Lc:
            r0 = 0
            goto Lf
        Le:
            r0 = 1
        Lf:
            if (r0 == 0) goto L17
            kotlin.Unit r0 = kotlin.Unit.f50853a     // Catch: java.lang.Throwable -> L23
            monitor-exit(r2)
            okhttp3.internal.http2.Http2Stream$FramingSink r0 = r2.sink
            return r0
        L17:
            java.lang.String r0 = "reply before requesting the sink"
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException     // Catch: java.lang.Throwable -> L23
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Throwable -> L23
            r1.<init>(r0)     // Catch: java.lang.Throwable -> L23
            throw r1     // Catch: java.lang.Throwable -> L23
        L23:
            r0 = move-exception
            monitor-exit(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.http2.Http2Stream.getSink():okio.Sink");
    }

    public final FramingSink getSink$okhttp() {
        return this.sink;
    }

    public final Source getSource() {
        return this.source;
    }

    public final FramingSource getSource$okhttp() {
        return this.source;
    }

    public final long getWriteBytesMaximum() {
        return this.writeBytesMaximum;
    }

    public final long getWriteBytesTotal() {
        return this.writeBytesTotal;
    }

    public final StreamTimeout getWriteTimeout$okhttp() {
        return this.writeTimeout;
    }

    public final boolean isLocallyInitiated() {
        boolean z7;
        if ((this.id & 1) == 1) {
            z7 = true;
        } else {
            z7 = false;
        }
        if (this.connection.getClient$okhttp() == z7) {
            return true;
        }
        return false;
    }

    public final synchronized boolean isOpen() {
        if (this.errorCode != null) {
            return false;
        }
        if ((this.source.getFinished$okhttp() || this.source.getClosed$okhttp()) && (this.sink.getFinished() || this.sink.getClosed())) {
            if (this.hasResponseHeaders) {
                return false;
            }
        }
        return true;
    }

    public final Timeout readTimeout() {
        return this.readTimeout;
    }

    public final void receiveData(BufferedSource source, int i8) throws IOException {
        Intrinsics.f(source, "source");
        if (Util.assertionsEnabled && Thread.holdsLock(this)) {
            throw new AssertionError("Thread " + ((Object) Thread.currentThread().getName()) + " MUST NOT hold lock on " + this);
        }
        this.source.receive$okhttp(source, i8);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0051 A[Catch: all -> 0x006c, TryCatch #0 {, blocks: (B:10:0x0038, B:14:0x0040, B:17:0x0051, B:18:0x0058, B:15:0x0048), top: B:26:0x0038 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void receiveHeaders(okhttp3.Headers r3, boolean r4) {
        /*
            r2 = this;
            java.lang.String r0 = "headers"
            kotlin.jvm.internal.Intrinsics.f(r3, r0)
            boolean r0 = okhttp3.internal.Util.assertionsEnabled
            if (r0 == 0) goto L37
            boolean r0 = java.lang.Thread.holdsLock(r2)
            if (r0 != 0) goto L10
            goto L37
        L10:
            java.lang.AssertionError r3 = new java.lang.AssertionError
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r0 = "Thread "
            r4.append(r0)
            java.lang.Thread r0 = java.lang.Thread.currentThread()
            java.lang.String r0 = r0.getName()
            r4.append(r0)
            java.lang.String r0 = " MUST NOT hold lock on "
            r4.append(r0)
            r4.append(r2)
            java.lang.String r4 = r4.toString()
            r3.<init>(r4)
            throw r3
        L37:
            monitor-enter(r2)
            boolean r0 = r2.hasResponseHeaders     // Catch: java.lang.Throwable -> L6c
            r1 = 1
            if (r0 == 0) goto L48
            if (r4 != 0) goto L40
            goto L48
        L40:
            okhttp3.internal.http2.Http2Stream$FramingSource r0 = r2.getSource$okhttp()     // Catch: java.lang.Throwable -> L6c
            r0.setTrailers(r3)     // Catch: java.lang.Throwable -> L6c
            goto L4f
        L48:
            r2.hasResponseHeaders = r1     // Catch: java.lang.Throwable -> L6c
            java.util.ArrayDeque<okhttp3.Headers> r0 = r2.headersQueue     // Catch: java.lang.Throwable -> L6c
            r0.add(r3)     // Catch: java.lang.Throwable -> L6c
        L4f:
            if (r4 == 0) goto L58
            okhttp3.internal.http2.Http2Stream$FramingSource r3 = r2.getSource$okhttp()     // Catch: java.lang.Throwable -> L6c
            r3.setFinished$okhttp(r1)     // Catch: java.lang.Throwable -> L6c
        L58:
            boolean r3 = r2.isOpen()     // Catch: java.lang.Throwable -> L6c
            r2.notifyAll()     // Catch: java.lang.Throwable -> L6c
            kotlin.Unit r4 = kotlin.Unit.f50853a     // Catch: java.lang.Throwable -> L6c
            monitor-exit(r2)
            if (r3 != 0) goto L6b
            okhttp3.internal.http2.Http2Connection r3 = r2.connection
            int r4 = r2.id
            r3.removeStream$okhttp(r4)
        L6b:
            return
        L6c:
            r3 = move-exception
            monitor-exit(r2)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.http2.Http2Stream.receiveHeaders(okhttp3.Headers, boolean):void");
    }

    public final synchronized void receiveRstStream(ErrorCode errorCode) {
        Intrinsics.f(errorCode, "errorCode");
        if (this.errorCode == null) {
            this.errorCode = errorCode;
            notifyAll();
        }
    }

    public final void setErrorCode$okhttp(ErrorCode errorCode) {
        this.errorCode = errorCode;
    }

    public final void setErrorException$okhttp(IOException iOException) {
        this.errorException = iOException;
    }

    public final void setReadBytesAcknowledged$okhttp(long j8) {
        this.readBytesAcknowledged = j8;
    }

    public final void setReadBytesTotal$okhttp(long j8) {
        this.readBytesTotal = j8;
    }

    public final void setWriteBytesMaximum$okhttp(long j8) {
        this.writeBytesMaximum = j8;
    }

    public final void setWriteBytesTotal$okhttp(long j8) {
        this.writeBytesTotal = j8;
    }

    public final synchronized Headers takeHeaders() throws IOException {
        Headers removeFirst;
        this.readTimeout.enter();
        while (this.headersQueue.isEmpty() && this.errorCode == null) {
            waitForIo$okhttp();
        }
        this.readTimeout.exitAndThrowIfTimedOut();
        if (!this.headersQueue.isEmpty()) {
            removeFirst = this.headersQueue.removeFirst();
            Intrinsics.e(removeFirst, "headersQueue.removeFirst()");
        } else {
            IOException iOException = this.errorException;
            if (iOException == null) {
                ErrorCode errorCode = this.errorCode;
                Intrinsics.c(errorCode);
                throw new StreamResetException(errorCode);
            }
            throw iOException;
        }
        return removeFirst;
    }

    public final synchronized Headers trailers() throws IOException {
        Headers trailers;
        if (this.source.getFinished$okhttp() && this.source.getReceiveBuffer().y0() && this.source.getReadBuffer().y0()) {
            trailers = this.source.getTrailers();
            if (trailers == null) {
                trailers = Util.EMPTY_HEADERS;
            }
        } else if (this.errorCode != null) {
            IOException iOException = this.errorException;
            if (iOException == null) {
                ErrorCode errorCode = this.errorCode;
                Intrinsics.c(errorCode);
                throw new StreamResetException(errorCode);
            }
            throw iOException;
        } else {
            throw new IllegalStateException("too early; can't read the trailers yet");
        }
        return trailers;
    }

    public final void waitForIo$okhttp() throws InterruptedIOException {
        try {
            wait();
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
            throw new InterruptedIOException();
        }
    }

    public final void writeHeaders(List<Header> responseHeaders, boolean z7, boolean z8) throws IOException {
        boolean z9;
        Intrinsics.f(responseHeaders, "responseHeaders");
        if (Util.assertionsEnabled && Thread.holdsLock(this)) {
            throw new AssertionError("Thread " + ((Object) Thread.currentThread().getName()) + " MUST NOT hold lock on " + this);
        }
        synchronized (this) {
            z9 = true;
            this.hasResponseHeaders = true;
            if (z7) {
                getSink$okhttp().setFinished(true);
            }
            Unit unit = Unit.f50853a;
        }
        if (!z8) {
            synchronized (this.connection) {
                if (getConnection().getWriteBytesTotal() < getConnection().getWriteBytesMaximum()) {
                    z9 = false;
                }
            }
            z8 = z9;
        }
        this.connection.writeHeaders$okhttp(this.id, z7, responseHeaders);
        if (z8) {
            this.connection.flush();
        }
    }

    public final Timeout writeTimeout() {
        return this.writeTimeout;
    }

    /* compiled from: Http2Stream.kt */
    /* loaded from: classes5.dex */
    public final class FramingSink implements Sink {
        private boolean closed;
        private boolean finished;
        private final Buffer sendBuffer;
        private Headers trailers;

        public FramingSink(Http2Stream this$0, boolean z7) {
            Intrinsics.f(this$0, "this$0");
            Http2Stream.this = this$0;
            this.finished = z7;
            this.sendBuffer = new Buffer();
        }

        private final void emitFrame(boolean z7) throws IOException {
            long min;
            boolean z8;
            Http2Stream http2Stream = Http2Stream.this;
            synchronized (http2Stream) {
                http2Stream.getWriteTimeout$okhttp().enter();
                while (http2Stream.getWriteBytesTotal() >= http2Stream.getWriteBytesMaximum() && !getFinished() && !getClosed() && http2Stream.getErrorCode$okhttp() == null) {
                    http2Stream.waitForIo$okhttp();
                }
                http2Stream.getWriteTimeout$okhttp().exitAndThrowIfTimedOut();
                http2Stream.checkOutNotClosed$okhttp();
                min = Math.min(http2Stream.getWriteBytesMaximum() - http2Stream.getWriteBytesTotal(), this.sendBuffer.size());
                http2Stream.setWriteBytesTotal$okhttp(http2Stream.getWriteBytesTotal() + min);
                if (z7 && min == this.sendBuffer.size()) {
                    z8 = true;
                } else {
                    z8 = false;
                }
                Unit unit = Unit.f50853a;
            }
            Http2Stream.this.getWriteTimeout$okhttp().enter();
            try {
                Http2Stream.this.getConnection().writeData(Http2Stream.this.getId(), z8, this.sendBuffer, min);
            } finally {
                Http2Stream.this.getWriteTimeout$okhttp().exitAndThrowIfTimedOut();
            }
        }

        @Override // okio.Sink, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            boolean z7;
            boolean z8;
            boolean z9;
            Http2Stream http2Stream = Http2Stream.this;
            if (Util.assertionsEnabled && Thread.holdsLock(http2Stream)) {
                throw new AssertionError("Thread " + ((Object) Thread.currentThread().getName()) + " MUST NOT hold lock on " + http2Stream);
            }
            Http2Stream http2Stream2 = Http2Stream.this;
            synchronized (http2Stream2) {
                if (getClosed()) {
                    return;
                }
                if (http2Stream2.getErrorCode$okhttp() == null) {
                    z7 = true;
                } else {
                    z7 = false;
                }
                Unit unit = Unit.f50853a;
                if (!Http2Stream.this.getSink$okhttp().finished) {
                    if (this.sendBuffer.size() > 0) {
                        z8 = true;
                    } else {
                        z8 = false;
                    }
                    if (this.trailers != null) {
                        z9 = true;
                    } else {
                        z9 = false;
                    }
                    if (z9) {
                        while (this.sendBuffer.size() > 0) {
                            emitFrame(false);
                        }
                        Http2Connection connection = Http2Stream.this.getConnection();
                        int id = Http2Stream.this.getId();
                        Headers headers = this.trailers;
                        Intrinsics.c(headers);
                        connection.writeHeaders$okhttp(id, z7, Util.toHeaderList(headers));
                    } else if (z8) {
                        while (this.sendBuffer.size() > 0) {
                            emitFrame(true);
                        }
                    } else if (z7) {
                        Http2Stream.this.getConnection().writeData(Http2Stream.this.getId(), true, null, 0L);
                    }
                }
                synchronized (Http2Stream.this) {
                    setClosed(true);
                    Unit unit2 = Unit.f50853a;
                }
                Http2Stream.this.getConnection().flush();
                Http2Stream.this.cancelStreamIfNecessary$okhttp();
            }
        }

        @Override // okio.Sink, java.io.Flushable
        public void flush() throws IOException {
            Http2Stream http2Stream = Http2Stream.this;
            if (Util.assertionsEnabled && Thread.holdsLock(http2Stream)) {
                throw new AssertionError("Thread " + ((Object) Thread.currentThread().getName()) + " MUST NOT hold lock on " + http2Stream);
            }
            Http2Stream http2Stream2 = Http2Stream.this;
            synchronized (http2Stream2) {
                http2Stream2.checkOutNotClosed$okhttp();
                Unit unit = Unit.f50853a;
            }
            while (this.sendBuffer.size() > 0) {
                emitFrame(false);
                Http2Stream.this.getConnection().flush();
            }
        }

        public final boolean getClosed() {
            return this.closed;
        }

        public final boolean getFinished() {
            return this.finished;
        }

        public final Headers getTrailers() {
            return this.trailers;
        }

        public final void setClosed(boolean z7) {
            this.closed = z7;
        }

        public final void setFinished(boolean z7) {
            this.finished = z7;
        }

        public final void setTrailers(Headers headers) {
            this.trailers = headers;
        }

        @Override // okio.Sink
        public Timeout timeout() {
            return Http2Stream.this.getWriteTimeout$okhttp();
        }

        @Override // okio.Sink
        public void write(Buffer source, long j8) throws IOException {
            Intrinsics.f(source, "source");
            Http2Stream http2Stream = Http2Stream.this;
            if (Util.assertionsEnabled && Thread.holdsLock(http2Stream)) {
                throw new AssertionError("Thread " + ((Object) Thread.currentThread().getName()) + " MUST NOT hold lock on " + http2Stream);
            }
            this.sendBuffer.write(source, j8);
            while (this.sendBuffer.size() >= Http2Stream.EMIT_BUFFER_SIZE) {
                emitFrame(false);
            }
        }

        public /* synthetic */ FramingSink(boolean z7, int i8, DefaultConstructorMarker defaultConstructorMarker) {
            this(Http2Stream.this, (i8 & 1) != 0 ? false : z7);
        }
    }
}
