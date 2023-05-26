package com.google.android.datatransport.runtime.retries;

/* loaded from: classes.dex */
public interface RetryStrategy<TInput, TResult> {
    TInput a(TInput tinput, TResult tresult);
}
