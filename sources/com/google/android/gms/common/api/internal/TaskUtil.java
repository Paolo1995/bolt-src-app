package com.google.android.gms.common.api.internal;

import androidx.annotation.NonNull;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.ApiExceptionUtil;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.gms:play-services-base@@18.1.0 */
@KeepForSdk
/* loaded from: classes.dex */
public class TaskUtil {
    @KeepForSdk
    public static void setResultOrApiException(@NonNull Status status, @NonNull TaskCompletionSource<Void> taskCompletionSource) {
        setResultOrApiException(status, null, taskCompletionSource);
    }

    @NonNull
    @KeepForSdk
    @Deprecated
    public static Task<Void> toVoidTaskThatFailsOnFalse(@NonNull Task<Boolean> task) {
        return task.continueWith(new zacx());
    }

    @KeepForSdk
    public static <ResultT> boolean trySetResultOrApiException(@NonNull Status status, ResultT resultt, @NonNull TaskCompletionSource<ResultT> taskCompletionSource) {
        if (status.isSuccess()) {
            return taskCompletionSource.trySetResult(resultt);
        }
        return taskCompletionSource.trySetException(ApiExceptionUtil.fromStatus(status));
    }

    @KeepForSdk
    public static <ResultT> void setResultOrApiException(@NonNull Status status, ResultT resultt, @NonNull TaskCompletionSource<ResultT> taskCompletionSource) {
        if (status.isSuccess()) {
            taskCompletionSource.setResult(resultt);
        } else {
            taskCompletionSource.setException(ApiExceptionUtil.fromStatus(status));
        }
    }
}
