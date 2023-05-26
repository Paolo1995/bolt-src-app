package com.sinch.android.rtc.internal.natives;

import java.util.Map;

/* loaded from: classes3.dex */
public class HttpRequest {
    public static final int METHOD_DELETE = 3;
    public static final int METHOD_GET = 1;
    public static final int METHOD_POST = 0;
    public static final int METHOD_PUT = 2;
    private final byte[] body;
    private final Map<String, String> headers;
    private final int method;
    private final int requestTimeoutMs;
    private final int retryAttempts;
    private final String url;

    public HttpRequest(String str, int i8, byte[] bArr, Map<String, String> map, int i9, int i10) {
        this.url = str;
        this.method = i8;
        this.body = bArr;
        this.headers = map;
        this.requestTimeoutMs = i9;
        this.retryAttempts = i10;
    }

    public byte[] getBody() {
        return this.body;
    }

    public Map<String, String> getHeaders() {
        return this.headers;
    }

    public int getMethod() {
        return this.method;
    }

    public String getMethodString() {
        int i8 = this.method;
        if (i8 != 0) {
            if (i8 != 1) {
                if (i8 != 2) {
                    if (i8 == 3) {
                        return "DELETE";
                    }
                    throw new IllegalStateException("Unsupported http method value: " + this.method);
                }
                return "PUT";
            }
            return "GET";
        }
        return "POST";
    }

    public int getRequestTimeoutMs() {
        return this.requestTimeoutMs;
    }

    public int getRetryAttempts() {
        return this.retryAttempts;
    }

    public String getUrl() {
        return this.url;
    }
}
