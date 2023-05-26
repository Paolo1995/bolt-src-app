package okhttp3.logging;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Call;
import okhttp3.Connection;
import okhttp3.EventListener;
import okhttp3.Handshake;
import okhttp3.HttpUrl;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;

/* compiled from: LoggingEventListener.kt */
/* loaded from: classes5.dex */
public final class LoggingEventListener extends EventListener {
    private final HttpLoggingInterceptor.Logger logger;
    private long startNs;

    private LoggingEventListener(HttpLoggingInterceptor.Logger logger) {
        this.logger = logger;
    }

    public /* synthetic */ LoggingEventListener(HttpLoggingInterceptor.Logger logger, DefaultConstructorMarker defaultConstructorMarker) {
        this(logger);
    }

    private final void logWithTime(String str) {
        long millis = TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - this.startNs);
        HttpLoggingInterceptor.Logger logger = this.logger;
        logger.log('[' + millis + " ms] " + str);
    }

    @Override // okhttp3.EventListener
    public void cacheConditionalHit(Call call, Response cachedResponse) {
        Intrinsics.f(call, "call");
        Intrinsics.f(cachedResponse, "cachedResponse");
        logWithTime(Intrinsics.n("cacheConditionalHit: ", cachedResponse));
    }

    @Override // okhttp3.EventListener
    public void cacheHit(Call call, Response response) {
        Intrinsics.f(call, "call");
        Intrinsics.f(response, "response");
        logWithTime(Intrinsics.n("cacheHit: ", response));
    }

    @Override // okhttp3.EventListener
    public void cacheMiss(Call call) {
        Intrinsics.f(call, "call");
        logWithTime("cacheMiss");
    }

    @Override // okhttp3.EventListener
    public void callEnd(Call call) {
        Intrinsics.f(call, "call");
        logWithTime("callEnd");
    }

    @Override // okhttp3.EventListener
    public void callFailed(Call call, IOException ioe) {
        Intrinsics.f(call, "call");
        Intrinsics.f(ioe, "ioe");
        logWithTime(Intrinsics.n("callFailed: ", ioe));
    }

    @Override // okhttp3.EventListener
    public void callStart(Call call) {
        Intrinsics.f(call, "call");
        this.startNs = System.nanoTime();
        logWithTime(Intrinsics.n("callStart: ", call.request()));
    }

    @Override // okhttp3.EventListener
    public void canceled(Call call) {
        Intrinsics.f(call, "call");
        logWithTime("canceled");
    }

    @Override // okhttp3.EventListener
    public void connectEnd(Call call, InetSocketAddress inetSocketAddress, Proxy proxy, Protocol protocol) {
        Intrinsics.f(call, "call");
        Intrinsics.f(inetSocketAddress, "inetSocketAddress");
        Intrinsics.f(proxy, "proxy");
        logWithTime(Intrinsics.n("connectEnd: ", protocol));
    }

    @Override // okhttp3.EventListener
    public void connectFailed(Call call, InetSocketAddress inetSocketAddress, Proxy proxy, Protocol protocol, IOException ioe) {
        Intrinsics.f(call, "call");
        Intrinsics.f(inetSocketAddress, "inetSocketAddress");
        Intrinsics.f(proxy, "proxy");
        Intrinsics.f(ioe, "ioe");
        logWithTime("connectFailed: " + protocol + ' ' + ioe);
    }

    @Override // okhttp3.EventListener
    public void connectStart(Call call, InetSocketAddress inetSocketAddress, Proxy proxy) {
        Intrinsics.f(call, "call");
        Intrinsics.f(inetSocketAddress, "inetSocketAddress");
        Intrinsics.f(proxy, "proxy");
        logWithTime("connectStart: " + inetSocketAddress + ' ' + proxy);
    }

    @Override // okhttp3.EventListener
    public void connectionAcquired(Call call, Connection connection) {
        Intrinsics.f(call, "call");
        Intrinsics.f(connection, "connection");
        logWithTime(Intrinsics.n("connectionAcquired: ", connection));
    }

    @Override // okhttp3.EventListener
    public void connectionReleased(Call call, Connection connection) {
        Intrinsics.f(call, "call");
        Intrinsics.f(connection, "connection");
        logWithTime("connectionReleased");
    }

    @Override // okhttp3.EventListener
    public void dnsEnd(Call call, String domainName, List<? extends InetAddress> inetAddressList) {
        Intrinsics.f(call, "call");
        Intrinsics.f(domainName, "domainName");
        Intrinsics.f(inetAddressList, "inetAddressList");
        logWithTime(Intrinsics.n("dnsEnd: ", inetAddressList));
    }

    @Override // okhttp3.EventListener
    public void dnsStart(Call call, String domainName) {
        Intrinsics.f(call, "call");
        Intrinsics.f(domainName, "domainName");
        logWithTime(Intrinsics.n("dnsStart: ", domainName));
    }

    @Override // okhttp3.EventListener
    public void proxySelectEnd(Call call, HttpUrl url, List<? extends Proxy> proxies) {
        Intrinsics.f(call, "call");
        Intrinsics.f(url, "url");
        Intrinsics.f(proxies, "proxies");
        logWithTime(Intrinsics.n("proxySelectEnd: ", proxies));
    }

    @Override // okhttp3.EventListener
    public void proxySelectStart(Call call, HttpUrl url) {
        Intrinsics.f(call, "call");
        Intrinsics.f(url, "url");
        logWithTime(Intrinsics.n("proxySelectStart: ", url));
    }

    @Override // okhttp3.EventListener
    public void requestBodyEnd(Call call, long j8) {
        Intrinsics.f(call, "call");
        logWithTime(Intrinsics.n("requestBodyEnd: byteCount=", Long.valueOf(j8)));
    }

    @Override // okhttp3.EventListener
    public void requestBodyStart(Call call) {
        Intrinsics.f(call, "call");
        logWithTime("requestBodyStart");
    }

    @Override // okhttp3.EventListener
    public void requestFailed(Call call, IOException ioe) {
        Intrinsics.f(call, "call");
        Intrinsics.f(ioe, "ioe");
        logWithTime(Intrinsics.n("requestFailed: ", ioe));
    }

    @Override // okhttp3.EventListener
    public void requestHeadersEnd(Call call, Request request) {
        Intrinsics.f(call, "call");
        Intrinsics.f(request, "request");
        logWithTime("requestHeadersEnd");
    }

    @Override // okhttp3.EventListener
    public void requestHeadersStart(Call call) {
        Intrinsics.f(call, "call");
        logWithTime("requestHeadersStart");
    }

    @Override // okhttp3.EventListener
    public void responseBodyEnd(Call call, long j8) {
        Intrinsics.f(call, "call");
        logWithTime(Intrinsics.n("responseBodyEnd: byteCount=", Long.valueOf(j8)));
    }

    @Override // okhttp3.EventListener
    public void responseBodyStart(Call call) {
        Intrinsics.f(call, "call");
        logWithTime("responseBodyStart");
    }

    @Override // okhttp3.EventListener
    public void responseFailed(Call call, IOException ioe) {
        Intrinsics.f(call, "call");
        Intrinsics.f(ioe, "ioe");
        logWithTime(Intrinsics.n("responseFailed: ", ioe));
    }

    @Override // okhttp3.EventListener
    public void responseHeadersEnd(Call call, Response response) {
        Intrinsics.f(call, "call");
        Intrinsics.f(response, "response");
        logWithTime(Intrinsics.n("responseHeadersEnd: ", response));
    }

    @Override // okhttp3.EventListener
    public void responseHeadersStart(Call call) {
        Intrinsics.f(call, "call");
        logWithTime("responseHeadersStart");
    }

    @Override // okhttp3.EventListener
    public void satisfactionFailure(Call call, Response response) {
        Intrinsics.f(call, "call");
        Intrinsics.f(response, "response");
        logWithTime(Intrinsics.n("satisfactionFailure: ", response));
    }

    @Override // okhttp3.EventListener
    public void secureConnectEnd(Call call, Handshake handshake) {
        Intrinsics.f(call, "call");
        logWithTime(Intrinsics.n("secureConnectEnd: ", handshake));
    }

    @Override // okhttp3.EventListener
    public void secureConnectStart(Call call) {
        Intrinsics.f(call, "call");
        logWithTime("secureConnectStart");
    }

    /* compiled from: LoggingEventListener.kt */
    /* loaded from: classes5.dex */
    public static class Factory implements EventListener.Factory {
        private final HttpLoggingInterceptor.Logger logger;

        public Factory() {
            this(null, 1, null);
        }

        public Factory(HttpLoggingInterceptor.Logger logger) {
            Intrinsics.f(logger, "logger");
            this.logger = logger;
        }

        @Override // okhttp3.EventListener.Factory
        public EventListener create(Call call) {
            Intrinsics.f(call, "call");
            return new LoggingEventListener(this.logger, null);
        }

        public /* synthetic */ Factory(HttpLoggingInterceptor.Logger logger, int i8, DefaultConstructorMarker defaultConstructorMarker) {
            this((i8 & 1) != 0 ? HttpLoggingInterceptor.Logger.DEFAULT : logger);
        }
    }
}
