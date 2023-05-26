package com.sinch.httpclient;

/* loaded from: classes3.dex */
public interface RetryPolicy {
    int getBackOffMillis();

    void handleError(Exception exc);

    boolean shouldRetry();
}
