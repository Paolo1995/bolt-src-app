package com.sinch.android.rtc.internal.service.http;

import com.sinch.httpclient.RetryPolicy;

/* loaded from: classes3.dex */
public final class NoRetryPolicy implements RetryPolicy {
    @Override // com.sinch.httpclient.RetryPolicy
    public int getBackOffMillis() {
        return -1;
    }

    @Override // com.sinch.httpclient.RetryPolicy
    public void handleError(Exception exc) {
    }

    @Override // com.sinch.httpclient.RetryPolicy
    public boolean shouldRetry() {
        return false;
    }
}
