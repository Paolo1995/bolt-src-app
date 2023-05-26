package okhttp3.internal.connection;

import java.lang.ref.Reference;
import java.net.Socket;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Address;
import okhttp3.ConnectionPool;
import okhttp3.Route;
import okhttp3.internal.Util;
import okhttp3.internal.concurrent.Task;
import okhttp3.internal.concurrent.TaskQueue;
import okhttp3.internal.concurrent.TaskRunner;
import okhttp3.internal.connection.RealCall;
import okhttp3.internal.platform.Platform;

/* compiled from: RealConnectionPool.kt */
/* loaded from: classes5.dex */
public final class RealConnectionPool {
    public static final Companion Companion = new Companion(null);
    private final TaskQueue cleanupQueue;
    private final RealConnectionPool$cleanupTask$1 cleanupTask;
    private final ConcurrentLinkedQueue<RealConnection> connections;
    private final long keepAliveDurationNs;
    private final int maxIdleConnections;

    /* compiled from: RealConnectionPool.kt */
    /* loaded from: classes5.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final RealConnectionPool get(ConnectionPool connectionPool) {
            Intrinsics.f(connectionPool, "connectionPool");
            return connectionPool.getDelegate$okhttp();
        }
    }

    /* JADX WARN: Type inference failed for: r4v2, types: [okhttp3.internal.connection.RealConnectionPool$cleanupTask$1] */
    public RealConnectionPool(TaskRunner taskRunner, int i8, long j8, TimeUnit timeUnit) {
        boolean z7;
        Intrinsics.f(taskRunner, "taskRunner");
        Intrinsics.f(timeUnit, "timeUnit");
        this.maxIdleConnections = i8;
        this.keepAliveDurationNs = timeUnit.toNanos(j8);
        this.cleanupQueue = taskRunner.newQueue();
        final String n8 = Intrinsics.n(Util.okHttpName, " ConnectionPool");
        this.cleanupTask = new Task(n8) { // from class: okhttp3.internal.connection.RealConnectionPool$cleanupTask$1
            @Override // okhttp3.internal.concurrent.Task
            public long runOnce() {
                return RealConnectionPool.this.cleanup(System.nanoTime());
            }
        };
        this.connections = new ConcurrentLinkedQueue<>();
        if (j8 > 0) {
            z7 = true;
        } else {
            z7 = false;
        }
        if (z7) {
            return;
        }
        throw new IllegalArgumentException(Intrinsics.n("keepAliveDuration <= 0: ", Long.valueOf(j8)).toString());
    }

    private final int pruneAndGetAllocationCount(RealConnection realConnection, long j8) {
        if (Util.assertionsEnabled && !Thread.holdsLock(realConnection)) {
            throw new AssertionError("Thread " + ((Object) Thread.currentThread().getName()) + " MUST hold lock on " + realConnection);
        }
        List<Reference<RealCall>> calls = realConnection.getCalls();
        int i8 = 0;
        while (i8 < calls.size()) {
            Reference<RealCall> reference = calls.get(i8);
            if (reference.get() != null) {
                i8++;
            } else {
                Platform.Companion.get().logCloseableLeak("A connection to " + realConnection.route().address().url() + " was leaked. Did you forget to close a response body?", ((RealCall.CallReference) reference).getCallStackTrace());
                calls.remove(i8);
                realConnection.setNoNewExchanges(true);
                if (calls.isEmpty()) {
                    realConnection.setIdleAtNs$okhttp(j8 - this.keepAliveDurationNs);
                    return 0;
                }
            }
        }
        return calls.size();
    }

    public final boolean callAcquirePooledConnection(Address address, RealCall call, List<Route> list, boolean z7) {
        Intrinsics.f(address, "address");
        Intrinsics.f(call, "call");
        Iterator<RealConnection> it = this.connections.iterator();
        while (it.hasNext()) {
            RealConnection connection = it.next();
            Intrinsics.e(connection, "connection");
            synchronized (connection) {
                if (z7) {
                    if (!connection.isMultiplexed$okhttp()) {
                        Unit unit = Unit.f50853a;
                    }
                }
                if (connection.isEligible$okhttp(address, list)) {
                    call.acquireConnectionNoEvents(connection);
                    return true;
                }
                Unit unit2 = Unit.f50853a;
            }
        }
        return false;
    }

    public final long cleanup(long j8) {
        Iterator<RealConnection> it = this.connections.iterator();
        int i8 = 0;
        long j9 = Long.MIN_VALUE;
        RealConnection realConnection = null;
        int i9 = 0;
        while (it.hasNext()) {
            RealConnection connection = it.next();
            Intrinsics.e(connection, "connection");
            synchronized (connection) {
                if (pruneAndGetAllocationCount(connection, j8) > 0) {
                    i9++;
                } else {
                    i8++;
                    long idleAtNs$okhttp = j8 - connection.getIdleAtNs$okhttp();
                    if (idleAtNs$okhttp > j9) {
                        realConnection = connection;
                        j9 = idleAtNs$okhttp;
                    }
                    Unit unit = Unit.f50853a;
                }
            }
        }
        long j10 = this.keepAliveDurationNs;
        if (j9 < j10 && i8 <= this.maxIdleConnections) {
            if (i8 > 0) {
                return j10 - j9;
            }
            if (i9 > 0) {
                return j10;
            }
            return -1L;
        }
        Intrinsics.c(realConnection);
        synchronized (realConnection) {
            if (!realConnection.getCalls().isEmpty()) {
                return 0L;
            }
            if (realConnection.getIdleAtNs$okhttp() + j9 != j8) {
                return 0L;
            }
            realConnection.setNoNewExchanges(true);
            this.connections.remove(realConnection);
            Util.closeQuietly(realConnection.socket());
            if (this.connections.isEmpty()) {
                this.cleanupQueue.cancelAll();
            }
            return 0L;
        }
    }

    public final boolean connectionBecameIdle(RealConnection connection) {
        Intrinsics.f(connection, "connection");
        if (Util.assertionsEnabled && !Thread.holdsLock(connection)) {
            throw new AssertionError("Thread " + ((Object) Thread.currentThread().getName()) + " MUST hold lock on " + connection);
        } else if (!connection.getNoNewExchanges() && this.maxIdleConnections != 0) {
            TaskQueue.schedule$default(this.cleanupQueue, this.cleanupTask, 0L, 2, null);
            return false;
        } else {
            connection.setNoNewExchanges(true);
            this.connections.remove(connection);
            if (!this.connections.isEmpty()) {
                return true;
            }
            this.cleanupQueue.cancelAll();
            return true;
        }
    }

    public final int connectionCount() {
        return this.connections.size();
    }

    public final void evictAll() {
        Socket socket;
        Iterator<RealConnection> it = this.connections.iterator();
        Intrinsics.e(it, "connections.iterator()");
        while (it.hasNext()) {
            RealConnection connection = it.next();
            Intrinsics.e(connection, "connection");
            synchronized (connection) {
                if (connection.getCalls().isEmpty()) {
                    it.remove();
                    connection.setNoNewExchanges(true);
                    socket = connection.socket();
                } else {
                    socket = null;
                }
            }
            if (socket != null) {
                Util.closeQuietly(socket);
            }
        }
        if (this.connections.isEmpty()) {
            this.cleanupQueue.cancelAll();
        }
    }

    public final int idleConnectionCount() {
        boolean isEmpty;
        ConcurrentLinkedQueue<RealConnection> concurrentLinkedQueue = this.connections;
        int i8 = 0;
        if (!(concurrentLinkedQueue instanceof Collection) || !concurrentLinkedQueue.isEmpty()) {
            for (RealConnection it : concurrentLinkedQueue) {
                Intrinsics.e(it, "it");
                synchronized (it) {
                    isEmpty = it.getCalls().isEmpty();
                }
                if (isEmpty && (i8 = i8 + 1) < 0) {
                    CollectionsKt__CollectionsKt.t();
                }
            }
        }
        return i8;
    }

    public final void put(RealConnection connection) {
        Intrinsics.f(connection, "connection");
        if (Util.assertionsEnabled && !Thread.holdsLock(connection)) {
            throw new AssertionError("Thread " + ((Object) Thread.currentThread().getName()) + " MUST hold lock on " + connection);
        }
        this.connections.add(connection);
        TaskQueue.schedule$default(this.cleanupQueue, this.cleanupTask, 0L, 2, null);
    }
}
