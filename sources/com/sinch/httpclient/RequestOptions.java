package com.sinch.httpclient;

/* loaded from: classes3.dex */
public final class RequestOptions {
    public static final int PRIORITY_HIGH = 1;
    public static final int PRIORITY_LOW = -1;
    public static final int PRIORITY_NORMAL = 0;
    public final int connectionTimeout;
    public final Logger logger;
    public final int priority;
    public final int readTimeout;
    public final int requestTimeout;
    public final RetryPolicy retry;

    public RequestOptions(int i8, RetryPolicy retryPolicy, Logger logger) {
        this(i8, retryPolicy, logger, 0, 0, 0);
    }

    public RequestOptions(int i8, RetryPolicy retryPolicy, Logger logger, int i9, int i10, int i11) {
        this.priority = i8;
        this.retry = retryPolicy;
        this.logger = logger;
        this.connectionTimeout = i9;
        this.readTimeout = i10;
        this.requestTimeout = i11;
    }
}
