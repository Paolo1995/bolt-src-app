package io.ktor.client.plugins;

import java.io.IOException;

/* compiled from: HttpTimeout.kt */
/* loaded from: classes5.dex */
public final class HttpRequestTimeoutException extends IOException {
    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public HttpRequestTimeoutException(java.lang.String r3, java.lang.Long r4) {
        /*
            r2 = this;
            java.lang.String r0 = "url"
            kotlin.jvm.internal.Intrinsics.f(r3, r0)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Request timeout has expired [url="
            r0.append(r1)
            r0.append(r3)
            java.lang.String r3 = ", request_timeout="
            r0.append(r3)
            if (r4 != 0) goto L1b
            java.lang.String r4 = "unknown"
        L1b:
            r0.append(r4)
            java.lang.String r3 = " ms]"
            r0.append(r3)
            java.lang.String r3 = r0.toString()
            r2.<init>(r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.plugins.HttpRequestTimeoutException.<init>(java.lang.String, java.lang.Long):void");
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public HttpRequestTimeoutException(io.ktor.client.request.HttpRequestBuilder r3) {
        /*
            r2 = this;
            java.lang.String r0 = "request"
            kotlin.jvm.internal.Intrinsics.f(r3, r0)
            io.ktor.http.URLBuilder r0 = r3.h()
            java.lang.String r0 = r0.c()
            io.ktor.client.plugins.HttpTimeout$Plugin r1 = io.ktor.client.plugins.HttpTimeout.f46390d
            java.lang.Object r3 = r3.e(r1)
            io.ktor.client.plugins.HttpTimeout$HttpTimeoutCapabilityConfiguration r3 = (io.ktor.client.plugins.HttpTimeout.HttpTimeoutCapabilityConfiguration) r3
            if (r3 == 0) goto L1c
            java.lang.Long r3 = r3.d()
            goto L1d
        L1c:
            r3 = 0
        L1d:
            r2.<init>(r0, r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.client.plugins.HttpRequestTimeoutException.<init>(io.ktor.client.request.HttpRequestBuilder):void");
    }
}
