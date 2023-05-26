package com.sinch.android.rtc.internal.service.http;

import com.sinch.httpclient.RetryPolicy;
import java.util.Date;
import java.util.concurrent.CancellationException;

/* loaded from: classes3.dex */
public class ScopedConstantBackoffRetryPolicy implements RetryPolicy {
    private boolean cancelledForGood = false;
    private final int retryWaitMs;
    private final int scopeMs;
    private long scopeStart;

    public ScopedConstantBackoffRetryPolicy(int i8, int i9) {
        this.scopeMs = i8;
        this.retryWaitMs = i9;
    }

    @Override // com.sinch.httpclient.RetryPolicy
    public int getBackOffMillis() {
        return this.retryWaitMs;
    }

    @Override // com.sinch.httpclient.RetryPolicy
    public void handleError(Exception exc) {
        this.scopeStart = new Date().getTime();
        if (exc instanceof CancellationException) {
            this.cancelledForGood = true;
        }
    }

    @Override // com.sinch.httpclient.RetryPolicy
    public boolean shouldRetry() {
        return !this.cancelledForGood && new Date().getTime() - this.scopeStart < ((long) this.scopeMs);
    }
}
