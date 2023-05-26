package com.sinch.android.rtc.internal.service.http;

import com.sinch.httpclient.FixedBackoffRetryPolicy;
import java.util.concurrent.CancellationException;
import java.util.concurrent.TimeUnit;

/* loaded from: classes3.dex */
public class CancellableInfiniteFixedBackoffRetryPolicy extends FixedBackoffRetryPolicy {
    private boolean cancelledForGood;

    public CancellableInfiniteFixedBackoffRetryPolicy(int[] iArr, TimeUnit timeUnit) {
        super(iArr, timeUnit);
        this.cancelledForGood = false;
    }

    @Override // com.sinch.httpclient.FixedBackoffRetryPolicy, com.sinch.httpclient.RetryPolicy
    public void handleError(Exception exc) {
        super.handleError(exc);
        if (exc instanceof CancellationException) {
            this.cancelledForGood = true;
        }
    }

    @Override // com.sinch.httpclient.FixedBackoffRetryPolicy, com.sinch.httpclient.RetryPolicy
    public boolean shouldRetry() {
        return !this.cancelledForGood;
    }
}
