package com.sinch.httpclient;

import java.util.concurrent.TimeUnit;

/* loaded from: classes3.dex */
public class FixedBackoffRetryPolicy implements RetryPolicy {
    public static final /* synthetic */ boolean $assertionsDisabled = false;
    private final int[] mBackoffIntervalsMs;
    private int mCurrentRetryCount;
    private final int mMaxNumRetries;

    public FixedBackoffRetryPolicy(int[] iArr, TimeUnit timeUnit) {
        validateIntervals(iArr);
        if (timeUnit == null) {
            throw new IllegalArgumentException("time unit is null");
        }
        int[] intervalMs = toIntervalMs(iArr, timeUnit);
        this.mBackoffIntervalsMs = intervalMs;
        this.mMaxNumRetries = intervalMs.length;
    }

    private static int[] toIntervalMs(int[] iArr, TimeUnit timeUnit) {
        int[] iArr2 = new int[iArr.length];
        for (int i8 = 0; i8 < iArr.length; i8++) {
            iArr2[i8] = (int) timeUnit.toMillis(iArr[i8]);
        }
        return iArr2;
    }

    private static void validateIntervals(int[] iArr) throws IllegalArgumentException {
        if (iArr == null) {
            throw new IllegalArgumentException("backoffIntervalsMs is null");
        }
        if (iArr.length < 1) {
            throw new IllegalArgumentException("backOffIntervalMs is empty");
        }
        for (int i8 : iArr) {
            if (i8 < 1) {
                throw new IllegalArgumentException("backoffIntervalsMs contains invalid value (< 1)");
            }
        }
    }

    @Override // com.sinch.httpclient.RetryPolicy
    public int getBackOffMillis() {
        int[] iArr = this.mBackoffIntervalsMs;
        int i8 = this.mCurrentRetryCount;
        return i8 == 0 ? iArr[0] : i8 > iArr.length ? iArr[iArr.length - 1] : iArr[i8 - 1];
    }

    @Override // com.sinch.httpclient.RetryPolicy
    public void handleError(Exception exc) {
        this.mCurrentRetryCount++;
    }

    @Override // com.sinch.httpclient.RetryPolicy
    public boolean shouldRetry() {
        return this.mMaxNumRetries >= this.mCurrentRetryCount;
    }
}
