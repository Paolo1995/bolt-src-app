package okio;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AsyncTimeout.kt */
/* loaded from: classes5.dex */
public class AsyncTimeout extends Timeout {
    public static final Companion Companion = new Companion(null);
    private static final long IDLE_TIMEOUT_MILLIS;
    private static final long IDLE_TIMEOUT_NANOS;
    private static final int TIMEOUT_WRITE_SIZE = 65536;
    private static AsyncTimeout head;
    private boolean inQueue;
    private AsyncTimeout next;
    private long timeoutAt;

    /* compiled from: AsyncTimeout.kt */
    /* loaded from: classes5.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean d(AsyncTimeout asyncTimeout) {
            synchronized (AsyncTimeout.class) {
                if (asyncTimeout.inQueue) {
                    asyncTimeout.inQueue = false;
                    for (AsyncTimeout asyncTimeout2 = AsyncTimeout.head; asyncTimeout2 != null; asyncTimeout2 = asyncTimeout2.next) {
                        if (asyncTimeout2.next == asyncTimeout) {
                            asyncTimeout2.next = asyncTimeout.next;
                            asyncTimeout.next = null;
                            return false;
                        }
                    }
                    return true;
                }
                return false;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void e(AsyncTimeout asyncTimeout, long j8, boolean z7) {
            synchronized (AsyncTimeout.class) {
                if (!asyncTimeout.inQueue) {
                    asyncTimeout.inQueue = true;
                    if (AsyncTimeout.head == null) {
                        AsyncTimeout.head = new AsyncTimeout();
                        new Watchdog().start();
                    }
                    long nanoTime = System.nanoTime();
                    int i8 = (j8 > 0L ? 1 : (j8 == 0L ? 0 : -1));
                    if (i8 != 0 && z7) {
                        asyncTimeout.timeoutAt = Math.min(j8, asyncTimeout.deadlineNanoTime() - nanoTime) + nanoTime;
                    } else if (i8 != 0) {
                        asyncTimeout.timeoutAt = j8 + nanoTime;
                    } else if (z7) {
                        asyncTimeout.timeoutAt = asyncTimeout.deadlineNanoTime();
                    } else {
                        throw new AssertionError();
                    }
                    long remainingNanos = asyncTimeout.remainingNanos(nanoTime);
                    AsyncTimeout asyncTimeout2 = AsyncTimeout.head;
                    Intrinsics.c(asyncTimeout2);
                    while (asyncTimeout2.next != null) {
                        AsyncTimeout asyncTimeout3 = asyncTimeout2.next;
                        Intrinsics.c(asyncTimeout3);
                        if (remainingNanos < asyncTimeout3.remainingNanos(nanoTime)) {
                            break;
                        }
                        asyncTimeout2 = asyncTimeout2.next;
                        Intrinsics.c(asyncTimeout2);
                    }
                    asyncTimeout.next = asyncTimeout2.next;
                    asyncTimeout2.next = asyncTimeout;
                    if (asyncTimeout2 == AsyncTimeout.head) {
                        AsyncTimeout.class.notify();
                    }
                    Unit unit = Unit.f50853a;
                } else {
                    throw new IllegalStateException("Unbalanced enter/exit".toString());
                }
            }
        }

        public final AsyncTimeout c() throws InterruptedException {
            AsyncTimeout asyncTimeout = AsyncTimeout.head;
            Intrinsics.c(asyncTimeout);
            AsyncTimeout asyncTimeout2 = asyncTimeout.next;
            if (asyncTimeout2 != null) {
                long remainingNanos = asyncTimeout2.remainingNanos(System.nanoTime());
                if (remainingNanos <= 0) {
                    AsyncTimeout asyncTimeout3 = AsyncTimeout.head;
                    Intrinsics.c(asyncTimeout3);
                    asyncTimeout3.next = asyncTimeout2.next;
                    asyncTimeout2.next = null;
                    return asyncTimeout2;
                }
                long j8 = remainingNanos / 1000000;
                AsyncTimeout.class.wait(j8, (int) (remainingNanos - (1000000 * j8)));
                return null;
            }
            long nanoTime = System.nanoTime();
            AsyncTimeout.class.wait(AsyncTimeout.IDLE_TIMEOUT_MILLIS);
            AsyncTimeout asyncTimeout4 = AsyncTimeout.head;
            Intrinsics.c(asyncTimeout4);
            if (asyncTimeout4.next == null && System.nanoTime() - nanoTime >= AsyncTimeout.IDLE_TIMEOUT_NANOS) {
                return AsyncTimeout.head;
            }
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: AsyncTimeout.kt */
    /* loaded from: classes5.dex */
    public static final class Watchdog extends Thread {
        public Watchdog() {
            super("Okio Watchdog");
            setDaemon(true);
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            AsyncTimeout c8;
            while (true) {
                try {
                    synchronized (AsyncTimeout.class) {
                        c8 = AsyncTimeout.Companion.c();
                        if (c8 == AsyncTimeout.head) {
                            AsyncTimeout.head = null;
                            return;
                        }
                        Unit unit = Unit.f50853a;
                    }
                    if (c8 != null) {
                        c8.timedOut();
                    }
                } catch (InterruptedException unused) {
                }
            }
        }
    }

    static {
        long millis = TimeUnit.SECONDS.toMillis(60L);
        IDLE_TIMEOUT_MILLIS = millis;
        IDLE_TIMEOUT_NANOS = TimeUnit.MILLISECONDS.toNanos(millis);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final long remainingNanos(long j8) {
        return this.timeoutAt - j8;
    }

    public final IOException access$newTimeoutException(IOException iOException) {
        return newTimeoutException(iOException);
    }

    public final void enter() {
        long timeoutNanos = timeoutNanos();
        boolean hasDeadline = hasDeadline();
        if (timeoutNanos != 0 || hasDeadline) {
            Companion.e(this, timeoutNanos, hasDeadline);
        }
    }

    public final boolean exit() {
        return Companion.d(this);
    }

    protected IOException newTimeoutException(IOException iOException) {
        InterruptedIOException interruptedIOException = new InterruptedIOException("timeout");
        if (iOException != null) {
            interruptedIOException.initCause(iOException);
        }
        return interruptedIOException;
    }

    public final Sink sink(final Sink sink) {
        Intrinsics.f(sink, "sink");
        return new Sink() { // from class: okio.AsyncTimeout$sink$1
            @Override // okio.Sink
            /* renamed from: a */
            public AsyncTimeout timeout() {
                return AsyncTimeout.this;
            }

            @Override // okio.Sink, java.io.Closeable, java.lang.AutoCloseable
            public void close() {
                AsyncTimeout asyncTimeout = AsyncTimeout.this;
                Sink sink2 = sink;
                asyncTimeout.enter();
                try {
                    sink2.close();
                    Unit unit = Unit.f50853a;
                    if (!asyncTimeout.exit()) {
                        return;
                    }
                    throw asyncTimeout.access$newTimeoutException(null);
                } catch (IOException e8) {
                    if (!asyncTimeout.exit()) {
                        throw e8;
                    }
                    throw asyncTimeout.access$newTimeoutException(e8);
                } finally {
                    asyncTimeout.exit();
                }
            }

            @Override // okio.Sink, java.io.Flushable
            public void flush() {
                AsyncTimeout asyncTimeout = AsyncTimeout.this;
                Sink sink2 = sink;
                asyncTimeout.enter();
                try {
                    sink2.flush();
                    Unit unit = Unit.f50853a;
                    if (!asyncTimeout.exit()) {
                        return;
                    }
                    throw asyncTimeout.access$newTimeoutException(null);
                } catch (IOException e8) {
                    if (!asyncTimeout.exit()) {
                        throw e8;
                    }
                    throw asyncTimeout.access$newTimeoutException(e8);
                } finally {
                    asyncTimeout.exit();
                }
            }

            public String toString() {
                return "AsyncTimeout.sink(" + sink + ')';
            }

            @Override // okio.Sink
            public void write(Buffer source, long j8) {
                Intrinsics.f(source, "source");
                _UtilKt.b(source.size(), 0L, j8);
                while (true) {
                    long j9 = 0;
                    if (j8 > 0) {
                        Segment segment = source.f52580f;
                        Intrinsics.c(segment);
                        while (true) {
                            if (j9 >= 65536) {
                                break;
                            }
                            j9 += segment.f52633c - segment.f52632b;
                            if (j9 >= j8) {
                                j9 = j8;
                                break;
                            } else {
                                segment = segment.f52636f;
                                Intrinsics.c(segment);
                            }
                        }
                        AsyncTimeout asyncTimeout = AsyncTimeout.this;
                        Sink sink2 = sink;
                        asyncTimeout.enter();
                        try {
                            sink2.write(source, j9);
                            Unit unit = Unit.f50853a;
                            if (!asyncTimeout.exit()) {
                                j8 -= j9;
                            } else {
                                throw asyncTimeout.access$newTimeoutException(null);
                            }
                        } catch (IOException e8) {
                            if (!asyncTimeout.exit()) {
                                throw e8;
                            }
                            throw asyncTimeout.access$newTimeoutException(e8);
                        } finally {
                            asyncTimeout.exit();
                        }
                    } else {
                        return;
                    }
                }
            }
        };
    }

    public final Source source(final Source source) {
        Intrinsics.f(source, "source");
        return new Source() { // from class: okio.AsyncTimeout$source$1
            @Override // okio.Source
            /* renamed from: a */
            public AsyncTimeout timeout() {
                return AsyncTimeout.this;
            }

            @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
            public void close() {
                AsyncTimeout asyncTimeout = AsyncTimeout.this;
                Source source2 = source;
                asyncTimeout.enter();
                try {
                    source2.close();
                    Unit unit = Unit.f50853a;
                    if (!asyncTimeout.exit()) {
                        return;
                    }
                    throw asyncTimeout.access$newTimeoutException(null);
                } catch (IOException e8) {
                    if (!asyncTimeout.exit()) {
                        throw e8;
                    }
                    throw asyncTimeout.access$newTimeoutException(e8);
                } finally {
                    asyncTimeout.exit();
                }
            }

            @Override // okio.Source
            public long read(Buffer sink, long j8) {
                Intrinsics.f(sink, "sink");
                AsyncTimeout asyncTimeout = AsyncTimeout.this;
                Source source2 = source;
                asyncTimeout.enter();
                try {
                    long read = source2.read(sink, j8);
                    if (!asyncTimeout.exit()) {
                        return read;
                    }
                    throw asyncTimeout.access$newTimeoutException(null);
                } catch (IOException e8) {
                    if (!asyncTimeout.exit()) {
                        throw e8;
                    }
                    throw asyncTimeout.access$newTimeoutException(e8);
                } finally {
                    asyncTimeout.exit();
                }
            }

            public String toString() {
                return "AsyncTimeout.source(" + source + ')';
            }
        };
    }

    protected void timedOut() {
    }

    public final <T> T withTimeout(Function0<? extends T> block) {
        Intrinsics.f(block, "block");
        enter();
        try {
            try {
                T invoke = block.invoke();
                InlineMarker.b(1);
                if (!exit()) {
                    InlineMarker.a(1);
                    return invoke;
                }
                throw access$newTimeoutException(null);
            } catch (IOException e8) {
                if (!exit()) {
                    throw e8;
                }
                throw access$newTimeoutException(e8);
            }
        } catch (Throwable th) {
            InlineMarker.b(1);
            exit();
            InlineMarker.a(1);
            throw th;
        }
    }
}
