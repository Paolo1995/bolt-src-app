package okhttp3.internal.connection;

import java.io.IOException;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Address;
import okhttp3.EventListener;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Route;
import okhttp3.internal.Util;
import okhttp3.internal.connection.RouteSelector;
import okhttp3.internal.http.ExchangeCodec;
import okhttp3.internal.http.RealInterceptorChain;
import okhttp3.internal.http2.ConnectionShutdownException;
import okhttp3.internal.http2.ErrorCode;
import okhttp3.internal.http2.StreamResetException;

/* compiled from: ExchangeFinder.kt */
/* loaded from: classes5.dex */
public final class ExchangeFinder {
    private final Address address;
    private final RealCall call;
    private final RealConnectionPool connectionPool;
    private int connectionShutdownCount;
    private final EventListener eventListener;
    private Route nextRouteToTry;
    private int otherFailureCount;
    private int refusedStreamCount;
    private RouteSelector.Selection routeSelection;
    private RouteSelector routeSelector;

    public ExchangeFinder(RealConnectionPool connectionPool, Address address, RealCall call, EventListener eventListener) {
        Intrinsics.f(connectionPool, "connectionPool");
        Intrinsics.f(address, "address");
        Intrinsics.f(call, "call");
        Intrinsics.f(eventListener, "eventListener");
        this.connectionPool = connectionPool;
        this.address = address;
        this.call = call;
        this.eventListener = eventListener;
    }

    /* JADX WARN: Removed duplicated region for block: B:59:0x0137  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0151  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final okhttp3.internal.connection.RealConnection findConnection(int r15, int r16, int r17, int r18, boolean r19) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 385
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.connection.ExchangeFinder.findConnection(int, int, int, int, boolean):okhttp3.internal.connection.RealConnection");
    }

    private final RealConnection findHealthyConnection(int i8, int i9, int i10, int i11, boolean z7, boolean z8) throws IOException {
        boolean hasNext;
        while (true) {
            RealConnection findConnection = findConnection(i8, i9, i10, i11, z7);
            if (findConnection.isHealthy(z8)) {
                return findConnection;
            }
            findConnection.noNewExchanges$okhttp();
            if (this.nextRouteToTry == null) {
                RouteSelector.Selection selection = this.routeSelection;
                boolean z9 = true;
                if (selection == null) {
                    hasNext = true;
                } else {
                    hasNext = selection.hasNext();
                }
                if (hasNext) {
                    continue;
                } else {
                    RouteSelector routeSelector = this.routeSelector;
                    if (routeSelector != null) {
                        z9 = routeSelector.hasNext();
                    }
                    if (!z9) {
                        throw new IOException("exhausted all routes");
                    }
                }
            }
        }
    }

    private final Route retryRoute() {
        RealConnection connection;
        if (this.refusedStreamCount > 1 || this.connectionShutdownCount > 1 || this.otherFailureCount > 0 || (connection = this.call.getConnection()) == null) {
            return null;
        }
        synchronized (connection) {
            if (connection.getRouteFailureCount$okhttp() != 0) {
                return null;
            }
            if (!Util.canReuseConnectionFor(connection.route().address().url(), getAddress$okhttp().url())) {
                return null;
            }
            return connection.route();
        }
    }

    public final ExchangeCodec find(OkHttpClient client, RealInterceptorChain chain) {
        boolean z7;
        Intrinsics.f(client, "client");
        Intrinsics.f(chain, "chain");
        try {
            int connectTimeoutMillis$okhttp = chain.getConnectTimeoutMillis$okhttp();
            int readTimeoutMillis$okhttp = chain.getReadTimeoutMillis$okhttp();
            int writeTimeoutMillis$okhttp = chain.getWriteTimeoutMillis$okhttp();
            int pingIntervalMillis = client.pingIntervalMillis();
            boolean retryOnConnectionFailure = client.retryOnConnectionFailure();
            if (!Intrinsics.a(chain.getRequest$okhttp().method(), "GET")) {
                z7 = true;
            } else {
                z7 = false;
            }
            return findHealthyConnection(connectTimeoutMillis$okhttp, readTimeoutMillis$okhttp, writeTimeoutMillis$okhttp, pingIntervalMillis, retryOnConnectionFailure, z7).newCodec$okhttp(client, chain);
        } catch (IOException e8) {
            trackFailure(e8);
            throw new RouteException(e8);
        } catch (RouteException e9) {
            trackFailure(e9.getLastConnectException());
            throw e9;
        }
    }

    public final Address getAddress$okhttp() {
        return this.address;
    }

    public final boolean retryAfterFailure() {
        RouteSelector routeSelector;
        boolean z7 = false;
        if (this.refusedStreamCount == 0 && this.connectionShutdownCount == 0 && this.otherFailureCount == 0) {
            return false;
        }
        if (this.nextRouteToTry != null) {
            return true;
        }
        Route retryRoute = retryRoute();
        if (retryRoute != null) {
            this.nextRouteToTry = retryRoute;
            return true;
        }
        RouteSelector.Selection selection = this.routeSelection;
        if (selection != null && selection.hasNext()) {
            z7 = true;
        }
        if (z7 || (routeSelector = this.routeSelector) == null) {
            return true;
        }
        return routeSelector.hasNext();
    }

    public final boolean sameHostAndPort(HttpUrl url) {
        Intrinsics.f(url, "url");
        HttpUrl url2 = this.address.url();
        if (url.port() == url2.port() && Intrinsics.a(url.host(), url2.host())) {
            return true;
        }
        return false;
    }

    public final void trackFailure(IOException e8) {
        Intrinsics.f(e8, "e");
        this.nextRouteToTry = null;
        if ((e8 instanceof StreamResetException) && ((StreamResetException) e8).errorCode == ErrorCode.REFUSED_STREAM) {
            this.refusedStreamCount++;
        } else if (e8 instanceof ConnectionShutdownException) {
            this.connectionShutdownCount++;
        } else {
            this.otherFailureCount++;
        }
    }
}
