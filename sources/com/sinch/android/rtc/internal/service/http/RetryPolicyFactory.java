package com.sinch.android.rtc.internal.service.http;

import com.google.android.gms.auth.api.credentials.CredentialsApi;
import com.sinch.android.rtc.internal.InternalErrorCodes;
import com.sinch.android.rtc.internal.natives.HttpRequest;
import com.sinch.httpclient.RetryPolicy;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

/* loaded from: classes3.dex */
final class RetryPolicyFactory {
    public static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final int[] RETRY_INTERVALS = {200, 1000, CredentialsApi.CREDENTIAL_PICKER_REQUEST_CODE, InternalErrorCodes.ApiCallFailed, 6000};

    public static RetryPolicy createRetryPolicy(HttpRequest httpRequest) {
        int retryAttempts = httpRequest.getRetryAttempts() > 0 ? httpRequest.getRetryAttempts() : 0;
        if (retryAttempts <= 99) {
            return retryAttempts > 0 ? new CancellableFixedBackoffRetryPolicy(extendArrayWithLastValue(RETRY_INTERVALS, retryAttempts), TimeUnit.MILLISECONDS) : new NoRetryPolicy();
        }
        throw new IllegalArgumentException("Invalid number of retry attempts");
    }

    private static int[] extendArrayWithLastValue(int[] iArr, int i8) {
        int[] iArr2 = new int[i8];
        System.arraycopy(iArr, 0, iArr2, 0, Math.min(iArr.length, i8));
        if (i8 > iArr.length) {
            Arrays.fill(iArr2, iArr.length, i8, iArr[iArr.length - 1]);
        }
        return iArr2;
    }
}
