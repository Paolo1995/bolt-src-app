package io.ktor.client.plugins;

import io.ktor.client.network.sockets.ConnectTimeoutException;
import io.ktor.client.network.sockets.SocketTimeoutException;
import io.ktor.client.plugins.HttpTimeout;
import io.ktor.client.request.HttpRequestData;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: HttpTimeout.kt */
/* loaded from: classes5.dex */
public final class HttpTimeoutKt {
    public static final ConnectTimeoutException a(HttpRequestData request, Throwable th) {
        Intrinsics.f(request, "request");
        StringBuilder sb = new StringBuilder();
        sb.append("Connect timeout has expired [url=");
        sb.append(request.h());
        sb.append(", connect_timeout=");
        HttpTimeout.HttpTimeoutCapabilityConfiguration httpTimeoutCapabilityConfiguration = (HttpTimeout.HttpTimeoutCapabilityConfiguration) request.c(HttpTimeout.f46390d);
        sb.append((httpTimeoutCapabilityConfiguration == null || (r3 = httpTimeoutCapabilityConfiguration.c()) == null) ? "unknown" : "unknown");
        sb.append(" ms]");
        return new ConnectTimeoutException(sb.toString(), th);
    }

    public static final SocketTimeoutException b(HttpRequestData request, Throwable th) {
        Intrinsics.f(request, "request");
        StringBuilder sb = new StringBuilder();
        sb.append("Socket timeout has expired [url=");
        sb.append(request.h());
        sb.append(", socket_timeout=");
        HttpTimeout.HttpTimeoutCapabilityConfiguration httpTimeoutCapabilityConfiguration = (HttpTimeout.HttpTimeoutCapabilityConfiguration) request.c(HttpTimeout.f46390d);
        sb.append((httpTimeoutCapabilityConfiguration == null || (r3 = httpTimeoutCapabilityConfiguration.e()) == null) ? "unknown" : "unknown");
        sb.append("] ms");
        return new SocketTimeoutException(sb.toString(), th);
    }

    public static final long c(long j8) {
        if (j8 == Long.MAX_VALUE) {
            return 0L;
        }
        return j8;
    }
}
