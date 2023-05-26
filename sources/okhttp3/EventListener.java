package okhttp3;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: EventListener.kt */
/* loaded from: classes5.dex */
public abstract class EventListener {
    public static final Companion Companion = new Companion(null);
    public static final EventListener NONE = new EventListener() { // from class: okhttp3.EventListener$Companion$NONE$1
    };

    /* compiled from: EventListener.kt */
    /* loaded from: classes5.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: EventListener.kt */
    /* loaded from: classes5.dex */
    public interface Factory {
        EventListener create(Call call);
    }

    public void cacheConditionalHit(Call call, Response cachedResponse) {
        Intrinsics.f(call, "call");
        Intrinsics.f(cachedResponse, "cachedResponse");
    }

    public void cacheHit(Call call, Response response) {
        Intrinsics.f(call, "call");
        Intrinsics.f(response, "response");
    }

    public void cacheMiss(Call call) {
        Intrinsics.f(call, "call");
    }

    public void callEnd(Call call) {
        Intrinsics.f(call, "call");
    }

    public void callFailed(Call call, IOException ioe) {
        Intrinsics.f(call, "call");
        Intrinsics.f(ioe, "ioe");
    }

    public void callStart(Call call) {
        Intrinsics.f(call, "call");
    }

    public void canceled(Call call) {
        Intrinsics.f(call, "call");
    }

    public void connectEnd(Call call, InetSocketAddress inetSocketAddress, Proxy proxy, Protocol protocol) {
        Intrinsics.f(call, "call");
        Intrinsics.f(inetSocketAddress, "inetSocketAddress");
        Intrinsics.f(proxy, "proxy");
    }

    public void connectFailed(Call call, InetSocketAddress inetSocketAddress, Proxy proxy, Protocol protocol, IOException ioe) {
        Intrinsics.f(call, "call");
        Intrinsics.f(inetSocketAddress, "inetSocketAddress");
        Intrinsics.f(proxy, "proxy");
        Intrinsics.f(ioe, "ioe");
    }

    public void connectStart(Call call, InetSocketAddress inetSocketAddress, Proxy proxy) {
        Intrinsics.f(call, "call");
        Intrinsics.f(inetSocketAddress, "inetSocketAddress");
        Intrinsics.f(proxy, "proxy");
    }

    public void connectionAcquired(Call call, Connection connection) {
        Intrinsics.f(call, "call");
        Intrinsics.f(connection, "connection");
    }

    public void connectionReleased(Call call, Connection connection) {
        Intrinsics.f(call, "call");
        Intrinsics.f(connection, "connection");
    }

    public void dnsEnd(Call call, String domainName, List<InetAddress> inetAddressList) {
        Intrinsics.f(call, "call");
        Intrinsics.f(domainName, "domainName");
        Intrinsics.f(inetAddressList, "inetAddressList");
    }

    public void dnsStart(Call call, String domainName) {
        Intrinsics.f(call, "call");
        Intrinsics.f(domainName, "domainName");
    }

    public void proxySelectEnd(Call call, HttpUrl url, List<Proxy> proxies) {
        Intrinsics.f(call, "call");
        Intrinsics.f(url, "url");
        Intrinsics.f(proxies, "proxies");
    }

    public void proxySelectStart(Call call, HttpUrl url) {
        Intrinsics.f(call, "call");
        Intrinsics.f(url, "url");
    }

    public void requestBodyEnd(Call call, long j8) {
        Intrinsics.f(call, "call");
    }

    public void requestBodyStart(Call call) {
        Intrinsics.f(call, "call");
    }

    public void requestFailed(Call call, IOException ioe) {
        Intrinsics.f(call, "call");
        Intrinsics.f(ioe, "ioe");
    }

    public void requestHeadersEnd(Call call, Request request) {
        Intrinsics.f(call, "call");
        Intrinsics.f(request, "request");
    }

    public void requestHeadersStart(Call call) {
        Intrinsics.f(call, "call");
    }

    public void responseBodyEnd(Call call, long j8) {
        Intrinsics.f(call, "call");
    }

    public void responseBodyStart(Call call) {
        Intrinsics.f(call, "call");
    }

    public void responseFailed(Call call, IOException ioe) {
        Intrinsics.f(call, "call");
        Intrinsics.f(ioe, "ioe");
    }

    public void responseHeadersEnd(Call call, Response response) {
        Intrinsics.f(call, "call");
        Intrinsics.f(response, "response");
    }

    public void responseHeadersStart(Call call) {
        Intrinsics.f(call, "call");
    }

    public void satisfactionFailure(Call call, Response response) {
        Intrinsics.f(call, "call");
        Intrinsics.f(response, "response");
    }

    public void secureConnectEnd(Call call, Handshake handshake) {
        Intrinsics.f(call, "call");
    }

    public void secureConnectStart(Call call) {
        Intrinsics.f(call, "call");
    }
}
