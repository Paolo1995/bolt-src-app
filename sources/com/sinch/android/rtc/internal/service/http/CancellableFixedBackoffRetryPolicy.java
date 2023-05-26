package com.sinch.android.rtc.internal.service.http;

import com.sinch.httpclient.FixedBackoffRetryPolicy;
import java.util.concurrent.CancellationException;
import java.util.concurrent.TimeUnit;

/* loaded from: classes3.dex */
public class CancellableFixedBackoffRetryPolicy extends FixedBackoffRetryPolicy {
    private boolean isCancelledForGood;

    public CancellableFixedBackoffRetryPolicy(int[] iArr, TimeUnit timeUnit) {
        super(iArr, timeUnit);
        this.isCancelledForGood = false;
    }

    @Override // com.sinch.httpclient.FixedBackoffRetryPolicy, com.sinch.httpclient.RetryPolicy
    public void handleError(Exception exc) {
        super.handleError(exc);
        if (exc instanceof CancellationException) {
            this.isCancelledForGood = true;
        }
    }

    @Override // com.sinch.httpclient.FixedBackoffRetryPolicy, com.sinch.httpclient.RetryPolicy
    public boolean shouldRetry() {
        return !this.isCancelledForGood && super.shouldRetry();
    }
}
